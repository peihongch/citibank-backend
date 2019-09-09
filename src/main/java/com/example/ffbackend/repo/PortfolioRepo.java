package com.example.ffbackend.repo;

import com.example.ffbackend.entity.Portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepo extends JpaRepository<Portfolio, Integer> {
}