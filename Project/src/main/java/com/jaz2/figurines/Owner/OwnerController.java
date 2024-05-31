package com.jaz2.figurines.Owner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import com.baeldung.openapi.api.OwnersApi;
import com.baeldung.openapi.model.OwnerCreate;
import com.baeldung.openapi.model.OwnerReceive;
import com.baeldung.openapi.model.OwnerUpdate;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService service;

    @GetMapping
    public ResponseEntity<List<OwnerReceive>> getAllOwners() {
        return ResponseEntity.ok(service.getAllOwners());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerReceive> getOwnerById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getOwnerById(id));
    }

    @PostMapping
    public ResponseEntity<OwnerReceive> createOwner(@RequestBody OwnerCreate owner) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOwner(owner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerReceive> updateOwner(@PathVariable UUID id, @RequestBody OwnerUpdate owner) {
        return ResponseEntity.ok(service.updateOwner(id, owner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable UUID id) {
        service.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }
}
