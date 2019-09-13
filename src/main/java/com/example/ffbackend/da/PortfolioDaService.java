package com.example.ffbackend.da;

import com.example.ffbackend.entity.Portfolio;
import com.example.ffbackend.repo.PortfolioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioDaService {
    @Autowired
    PortfolioRepo repo;

    public Portfolio insertPortfolio(Portfolio po) {
        po.setId(-1);
        return repo.save(po);
    }

    public Portfolio updatePortfolio(Portfolio po) {
        return repo.save(po);
    }

    public boolean deletePortfolio(int id) {
        repo.deleteById(id);
        return true;
    }

    public Portfolio getPortfolio(int id) {
        return repo.findById(id).orElse(null);
    }
}