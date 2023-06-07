// package com.br.webflux;

// import java.util.UUID;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.br.webflux.document.Song;
// import com.br.webflux.repository.SongRepository;

// import reactor.core.publisher.Flux;

// @Component
// public class DummyData implements CommandLineRunner {

// private final SongRepository songRepository;

// DummyData(SongRepository songRepository) {
// this.songRepository = songRepository;
// }

// @Override
// public void run(String... args) throws Exception {

// songRepository.deleteAll()
// .thenMany(
// Flux.just("Faded", "Don't Worry Child", "Californication",
// "Another Love", "Black out days", "Perfect Girl")
// .map(nome -> new Song(UUID.randomUUID().toString(), nome))
// .flatMap(songRepository::save))
// .subscribe(System.out::println);
// }

// }
