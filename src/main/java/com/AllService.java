package com;

import com.controllers.CarDto;
import com.model.car.Car;
import com.model.carColour.CarColour;
import com.model.carColour.CarColourRepository;
import com.model.disk.Disk;
import com.model.disk.DisksRepository;
import com.model.engine.Engine;
import com.model.engine.EngineRepository;
import com.model.car.CarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllService {

  private final CarColourRepository carColourRepository;
  private final DisksRepository disksRepository;
  private final EngineRepository engineRepository;
  private final CarRepository carRepository;

  @Autowired
  public AllService(CarColourRepository carColourRepository,
      DisksRepository disksRepository, EngineRepository engineRepository,
      CarRepository carRepository) {
    this.carColourRepository = carColourRepository;
    this.carRepository = carRepository;
    this.disksRepository = disksRepository;
    this.engineRepository = engineRepository;
  }

  public Iterable<Car> getAllCars() {
    return carRepository.findAll();
  }

  public List<Car> getCarsByDto(CarDto carDto) {

    if (carDto.getId() != null) {
      return List.of(carRepository.findById(carDto.getId()).get());
    }

    if (carDto.getColour() != null && carDto.getHp() != null
        && carDto.getPrice() != null) {
      return carRepository.findByEngineAndCarColourAndPrice(engineRepository.findByHorsePowers(carDto.getHp())
          , carColourRepository.findByColour(carDto.getColour()),
          carDto.getPrice());
    }

    if (carDto.getColour() != null && carDto.getHp() != null) {
      return carRepository.findByEngineAndCarColour(engineRepository.findByHorsePowers(carDto.getHp())
          , carColourRepository.findByColour(carDto.getColour()));
    }

    if (carDto.getColour() != null && carDto.getPrice() != null) {
      return carRepository.findByCarColourAndPrice(carColourRepository.findByColour(carDto.getColour()),
          carDto.getPrice());
    }

    if (carDto.getHp() != null && carDto.getPrice() != null) {
      return carRepository.findByEngineAndPrice(engineRepository.findByHorsePowers(carDto.getHp())
          , carDto.getPrice());
    }

    if (carDto.getHp() != null) {
      return carRepository.findByEngine(engineRepository.findByHorsePowers(carDto.getHp()));
    }

    if (carDto.getPrice() != null) {
      return carRepository.findByPrice(carDto.getPrice());
    }

    if (carDto.getColour() != null) {
      return carRepository.findByCarColour(carColourRepository.findByColour(carDto.getColour()));
    }

    return carRepository.findAll();

  }

  public Iterable<Engine> getAllEngines(){
    return engineRepository.findAll();
  }

  public Iterable<Disk> getAllDisks(){
    return disksRepository.findAll();
  }

  public Iterable<CarColour> getAllColours(){
    return carColourRepository.findAll();
  }

  public Car create(CarDto carDto) {
    Car car = new Car();
    car.setCarColour(carColourRepository.findByColour(carDto.getColour()));
    car.setBrand(carDto.getBrand());
    car.setModel(carDto.getModel());
    car.setDisk(disksRepository.findById(carDto.getDiskId()).get());
    car.setEngine(engineRepository.findByHorsePowers(carDto.getHp()));
    car.setPrice(carDto.getPrice());
    if(carDto.getId() != null) {
      car.setId(carDto.getId());
       carRepository.updateCar( car.getBrand(), car.getModel(), car.getPrice(),
           car.getCarColour(), car.getEngine(), car.getDisk(), car.getId());
      return car;
    }
     carRepository.createCar(car.getBrand(), car.getModel(),
        car.getPrice(), car.getCarColour(), car.getEngine(), car.getDisk());
    return car;
  }

  public Car delete(Long id){
    Car car = carRepository.findById(id).get();
    carRepository.deleteCar(id);
    return car;
  }
}
