package com.demo;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class HelloLifecycle {

    public void onStart(@Observes StartupEvent startupEvent) {
        log.info("Quarkus application 'onStart' method triggered");
    }

    public void onStop(@Observes ShutdownEvent shutdownEvent) {
        log.info("Quarkus application 'onStop' method triggered");
    }
}
