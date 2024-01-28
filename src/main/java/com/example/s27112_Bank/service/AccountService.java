package com.example.s27112_Bank.service;

import com.example.s27112_Bank.exception.AccountNotFoundException;
import com.example.s27112_Bank.exception.ValidationException;
import com.example.s27112_Bank.model.account.Account;
import com.example.s27112_Bank.model.account.components.AccountCurrency;
import com.example.s27112_Bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    //create
    public Account create (Account account) {
        Map<String, String> errors = new HashMap<>();
        if (account.getBalance() < 0 ) {
            errors.put("balance", "balance cannot be a number below zero");
        }
        if (account.getUser().getPesel().length() == 11 ||
                account.getUser().getPesel().isBlank() ||
                account.getUser().getPesel() == null) {
            errors.put("pesel", "pesel cannot be empty or not real");
        }
        //tu tak naprawdę nie ma opcji podania złego currency
        if (account.getCurrency() != AccountCurrency.PLN &&
                account.getCurrency() != AccountCurrency.EUR &&
                account.getCurrency() != AccountCurrency.USD &&
                account.getCurrency() == null
        ) {
            errors.put("currency", "Currency cannot be blank or not EUR,USD,PLN ");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        return accountRepository.create(account);
    }
    // get by id
    public Account getAccountById (Integer id) {
        if (id == null){
            throw new ValidationException("id", "cannot be null");
        }
        return accountRepository.getByAccountId(id)
                .orElseThrow(() -> new AccountNotFoundException("Account id: " + id + " id does not exist"));
    }
    // get by balance
    public List<Account> getAccountsByMinimalBalance(Double balance, AccountCurrency accountCurrency) {
        return  accountRepository.getByAccountMinimalBalance(balance, accountCurrency);
    }
}
