package seyni.sn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Realisation {
    @Id
    @GeneratedValue
    private Long id;
    private String titre;
    private String description;
    @Enumerated(EnumType.STRING)
    private typeEntities type;


}
