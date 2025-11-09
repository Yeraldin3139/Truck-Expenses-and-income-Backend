package com.truckapp.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.ZonedDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Shipment {
    @Id @GeneratedValue
    private Long id;
    private String senderName;
    private String recipientName;
    private String fromAddress;
    private String toAddress;
    private double weightKg;
    private long priceCOP;
    private boolean paidByRecipient;
    private Double latTo;
    private Double lngTo;
    private ZonedDateTime createdAt = ZonedDateTime.now();

    @ManyToOne
    private Trip trip;
}
