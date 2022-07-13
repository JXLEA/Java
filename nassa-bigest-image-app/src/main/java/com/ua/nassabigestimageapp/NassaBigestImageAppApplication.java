package com.ua.nassabigestimageapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class NassaBigestImageAppApplication {

    @Bean
    @CacheEvict("picture")
    @Scheduled(cron = "10 * * * * MON-FRI")
    public CacheManager getCacheManager() {
        return new ConcurrentMapCacheManager();
    }

    public static void main(String[] args) {
        SpringApplication.run(NassaBigestImageAppApplication.class, args);
    }

}
