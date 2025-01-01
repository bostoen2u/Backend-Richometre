
package com.fullstack.movies.backend.repositories;

import com.fullstack.movies.backend.models.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByType(String type);
}
