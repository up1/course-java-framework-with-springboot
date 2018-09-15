package com.lotto.lotto.controller;

import com.lotto.lotto.category.UnitTest;
import com.lotto.lotto.controller.response.AccountResponse;
import com.lotto.lotto.model.Account;
import com.lotto.lotto.service.UserService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
@Category(UnitTest.class)
public class AccountControllerUnitTest {

    private AccountController accountController;

    @Mock
    private UserService userService;

    @Test
    public void getById() {
        // Stub
        Account account = new Account();
        account.setUserName("user");
        account.setPassword("pass");
        account.setSalary(1000);
        given(userService.getAccount(1))
                .willReturn(account);

        accountController = new AccountController( userService );
        AccountResponse response = accountController.getById(1);
        AccountResponse expected
                = new AccountResponse("user", "pass", 1000);
        assertEquals(expected, response);
    }
}