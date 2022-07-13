package com.ua.nassabigestimageapp;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Photo(@JsonProperty("img_src") String url) {

}
