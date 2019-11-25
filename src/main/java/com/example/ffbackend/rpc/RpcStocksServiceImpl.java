package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcStocksService;
import com.example.ffbackend.rpc.proto.StocksGrpc;
import com.example.ffbackend.rpc.proto.StocksProto;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RpcStocksServiceImpl implements RpcStocksService {
    @Autowired
    private StocksGrpc.StocksBlockingStub stocksBlockingStub;

    @Override
    public List<String> getAllStocks() {
        StocksProto.GetAllStocksInput input = StocksProto.GetAllStocksInput.newBuilder().build();
        StocksProto.GetAllStocksOutput res = stocksBlockingStub.getAllStocks(input);
        return res.getValueList();
    }

    @Override
    public List<List<String>> getStockHistory(String stockCode) {
        StocksProto.GetStockHistoryInput input = StocksProto.GetStockHistoryInput.newBuilder().setStockCode(stockCode).build();
        var output = stocksBlockingStub.getStockHistory(input);
        List<List<String>> ret = new LinkedList<>();
        for (StocksProto.GetStockHistoryRow row: output.getValueList()){
            ret.add(row.getRowList());
        }
        return ret;
    }
}
