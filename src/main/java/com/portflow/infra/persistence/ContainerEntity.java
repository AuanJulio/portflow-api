package com.portflow.infra.persistence;

import com.portflow.core.domain.enums.ContainerCategory;
import com.portflow.core.domain.enums.ContainerSize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_container")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContainerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "iso_code")
    private String isoCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ContainerCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private ContainerSize size;

    @Column(name = "tare_weight")
    private Double tareWeight;

    @Column(name = "payload_weight")
    private Double payloadWeight;

    @Column(name = "client_name")
    private String clientName;

}
