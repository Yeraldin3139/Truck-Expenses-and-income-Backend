package com.truckapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class AppUser {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String role; // DRIVER, CUSTOMER, ADMIN
}
