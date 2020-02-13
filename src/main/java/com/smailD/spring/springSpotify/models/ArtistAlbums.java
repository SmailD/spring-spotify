package com.smailD.spring.springSpotify.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArtistAlbums {

    @JsonProperty("items")
    private List<Album> items;

    public List<Album> getItems() {
        return items;
    }

}
