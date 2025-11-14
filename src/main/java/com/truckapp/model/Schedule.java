package com.truckapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Schedule {
    @Id
    private String placa;
    private String idaDays;
    private String regresoDays;
}
