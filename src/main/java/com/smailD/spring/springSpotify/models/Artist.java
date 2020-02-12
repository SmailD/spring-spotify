package com.smailD.spring.springSpotify.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Artist {

    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("genres")
    public List<String> genres;

}
