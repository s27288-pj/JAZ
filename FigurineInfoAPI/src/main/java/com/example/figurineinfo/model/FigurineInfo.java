package com.example.figurineinfo.model;

import lombok.Data;

import java.util.UUID;

@Data
public class FigurineInfo {
    private UUID id;
    private String comment;
}
