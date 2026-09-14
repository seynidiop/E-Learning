package seyni.sn.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seyni.sn.DTO.RealisationRequest;
import seyni.sn.DTO.RealisationResponse;
import seyni.sn.mappers.RealisationMapper;
import seyni.sn.repo.RealisationRepo;
import seyni.sn.services.RealisationService;

import java.util.List;

@RestController
@RequestMapping("/api/realisation")
@AllArgsConstructor

public class RealisationController {
    private final RealisationService service;
    private final RealisationMapper realisationMapper;
    private final RealisationRepo repo;

    @GetMapping
    public List<RealisationResponse> getAllRealisations(){
        return service.getAll();
    }
    @PostMapping
    public  RealisationResponse addRealisation(@RequestBody RealisationRequest request ){
        return service.create(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RealisationResponse> getRealisationById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RealisationResponse> updateRealisation(@PathVariable Long id, @RequestBody RealisationRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRealisation(@PathVariable Long id){
        return service.delete(id);
    }

}
