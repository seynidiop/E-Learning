package learn.sn.demo.entities;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "etudiant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String tel;
    private String password;


}
