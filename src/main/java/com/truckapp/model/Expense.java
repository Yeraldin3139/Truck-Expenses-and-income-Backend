package com.truckapp.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.ZonedDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Expense {
    @Id @GeneratedValue
    private Long id;
    private String type;
    private long amountCOP;
    private ZonedDateTime dateTime = ZonedDateTime.now();

    @ManyToOne
    private Trip trip;
}
