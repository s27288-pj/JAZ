package com.jaz2.figurines.Figurine;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FigurineMapper {

    @Mapping(target = "id", ignore = true)
    Figurine toEntity(FigurineCreateRequest request);

    FigurineResponse toResponse(Figurine figurine);

    @Mapping(target = "id", ignore = true)
    Figurine toUpdate(@MappingTarget Figurine figurine, FigurineUpdateRequest request);
}