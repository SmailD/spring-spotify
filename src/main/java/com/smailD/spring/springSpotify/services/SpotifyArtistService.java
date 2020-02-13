package com.smailD.spring.springSpotify.services;

import com.smailD.spring.springSpotify.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class SpotifyArtistService {

    private WebClient webClient;

    public SpotifyArtistService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Artist> getArtist(String spotifyId){
        return this.webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/artists/" + spotifyId).build())
                .retrieve()
                .bodyToMono(Artist.class)
                .doOnNext(artist -> log.info(artist.toString()));
    }

    public Flux<Album> getArtistAlbums(String spotifyId){
        return this.webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/artists/" + spotifyId + "/albums").build())
                .retrieve()
                .bodyToMono(ArtistAlbums.class)
                .map(ArtistAlbums::getItems)
                .flatMapMany(Flux::fromIterable)
                .doOnNext(artist -> log.info(artist.toString()));
    }

    public Flux<Track> getArtistTopTracks(String spotifyId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/artists/" + spotifyId + "/top-tracks").build())
                .retrieve()
                .bodyToMono(ListOfTracks.class)
                .map(ListOfTracks::getTracks)
                .flatMapMany(Flux::fromIterable)
                .doOnNext(track -> log.info(track.toString()));
    }

    public Flux<Artist> getArtists(String spotifyIds) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/artists/")
                        .queryParam("ids", spotifyIds)
                        .build())
                .retrieve()
                .bodyToMono(ListOfArtists.class)
                .map(ListOfArtists::getArtists)
                .flatMapMany(Flux::fromIterable)
                .doOnNext(artist -> log.info(artist.toString()));
    }

}
