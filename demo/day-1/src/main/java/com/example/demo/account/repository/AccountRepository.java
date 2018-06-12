package com.example.demo.account.repository;

import com.example.demo.account.repository.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository
extends CrudRepository<Account, Integer> {



}
