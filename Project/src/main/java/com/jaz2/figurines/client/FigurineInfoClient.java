package com.jaz2.figurines.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "figurineInfoClient", url = "http://localhost:8081")
public interface FigurineInfoClient {

    @GetMapping("/figurines/{id}")
    FigurineInfo getFigurineInfo(@PathVariable("id") UUID id);
}