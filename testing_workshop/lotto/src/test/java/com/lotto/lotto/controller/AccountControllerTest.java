package com.lotto.lotto.controller;

import com.lotto.lotto.controller.response.AccountResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getById() {
        ResponseEntity<AccountResponse> result =
              testRestTemplate
                      .getForEntity("/account/1"
                                    , AccountResponse.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        AccountResponse expected
                = new AccountResponse("user", "pass", 1000);
        assertEquals(expected, result.getBody());
    }
}