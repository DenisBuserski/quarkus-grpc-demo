package com.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.Set;

@Getter
@Setter
public class TvRestResponse {
    private long id;
    private URL url;
    private String name;
    private String summary;
    private String language;
    private Set<String> genres;
    private URL officialSite;
}
