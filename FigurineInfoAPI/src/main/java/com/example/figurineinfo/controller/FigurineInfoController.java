package com.example.figurineinfo.controller;

import com.example.figurineinfo.model.FigurineInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FigurineInfoController {

    @GetMapping("/figurines/{id}")
    public FigurineInfo getFigurineInfo(@PathVariable UUID id) {
        FigurineInfo figurineInfo = new FigurineInfo();
        figurineInfo.setId(id);
        figurineInfo.setComment("This is a comment");
        return figurineInfo;
    }
}
