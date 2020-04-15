package com.wangjun.io.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author wangjun
 * @date 2020-04-02
 * @version 1.0
 */
public class EchoClientHandler extends ChannelHandlerAdapter {
	
	public EchoClientHandler() {
	}
	
	/*
	 * 当客户端和服务端TCP链路建立成功之后调用此方法，发送消息给服务端
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String msg = "12345678901234567890123";
		ctx.writeAndFlush(Unpooled.copiedBuffer(msg.getBytes()));
		System.out.println("客户端发送的消息：" + msg);
	}
	
	/*
	 * 当服务端返回应答消息时调用此方法
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String body = (String)msg;
		System.out.println("收到服务器消息:" + body);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("unexpected exception from downstream:" + cause.getMessage());
		ctx.close();
	}
}
