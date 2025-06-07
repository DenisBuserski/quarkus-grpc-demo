package com.demo;

import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Startup
@Slf4j
public class HelloStartUp {

    @PostConstruct
    public void init() {
        log.info("Post construct method call");
    }
}
