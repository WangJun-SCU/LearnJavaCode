package com.wangjun.io.nio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wangjun
 * @date 2020-03-30
 * @version 1.0
 */
public class MultiplexerTimeServer implements Runnable {

	private Selector selector;
	private ServerSocketChannel servChannel;
	private volatile boolean stop;
	
	private final long SLEEP_TIME = 10000L;

	/**
	 * 初始化多路复用器，绑定监听端口
	 * 
	 * @param port
	 */
	public MultiplexerTimeServer(int port) {
		try {
			selector = Selector.open();
			servChannel = ServerSocketChannel.open();
			servChannel.configureBlocking(false);
			servChannel.socket().bind(new InetSocketAddress(port), 1024);//???1024这个参数什么作用
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The nio time server start in port:" + port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void stop() {
		this.stop = true;
	}

	@Override
	public void run() {
		while (!stop) {
			try {
				//休眠时间为1秒，无论是否有读写事件，selector每隔1s被唤醒一次
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					try {
						handleInput(key);
						//new Thread(new MyThread(key)).start();
					} catch (Exception e) {
						e.printStackTrace();
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
					}
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
		//多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所有不需要重复释放资源
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleInput(SelectionKey key) throws IOException {
		if (key.isValid()) {
			// 处理新接入的请求消息
			if (key.isAcceptable()) {
				System.out.println("收到 accept 请求");
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			}
			if (key.isReadable()) {
				System.out.println("收到 read 请求，休眠" + SLEEP_TIME/1000 + "s");
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("时间服务器收到的命令是:" + body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
							? new Date(System.currentTimeMillis()).toString()
							: "BAD ORDER";
					doWrite(sc, currentTime);
				} else if (readBytes < 0) {
					System.out.println("对端链路关闭");
					// 对端链路关闭
					key.channel();
					sc.close();
				} else {
					System.out.println("收到0字节");
					// 读到0字节，忽略
				}
			}
		}
	}

	private void doWrite(SocketChannel channel, String response) throws IOException {
		if(response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
		}
	}
	
	class MyThread implements Runnable {
		
		private SelectionKey key;
		
		public MyThread(SelectionKey key) {
			this.key = key;
		}
		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			try {
				if (key.isValid()) {
					// 处理新接入的请求消息
					if (key.isAcceptable()) {
						System.out.println("收到 accept 请求");
						ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
						SocketChannel sc = ssc.accept();
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);
					}
					if (key.isReadable()) {
						System.out.println("收到 read 请求，休眠" + SLEEP_TIME/1000 + "s");
						try {
							Thread.sleep(SLEEP_TIME);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						SocketChannel sc = (SocketChannel) key.channel();
						ByteBuffer readBuffer = ByteBuffer.allocate(1024);
						int readBytes = sc.read(readBuffer);
						if (readBytes > 0) {
							readBuffer.flip();
							byte[] bytes = new byte[readBuffer.remaining()];
							readBuffer.get(bytes);
							String body = new String(bytes, "UTF-8");
							System.out.println("时间服务器收到的命令是:" + body);
							String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
									? new Date(System.currentTimeMillis()).toString()
									: "BAD ORDER";
							doWrite(sc, currentTime);
						} else if (readBytes < 0) {
							System.out.println("对端链路关闭");
							// 对端链路关闭
							key.channel();
							sc.close();
						} else {
							System.out.println("收到0字节");
							// 读到0字节，忽略
						}
					}
				}
			} catch (ClosedChannelException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println("执行线程耗费：" + (System.currentTimeMillis() - startTime)/1000 + "s");
			}
		}
	}
}
