package com.example.s27112_Bank.controller;

import com.example.s27112_Bank.model.account.Account;
import com.example.s27112_Bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<Account> getAccountByParam(@RequestParam(required = false) Integer id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountByPathVariable(@PathVariable Integer id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }
    @GetMapping("/create")
    public ResponseEntity<Account> createAccount( @RequestBody Account account) {
        Account createdAccount = accountService.create(account);
        return ResponseEntity.ok(createdAccount);
    }

}
