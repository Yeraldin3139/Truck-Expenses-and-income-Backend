package com.truckapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String truck;
    private String title;
    @Column(length = 1000)
    private String text;
    private String date;
    private Boolean done = false;
}
