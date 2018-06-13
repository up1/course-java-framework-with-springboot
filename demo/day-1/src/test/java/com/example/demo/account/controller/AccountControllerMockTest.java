package com.example.demo.account.controller;

import com.example.demo.account.model.AccountResponse;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.repository.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountControllerMockTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void
    เรียกข้อมูลบัญชีของหมายเลข_0868696209_ต้องเจอสองบัญชีนะ() {
        // Arrange
        List<Account> accountIterable = new ArrayList<>();
        accountIterable.add(new Account("01"));
        accountIterable.add(new Account("02"));
        given(accountRepository.findAll()).willReturn(accountIterable);

        // Act
        List<AccountResponse> accountResponses
                = testRestTemplate.getForObject(
                        "/account/0868696209", List.class);

        // Assert
        assertEquals(2, accountResponses.size());
    }
}
