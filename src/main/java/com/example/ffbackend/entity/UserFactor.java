package com.example.ffbackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table()
@AllArgsConstructor
@NoArgsConstructor
public class UserFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer id;

    Double transAct;
    Double storeWill;
    Double financialFlex;
    Double expectMoney;
    Double expectReturn;
    Double planTime;
    Double riskTol;
}