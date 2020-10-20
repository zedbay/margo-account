package com.margo.tt.tt.user;

import com.margo.tt.tt.account.Account;

public class User {

    private static Integer idCounter = 0;
    private final Account account = new Account();
    private final Integer id;

    public User() {
        this.id = User.idCounter++;
    }

    public Integer getId() {
        return this.id;
    }
    public Account getAccount() { return this.account; }

}
