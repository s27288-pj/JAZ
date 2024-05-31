package com.jaz2.figurines.Owner;

import org.mapstruct.*;

import com.baeldung.openapi.model.OwnerCreate;
import com.baeldung.openapi.model.OwnerReceive;
import com.baeldung.openapi.model.OwnerUpdate;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface OwnerMapper {

    @Mapping(target = "id", ignore = true)
    Owner toOwner(OwnerCreate ownerCreate);

    @Mapping(target = "id", ignore = true)
    Owner toUpdate(@MappingTarget Owner owner, OwnerUpdate ownerUpdate);

    OwnerReceive toOwnerReceive(Owner owner);
}
