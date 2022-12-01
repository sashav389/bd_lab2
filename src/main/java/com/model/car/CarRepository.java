package com.model.car;

import com.model.carColour.CarColour;
import com.model.disk.Disk;
import com.model.engine.Engine;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@EnableJpaRepositories(basePackages="com.databases", entityManagerFactoryRef="emf")
public interface CarRepository extends CrudRepository<Car, Long> {

  @Query(value = "SELECT * FROM car WHERE engine = ?1 and c_car = ?2 and price = ?3", nativeQuery = true)
  List<Car> findByEngineAndCarColourAndPrice(Engine hp, CarColour colour, Long price);

  @Query(value = "SELECT * FROM car WHERE engine = ?1 and c_car = ?2", nativeQuery = true)
  List<Car> findByEngineAndCarColour(Engine hp, CarColour colour);

  @Query(value = "SELECT * FROM car WHERE engine = ?1 and price = ?2", nativeQuery = true)
  List<Car> findByEngineAndPrice(Engine hp, Long price);

  @Query(value = "SELECT * FROM car WHERE c_car = ?1 and price = ?2", nativeQuery = true)
  List<Car> findByCarColourAndPrice(CarColour colour, Long price);

  @Query(value = "SELECT * FROM car  WHERE price = ?1", nativeQuery = true)
  List<Car> findByPrice(Long price);

  @Query(value = "SELECT * FROM car WHERE engine = ?1", nativeQuery = true)
  List<Car> findByEngine(Engine hp);

  @Query(value = "SELECT * FROM car WHERE c_car = ?1", nativeQuery = true)
  List<Car> findByCarColour(CarColour colour);

  @Modifying
  @Transactional
  @Query(value = "update car set brand = ?1, model = ?2, price = ?3, c_car = ?4," +
      "engine = ?5, disk = ?6 where id = ?7",
      nativeQuery = true)
  void updateCar(String brand, String model, Long price, CarColour colour,
      Engine engine, Disk disk, Long id);


  @Modifying
  @Transactional
  @Query(value = "INSERT INTO car (brand, model, price, c_car, engine, disk)" +
      " VALUES (?1,?2,?3,?4,?5,?6)",
      nativeQuery = true)
  void createCar(String brand, String model, Long price, CarColour colour,
      Engine engine, Disk disk);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM car WHERE id = ?1",
      nativeQuery = true)
  void deleteCar(Long id);




  @Override
  List<Car> findAll();
}
