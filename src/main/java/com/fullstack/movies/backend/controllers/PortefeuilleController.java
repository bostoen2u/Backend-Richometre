
package com.fullstack.movies.backend.controllers;

import com.fullstack.movies.backend.models.dtos.TransactionDto;
import com.fullstack.movies.backend.services.PortefeuilleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portefeuille")
@RequiredArgsConstructor
public class PortefeuilleController {

    private final PortefeuilleService portefeuilleService;

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getTransactions(@RequestParam String type) {
        return ResponseEntity.ok(portefeuilleService.getTransactions(type));
    }

    @PostMapping
    public ResponseEntity<TransactionDto> addTransaction(@RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok(portefeuilleService.addTransaction(transactionDto));
    }
}
