package com.ua.nassabigestimageapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor
@Slf4j
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/{sol}/largest")
    public ResponseEntity<?> getBiggestPhoto(@PathVariable String sol) {
        log.info("sol: " + sol);
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(imageService.getBiggestPhoto(sol)).build();
    }
}
