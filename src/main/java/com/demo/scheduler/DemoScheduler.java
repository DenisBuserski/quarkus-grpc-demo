package com.demo.scheduler;

import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@Slf4j
public class DemoScheduler {
    private AtomicInteger counter = new AtomicInteger(0);

    @Scheduled(every = "10s")
    public void incrementEachTenSeconds() {
        counter.incrementAndGet();
        log.info("Counter: {}", counter);
    }

    @Scheduled(cron = "0 0/5 14 * * ?")
    public void scheduleViaCron(ScheduledExecution scheduledExecution) {
        counter.incrementAndGet();
        log.info("Schedule via cron at: {} and Counter: {}", scheduledExecution.getScheduledFireTime(), counter);
    }
}
