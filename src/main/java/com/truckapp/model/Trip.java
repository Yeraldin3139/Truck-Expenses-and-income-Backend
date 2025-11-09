package com.truckapp.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Trip {
    @Id @GeneratedValue
    private Long id;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String origin;
    private String destination;

    @ManyToOne
    private Truck truck;

    @OneToMany(mappedBy="trip", cascade = CascadeType.ALL)
    private List<Shipment> shipments = new ArrayList<>();

    @OneToMany(mappedBy="trip", cascade = CascadeType.ALL)
    private List<Expense> expenses = new ArrayList<>();

    private long totalIncomeCOP;
    private long totalExpensesCOP;

    public void calculateTotals(){
        totalIncomeCOP = shipments.stream().mapToLong(s -> s.getPriceCOP()).sum();
        totalExpensesCOP = expenses.stream().mapToLong(e -> e.getAmountCOP()).sum();
    }
}
