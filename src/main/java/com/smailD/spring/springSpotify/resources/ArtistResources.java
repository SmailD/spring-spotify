package com.smailD.spring.springSpotify.resources;

import com.smailD.spring.springSpotify.models.Artist;
import com.smailD.spring.springSpotify.services.SpotifyArtistService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ArtistResources {

    private SpotifyArtistService artistService;

    public ArtistResources(SpotifyArtistService artistService) {
        this.artistService = artistService;
    }

    public Mono<Artist> getArtist(@PathVariable String id){
        return artistService.getArtist(id);
    }
}
