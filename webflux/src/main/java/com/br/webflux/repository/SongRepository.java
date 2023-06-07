package com.br.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.br.webflux.document.Song;

public interface SongRepository extends ReactiveMongoRepository<Song, String> {

}
