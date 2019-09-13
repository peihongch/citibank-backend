package com.example.ffbackend.repo;

import java.util.List;

import com.example.ffbackend.entity.StockInPortfolio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepo extends JpaRepository<StockInPortfolio, Integer> {
    List<StockInPortfolio> findByUserId (Integer userId);
}