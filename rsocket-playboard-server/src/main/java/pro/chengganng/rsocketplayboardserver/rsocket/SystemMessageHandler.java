package pro.chengganng.rsocketplayboardserver.rsocket;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author: chenggang
 * @date 2019-12-09.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class SystemMessageHandler {

    private final Gson gson;

    @MessageMapping("ping")
    public Mono<String> ping(){
        return Mono.just("pong");
    }

    @MessageMapping("echo")
    public Mono<Map> echo(Mono<Map> body){
        return body;
    }

}
