package com.example.kapsejladseksamen.Controller;

import com.example.kapsejladseksamen.Model.Sailboats;
import com.example.kapsejladseksamen.Repository.SailboatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SailBoatController {


  @Autowired
  SailboatsRepository sailboatsRepository;

  @GetMapping("/boats")
  public List<Sailboats> getAllBoats() {
    return sailboatsRepository.findAll();
  }

  @GetMapping("/boats/{id}")
  public ResponseEntity<Sailboats> getBoatById(@PathVariable(value = "id") int boatId) {
    Optional<Sailboats> boat = sailboatsRepository.findById(boatId);
    if (boat.isPresent()) {
      return ResponseEntity.ok().body(boat.get());
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Boat not found");
    }
  }

  @PostMapping("/boats")
  public Sailboats addBoat(@RequestBody Sailboats boat) {
    try {
      sailboatsRepository.save(boat);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return boat;
  }

  @PutMapping("/boats/{id}")
  public ResponseEntity<Sailboats> updateBoat(@PathVariable(value = "id") int boatId, @RequestBody Sailboats boatDetails) {
    Optional<Sailboats> boat = sailboatsRepository.findById(boatId);
    if (boat.isPresent()) {
      Sailboats updatedBoat = boat.get();
      updatedBoat.setBoat25(boatDetails.getBoat25());
      updatedBoat.setBoat25_40(boatDetails.getBoat25_40());
      updatedBoat.setBoat40(boatDetails.getBoat40());

      sailboatsRepository.save(updatedBoat);
      return ResponseEntity.ok().body(updatedBoat);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Boat not found");
    }
  }

  @DeleteMapping("/boats/{id}")
  public ResponseEntity<?> deleteBoat(@PathVariable(value = "id") int boatId) {
    Optional<Sailboats> boat = sailboatsRepository.findById(boatId);
    if (boat.isPresent()) {
      sailboatsRepository.delete(boat.get());
      return ResponseEntity.ok().build();
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Boat not found");
    }
  }
}


