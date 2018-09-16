package com.lotto.lotto.controller;

import com.lotto.lotto.category.UnitTest;
import com.lotto.lotto.controller.response.AccountResponse;
import com.lotto.lotto.exception.MyAccountNotFoundException;
import com.lotto.lotto.model.Account;
import com.lotto.lotto.repository.AccountRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@Category(UnitTest.class)
public class AccountControllerErrorUnitTest {

    @Mock
    private AccountRepository repository;

    private AccountController accountController;

    @Before
    public void initial() {
        initMocks(this);
    }

    @Test(expected = MyAccountNotFoundException.class)
    public void getByIdWithException() {
        // Stub
        when(repository.findById(2))
                .thenReturn(Optional.empty());
//                .willThrow(new MyAccountNotFoundException("Fail na"));

        accountController = new AccountController(repository);
        AccountResponse response = accountController.getById(2);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getByIdWithExceptionWithRule() {
        // Stub
        when(repository.findById(2))
                .thenReturn(Optional.empty());

        accountController = new AccountController(repository);

        thrown.expect(MyAccountNotFoundException.class);
        thrown.expectMessage("Account id=[2] not found");
        AccountResponse response = accountController.getById(2);
    }

}