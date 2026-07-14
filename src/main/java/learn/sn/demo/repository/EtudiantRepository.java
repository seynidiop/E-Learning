package learn.sn.demo.repository;

import learn.sn.demo.entities.etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtudiantRepository extends JpaRepository<etudiant, Long> {
}
