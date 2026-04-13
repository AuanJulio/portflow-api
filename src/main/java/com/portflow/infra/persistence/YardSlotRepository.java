package com.portflow.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface YardSlotRepository extends JpaRepository<YardSlotEntity, Long> {

    @Query("SELECT y FROM YardSlotEntity y WHERE y.isOperational = true")
    List<YardSlotEntity> findByIsOperationalQuery();

}
