package com.jaz2.figurines.Owner;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface OwnerMapper {

    @Mapping(target = "id", ignore = true)
    Owner toEntity(OwnerCreateRequest request);

    OwnerResponse toResponse(Owner owner);

    @Mapping(target = "id", ignore = true)
    Owner toUpdate(@MappingTarget Owner owner, OwnerUpdateRequest request);
}
