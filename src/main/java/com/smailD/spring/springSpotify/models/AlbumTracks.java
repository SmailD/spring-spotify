package com.smailD.spring.springSpotify.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AlbumTracks {

    @JsonProperty("items")
    private List<Track> items;

    public List<Track> getItems() {
        return items;
    }
}
