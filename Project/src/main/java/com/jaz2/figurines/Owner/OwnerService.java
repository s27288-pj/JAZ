package com.jaz2.figurines.Owner;

import com.jaz2.figurines.Exceptions.OwnerNotFoundException;
import com.jaz2.figurines.Exceptions.BadOwnerFieldsException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.baeldung.openapi.model.OwnerCreate;
import com.baeldung.openapi.model.OwnerReceive;
import com.baeldung.openapi.model.OwnerUpdate;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository OwnerRepository;
    private final OwnerMapper ownerMapper;

    public List<OwnerReceive> getAllOwners() {
        return OwnerRepository.findAll().stream().map(ownerMapper::toOwnerReceive).collect(Collectors.toList());
    }

    public OwnerReceive getOwnerById(UUID id) {
        if (OwnerRepository.existsById(id)) {
            return ownerMapper.toOwnerReceive(OwnerRepository.findById(id).orElseThrow());
        } else {
            throw new OwnerNotFoundException("Owner not found" + id);
        }
    }

    public OwnerReceive createOwner(OwnerCreate ownerCreate) {
        verifyOwnerCreateFields(ownerCreate);
        var owner = ownerMapper.toOwner(ownerCreate);
        return ownerMapper.toOwnerReceive(OwnerRepository.save(owner));
    }

    @Transactional
    public OwnerReceive updateOwner(UUID id, OwnerUpdate ownerUpdate) {
        if (OwnerRepository.existsById(id)) {
            verifyOwnerUpdateFields(ownerUpdate);
            var owner = OwnerRepository.findById(id).orElseThrow();
            ownerMapper.toUpdate(owner, ownerUpdate);
            return ownerMapper.toOwnerReceive(owner);
        } else {
            throw new OwnerNotFoundException("Owner not found" + id);
        }
    }

    public void deleteOwner(UUID id) {
        if (OwnerRepository.existsById(id)) {
            OwnerRepository.deleteById(id);
        } else {
            throw new OwnerNotFoundException("Owner not found" + id);
        }
    }

    public void verifyOwnerCreateFields(OwnerCreate ownerCreate) {
        if (ownerCreate.getName() == null || ownerCreate.getName().isEmpty()) {
            throw new BadOwnerFieldsException("Owner name is required");
        }
        if (ownerCreate.getSurname() == null || ownerCreate.getSurname().isEmpty()) {
            throw new BadOwnerFieldsException("Owner surname is required");
        }
        if (ownerCreate.getEmail() == null || ownerCreate.getEmail().isEmpty()) {
            throw new BadOwnerFieldsException("Owner email is required");
        }
        if (ownerCreate.getAddress() == null || ownerCreate.getAddress().isEmpty()) {
            throw new BadOwnerFieldsException("Owner address is required");
        }
        if (ownerCreate.getPhone() == null || ownerCreate.getPhone().isEmpty()) {
            throw new BadOwnerFieldsException("Owner phone is required");
        }
    }

    public void verifyOwnerUpdateFields(OwnerUpdate ownerUpdate) {
        if (ownerUpdate.getName() == null || ownerUpdate.getName().isEmpty()) {
            throw new BadOwnerFieldsException("Owner name is required");
        }
        if (ownerUpdate.getSurname() == null || ownerUpdate.getSurname().isEmpty()) {
            throw new BadOwnerFieldsException("Owner surname is required");
        }
        if (ownerUpdate.getEmail() == null || ownerUpdate.getEmail().isEmpty()) {
            throw new BadOwnerFieldsException("Owner email is required");
        }
        if (ownerUpdate.getAddress() == null || ownerUpdate.getAddress().isEmpty()) {
            throw new BadOwnerFieldsException("Owner address is required");
        }
        if (ownerUpdate.getPhone() == null || ownerUpdate.getPhone().isEmpty()) {
            throw new BadOwnerFieldsException("Owner phone is required");
        }
    }
}