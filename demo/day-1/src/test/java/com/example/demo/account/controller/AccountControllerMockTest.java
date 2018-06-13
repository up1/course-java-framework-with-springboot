package com.example.demo.account.controller;

import com.example.demo.account.model.AccountResponse;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.repository.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerMockTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void
    เรียกข้อมูลบัญชีของหมายเลข_0868696209_ต้องเจอสองบัญชีนะ() {
        // Arrange| Given
        List<Account> dataForTest = new ArrayList<>();
        dataForTest.add(new Account("T01"));
        dataForTest.add(new Account("T02"));
        given(accountRepository.findAll()).willReturn(dataForTest);

        // Act
        List<AccountResponse> accountResponses
                = testRestTemplate.getForObject(
                "/account/0868696209", List.class);

        // Assert
        assertEquals(2, accountResponses.size());
    }

}