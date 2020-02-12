package com.smailD.spring.springSpotify.resources;

import com.smailD.spring.springSpotify.models.Album;
import com.smailD.spring.springSpotify.models.Track;
import com.smailD.spring.springSpotify.services.SpotifyAlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AlbumResources {

    private SpotifyAlbumService albumService;

    public AlbumResources(SpotifyAlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping(value = "/albums/{id}")
    public Mono<Album> album(@PathVariable final String id){
        return albumService.getAlbum(id);
    }

    @GetMapping(value = "/albums/{id}/tracks")
    public Flux<Track> albumTracks(@PathVariable final String id){
        return albumService.getTracksByAlbum(id);
    }

    @GetMapping(value = "/albums")
    public Flux<Album> albums(@RequestParam final String ids){
        return albumService.getAlbums(ids);
    }

}
