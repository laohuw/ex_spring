package com.algo.dao;

import com.algo.business.AccountBusiness;
import com.algo.model.Account;
import com.algo.model.Bookmark;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by hd on 8/12/18.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setup(){
        Arrays.asList("jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong")
                .forEach(username -> {
                    Account account = accountRepository.save(new Account(username, "password"));
                });
    }
    @Test
    public void findByUsername() throws Exception {
        Optional<Account> account=accountRepository.findByUsername("jhoeller");
        assertTrue(account.isPresent());
        System.out.println(account.get());
    }

}