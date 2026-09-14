package seyni.sn.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import seyni.sn.DTO.RealisationRequest;
import seyni.sn.DTO.RealisationResponse;
import seyni.sn.entities.Realisation;

@Mapper(componentModel = "spring")
public interface RealisationMapper {
    RealisationResponse toDto(Realisation realisation);
    Realisation toEntity (RealisationRequest request);
    void updateRealisation(RealisationRequest request, @MappingTarget Realisation realisation);
}
