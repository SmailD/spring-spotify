package com.smailD.spring.springSpotify.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListOfArtists {

    @JsonProperty("artists")
    private List<Artist> artists;

    public List<Artist> getArtists() {
        return artists;
    }

}
