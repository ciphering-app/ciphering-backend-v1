package com.sqewes.ciphering.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String phoneNumber;

    private String userName;

    private boolean premium;

    private Instant registeredAt = Instant.now();

}
