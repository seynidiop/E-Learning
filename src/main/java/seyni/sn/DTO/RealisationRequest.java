package seyni.sn.DTO;
import lombok.*;
import seyni.sn.entities.typeEntities;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class RealisationRequest{
    private String titre;
    private String description;
    private typeEntities type;
}
