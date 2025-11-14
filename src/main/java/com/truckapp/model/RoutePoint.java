package com.truckapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class RoutePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String type; // route, serviceRoute, stop
    private Double lat;
    private Double lng;
    private String nombre;
    private Boolean entregado;
    private String carga;
    private String destino;
    @Column(name = "seq_order")
    private String order;
}
