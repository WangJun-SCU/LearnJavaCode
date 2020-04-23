package com.wangjun.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author wangjun
 * @date 2020-04-02
 * @version 1.0
 */
public class TimeServer {

	public void bind(int port) throws Exception {
		// 配置服务端的NIO线程组,一个用于接收客户端的链接，另一个用于进行SocketChannel的网络读写
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
					.childHandler(new ChildChannelHandler());
			// 绑定端口，同步等待成功
			ChannelFuture f = b.bind(port).sync();
			// 阻塞main线程，等待服务端监听端口关闭之后main函数才退出
			f.channel().closeFuture().sync();
		} finally {
			// 优雅退出，释放线程资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel arg0) throws Exception {
			//pipeline是一个管理ChannelHandler列表，间接处理channel读写
             arg0.pipeline().addLast(new TimeServerHandler());
		}
	}

	public static void main(String[] args) throws Exception {
		int port = 8080;
		new TimeServer().bind(port);
	}
}