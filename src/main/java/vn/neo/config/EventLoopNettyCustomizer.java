package vn.neo.config;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import reactor.netty.http.server.HttpServer;

/**
 * @author thanglv on 12/22/2021
 * @project fast-forward
 */
public class EventLoopNettyCustomizer implements NettyServerCustomizer {
    @Override
    public HttpServer apply(HttpServer httpServer) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        eventLoopGroup.register(new NioServerSocketChannel());
        return httpServer.runOn(eventLoopGroup);
    }
}
