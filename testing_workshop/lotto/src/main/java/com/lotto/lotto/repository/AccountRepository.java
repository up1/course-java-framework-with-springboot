package com.lotto.lotto.repository;

import com.lotto.lotto.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository
 extends CrudRepository<Account, Integer> {
}
