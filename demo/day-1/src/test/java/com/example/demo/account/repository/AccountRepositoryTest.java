package com.example.demo.account.repository;

import com.example.demo.account.repository.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void
    ทำการสร้างหนึ่งบัญชีลงฐานข้อมูล() {
        // Arrange
        Account newAccount = new Account();
        newAccount.setAccountId("01");
        newAccount.setMobileNo("0868696209");

        // Action
        Account actualAccount
                = accountRepository.save(newAccount);

        // Assert
        assertNotNull(actualAccount);
        assertTrue(actualAccount.getId() > 0);
        assertEquals("01", actualAccount.getAccountId());
    }

    @Test
    public void
    ทำการสร้างหนึ่งบัญชีลงฐานข้อมูล2() {
        // Initial data
        assertEquals(0, accountRepository.count());

        // Insert new account
        Account newAccount = new Account();
        newAccount.setAccountId("02");
        newAccount.setMobileNo("0868696209");
        accountRepository.save(newAccount);

        // Assert
        assertEquals(1, accountRepository.count());
    }

}