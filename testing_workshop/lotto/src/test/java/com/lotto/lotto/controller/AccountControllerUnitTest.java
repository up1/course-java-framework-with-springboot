package com.lotto.lotto.controller;

import com.lotto.lotto.controller.response.AccountResponse;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountControllerUnitTest {

    private AccountController accountController;

    @Test
    public void getById() {

        accountController = new AccountController();
        AccountResponse response = accountController.getById(1);
        AccountResponse expected
                = new AccountResponse("user", "pass", 1000);
        assertEquals(expected, response);
    }
}