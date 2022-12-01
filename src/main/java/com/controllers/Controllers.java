package com.controllers;


import com.AllService;
import com.model.car.Car;
import com.model.carColour.CarColour;
import com.model.disk.Disk;
import com.model.engine.Engine;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

  private final AllService allService;

  public Controllers(AllService allService){
    this.allService = allService;
  }

  @GetMapping("/cars")
  public ResponseEntity<Iterable<Car>> getAllCars(){

    Iterable<Car> allCars = allService.getAllCars();

    return new ResponseEntity<>(allCars, HttpStatus.OK);
  }

  @GetMapping("/cars/body")
  public ResponseEntity<Iterable<Car>> getCarsByDto(@RequestBody CarDto carDto){

    Iterable<Car> allCars = allService.getCarsByDto(carDto);

    return new ResponseEntity<>(allCars, HttpStatus.OK);
  }

  @GetMapping("/engines")
  public ResponseEntity<Iterable<Engine>> getAllEngines(){

    Iterable<Engine> allEngines = allService.getAllEngines();

    return new ResponseEntity<>(allEngines, HttpStatus.OK);
  }

  @GetMapping("/disks")
  public ResponseEntity<Iterable<Disk>> getAllDisks(){

    Iterable<Disk> allDisk = allService.getAllDisks();

    return new ResponseEntity<>(allDisk, HttpStatus.OK);
  }

  @GetMapping("/colours")
  public ResponseEntity<Iterable<CarColour>> getAllColours(){

    Iterable<CarColour> allCarColour = allService.getAllColours();

    return new ResponseEntity<>(allCarColour, HttpStatus.OK);
  }

  @PostMapping("/car")
  public ResponseEntity<Car> createCar(@RequestBody CarDto carDto){

    Car car = allService.create(carDto);

    return new ResponseEntity<>(car, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Car> deleteCar(@RequestBody CarDto carDto,
      @PathVariable("id") Long id){

    Car car = allService.delete(id);

    return new ResponseEntity<>(car, HttpStatus.OK);
  }

}
