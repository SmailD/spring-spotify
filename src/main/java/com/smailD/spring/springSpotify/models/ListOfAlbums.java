package com.smailD.spring.springSpotify.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListOfAlbums {

    @JsonProperty("albums")
    private List<Album> albums;

    public List<Album> getAlbums() {
        return albums;
    }

}
