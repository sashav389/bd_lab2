package com.model.car;

import com.model.disk.Disk;
import com.model.engine.Engine;
import com.model.carColour.CarColour;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "brand")
  private String brand;

  @Column(name = "price")
  private Long price;

  @Column(name = "model")
  private String model;

  @ManyToOne
  @JoinColumn(name = "engine")
  private Engine engine;

  @ManyToOne
  @JoinColumn(name = "disk")
  private Disk disk;

  @ManyToOne
  @JoinColumn(name = "c_car")
  private CarColour carColour;

  @Override
  public String toString(){
    return "car id - " + id +
        ", " + brand + " " + model +
        ", with " + engine + ", with " + disk + " and " + carColour;
  }
}
