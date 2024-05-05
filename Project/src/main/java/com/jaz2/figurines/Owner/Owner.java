package com.jaz2.figurines.Owner;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
public class Owner {
    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
}
