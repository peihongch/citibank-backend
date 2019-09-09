package com.example.ffbackend.bl;

import com.example.ffbackend.vo.PortfolioVo;

public interface PortfolioService {
    int insertPortfolio (PortfolioVo vo);
    boolean deletePortfolio (int id);
    boolean updatePortfolio (PortfolioVo vo);
    PortfolioVo getPortfolio (int id);
}