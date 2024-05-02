package com.jaz2.figurines.Figurine;

import com.jaz2.figurines.Owner.Owner;
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
    private Owner idOwner;
    private Double buyPrice;
}
