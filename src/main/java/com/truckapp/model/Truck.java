package com.truckapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Truck {
    @Id
    private String plate; // AAA123
    private String brand;
    private String model;
    private String ownerUsername;
}
