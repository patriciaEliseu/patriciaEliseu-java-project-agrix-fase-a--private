package com.betrybe.agrix.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * class.
 */


@Entity
@Table(name = "crop")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Double planted_area;

  public Crop() {
  }

  public Crop(Long id, String name, Double planted_area) {
    this.id = id;
    this.name = name;
    this.planted_area = planted_area;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlanted_area() {
    return planted_area;
  }

  public void setPlanted_area(Double planted_area) {
    this.planted_area = planted_area;
  }
}
