package org.lwl.netty.client;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwl.netty.config.ProtocolConfig;
import org.lwl.netty.server.NettyServer;
import org.lwl.netty.util.concurrent.CustomThreadFactory;

/**
 * @author thinking_fioa
 * @createTime 2018/5/12
 * @description NettyClient适配器，可以控制重连机制。另一个项目可以见到链路切换
 */

public class NettyClientAdapter {
    private static final Logger LOGGER = LogManager.getLogger(NettyClientAdapter.class);

    private static final CustomThreadFactory THREAD_FACTORY = new CustomThreadFactory("ClentEventLoop", false);

    private final String ip;
    private final int port;
    private final EventLoopGroup clientGroup;
    private final NettyClient client;

    public NettyClientAdapter() {
        this.ip = ProtocolConfig.getIp();
        this.port = ProtocolConfig.getPort();
        clientGroup = new NioEventLoopGroup(1, THREAD_FACTORY);
        client = new NettyClient();
    }

    public void start() {
        connection(ip, port);
    }

    public void quit() {
        if(null != clientGroup) {
            clientGroup.shutdownGracefully();
        }
    }

    public void reconnect() {
        // TODO:: 新线程
        new Thread(() -> {
            connection(ip, port);
        }
        ).start();
    }

    private void connection(final String ip, final int port) {
        try {
            ChannelFuture cf = client.connect(clientGroup, ip, port);
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if(future.isSuccess()) {
                        LOGGER.info("client connect success. ip:{}, port:{}", ip, port);
                    } else {
                        // TODO:: error重连
                    }
                }
            });
        } catch (Exception e) {
            //TODO:: 重连
        }

    }
}
