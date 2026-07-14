package learn.sn.demo.controllers;

import learn.sn.demo.repository.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import learn.sn.demo.DTO.*;
import learn.sn.demo.entities.*;
import learn.sn.demo.Request.*;
import lombok.AllArgsConstructor;
import learn.sn.demo.Mapper.*;
import org.springframework.data.domain.Sort;
import learn.sn.demo.service.EtudiantService;
import java.util.*;



@RestController

@AllArgsConstructor
public class HomeController {
    private final EtudiantRepository etudiantRepository;
    private final etudiantMapper etudiantMapper;
    private final FiliereRepository filiereRepository;
    private final filiereMapper filiereMapper;
    private final EtudiantService etudiantService;

    @GetMapping("/etudiants")
    public Iterable<etudiantDTO> getAllEtudiantDTOs(){
       var etudiants = etudiantService.getAll("nom");
       return etudiants;
    }

    @GetMapping("/etudiants/{id}")
    public ResponseEntity<etudiantDTO>  getByEtudiantId(@PathVariable Long id){
        var etudiant = etudiantService.getById(id);
       
        return etudiant;
    }

    @PostMapping("/etudiants")
    public etudiantDTO store(@RequestBody SaveEtuRequest request){
        var etudiantEntity = etudiantMapper.toEntity(request);

        var savedEtudiant = etudiantRepository.save(etudiantEntity);

        return etudiantMapper.toDTO(savedEtudiant);
    }

    @GetMapping("/filiere")
    public Iterable<filiereDTO> getFilieres(){
        return filiereRepository.findAll()
                .stream()
                .map(filiereMapper::toDTO)
                .toList();
    }

    @PostMapping("/filiere")
    public filiereDTO storeFiliere(@RequestBody SaveFilRequest request){
        var filiereEntity = filiereMapper.toEntity(request);
        var savedFiliere = filiereRepository.save(filiereEntity);
        return filiereMapper.toDTO(savedFiliere);
    }

    @PutMapping("/etudiants/{id}")
    public ResponseEntity<etudiantDTO> update(@PathVariable Long id, @RequestBody UpdateEtuRequest request) {
        var etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant == null) { 
            return ResponseEntity.notFound().build();
        }
        etudiantMapper.updateEntityFromRequest(request, etudiant);
        var updatedEtudiant = etudiantRepository.save(etudiant);
        return ResponseEntity.ok(etudiantMapper.toDTO(updatedEtudiant));
    }

    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant == null) {
            return ResponseEntity.notFound().build();
        }
        etudiantRepository.delete(etudiant);
        return ResponseEntity.noContent().build();
    }
}
