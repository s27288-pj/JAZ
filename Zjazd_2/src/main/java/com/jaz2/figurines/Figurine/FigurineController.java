package com.jaz2.figurines.Figurine;

import com.jaz2.figurines.Owner.OwnerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FigurineController {

    private final FigurineService service;

    @PostMapping("/addFigurine")
    public FigurineResponse createFigurine(@RequestBody FigurineCreateRequest request){
        return service.addFigurine(request);
    }

    @GetMapping("/getFigurines")
    public List<FigurineResponse> getFigurines(){
        return service.getAllFigurines();
    }

    @GetMapping("/getFigurine/{id}")
    public FigurineResponse getFigurine(@PathVariable UUID id){
        return service.getFigurine(id);
    }

    @PutMapping("/updateFigurine/{id}")
    public FigurineResponse updateFigurine(@PathVariable UUID id, @RequestBody FigurineUpdateRequest request){
        return service.updateFigurine(id, request);
    }

    @DeleteMapping("/deleteFigurine/{id}")
    public void deleteFigurine(@PathVariable UUID id){
        service.deleteFigurine(id);
    }
}
