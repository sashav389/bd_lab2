package com.model.carColour;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO for InterviewerSlot entity.
 */
public interface CarColourRepository extends CrudRepository<CarColour, Long> {
  @Query(value = "SELECT * FROM colours WHERE colour = ?1", nativeQuery = true)
  CarColour findByColour(String colour);
}
