
package com.example.kapsejladseksamen.Configure;

import com.example.kapsejladseksamen.Model.*;
import com.example.kapsejladseksamen.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class initdata implements CommandLineRunner {

  @Autowired
  Boat25Repository boat25Repository;

  @Autowired
  Boat25_40Repository boat25_40Repository;

  @Autowired
  Boat40Repository boat40Repository;

  @Autowired
  SailboatsRepository sailboatsRepository;

  @Autowired
  CompetitionRepository competitionRepository;

  //Boats

  @Override
  public void run(String... args) throws Exception {

    Boat25 boat25 = new Boat25();
    boat25.setName("Kurt");
    boat25.setNumber(2);
    boat25.setId(1);
    boat25Repository.save(boat25);

    Boat25_40 boat25_40 = new Boat25_40();
    boat25_40.setName("Anders");
    boat25_40.setNumber(1);
    boat25_40.setId(2);
    boat25_40Repository.save(boat25_40);

    Boats40 boat40 = new Boats40();
    boat40.setName("Niels");
    boat40.setNumber(3);
    boat40.setId(3);
    boat40Repository.save(boat40);

    //Competition

    CompetitionModel competition = new CompetitionModel();
    competition.setName("Holger");
    competition.setId(1);
    competition.setBoattype("40fods");
    competition.setPoints(3);
    competitionRepository.save(competition);

  }

}