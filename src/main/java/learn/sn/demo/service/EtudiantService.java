package learn.sn.demo.service;
import lombok.*;

import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import learn.sn.demo.DTO.etudiantDTO;
import learn.sn.demo.Mapper.etudiantMapper;
import learn.sn.demo.repository.EtudiantRepository;

@AllArgsConstructor
@Service
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;
    private final etudiantMapper etudiantMapper;

    
    public Iterable<etudiantDTO> getAll(@RequestParam(required = false, defaultValue = "nom") String sort){
        if(Set.of("nom", "tel").contains(sort)){
            sort = "nom";
        }
        return etudiantRepository.findAll(Sort.by(sort).descending())
        .stream()
        .map(etudiantMapper::toDTO)
        .toList();
    }

    public ResponseEntity<etudiantDTO>  getById(@PathVariable Long id){
        var etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(etudiantMapper.toDTO(etudiant));
    }
}
