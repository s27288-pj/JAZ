package com.jaz2.figurines.Owner;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService service;

    @PostMapping("/addOwner")
    public OwnerResponse createOwner(@RequestBody OwnerCreateRequest request){
        return service.addOwner(request);
    }

    @GetMapping("/getOwners")
    public List<OwnerResponse> getOwners(){
        return service.getAllOwners();
    }

    @GetMapping("/getOwner/{id}")
    public OwnerResponse getOwner(@PathVariable UUID id){
        return service.getOwner(id);
    }

    @PutMapping("/updateOwner/{id}")
    public OwnerResponse updateOwner(@PathVariable UUID id, @RequestBody OwnerUpdateRequest request){
        return service.updateOwner(id, request);
    }

    @DeleteMapping("/deleteOwner/{id}")
    public void deleteOwner(@PathVariable UUID id){
        service.deleteOwner(id);
    }
}
