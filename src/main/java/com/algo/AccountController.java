package com.algo;

import com.algo.business.AccountBusiness;
import com.algo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hd on 8/6/18.
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountBusiness accountBusiness;

    @GetMapping("/init")
    public List<Account> init(){
        List<Account>  accounts=accountBusiness.init();
        return accounts;
    }

    @GetMapping("/all")
    public List<Account> getAll(){
        List<Account>  accounts= accountBusiness.getAll();
        return accounts;
    }
}
