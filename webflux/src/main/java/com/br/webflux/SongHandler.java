package com.br.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.br.webflux.document.Song;
import com.br.webflux.service.SongService;

import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
public class SongHandler {

    @Autowired
    private SongService songService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(songService.findAll(), Song.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(songService.findById(id), Song.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Song> song = request.bodyToMono(Song.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(song.flatMap(songService::save), Song.class));
    }
}
