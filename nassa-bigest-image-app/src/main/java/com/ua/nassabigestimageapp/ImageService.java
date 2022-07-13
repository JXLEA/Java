package com.ua.nassabigestimageapp;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.Comparator;

@Service
@Slf4j
public class ImageService {

    private final String API_KEY = "cgZ0ehLM59J4TxPZttTXIczSWGxNifMWcHBLgpDm";
    private RestTemplate restTemplate;


    @Autowired
    ApplicationContext applicationContext;

    @PostConstruct
    private void init() {
        restTemplate = new RestTemplate();
    }

    @Cacheable("picture")
    public URI getBiggestPhoto(String sol) {
        var uri = UriComponentsBuilder.fromHttpUrl("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&api_key={apiKey}").build(sol, API_KEY);
        var photos = restTemplate.getForObject(uri, Photos.class);
        return URI.create(photos.photos()
                .parallelStream()
                .map(Photo::url)
                .map(url -> Pair.of(url, Long.valueOf(restTemplate.headForHeaders(restTemplate.headForHeaders(url).get(HttpHeaders.LOCATION).get(0)).get(HttpHeaders.CONTENT_LENGTH).get(0))))
                .max(Comparator.comparing(Pair::getRight))
                .map(Pair::getLeft).orElseThrow());
    }
}
