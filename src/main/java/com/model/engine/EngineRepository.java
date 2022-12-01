package com.model.engine;

import com.model.engine.Engine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories(basePackages="com.databases", entityManagerFactoryRef="emf")
public interface EngineRepository extends CrudRepository<Engine, Long> {
  @Query(value = "SELECT * FROM engines WHERE horse_powers = ?1", nativeQuery = true)
  Engine findByHorsePowers(Integer hp);
}
