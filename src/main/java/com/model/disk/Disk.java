package com.model.disk;

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
@Table(name = "disks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Disk {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "disk_id")
  private Long id;

  @Column(name = "spokes_number")
  private Integer spokesNumber;

  @Column(name = "material")
  private String material;


  @Column(name = "colour")
  private String colour;

  @Override
  public String toString(){
    return "disk id - " + id +
        ", material " + material + " and " + colour + " colour";
  }
}