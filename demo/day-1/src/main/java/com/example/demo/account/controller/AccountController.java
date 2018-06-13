package com.example.demo.account.controller;

import com.example.demo.account.model.AccountResponse;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.repository.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/account/{mobileNo}")
    public List<AccountResponse> getAccounts(
            @PathVariable String mobileNo) {

        List<Account> accounts
                = (List<Account>) accountRepository.findAll();
        if(accounts == null) {
            accounts = new ArrayList<>();
        }

        // Convert from Account to AccountResponse
        List<AccountResponse> foundAccountResponses = new ArrayList<>();
        for (Account account: accounts) {
            foundAccountResponses.add(
                    new AccountResponse(account.getAccountId(),
                            account.getMobileNo(), "", ""));
        }
        return foundAccountResponses;
    }

//    @PostConstruct
//    public void initData() {
//        Account account1 = new Account();
//        account1.setAccountId("01");
//        accountRepository.save(account1);
//        Account account2 = new Account();
//        account2.setAccountId("02");
//        accountRepository.save(account2);
//    }

}
