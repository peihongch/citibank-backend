package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcStyleFactorService;
import com.example.ffbackend.rpc.proto.StocksProto;
import com.example.ffbackend.rpc.proto.StyleFactorGrpc;
import com.example.ffbackend.rpc.proto.StyleFactorProto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RpcStyleFactorServiceImpl implements RpcStyleFactorService {
    @Autowired
    private StyleFactorGrpc.StyleFactorBlockingStub styleFactorBlockingStub;

    @Override
    public float getSize(String tsCode, String fields) {
        GetSizeInput getSizeInput = GetSizeInput.newBuilder()
                .setTsCode(tsCode).setFields(fields)
                .build();
        GetSizeOutput getSizeOutput = styleFactorBlockingStub.getSize(getSizeInput);
        return getSizeOutput.getValue();
    }

    @Override
    public float getMomentum(String tsCode) {
        GetMomentumInput getMomentumInput = GetMomentumInput.newBuilder()
                .setTsCode(tsCode)
                .build();
        GetMomentumOutput getMomentumOutput = styleFactorBlockingStub.getMomentum(getMomentumInput);
        return getMomentumOutput.getValue();
    }

    @Override
    public float getBookToMarket(String stockCode) {
        GetBookToMarketInput getBookToMarketInput = GetBookToMarketInput.newBuilder()
                .setStockCode(stockCode)
                .build();
        GetBookToMarketOutput getBookToMarketOutput = styleFactorBlockingStub.getBookToMarket(getBookToMarketInput);
        return getBookToMarketOutput.getValue();
    }

    @Override
    public float getLiquidity(String stockCode) {
        GetLiquidityInput getLiquidityInput = GetLiquidityInput.newBuilder()
                .setStockCode(stockCode)
                .build();
        GetLiquidityOutput getLiquidityOutput = styleFactorBlockingStub.getLiquidity(getLiquidityInput);
        return getLiquidityOutput.getValue();
    }

    @Override
    public List<String> getAllFactors(){
        GetAllFactorsInput getAllFactorsInput = GetAllFactorsInput.newBuilder().build();
        GetAllFactorsOutput getAllFactorsOutput = styleFactorBlockingStub.getAllFactors(getAllFactorsInput);

        return getAllFactorsOutput.getOutListList();
    }
    @Override
    public List<Float> getBeta(String stockCode) {
        GetBetaInput getBetaInput = GetBetaInput.newBuilder().setStockCode(stockCode).build();
        GetBetaOutput getBetaOutput = styleFactorBlockingStub.getBeta(getBetaInput);

        return getBetaOutput.getOutListList();
    }
}
