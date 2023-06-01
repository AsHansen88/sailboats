package com.example.kapsejladseksamen.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Boat25 {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="boat25")
  private int id;
  private String name;
  private int number;

  @OneToMany(mappedBy = "boat25")
  @JsonBackReference
  private Set<Sailboats> sailboats25 = new HashSet<>();

  public Set<Sailboats> getSailboats25() {
    return sailboats25;
  }

  public void setSailboats25(Set<Sailboats> sailboats25) {
    this.sailboats25 = sailboats25;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
