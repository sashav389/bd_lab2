package com.model.disk;

import com.model.disk.Disk;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories(basePackages="com.databases", entityManagerFactoryRef="emf")
public interface DisksRepository extends CrudRepository<Disk, Long> {

}
