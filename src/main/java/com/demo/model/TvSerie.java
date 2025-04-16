package com.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.Set;

@Getter
@Setter
public class TvSerie {
    private long id;
    private String name;
    private URL url;
    private String summary;
    private String language;
    private Set<String> generes;
    private URL officialSite;
}
