package com.wangjun.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author wangjun
 * @date 2020-04-02
 * @version 1.0
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
	private final ByteBuf firstMessage;
	
	public TimeClientHandler() {
		byte[] req = "QUERY TIME ORDER".getBytes();
		firstMessage = Unpooled.buffer(req.length);//?????????
		firstMessage.writeBytes(req);
	}
	
	/*
	 * 当客户端和服务端TCP链路建立成功之后调用此方法，发送消息给服务端
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(firstMessage);
	}
	
	/*
	 * 当服务端返回应答消息时调用此方法
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf)msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println("Now is:" + body);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("unexpected exception from downstream:" + cause.getMessage());
		ctx.close();
	}
}