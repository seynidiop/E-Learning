package learn.sn.demo.Mapper;
import org.mapstruct.Mapper;
import learn.sn.demo.DTO.etudiantDTO;
import learn.sn.demo.entities.etudiant;
import learn.sn.demo.Request.SaveEtuRequest;
import learn.sn.demo.Request.UpdateEtuRequest;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface etudiantMapper {
    etudiantDTO toDTO(etudiant etudiant);
    etudiant toEntity(SaveEtuRequest request);
    void updateEntityFromRequest(UpdateEtuRequest request, @MappingTarget etudiant etudiant);
}
