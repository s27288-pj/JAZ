package com.jaz2.figurines.Figurine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class FigurineResponse {
    private UUID id;
    private String name;
    private String description;
    private String model;
    private String series;
    private UUID idOwner;
    private Double buyPrice;
}
