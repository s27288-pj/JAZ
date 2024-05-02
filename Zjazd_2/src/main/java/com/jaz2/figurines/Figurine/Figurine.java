package com.jaz2.figurines.Figurine;

import com.jaz2.figurines.Owner.Owner;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private Owner idOwner;
}
