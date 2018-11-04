package com.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hd on 8/6/18.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "account")
    private Set<Bookmark> bookmarks=new HashSet();

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public String getUsername() {
        return username;
    }
    public String toString(){
        return "Account: {id: "+id +", username: "+username+"}";
    }
}
