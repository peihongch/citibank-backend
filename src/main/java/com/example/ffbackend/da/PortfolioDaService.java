package com.example.ffbackend.da;

import com.example.ffbackend.entity.Portfolio;

public interface PortfolioDaService {
    Portfolio insertPortfolio (Portfolio po);
    Portfolio updatePortfolio (Portfolio po);
    boolean deletePortfolio (int id);
    Portfolio getPortfolio (int id);
}