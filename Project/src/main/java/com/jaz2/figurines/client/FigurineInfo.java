package com.jaz2.figurines.client;

import lombok.Data;

import java.util.UUID;

@Data
public class FigurineInfo {
    private UUID id;
    private String comment;
}
