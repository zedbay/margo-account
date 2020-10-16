package com.margo.tt.tt.statement;

import com.margo.tt.tt.OperationType;

import java.util.Date;

public class Statement {

    public Date creationDate;
    public Float amount;
    public Float balance;
    public OperationType operationType;

    public Statement(OperationType operationType, Float amount, Float balance, Date creationDate) {
        this.operationType = operationType;
        this.amount = amount;
        this.balance = balance;
        this.creationDate = creationDate;
    }

}
