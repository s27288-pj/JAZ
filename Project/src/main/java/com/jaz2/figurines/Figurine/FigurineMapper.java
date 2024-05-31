package com.jaz2.figurines.Figurine;

import org.mapstruct.*;

import com.baeldung.openapi.model.FigurineCreate;
import com.baeldung.openapi.model.FigurineReceive;
import com.baeldung.openapi.model.FigurineUpdate;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FigurineMapper {

    @Mapping(target = "id", ignore = true)
    Figurine toFigurine(FigurineCreate figurineCreate);

    FigurineReceive toFigurineReceive(Figurine figurine);

    @Mapping(target = "id", ignore = true)
    Figurine toUpdate(@MappingTarget Figurine figurine, FigurineUpdate figurineUpdate);
}