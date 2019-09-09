package com.example.ffbackend.da;

import com.example.ffbackend.entity.Portfolio;

public interface PortfolioDaService {
    Portfolio insertPortfolio (Portfolio vo);
    Portfolio updatePortfolio (Portfolio vo);
    boolean deletePortfolio (int id);
    Portfolio getPortfolio (int id);
}