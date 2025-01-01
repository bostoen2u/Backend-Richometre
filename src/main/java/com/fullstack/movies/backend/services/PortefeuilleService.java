package com.fullstack.movies.backend.services;

import com.fullstack.movies.backend.models.dtos.TransactionDto;
import com.fullstack.movies.backend.models.entities.Transaction;
import com.fullstack.movies.backend.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortefeuilleService {

    private final TransactionRepository transactionRepository;
    private final AlphaVantageService alphaVantageService;

    public List<TransactionDto> getTransactions(String type) {
        return transactionRepository.findByType(type)
                .stream()
                .map(transaction -> {
                    double coursDuJour = alphaVantageService.getCoursDuJour(transaction.getNom());
                    return new TransactionDto(
                            transaction.getId(),
                            transaction.getType(),
                            transaction.getNom(),
                            transaction.getQuantite(),
                            transaction.getPrix(),
                            coursDuJour
                    );
                })
                .collect(Collectors.toList());
    }

    public TransactionDto addTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setType(transactionDto.getType());
        transaction.setNom(transactionDto.getNom());
        transaction.setQuantite(transactionDto.getQuantite());
        transaction.setPrix(transactionDto.getPrix());
        transaction = transactionRepository.save(transaction);

        double coursDuJour = alphaVantageService.getCoursDuJour(transaction.getNom());

        return new TransactionDto(
                transaction.getId(),
                transaction.getType(),
                transaction.getNom(),
                transaction.getQuantite(),
                transaction.getPrix(),
                coursDuJour);
    }
}
