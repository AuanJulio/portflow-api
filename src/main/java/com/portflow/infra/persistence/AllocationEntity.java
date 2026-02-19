package com.portflow.infra.persistence;

import com.portflow.core.domain.enums.AllocationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_allocation")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AllocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private ContainerEntity container;

    @ManyToOne
    @JoinColumn(name = "yard_slot_id")
    private YardSlotEntity yardSlot;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "estimated_departure")
    private LocalDateTime estimatedDeparture;

    @Column(name = "actual_departure")
    private LocalDateTime actualDeparture;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AllocationStatus status;

}
