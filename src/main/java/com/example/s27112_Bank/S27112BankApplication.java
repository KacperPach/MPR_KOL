package com.example.s27112_Bank;

import com.example.s27112_Bank.model.account.Account;
import com.example.s27112_Bank.model.account.components.AccountCurrency;
import com.example.s27112_Bank.model.user.User;
import com.example.s27112_Bank.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class S27112BankApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(S27112BankApplication.class, args);
		AccountService accountService = context.getBean("accountService", AccountService.class);

		accountService.create(new Account(1,1000.00, AccountCurrency.PLN,
				new User(1,"Kacper","Pach", "761115PPP3")));

	}

}
