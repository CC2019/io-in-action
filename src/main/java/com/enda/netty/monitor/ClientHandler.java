package com.enda.netty.monitor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author wt
 * @create 2019-03-21 上午10:02
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(channelHandlerContext.channel().remoteAddress());
        System.out.println("client output: " + s);
        channelHandlerContext.writeAndFlush("from client: "  + System.currentTimeMillis());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client channel active");
        ctx.writeAndFlush("来自客户端的问候!");
    }

//    @Override
//    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("client channel registered");
//        super.channelRegistered(ctx);
//    }
//
//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("client channel added");
//        super.handlerAdded(ctx);
//    }
//
//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("client channel inactive");
//        super.channelInactive(ctx);
//    }
//
//    @Override
//    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("client channel unregistered");
//        super.channelUnregistered(ctx);
//    }
}
