package com.model.carColour;

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
@Table(name = "colours")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarColour {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "colour_id")
  private Long id;

  @Column(name = "colour")
  private String colour;

  @Column(name = "price")
  private Integer price;

  @Override
  public String toString(){
    return "colour id - " + id +
        ", colour " + colour + " and " + price + "$ price";
  }
}
