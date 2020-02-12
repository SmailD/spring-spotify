package com.smailD.spring.springSpotify.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Album {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("popularity")
    private int popularity;

    @JsonProperty("album_type")
    private String albumType;

    @JsonProperty("artists")
    private List<Artist> artists;

    @JsonProperty("genres")
    private List<String> genres;

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", albumType='" + albumType + '\'' +
                '}';
    }
}
