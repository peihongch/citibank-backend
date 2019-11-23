package com.example.ffbackend;

import com.example.ffbackend.bl.RpcAdjustmentAndTriggeringOfPortfolioService;
import com.example.ffbackend.bl.RpcCitibankApiService;
import com.example.ffbackend.bl.RpcConditionalTriggerService;
import com.example.ffbackend.bl.RpcDatabaseService;
import com.example.ffbackend.bl.RpcDrawingService;
import com.example.ffbackend.bl.RpcOptionFuturesService;
import com.example.ffbackend.bl.RpcRegularAdjustmentService;
import com.example.ffbackend.bl.RpcStocksService;
import com.example.ffbackend.bl.RpcStyleFactorService;
import com.example.ffbackend.bl.RpcTailRiskService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RpcTests {
	@Autowired
	RpcAdjustmentAndTriggeringOfPortfolioService rpcAdjustmentAndTriggeringOfPortfolioService;

	@Autowired
	RpcCitibankApiService rpcCitibankApiService;

	@Autowired
	RpcConditionalTriggerService rpcConditionalTriggerService;

	@Autowired
	RpcDatabaseService rpcDatabaseService;

	@Autowired
	RpcDrawingService rpcDrawingService;

	@Autowired
	RpcOptionFuturesService rpcOptionFuturesService;

	@Autowired
	RpcRegularAdjustmentService rpcRegularAdjustmentService;

	@Autowired
	RpcStocksService rpcStocksService;

	@Autowired
	RpcStyleFactorService rpcStyleFactorService;

	@Autowired
	RpcTailRiskService rpcTailRiskService;

	@Test
	public void testRpcAdjustmentAndTriggeringOfPortfolioService() {
		boolean res1 = rpcAdjustmentAndTriggeringOfPortfolioService.portFolioVar("????", 1.5f);
		boolean res2 = rpcAdjustmentAndTriggeringOfPortfolioService.stockDiff("????", 1.5f);
		boolean res3 = rpcAdjustmentAndTriggeringOfPortfolioService.stockVolatility("????", 1.5f);
	}

	@Test
	public void testRpcCitibankApiService() {
		float res1 = rpcCitibankApiService.stockPoundage(15.3f);
		float res2 = rpcCitibankApiService.optionsPoundage(12);
		float res3 = rpcCitibankApiService.futurePoundage(5.02f);
	}
}
