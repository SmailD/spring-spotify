package com.smailD.spring.springSpotify.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Track {

    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("popularity")
    public Integer popularity;

    @JsonProperty("preview_url")
    public String preview_url;

    @JsonProperty("href")
    public String href;

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", popularity=" + popularity +
                ", preview_url='" + preview_url + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
