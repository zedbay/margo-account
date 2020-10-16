package com.margo.tt.tt;

import com.margo.tt.tt.account.Account;
import com.margo.tt.tt.account.AccountNotEnoughProvisioned;
import com.margo.tt.tt.statement.Statement;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AccountTests {


    @Test
    public void balanceInNewShouldBeEqualToZero() {
        Account account = new Account();
        assertEquals(account.getBalance(), (float) 0);
    }

    @Test
    public void testDeposit() {
        Account account = new Account();
        account.deposit((float) 122);
        assertEquals(account.getBalance(), 122);
    }

    @Test
    public void testWithdrawal() {
        Account account = new Account();
        account.deposit((float) 122);
        try {
            account.withdrawal((float) 12);
        } catch (AccountNotEnoughProvisioned e) {
            fail(e.getMessage());
        }
        assertEquals(account.getBalance(), 110);
    }

    @Test
    public void testHistory() {
        Account account = new Account();
        account.deposit((float) 100);
        assertEquals(account.getHistory().size(), 1);
        try {
            account.withdrawal((float) 12);
        } catch (AccountNotEnoughProvisioned e) {
            fail(e.getMessage());
        }
        assertEquals(account.getHistory().size(), 2);
    }

    @Test
    public void shouldAssertAccountNotEnoughProvisionedException() {
        Account account = new Account();
        Exception exception = assertThrows(AccountNotEnoughProvisioned.class, () -> {
           account.withdrawal((float) 1);
        });
        String expectedMessage = "Impossible action: account not enough provisioned";
        assertEquals(expectedMessage, exception.getMessage());
    }


}
