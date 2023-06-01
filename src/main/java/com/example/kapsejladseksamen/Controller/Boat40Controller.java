package com.example.kapsejladseksamen.Controller;

import com.example.kapsejladseksamen.Model.Boats40;
import com.example.kapsejladseksamen.Repository.Boat40Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class Boat40Controller {

  @Autowired
  Boat40Repository boat40Repository;

  @GetMapping("/boats40")
  public List<Boats40> getAllBoats() {
    return boat40Repository.findAll();
  }

  @GetMapping("/boats40/{id}")
  public ResponseEntity<Boats40> getBoatById(@PathVariable(value = "id") int boatId) {
    Optional<Boats40> boat = boat40Repository.findById(boatId);
    if (boat.isPresent()) {
      return ResponseEntity.ok().body(boat.get());
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Boat not found");
    }
  }

  @PostMapping("/boats40")
  public Boats40 addBoat(@RequestBody Boats40 boat) {
    try {
      return boat40Repository.save(boat);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add boat");
    }
  }

  @PutMapping("/boats40/{id}")
  public ResponseEntity<Boats40> updateBoat(@PathVariable(value = "id") int boatId, @RequestBody Boats40 boatDetails) {
    Optional<Boats40> boat = boat40Repository.findById(boatId);
    if (boat.isPresent()) {
      Boats40 updatedBoat = boat.get();
      updatedBoat.setName(boatDetails.getName());
      updatedBoat.setNumber(boatDetails.getNumber());

      try {
        return ResponseEntity.ok().body(boat40Repository.save(updatedBoat));
      } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update boat");
      }
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Boat not found");
    }
  }

  @DeleteMapping("/boats40/{id}")
  public ResponseEntity<?> deleteBoat(@PathVariable(value = "id") int boatId) {
    Optional<Boats40> boat = boat40Repository.findById(boatId);
    if (boat.isPresent()) {
      try {
        boat40Repository.delete(boat.get());
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
