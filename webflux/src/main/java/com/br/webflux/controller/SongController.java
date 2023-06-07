package com.br.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.webflux.document.Song;
import com.br.webflux.service.SongService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public Flux<Song> findAll() {
        return songService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Song> findById(@PathVariable String id) {
        return songService.findById(id);
    }

    @PostMapping
    public Mono<Song> create(Song song) {
        return songService.save(song);
    }

}
