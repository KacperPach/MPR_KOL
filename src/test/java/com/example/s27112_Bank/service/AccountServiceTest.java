package com.example.s27112_Bank.service;

import com.example.s27112_Bank.model.account.Account;
import com.example.s27112_Bank.model.account.components.AccountCurrency;
import com.example.s27112_Bank.model.user.User;
import com.example.s27112_Bank.repository.AccountRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
class AccountServiceTest {
    private static AccountService accountService;
    private static AccountRepository accountRepository;
    @BeforeAll
    static void setup () {
        accountRepository = new AccountRepository();
        accountService = new AccountService(accountRepository);
    }

    @Test
    void shouldCorrectlyCreateAccount () {
        User user = new User(1,"Kacper","Pach", "761115PPP3");
        Account account = new Account(0, 1000.0, AccountCurrency.PLN, user);

        Account res = assertDoesNotThrow( () -> accountService.create(account));

        assertEquals(account,res);
    }

    @Test
    void shouldGetByid () {
        User user = new User(1,"Kacper","Pach", "761115PPP3");
        Account account = new Account(0, 1000.0, AccountCurrency.PLN, user);
        accountService.create(account);

        Account res = assertDoesNotThrow( () -> accountService.getAccountById(account.getId()));

        assertEquals(account,res);

    }

    @Test
    void shouldGetByBalance () {
        User user = new User(1,"Kacper","Pach", "761115PPP3");
        Account account = new Account(0, 1000.0, AccountCurrency.PLN, user);
        accountService.create(account);

        List<Account> res = assertDoesNotThrow( () -> accountService.getAccountsByMinimalBalance(account.getBalance()-1, account.getCurrency()));

    }


}