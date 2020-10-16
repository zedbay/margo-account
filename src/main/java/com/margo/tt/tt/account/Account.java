package com.margo.tt.tt.account;

import com.margo.tt.tt.OperationType;
import com.margo.tt.tt.statement.Statement;

import java.util.ArrayList;
import java.util.Date;

public class Account {

    private Float balance = (float) 0;
    private ArrayList<Statement> history = new ArrayList<>();

    public Statement withdrawal(Float amount) throws AccountNotEnoughProvisioned {
        if (this.balance - amount < 0) {
            throw new AccountNotEnoughProvisioned("Impossible action: account not enough provisioned");
        }
        this.balance -= amount;
        Statement statement = new Statement(
                OperationType.WITHDRAWAL,
                amount,
                this.balance,
                new Date()
        );
        this.history.add(statement);
        return statement;
    }

    public Statement deposit(Float amount) {
        this.balance += amount;
        Statement statement = new Statement(
                OperationType.DEPOSIT,
                amount,
                this.balance,
                new Date()
        );
        this.history.add(statement);
        return statement;
    }

    public Float getBalance() {
        return this.balance;
    }

    public ArrayList<Statement> getHistory() { return this.history; }

}
