package com.demo.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "application")
public interface CustomConfig {
    String message();
}
