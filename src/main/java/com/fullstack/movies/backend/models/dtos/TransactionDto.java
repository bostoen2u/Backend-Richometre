package com.fullstack.movies.backend.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    private String type;
    private String nom;
    private int quantite;
    private double prix;
    private double coursDuJour;
}
