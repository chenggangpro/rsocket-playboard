package pro.chengganng.rsocketplayboardserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import redis.embedded.RedisServer;

import java.io.IOException;

@SpringBootApplication
public class RsocketPlayboardServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsocketPlayboardServerApplication.class, args);
    }

    @Bean(initMethod = "start",destroyMethod = "stop")
    public RedisServer redisServer() throws IOException {
        return new RedisServer(16379);
    }

}
