package com.jaz2.figurines.Figurine;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import com.baeldung.openapi.api.FigurineApi;
import com.baeldung.openapi.model.FigurineCreate;
import com.baeldung.openapi.model.FigurineReceive;
import com.baeldung.openapi.model.FigurineUpdate;

@RestController
@RequestMapping("/figurines")
@RequiredArgsConstructor
public class FigurineController {

    private final FigurineService service;

    @GetMapping
    public ResponseEntity<List<FigurineReceive>> getAllFigurines() {
        return ResponseEntity.ok(service.getAllFigurines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FigurineReceive> getFigurineById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getFigurineById(id));
    }

    @PostMapping
    public ResponseEntity<FigurineReceive> createFigurine(@RequestBody FigurineCreate figurine) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createFigurine(figurine));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FigurineReceive> updateFigurine(@PathVariable UUID id, @RequestBody FigurineUpdate figurine) {
        return ResponseEntity.ok(service.updateFigurine(id, figurine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFigurine(@PathVariable UUID id) {
        service.deleteFigurine(id);
        return ResponseEntity.noContent().build();
    }
}
