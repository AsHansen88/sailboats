package com.example.kapsejladseksamen.Service;

import com.example.kapsejladseksamen.Model.Sailboats;
import com.example.kapsejladseksamen.Repository.SailboatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SailboatsService {

  @Autowired
  private SailboatsRepository sailboatsRepository;

  public List<Sailboats> getAllSailboats() {
    return sailboatsRepository.findAll();
  }
}
