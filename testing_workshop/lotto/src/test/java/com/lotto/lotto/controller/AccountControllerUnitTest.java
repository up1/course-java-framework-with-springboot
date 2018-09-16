package com.lotto.lotto.controller;

import com.lotto.lotto.category.UnitTest;
import com.lotto.lotto.controller.response.AccountResponse;
import com.lotto.lotto.model.Account;
import com.lotto.lotto.repository.AccountRepository;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@Category(UnitTest.class)
public class AccountControllerUnitTest {

    @Mock
    private AccountRepository repository;

    private AccountController accountController;

    @Before
    public void initial() {
        initMocks(this);
    }

    @Test
    public void getById() {
        // Stub
        Account account = new Account();
        account.setUserName("user");
        account.setPassword("pass");
        account.setSalary(1000);
        given(repository.findById(1))
                .willReturn(Optional.of(account));

        accountController = new AccountController(repository);
        AccountResponse response = accountController.getById(1);
        AccountResponse expected
                = new AccountResponse("user", "pass", 1000);
        assertEquals(expected, response);
    }
}