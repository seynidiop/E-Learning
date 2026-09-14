package seyni.sn.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import seyni.sn.DTO.RealisationRequest;
import seyni.sn.DTO.RealisationResponse;
import seyni.sn.mappers.RealisationMapper;
import seyni.sn.repo.RealisationRepo;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor

@Service

public class RealisationService {
    private final RealisationRepo repo;
    private final RealisationMapper realisationMapper;


    public List<RealisationResponse> getAll(){
        return repo.findAll()
                    .stream()
                    .map(realisationMapper::toDto)
                    .toList();
    }

    public RealisationResponse create(@RequestBody RealisationRequest request){
        var newRealisation= realisationMapper.toEntity(request);
        repo.save(newRealisation);
        return realisationMapper.toDto(newRealisation);
    }

    public ResponseEntity<RealisationResponse> getById(@RequestParam @PathVariable Long id){
        var search= repo.findById(id).orElse(null);
        if(search==null){
            return  ResponseEntity.notFound().build();
        }
        return   ResponseEntity.ok(realisationMapper.toDto(search)) ;
    }

    public ResponseEntity<RealisationResponse> update(@PathVariable Long id, @RequestBody RealisationRequest realisation){
        var search= repo.findById(id).orElse(null);
        if (search==null){
            return ResponseEntity.notFound().build();
        }
        var updatedValue= repo.save(search);
        realisationMapper.updateRealisation(realisation,updatedValue);
        return ResponseEntity.ok(realisationMapper.toDto(updatedValue));
    }

    public ResponseEntity<Void>delete(@PathVariable Long id){
        var search= repo.findById(id).orElse(null);
        if (search==null){
            return ResponseEntity.notFound().build();
        }
        repo.delete(search);
        return ResponseEntity.noContent().build();
    }
}
