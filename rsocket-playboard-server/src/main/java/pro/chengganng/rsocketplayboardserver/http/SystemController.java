package pro.chengganng.rsocketplayboardserver.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: chenggang
 * @date 2019-12-15.
 */
@Slf4j
@RestController
public class SystemController {

    @RequestMapping("/ping")
    public Mono<String> ping(){
        return Mono.just("pong");
    }
}
