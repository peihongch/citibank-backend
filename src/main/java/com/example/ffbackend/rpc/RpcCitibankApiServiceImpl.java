package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcCitibankApiService;
import com.example.ffbackend.rpc.proto.CitibankApiGrpc.*;
import com.example.ffbackend.rpc.proto.CitibankApiProto.*;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RpcCitibankApiServiceImpl implements RpcCitibankApiService {
    @Autowired
    private CitibankApiBlockingStub citibankApiBlockingStub;

    @Override
    public float stockPoundage(float dealAmount) {
        var input = StockPoundageInput.newBuilder().setDealAmount(dealAmount).build();
        return citibankApiBlockingStub.stockPoundage(input).getValue();
    }

    @Override
    public float futurePoundage(float dealAmount) {
        var input = FuturePoundageInput.newBuilder().setDealAmount(dealAmount).build();
        return citibankApiBlockingStub.futurePoundage(input).getValue();
    }

    @Override
    public float optionsPoundage(int numOfPiece) {
        var input = OptionsPoundageInput.newBuilder().setNumOfPiece(numOfPiece).build();
        return citibankApiBlockingStub.optionsPoundage(input).getValue();
    }
}
