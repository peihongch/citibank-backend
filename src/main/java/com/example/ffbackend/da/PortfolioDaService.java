package com.example.ffbackend.da;

import java.util.List;

import com.example.ffbackend.entity.StockInPortfolio;
import com.example.ffbackend.repo.PortfolioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioDaService {
    @Autowired
    PortfolioRepo repo;

    public StockInPortfolio insertPortfolio(StockInPortfolio po) {
        po.setId(-1);
        return repo.save(po);
    }

    public StockInPortfolio updatePortfolio(StockInPortfolio po) {
        return repo.save(po);
    }

    public boolean deletePortfolio(int id) {
        repo.deleteById(id);
        return true;
    }

    public List<StockInPortfolio> getPortfolioByUserId(int userId) {
        return repo.findByUserId(userId);
    }
}