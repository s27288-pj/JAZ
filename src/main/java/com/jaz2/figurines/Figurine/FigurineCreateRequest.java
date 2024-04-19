package com.jaz2.figurines.Figurine;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class FigurineCreateRequest {
    private String name;
    private String description;
    private String model;
    private String series;
    private UUID idOwner;
    private Double buyPrice;
}
