package learn.sn.demo.Mapper;
import org.mapstruct.Mapper;
import learn.sn.demo.DTO.filiereDTO;
import learn.sn.demo.Request.SaveFilRequest;
import learn.sn.demo.entities.filiere;


@Mapper(componentModel = "spring")
public interface filiereMapper {
    filiereDTO toDTO(filiere filiere);
    filiere toEntity(SaveFilRequest request); 
}
