package com.example.kapsejladseksamen.Controller;

import com.example.kapsejladseksamen.Model.Boat25;
import com.example.kapsejladseksamen.Repository.Boat25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class Boat25Controller {

  @Autowired
  Boat25Repository boat25Repository;

  @GetMapping("/boats25")
  public List<Boat25> getAllBoats() {
    return boat25Repository.findAll();
  }

  @GetMapping("/boats25/{id}")
  public ResponseEntity<Boat25> getBoatById(@PathVariable(value = "id") int boatId) {
    Optional<Boat25> boat = boat25Repository.findById(boatId);
    if (boat.isPresent()) {
      return ResponseEntity.ok().body(boat.get());
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Boat not found");
    }
  }

  @PostMapping("/boats25")
  public Boat25 addBoat(@RequestBody Boat25 boat) {
    try {
      return boat25Repository.save(boat);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add boat");
    }
  }

  @PutMapping("/boats25/{id}")
  public ResponseEntity<Boat25> updateBoat(@PathVariable(value = "id") int boatId, @RequestBody Boat25 boatDetails) {
    Optional<Boat25> boat = boat25Repository.findById(boatId);
    if (boat.isPresent()) {
      Boat25 updatedBoat = boat.get();
      updatedBoat.setName(boatDetails.getName());
      updatedBoat.setNumber(boatDetails.getNumber());

      try {
        return ResponseEntity.ok().body(boat25Repository.save(updatedBoat));
      } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update boat");
      }
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Boat not found");
    }
  }

  @DeleteMapping("/boats25/{id}")
  public ResponseEntity<?> deleteBoat(@PathVariable(value = "id") int boatId) {
    Optional<Boat25> boat = boat25Repository.findById(boatId);
    if (boat.isPresent()) {
      try {
        boat25Repository.delete(boat.get());
        return ResponseEntity.ok().build();
      } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete boat");
      }
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Boat not found");
    }
  }
}