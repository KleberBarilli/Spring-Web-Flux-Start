package com.br.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.webflux.document.Song;
import com.br.webflux.repository.SongRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SongServiceImplementation implements SongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public Flux<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Mono<Song> findById(String id) {
        return songRepository.findById(id);
    }

    @Override
    public Mono<Song> save(Song song) {
        return songRepository.save(song);
    }

}
