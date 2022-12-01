package com.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarDto {
  private Long id;
  private Integer hp;
  private Long price;
  private String colour;
  private String brand;
  private String model;
  private Long diskId;

}
