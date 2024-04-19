package com.jaz2.figurines.Figurine;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;



@Data
@Entity
public class Figurine {

    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private String description;
    private String model;
    private String series;
    private Double buyPrice;
    private UUID idOwner;
}
