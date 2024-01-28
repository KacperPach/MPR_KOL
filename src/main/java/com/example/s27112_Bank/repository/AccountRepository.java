package com.example.s27112_Bank.repository;

import com.example.s27112_Bank.model.account.Account;
import com.example.s27112_Bank.model.account.components.AccountCurrency;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository {
    private List<Account> accountList = new ArrayList<>();

    public Account create(Account account) {
        account.setId(accountList.size());
        accountList.add(account);
        return account;
    }

    public Optional<Account> getByAccountId (Integer id) {
        return accountList.stream()
                          .filter(it -> it.getId().equals(id))
                          .findFirst();
    }
    /**
     *  @return  returns accounts that have balance above given value in a given currency
     * */
    public List<Account> getByAccountMinimalBalance (Double AccountBalance, AccountCurrency currency) {
        return  accountList.stream()
                .filter(it -> it.getCurrency().equals(currency))
                .filter(it -> it.getBalance() > AccountBalance)
                .toList();
    }

    public void deleteAll () {
        accountList.clear();
    }

    // LATER: delete modify

}
