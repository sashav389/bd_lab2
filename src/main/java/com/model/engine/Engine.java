package com.model.engine;

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
@Table(name = "engines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Engine {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "engine_id")
  private Long id;

  @Column(name = "cylinders")
  private Integer cylinders;


  @Column(name = "engine_volume")
  private Double engineVolumes;

  @Column(name = "horse_powers")
  private Integer horsePowers;

  @Override
  public String toString(){
    return "Engine id - " + id +
        ", with " + cylinders + " cylinders, " + engineVolumes + " engine volumes and " +
        horsePowers + " horse powers"
        ;
  }
}
