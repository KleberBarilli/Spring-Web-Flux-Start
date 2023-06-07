package com.br.webflux;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class SongRouter {

    @Bean
    public RouterFunction<ServerResponse> route(SongHandler handler) {
        return RouterFunctions
                .route(GET("/songs").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/songs/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/songs").and(accept(MediaType.APPLICATION_JSON)), handler::save);

    }

}