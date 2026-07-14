package learn.sn.demo.entities;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "filiere")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class filiere {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String nom;
    
}
