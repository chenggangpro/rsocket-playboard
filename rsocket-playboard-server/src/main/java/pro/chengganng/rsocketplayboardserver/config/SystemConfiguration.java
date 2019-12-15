package pro.chengganng.rsocketplayboardserver.config;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.rsocket.messaging.RSocketStrategiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.util.pattern.PathPatternRouteMatcher;
import redis.embedded.RedisServer;

import java.io.IOException;
import java.util.Map;

/**
 * @author: chenggang
 * @date 2019-12-09.
 */
@Slf4j
@Configuration
public class SystemConfiguration {

    @Bean(initMethod = "start",destroyMethod = "stop")
    public RedisServer redisServer() throws IOException {
        return new RedisServer(16379);
    }

    @Bean
    public Gson gson(){
        return new Gson();
    }

    @Bean
    public RSocketStrategies rSocketStrategies(ObjectProvider<RSocketStrategiesCustomizer> customizers) {
        RSocketStrategies.Builder builder = RSocketStrategies.builder();
        builder.routeMatcher(new PathPatternRouteMatcher());
        customizers.orderedStream().forEach((customizer) -> customizer.customize(builder));
        return builder
                .metadataExtractorRegistry(metadataExtractorRegistry -> metadataExtractorRegistry
                        .metadataToExtract(
                                MimeTypeUtils.APPLICATION_JSON,
                                new ParameterizedTypeReference<Map<String, Object>>() {},
                                (metadata, headers) -> metadata.forEach(headers::put)
                        )
                )
                .build();
    }
}
