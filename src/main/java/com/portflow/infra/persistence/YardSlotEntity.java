package com.portflow.infra.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_yard_slot")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class YardSlotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "block")
    private String block;

    @Column(name = "bay")
    private Integer bay;

    @Column(name = "slot")
    private Integer slot;

    @Column(name = "tier")
    private Integer tier;

    @Column(name = "max_weight_capacity")
    private Double maxWeightCapacity;

    @Column(name = "is_operational")
    private Boolean isOperational;

}
