package com.desafio.bancosimplificadojava.repository;

import com.desafio.bancosimplificadojava.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySenderId(Long senderId);
    List<Transaction> findByReceiverId(Long receiverId);
}
