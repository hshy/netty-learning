package org.lwl.netty.codec.marshalling.serialize.body;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.lwl.netty.codec.marshalling.serialize.IBodySerializer;
import org.lwl.netty.message.Body;
import org.lwl.netty.message.body.LogoutBody;

/**
 * @author thinking_fioa
 * @createTime 2018/5/26
 * @description
 */


public final class LogoutBodySerializer implements IBodySerializer<LogoutBody>{

    private static final LogoutBodySerializer INSTANCE = new LogoutBodySerializer();
    private LogoutBodySerializer(){}

    public static LogoutBodySerializer getInstance() {
        return INSTANCE;
    }


    @Override
    public void serialize(ChannelHandlerContext ctx, ByteBuf outByteBuf, Body body) {

    }

    @Override
    public LogoutBody deserialize(ChannelHandlerContext ctx, ByteBuf inByteBuf) {
        return new LogoutBody();
    }
}
