package seyni.sn.DTO;

import lombok.*;
import seyni.sn.entities.typeEntities;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class RealisationResponse {
    private Long id;
    private String titre;
    private String description;
    private typeEntities type;
}
