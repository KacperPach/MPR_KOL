package com.example.s27112_Bank.model.account;

import com.example.s27112_Bank.model.account.components.AccountCurrency;
import com.example.s27112_Bank.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Account {
    private Integer id;
    private Double balance;
    private AccountCurrency currency;
    private User user;
}
