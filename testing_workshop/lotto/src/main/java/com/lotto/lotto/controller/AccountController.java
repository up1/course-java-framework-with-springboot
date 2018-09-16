package com.lotto.lotto.controller;

import com.lotto.lotto.controller.response.AccountResponse;
import com.lotto.lotto.exception.MyAccountNotFoundException;
import com.lotto.lotto.model.Account;
import com.lotto.lotto.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
public class AccountController {

    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/account/{id}")
    public AccountResponse getById(
            @PathVariable int id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()) {
            if(account == null) {
                account = Optional.empty();
            }
            Account myAccount = account.get();
            return new AccountResponse(
                    myAccount.getUserName(),
                    myAccount.getPassword(),
                    myAccount.getSalary()
            );
        }
        throw new MyAccountNotFoundException(
                String.format("Account id=[%d] not found", id));
    }

    @PostConstruct
    public void initData() {
        Account account = new Account();
        account.setId(1);
        account.setUserName("fakeuser");
        account.setPassword("fakepass");
        accountRepository.save(account);
    }

}
