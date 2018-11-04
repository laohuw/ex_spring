package com.algo.business;

import com.algo.dao.AccountRepository;
import com.algo.dao.BookmarkRepository;
import com.algo.model.Account;
import com.algo.model.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;
import java.util.List;

/**
 * Created by hd on 8/6/18.
 */
@Component
@Transactional
public class AccountBusiness {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    BookmarkRepository bookmarkRepository;


    public List<Account> init(){
        Arrays.asList("jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong")
                .forEach(username -> {
                    Account account = accountRepository.save(new Account(username, "password"));
                    bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + username, "A description"));
                    bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + username, "A description"));
                });
        return null;
    }

    public List<Account> getAll(){
        return accountRepository.findAll();
    }
}
