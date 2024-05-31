package com.jaz2.figurines.Figurine;

import com.jaz2.figurines.Exceptions.FigurineNotFoundException;
import com.jaz2.figurines.Exceptions.BadFigurineFieldsException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.baeldung.openapi.model.FigurineCreate;
import com.baeldung.openapi.model.FigurineReceive;
import com.baeldung.openapi.model.FigurineUpdate;

@Service
@RequiredArgsConstructor
public class FigurineService {

    private final FigurineRepository repository;
    private final FigurineMapper mapper;

    public List<FigurineReceive> getAllFigurines() {
        return repository.findAll().stream().map(mapper::toFigurineReceive).collect(Collectors.toList());
    }

    public FigurineReceive getFigurineById(UUID id) {
        if (repository.existsById(id)) {
            return mapper.toFigurineReceive(repository.findById(id).orElseThrow());
        } else {
            throw new FigurineNotFoundException("Figurine not found" + id);
        }
    }

    public FigurineReceive createFigurine(FigurineCreate figurineCreate) {
        verifyFigurineCreateFields(figurineCreate);
        Figurine figurine = repository.save(mapper.toFigurine(figurineCreate));
        return mapper.toFigurineReceive(figurine);
    }

    @Transactional
    public FigurineReceive updateFigurine(UUID id, FigurineUpdate figurineUpdate) {
        if (repository.existsById(id)) {
            verifyFigurineUpdateFields(figurineUpdate);
            Figurine figurine = repository.findById(id).orElseThrow();
            mapper.toUpdate(figurine, figurineUpdate);
            return mapper.toFigurineReceive(figurine);
        } else {
            throw new FigurineNotFoundException("Figurine not found" + id);
        }
    }

    public void deleteFigurine(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new FigurineNotFoundException("Figurine not found" + id);
        }
    }

    private void verifyFigurineCreateFields(FigurineCreate figurineCreate) {
        if (figurineCreate.getName() == null || figurineCreate.getName().isBlank()) {
            throw new BadFigurineFieldsException("Figurine name is required");
        }
        if (figurineCreate.getDescription() == null || figurineCreate.getDescription().isBlank()) {
            throw new BadFigurineFieldsException("Figurine description is required");
        }
        if (figurineCreate.getModel() == null || figurineCreate.getModel().isBlank()) {
            throw new BadFigurineFieldsException("Figurine model is required");
        }
        if (figurineCreate.getSeries() == null || figurineCreate.getSeries().isBlank()) {
            throw new BadFigurineFieldsException("Figurine series is required");
        }

        if (figurineCreate.getBuyPrice() == null || figurineCreate.getBuyPrice() <= 0) {
            throw new BadFigurineFieldsException("Figurine price is required");
        }
        if (figurineCreate.getOwner() == null) {
            throw new BadFigurineFieldsException("Figurine owner is required");
        }
    }

    private void verifyFigurineUpdateFields(FigurineUpdate figurineUpdate) {
        if (figurineUpdate.getName() == null || figurineUpdate.getName().isBlank()) {
            throw new BadFigurineFieldsException("Figurine name is required");
        }
        if (figurineUpdate.getDescription() == null || figurineUpdate.getDescription().isBlank()) {
            throw new BadFigurineFieldsException("Figurine description is required");
        }
        if (figurineUpdate.getModel() == null || figurineUpdate.getModel().isBlank()) {
            throw new BadFigurineFieldsException("Figurine model is required");
        }
        if (figurineUpdate.getSeries() == null || figurineUpdate.getSeries().isBlank()) {
            throw new BadFigurineFieldsException("Figurine series is required");
        }

        if (figurineUpdate.getBuyPrice() == null || figurineUpdate.getBuyPrice() <= 0) {
            throw new BadFigurineFieldsException("Figurine price is required");
        }
        if (figurineUpdate.getOwner() == null) {
            throw new BadFigurineFieldsException("Figurine owner is required");
        }
    }
}