package com.demo.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloRestService {

    public String hello() {
        return "Hello World";
    }

    public String greeting(String name) {
        return "Hello " + name;
    }
}
