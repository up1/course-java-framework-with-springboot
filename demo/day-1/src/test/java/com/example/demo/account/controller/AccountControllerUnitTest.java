package com.example.demo.account.controller;

import com.example.demo.account.model.AccountResponse;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.repository.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class AccountControllerUnitTest {
    @Mock
    private AccountRepository accountRepository;
    private AccountController accountController;

    @Before
    public void initialObject() {
        initMocks(this);
        accountController = new AccountController();
        accountController.setAccountRepository(accountRepository);
    }

    @Test
    public void size_of_account_should_be_2() {
        // Arrange| Given
        List<Account> dataForTest = new ArrayList<>();
        dataForTest.add(new Account("T01"));
        dataForTest.add(new Account("T02"));
        given(accountRepository.findAll()).willReturn(dataForTest);

        // Act | When
        List<AccountResponse> responses =
                accountController.getAccounts("0868696209");

        // Assertion | Then
        assertEquals("Size of result must be 2", 2, responses.size());
    }

    @Test
    public void should_throw_exception() {
        // Arrange| Given
         given(accountRepository.findAll()).willReturn(null);

        // Act | When
        List<AccountResponse> responses =
                accountController.getAccounts("0868696209");

        // Assertion | Then
        assertEquals("Size of result must be 0", 0, responses.size());
    }
}