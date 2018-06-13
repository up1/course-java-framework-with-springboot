package com.example.demo.account.controller;

import com.example.demo.account.model.AccountResponse;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.repository.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

public class AccountControllerUnitTest {

    @Mock
    private AccountRepository accountRepository;

    private AccountController accountController;

    @Before
    public void init() {
        initMocks(this);
        accountController = new AccountController();
        accountController.setAccountRepository(accountRepository);
    }

    @Test
    public void
    เรียกข้อมูลบัญชีของหมายเลข_0868696209_ต้องเจอสองบัญชีนะ() {
        // Arrange
        List<Account> accountIterable = new ArrayList<>();
        accountIterable.add(new Account("01"));
        accountIterable.add(new Account("02"));
        given(accountRepository.findAll()).willReturn(accountIterable);

        // Act
        List<AccountResponse> accountResponses = accountController.getAccounts("0868696209");

        // Assert

        assertEquals(2, accountResponses.size());
    }
}