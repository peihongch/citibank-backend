package com.example.ffbackend.da;

import java.util.List;

import com.example.ffbackend.entity.Transaction;
import com.example.ffbackend.repo.TransactionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionDaService {
    @Autowired
    TransactionRepo repo;

    public Transaction insertTransaction(Transaction transaction) {
        return repo.save(transaction);
    }

    public List<Transaction> getTransactionByUserId(Integer userId) {
        return repo.findByUserId(userId);
    }
}