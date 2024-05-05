package com.jaz2.figurines.Owner;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository repository;
    private final OwnerMapper mapper;

    public OwnerResponse addOwner(OwnerCreateRequest request) {

        Owner owner = mapper.toEntity(request);
        Owner saved = repository.save(owner);

        return mapper.toResponse(saved);
    }

    public List<OwnerResponse> getAllOwners() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public OwnerResponse getOwner(UUID id) {
        Owner saved = repository.getReferenceById(id);

        return mapper.toResponse(saved);
    }

    public OwnerResponse updateOwner(UUID id, OwnerUpdateRequest request) {
        Owner owner = repository.getReferenceById(id);
        Owner updated = mapper.toUpdate(owner, request);

        Owner saved = repository.save(updated);

        return mapper.toResponse(saved);
    }

    public void deleteOwner(UUID id) {
        repository.deleteById(id);
    }
}