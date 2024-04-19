package com.jaz2.figurines.Owner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository repository;

    public OwnerResponse addOwner(OwnerCreateRequest request){
        Owner newOwner = new Owner();
        newOwner.setName(request.getName());
        newOwner.setSurname(request.getSurname());
        newOwner.setEmail(request.getEmail());
        newOwner.setAddress(request.getAddress());
        newOwner.setPhone(request.getPhone());

        Owner saved = repository.save(newOwner);

        OwnerResponse response = new OwnerResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setSurname(saved.getSurname());
        response.setEmail(saved.getEmail());
        response.setAddress(saved.getAddress());
        response.setPhone(saved.getPhone());

        return response;
    }

    public List<OwnerResponse> getAllOwners() {
        return repository
                .findAll()
                .stream()
                .map(o -> new OwnerResponse(o.getId(), o.getName(), o.getSurname(), o.getEmail(), o.getAddress(), o.getPhone()))
                .collect(Collectors.toList());
    }

    public OwnerResponse getOwner(UUID id) {
        Owner saved = repository.getReferenceById(id);

        OwnerResponse response = new OwnerResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setSurname(saved.getSurname());
        response.setEmail(saved.getEmail());
        response.setAddress(saved.getAddress());
        response.setPhone(saved.getPhone());

        return response;
    }

    public OwnerResponse updateOwner(UUID id, OwnerUpdateRequest request) {
        Owner owner = repository.getReferenceById(id);
        owner.setName(request.getName());
        owner.setSurname(request.getSurname());
        owner.setEmail(request.getEmail());
        owner.setAddress(request.getAddress());
        owner.setPhone(request.getPhone());

        OwnerResponse response = new OwnerResponse();
        response.setId(owner.getId());
        response.setName(owner.getName());
        response.setSurname(owner.getSurname());
        response.setEmail(owner.getEmail());
        response.setAddress(owner.getAddress());
        response.setPhone(owner.getPhone());

        return response;
    }

    public void deleteOwner(UUID id) {
        repository.deleteById(id);
    }
}