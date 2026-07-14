package learn.sn.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import learn.sn.demo.entities.filiere;

@Repository
public interface FiliereRepository extends JpaRepository<filiere, Long> {
    
}
