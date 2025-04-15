package com.demo.service.impl;

import com.demo.service.HelloRestService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloRestServiceImpl implements HelloRestService {
    @Override
    public String hello() {
        return "Hello";
    }
}
