package com.br.webflux.service;

import com.br.webflux.document.Song;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SongService {

    Flux<Song> findAll();

    Mono<Song> findById(String id);

    Mono<Song> save(Song song);
}
