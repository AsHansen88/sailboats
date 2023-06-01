package com.example.kapsejladseksamen.Controller;

import com.example.kapsejladseksamen.Model.Boat25_40;
import com.example.kapsejladseksamen.Repository.Boat25_40Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@RestController
public class Boat25_40Controller {


  @Autowired
  Boat25_40Repository boat25_40Repository;

  @GetMapping("/boats25-40")
  public List<Boat25_40> getAllBoats() {
    return boat25_40Repository.findAll();
  }

  @GetMapping("/boats25-40/{id}")
  public ResponseEntity<Boat25_40> getBoatById(@PathVariable(value = "id") int boatId) {
    Optional<Boat25_40> boat = boat25_40Repository.findById(boatId);
    if (boat.isPresent()) {
      return ResponseEntity.ok().body(boat.get());
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Boat not found");
    }
  }

  @PostMapping("/boats20-40")
  public Boat25_40 addBoat(@RequestBody Boat25_40 boat) {
    try {
      return boat25_40Repository.save(boat);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add boat");
    }
  }

  @PutMapping("/boats25-40/{id}")
  public ResponseEntity<Boat25_40> updateBoat(@PathVariable(value = "id") int boatId, @RequestBody Boat25_40 boatDetails) {
    Optional<Boat25_40> boat = boat25_40Repository.findById(boatId);
    if (boat.isPresent()) {
      Boat25_40 updatedBoat = boat.get();
      updatedBoat.setName(boatDetails.getName());
      updatedBoat.setNumber(boatDetails.getNumber());

      try {
        return ResponseEntity.ok().body(boat25_40Repository.save(updatedBoat));
      } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update boat");
      }
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Boat not found");
    }
  }

  @DeleteMapping("/boats25-40/{id}")
  public ResponseEntity<?> deleteBoat(@PathVariable(value = "id") int boatId) {
    Optional<Boat25_40> boat = boat25_40Repository.findById(boatId);
    if (boat.isPresent()) {
      try {
        boat25_40Repository.delete(boat.get());
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
