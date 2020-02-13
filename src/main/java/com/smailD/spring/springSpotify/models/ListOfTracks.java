package com.smailD.spring.springSpotify.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListOfTracks {

    @JsonProperty("tracks")
    private List<Track> tracks;

    public List<Track> getTracks() {
        return tracks;
    }

}
