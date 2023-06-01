package com.example.kapsejladseksamen.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Boats40 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="boat40")
  private int id;
  private String name;
  private int number;

  @OneToMany(mappedBy = "boat40")
  @JsonBackReference
  private Set<Sailboats> sailboats40 = new HashSet<>();

  public Set<Sailboats> getSailboats40() {
    return sailboats40;
  }

  public void setSailboats(Set<Sailboats> sailboats25_40) {
    this.sailboats40 = sailboats40;
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

