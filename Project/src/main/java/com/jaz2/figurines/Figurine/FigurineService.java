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
    private final FigurineMapper mapper;

    public FigurineResponse addFigurine(FigurineCreateRequest request) {
        Figurine newFigurine = mapper.toEntity(request);
        Figurine saved = repository.save(newFigurine);

        return mapper.toResponse(saved);
    }

    public List<FigurineResponse> getAllFigurines() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public FigurineResponse getFigurine(UUID id) {
        Figurine saved = repository.getReferenceById(id);

        return mapper.toResponse(saved);
    }

    public FigurineResponse updateFigurine(UUID id, FigurineUpdateRequest request) {
        Figurine figurine = repository.getReferenceById(id);
        Figurine updated = mapper.toUpdate(figurine, request);
        Figurine saved = repository.save(updated);

        return mapper.toResponse(saved);
    }

    public void deleteFigurine(UUID id) {
        repository.deleteById(id);
    }
}