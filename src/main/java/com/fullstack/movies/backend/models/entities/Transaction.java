
package com.fullstack.movies.backend.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // "crypto" or "action"

    private String nom;

    private int quantite;

    private double prix;
}
