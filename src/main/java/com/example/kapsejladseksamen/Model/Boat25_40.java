package com.example.kapsejladseksamen.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Boat25_40 {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="boat25_40id")
  private int id;
  private String name;
  private int number;

  @OneToMany(mappedBy = "boat25_40")
  @JsonBackReference
  private Set<Sailboats> sailboats25_40 = new HashSet<>();

  public Set<Sailboats> getSailboats25_40() {
    return sailboats25_40;
  }

  public void setSailboats(Set<Sailboats> sailboats25_40) {
    this.sailboats25_40 = sailboats25_40;
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
