package com.lotto.lotto.repository;

import com.lotto.lotto.category.SlicingTest;
import com.lotto.lotto.model.Account;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@Category(SlicingTest.class)
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void createNewAccount() {
        Account newAccount = new Account();
        newAccount.setUserName("somkiat");
        newAccount.setPassword("pass");
        newAccount.setSalary(100);
        Account actualAccount = accountRepository.save(newAccount);

        assertTrue(actualAccount.getId() > 0);
        assertEquals(1, accountRepository.count());
    }

    @Test
    public void createNewAccount2() {
        Account newAccount = new Account();
        newAccount.setUserName("somkiat");
        newAccount.setPassword("pass");
        newAccount.setSalary(100);
        Account newAccount2 = new Account();
        accountRepository.save(newAccount);
        accountRepository.save(newAccount2);

        assertEquals(2, accountRepository.count());
    }



}