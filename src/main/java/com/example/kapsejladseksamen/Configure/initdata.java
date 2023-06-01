package com.example.kapsejladseksamen.Configure;

import com.example.kapsejladseksamen.Model.Boat25;
import com.example.kapsejladseksamen.Model.Boat25_40;
import com.example.kapsejladseksamen.Model.Boats40;
import com.example.kapsejladseksamen.Model.Sailboats;
import com.example.kapsejladseksamen.Repository.Boat25Repository;
import com.example.kapsejladseksamen.Repository.Boat25_40Repository;
import com.example.kapsejladseksamen.Repository.Boat40Repository;
import com.example.kapsejladseksamen.Repository.SailboatsRepository;
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

    Sailboats sailboats = new Sailboats();
    sailboats.setBoat25(boat25);
    sailboats.setBoat25_40(boat25_40);
    sailboats.setBoat40(boat40);
    sailboatsRepository.save(sailboats);


  }

  }
