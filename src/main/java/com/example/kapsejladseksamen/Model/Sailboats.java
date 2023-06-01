package com.example.kapsejladseksamen.Model;

import jakarta.persistence.*;

@Entity
public class Sailboats {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

    @ManyToOne
    @JoinColumn(name = "bo25id", referencedColumnName = "boat25id")
    private Boat25 boat25;

    @ManyToOne
    @JoinColumn(name = "bo40id", referencedColumnName = "boat40id")
    private Boats40 boat40;

    @ManyToOne
    @JoinColumn(name = "bo25_40id", referencedColumnName = "boat25_40id")
    private Boat25_40 boat25_40;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public Boat25 getBoat25() {
    return boat25;
  }

  public void setBoat25(Boat25 boat25) {
    this.boat25 = boat25;
  }

  public Boats40 getBoat40() {
    return boat40;
  }

  public void setBoat40(Boats40 boat40) {
    this.boat40 = boat40;
  }

  public Boat25_40 getBoat25_40() {
    return boat25_40;
  }

  public void setBoat25_40(Boat25_40 boat25_40) {
    this.boat25_40 = boat25_40;
  }
}
