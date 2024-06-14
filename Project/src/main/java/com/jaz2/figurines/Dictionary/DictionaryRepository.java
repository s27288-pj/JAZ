package com.jaz2.figurines.Dictionary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DictionaryRepository extends JpaRepository<DictionaryEntity, UUID> {
    boolean existsByDictionaryNameAndValueName(String valueName, String dictionaryName);
}
