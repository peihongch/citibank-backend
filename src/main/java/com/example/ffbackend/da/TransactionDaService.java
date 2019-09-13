package com.example.ffbackend.da;

import com.example.ffbackend.repo.TransactionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionDaService {
    @Autowired TransactionRepo repo;
}