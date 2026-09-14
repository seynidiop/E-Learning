package seyni.sn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seyni.sn.entities.Realisation;

import java.util.List;
import java.util.Optional;
@Repository
public interface RealisationRepo extends JpaRepository<Realisation,Long>{
    List<Realisation> findByType(String type);
}
