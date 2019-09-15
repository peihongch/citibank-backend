package com.example.ffbackend.bl;

public interface RpcCitibankApiService {
    float stockPoundage(float dealAmount);

    float futurePoundage(float dealAmount);

    float optionsPoundage(int numOfPiece);
}
