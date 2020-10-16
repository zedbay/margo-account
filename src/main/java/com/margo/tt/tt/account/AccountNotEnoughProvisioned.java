package com.margo.tt.tt.account;

public class AccountNotEnoughProvisioned extends Exception {

    public AccountNotEnoughProvisioned(String errorMessage) {
        super(errorMessage);
    }

}
