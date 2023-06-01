package com.example.kapsejladseksamen.Configure;

import com.example.kapsejladseksamen.Model.Boat25;
import com.example.kapsejladseksamen.Model.Boat25_40;
import com.example.kapsejladseksamen.Model.Boats40;
import com.example.kapsejladseksamen.Repository.Boat25Repository;
import com.example.kapsejladseksamen.Repository.Boat25_40Repository;
import com.example.kapsejladseksamen.Repository.Boat40Repository;
import com.example.kapsejladseksamen.Repository.SailboatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

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


  }

  }
