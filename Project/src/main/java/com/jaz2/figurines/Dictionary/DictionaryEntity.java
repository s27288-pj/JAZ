package com.jaz2.figurines.Dictionary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
public class DictionaryEntity {
    @Id
    @UuidGenerator
    private UUID id;
    private String valueName;
    private String dictionaryName;
}
