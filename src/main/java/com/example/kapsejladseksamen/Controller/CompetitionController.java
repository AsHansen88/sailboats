package com.example.kapsejladseksamen.Controller;

import com.example.kapsejladseksamen.Model.Boat25_40;
import com.example.kapsejladseksamen.Model.CompetitionModel;
import com.example.kapsejladseksamen.Repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CompetitionController {

  @Autowired
  CompetitionRepository competitionRepository;

  @GetMapping("/konkurrence")
  public List<CompetitionModel> getAllCompetitions() {
    return competitionRepository.findAll();
  }

  @GetMapping("/konkurrence/{id}")
  public ResponseEntity<CompetitionModel> getCompetitionById(@PathVariable(value = "id") int competitionId) {
    Optional<CompetitionModel> competition = competitionRepository.findById(competitionId);
    if (competition.isPresent()) {
      return ResponseEntity.ok().body(competition.get());
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Competition not found");
    }
  }

  @PostMapping("/konkurrence")
  public CompetitionModel addCompetition(@RequestBody CompetitionModel competition) {
    try {
      return competitionRepository.save(competition);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add competition");
    }
  }

  @PutMapping("/konkurrence/{id}")
  public ResponseEntity<CompetitionModel> updateCompetition(@PathVariable(value = "id") int competitionId, @RequestBody CompetitionModel competitionDetails) {
    Optional<CompetitionModel> competition = competitionRepository.findById(competitionId);
    if (competition.isPresent()) {
      CompetitionModel updatedCompetition = competition.get();
      updatedCompetition.setId(competitionDetails.getId());
      updatedCompetition.setName(competitionDetails.getName());
      updatedCompetition.setBoattype(competitionDetails.getBoattype());
      updatedCompetition.setPoints(competitionDetails.getPoints());

      try {
        return ResponseEntity.ok().body(competitionRepository.save(updatedCompetition));
      } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update competition");
      }
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Competition not found");
    }
  }

  @DeleteMapping("/konkurrence/{id}")
  public ResponseEntity<?> deleteCompetition(@PathVariable(value = "id") int competitionId) {
    Optional<CompetitionModel> competition = competitionRepository.findById(competitionId);
    if (competition.isPresent()) {
      try {
        competitionRepository.delete(competition.get());
        return ResponseEntity.ok().build();
      } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete competition");
      }
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Competition not found");
    }
  }
}



