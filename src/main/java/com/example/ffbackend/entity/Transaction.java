package com.example.ffbackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.ffbackend.vo.TransactionVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Date date;
    Integer userId;
    String code;
    String name;
    String genre;
    Integer quantity;
    Double price;
    Double commission;

    public TransactionVo createVo() {
        return new TransactionVo(date, code, name, genre, quantity, price, quantity * price, commission);
    }
}