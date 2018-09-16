package com.lotto.lotto.controller;

import com.lotto.lotto.category.IntegrationTest;
import com.lotto.lotto.controller.response.AccountResponse;
import com.lotto.lotto.exception.ResponseException;
import com.lotto.lotto.repository.AccountRepository;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Category(IntegrationTest.class)
public class AccountControllerErrorTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void getByIdWithAccountNotFound() {
        // Clear data
        try {
            accountRepository.deleteById(2);
        } catch (Exception e) {}

        // Action
        ResponseEntity<ResponseException> result =
              testRestTemplate
                      .getForEntity("/account/2"
                                    , ResponseException.class);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals("Account id=[2] not found",
                result.getBody().getMessage());
        assertNotNull(result.getBody().getDate());
    }
}