package com.initialization;

import com.model.carColour.CarColour;
import com.model.carColour.CarColourRepository;
import com.model.disk.Disk;
import com.model.disk.DisksRepository;
import com.model.engine.Engine;
import com.model.engine.EngineRepository;
import com.model.car.Car;
import com.model.car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Class for initializing first coordinator in the system.
 */
@Component
public class StartDataLoader implements ApplicationRunner {

  @Autowired
  CarColourRepository carColourRepository;
  @Autowired
  CarRepository carNumberRepository;
  @Autowired
  DisksRepository disksRepository;
  @Autowired
  EngineRepository engineRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Disk disk = new Disk(null, 5, "metal", "black");
    Disk disk2 = new Disk(null, 6, "aluminium", "silver");
    Disk disk3 = new Disk(null, 7, "titan", "black");
    Disk disk4 = new Disk(null, 5, "carbon", "carbon");
    Disk disk5 = new Disk(null, 7, "metal", "yellow");

    Engine engine = new Engine(null, 6, 2.2D, 210);
    Engine engine2 = new Engine(null, 4, 1.4D, 170);
    Engine engine3 = new Engine(null, 4, 2.0D, 200);
    Engine engine4 = new Engine(null, 8, 4.0D, 550);
    Engine engine5 = new Engine(null, 12, 6.3D, 780);
    Engine engine6 = new Engine(null, 6, 3.2D, 410);
    Engine engine7 = new Engine(null, 16, 8D, 1600);

    CarColour carColour = new CarColour(null, "black", 1000);
    CarColour carColour2 = new CarColour(null, "white", 2000);
    CarColour carColour3 = new CarColour(null, "silver", 1200);

    Car carNumber = new Car(null, "Mercrdes", 180000L, "S-223",  engine4, disk4, carColour2);
    Car carNumber2 = new Car(null, "Mazda", 40000L, "6", engine2, disk, carColour);
    Car carNumber3 = new Car(null, "Porsche", 220000L, "911", engine6, disk3, carColour3);
    Car carNumber4 = new Car(null, "Porsche", 110000L, "Cayenne", engine6, disk3, carColour3);
    Car carNumber5 = new Car(null, "Porsche", 88000L, "Macan", engine3, disk3, carColour3);
    Car carNumber6 = new Car(null, "Porsche", 211000L, "GT3RS", engine5, disk3, carColour3);

    disksRepository.save(disk);
    disksRepository.save(disk2);
    disksRepository.save(disk3);
    disksRepository.save(disk4);
    disksRepository.save(disk5);

    engineRepository.save(engine);
    engineRepository.save(engine2);
    engineRepository.save(engine3);
    engineRepository.save(engine4);
    engineRepository.save(engine5);
    engineRepository.save(engine6);
    engineRepository.save(engine7);

    carColourRepository.save(carColour);
    carColourRepository.save(carColour2);
    carColourRepository.save(carColour3);

    carNumberRepository.save(carNumber);
    carNumberRepository.save(carNumber2);
    carNumberRepository.save(carNumber3);

    System.out.println(carNumber);
  }
}

  