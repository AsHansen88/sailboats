package com.example.kapsejladseksamen.Model;

import jakarta.persistence.*;


@Entity
public class CompetitionModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "konkurrenceid")
  private int id;
  private String name;
  private String Boattype;
  private int points;

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

  public String getBoattype() {
    return Boattype;
  }

  public void setBoattype(String boattype) {
    Boattype = boattype;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }
}