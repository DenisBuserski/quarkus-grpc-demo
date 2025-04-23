package com.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.Set;

@Getter
@Setter
public class TvRESTResponse {
    private long id;
    private URL url;
    private String name;
    private String type;
    private String language;
    private Set<String> generes;
    private URL officialSite;
}
