package org.lwl.netty.server.handler;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author thinking_fioa
 * @createTime 2018/4/21
 * @description 登陆回复的Handler
 */


public class LoginRespHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // TODO:: channel read
    }
}
