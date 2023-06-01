package com.example.kapsejladseksamen.Controller;

import com.example.kapsejladseksamen.Model.Sailboats;
import com.example.kapsejladseksamen.Service.SailboatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SailBoatController {


    @Autowired
    private SailboatsService sailboatsService;

    @GetMapping("/boats")
    public List<Sailboats> getAllSailboats() {
      return sailboatsService.getAllSailboats();
    }
  }



