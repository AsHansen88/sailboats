package com.example.kapsejladseksamen.Service;

import com.example.kapsejladseksamen.Model.Boat25;
import com.example.kapsejladseksamen.Model.Boat25_40;
import com.example.kapsejladseksamen.Model.Boats40;
import com.example.kapsejladseksamen.Model.Sailboats;
import com.example.kapsejladseksamen.Repository.SailboatsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
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
