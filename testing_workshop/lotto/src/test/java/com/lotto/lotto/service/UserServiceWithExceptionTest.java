package com.lotto.lotto.service;

import com.lotto.lotto.exception.MyAccountNotFoundException;
import com.lotto.lotto.model.Account;
import com.lotto.lotto.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceWithExceptionTest {

    @Mock
    private AccountRepository accountRepository;

    @Test(expected = MyAccountNotFoundException.class)
    public void getAccountWithException() {
        // Stub
        given(accountRepository.findById(1))
                .willThrow(new MyAccountNotFoundException("Not found"));

        UserService userService = new UserService(accountRepository);
        Account actualAccount = userService.getAccount(1);
    }

}

