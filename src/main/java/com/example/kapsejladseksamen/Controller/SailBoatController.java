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

}


