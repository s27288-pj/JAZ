package com.jaz2.figurines.Figurine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FigurineRepository extends JpaRepository<Figurine, UUID> {
}
