package com.portflow.infra.persistence;

import com.portflow.core.domain.enums.ContainerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContainerRepository extends JpaRepository<ContainerEntity, Long> {

    ContainerEntity findByIsoCode(String isoCode);

    @Query("SELECT t FROM ContainerEntity t WHERE (LOWER(t.clientName) LIKE LOWER(CONCAT('%', ?1, '%'))) OR (t.category = ?2) ")
    List<ContainerEntity> listAllContainersQuery(String clientName, ContainerCategory category);

    Boolean existsByIsoCode(String isoCode);

}
