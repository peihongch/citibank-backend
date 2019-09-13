package com.example.ffbackend.repo;

import java.util.List;

import com.example.ffbackend.entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByUserId (Integer userId);
}