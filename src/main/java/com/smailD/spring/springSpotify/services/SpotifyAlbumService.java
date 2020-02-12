package com.smailD.spring.springSpotify.services;

import com.smailD.spring.springSpotify.models.Album;
import com.smailD.spring.springSpotify.models.AlbumTracks;
import com.smailD.spring.springSpotify.models.ListOfAlbums;
import com.smailD.spring.springSpotify.models.Track;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class SpotifyAlbumService {

    private final WebClient webClient;

    public SpotifyAlbumService(WebClient webclient) {
        this.webClient = webclient;
    }

    public Mono<Album> getAlbum(String spotifyId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/albums/" + spotifyId).build())
                .retrieve()
                .bodyToMono(Album.class)
                .doOnNext(album -> log.info(album.toString()));
    }

    public Flux<Track> getTracksByAlbum(String spotifyId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/albums/" + spotifyId + "/tracks").build())
                .retrieve()
                .bodyToMono(AlbumTracks.class)
                .map(AlbumTracks::getItems)
                .flatMapMany(Flux::fromIterable)
                .doOnNext(track -> log.info(track.toString()));
    }

    public Flux<Album> getAlbums(String spotifyIds) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/albums/")
                        .queryParam("ids", spotifyIds)
                        .build())
                .retrieve()
                .bodyToMono(ListOfAlbums.class)
                .map(ListOfAlbums::getAlbums)
                .flatMapMany(Flux::fromIterable)
                .doOnNext(album -> log.info(album.toString()));
    }
}

