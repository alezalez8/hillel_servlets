package org.hillel.persistence.jpa.repository;

import org.hillel.persistence.entity.JourneyEntity;
import org.hillel.persistence.entity.StopEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//public interface  VehicleJpaRepository extends CrudRepository<VehicleEntity, Long> { // до CommonJpaRepository
//public interface  VehicleJpaRepository extends CommonJpaRepository<VehicleEntity, Long>, CrudRepository<VehicleEntity, Long> {

public interface JourneyJpaRepository extends CommonJpaRepository<JourneyEntity, Long>,
        JpaSpecificationExecutor<JourneyEntity> {




}
