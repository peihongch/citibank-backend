package com.example.ffbackend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		boolean res1 = rpcAdjustmentAndTriggeringOfPortfolioService.portFolioVar("12666", 1.5f);
		boolean res2 = rpcAdjustmentAndTriggeringOfPortfolioService.stockDiff("????", 1.5f);
		boolean res3 = rpcAdjustmentAndTriggeringOfPortfolioService.stockVolatility("????", 1.5f);
	}

	@Test
	public void testRpcCitibankApiService() {
		float res1 = rpcCitibankApiService.stockPoundage(15.3f);
		float res2 = rpcCitibankApiService.optionsPoundage(12);
		float res3 = rpcCitibankApiService.futurePoundage(5.02f);
	}

	@Test
	public void testRpcOptionFuturesService() {
		List<String> assetIdList = new ArrayList<>();
		assetIdList.add("SZ000002");assetIdList.add("SZ000002");
		List<String> assetAmountList = new ArrayList<>();
		assetAmountList.add("105");assetAmountList.add("150");
		float cash = 50000;
		String beginT = "2019-10-5";
		String endT = "2019-10-5";
		List<String> res1 = rpcOptionFuturesService.portfolioDelta(assetIdList, assetAmountList, cash, beginT, endT);
		List<String> res2 = rpcOptionFuturesService.portfolioGamma(assetIdList, assetAmountList, cash, beginT, endT);
		List<String> res3 = rpcOptionFuturesService.portfolioVega(assetIdList, assetAmountList, cash, beginT, endT);
		List<String> res4 = rpcOptionFuturesService.portfolioTheta(assetIdList, assetAmountList, cash, beginT, endT);;
		List<String> res5 = rpcOptionFuturesService.portfolioRho(assetIdList, assetAmountList, cash, beginT, endT);
	}

	@Test
	public void testRpcStocksService() {
		List<String> res1 = rpcStocksService.getAllStocks();
		List<List<String>> res2 = rpcStocksService.getStockHistory("SZ000001");
	}

	@Test
	public void testRpcStyleFactorService() {
		float res1 = rpcStyleFactorService.getBookToMarket("SZ000001");
		float res2 = rpcStyleFactorService.getLiquidity("SZ000001");
		float res3 = rpcStyleFactorService.getMomentum("SZ000001");
	}

	@Test
	public void testRpcRegularAdjustmentService(){
		boolean res1=rpcRegularAdjustmentService.stockLeastPosition("SZ000001",1,2);
		boolean res2=rpcRegularAdjustmentService.stockChange("SZ000002",12124,(float)0.5,(float)0.2);
		boolean res3=rpcRegularAdjustmentService.stockMeanReturn("SZ000001",12124,(float)0.5);
		boolean res4=rpcRegularAdjustmentService.stockVolatility("SZ000001",12124,(float)0.5);
	}

	@Test
	public void testRpcConditionalTriggerService(){
		boolean res1=rpcConditionalTriggerService.stockKdj("SZ000002",(float)0.5,(float)0.5,(float)0.5);
		boolean res2=rpcConditionalTriggerService.stockMacd("SZ000001",(float)0.5,(float)0.5);
		boolean res3=rpcConditionalTriggerService.stockRoc("SZ000001",1514871613,(float)0.5,(float)0.5);
	}

}
