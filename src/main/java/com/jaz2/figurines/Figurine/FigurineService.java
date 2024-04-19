package com.jaz2.figurines.Figurine;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FigurineService {

    private final FigurineRepository repository;

    public FigurineResponse addFigurine(FigurineCreateRequest request) {
        Figurine newFigurine = new Figurine();
        newFigurine.setName(request.getName());
        newFigurine.setDescription(request.getDescription());
        newFigurine.setModel(request.getModel());
        newFigurine.setSeries(request.getSeries());
        newFigurine.setIdOwner(request.getIdOwner());
        newFigurine.setBuyPrice(request.getBuyPrice());

        Figurine saved = repository.save(newFigurine);

        FigurineResponse response = new FigurineResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setDescription(saved.getDescription());
        response.setModel(saved.getModel());
        response.setSeries(saved.getSeries());
        response.setIdOwner(saved.getIdOwner());
        response.setBuyPrice(saved.getBuyPrice());

        return response;
    }

    public List<FigurineResponse> getAllFigurines() {
        return repository
                .findAll()
                .stream()
                .map(f -> new FigurineResponse(f.getId(), f.getName(), f.getDescription(), f.getModel(), f.getSeries(), f.getIdOwner(), f.getBuyPrice()))
                .collect(Collectors.toList());
    }

    public FigurineResponse getFigurine(UUID id) {
        Figurine saved = repository.getReferenceById(id);

        FigurineResponse response = new FigurineResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setDescription(saved.getDescription());
        response.setModel(saved.getModel());
        response.setSeries(saved.getSeries());
        response.setIdOwner(saved.getIdOwner());
        response.setBuyPrice(saved.getBuyPrice());

        return response;
    }

    public FigurineResponse updateFigurine(UUID id, FigurineUpdateRequest request) {
        Figurine figurine = repository.getReferenceById(id);
        figurine.setName(request.getName());
        figurine.setDescription(request.getDescription());
        figurine.setModel(request.getModel());
        figurine.setSeries(request.getSeries());
        figurine.setIdOwner(request.getIdOwner());

        FigurineResponse response = new FigurineResponse();
        response.setId(figurine.getId());
        response.setName(figurine.getName());
        response.setDescription(figurine.getDescription());
        response.setModel(figurine.getModel());
        response.setSeries(figurine.getSeries());
        response.setIdOwner(figurine.getIdOwner());

        return response;
    }

    public void deleteFigurine(UUID id) {
        repository.deleteById(id);
    }
}