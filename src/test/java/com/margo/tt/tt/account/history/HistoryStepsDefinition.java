package com.margo.tt.tt.account.history;

import com.margo.tt.tt.OperationType;
import com.margo.tt.tt.account.AccountNotEnoughProvisioned;
import com.margo.tt.tt.statement.Statement;
import com.margo.tt.tt.user.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@CucumberContextConfiguration
@SpringBootTest
public class HistoryStepsDefinition {

    private User user;
    private AccountNotEnoughProvisioned exception;

    @Given("^Un utilisateur possède un compte$")
    public void userHasAccountWithThisBalance() {
        this.user = new User();
    }

    @When("^Un utilisateur fait un depot de (\\d+)€$")
    public void userMakeASuccessfulDeposit(Float amountToDeposit) {
        this.user.getAccount().deposit(amountToDeposit);
    }

    @When("^Un utilisateur fait un retrait de (\\d+)€$")
    public void userMakeASuccessfulWithdrawal(Float amountToWithdrawal) throws AccountNotEnoughProvisioned {
        this.user.getAccount().deposit(amountToWithdrawal + 10);
        this.user.getAccount().withdrawal(amountToWithdrawal);
    }

    @Then("^Le dernier releve est de type depot$")
    public void lastStatementIsDepositType() {
        Statement lastStatement = this.getLastStatement();
        assertEquals(lastStatement.operationType, OperationType.DEPOSIT);
    }

    @Then("^Le dernier releve est de type retrait$")
    public void lastStatementIsWithdrawalType() {
        Statement lastStatement = this.getLastStatement();
        assertEquals(lastStatement.operationType, OperationType.WITHDRAWAL);
    }

    @Then("^Le dernier releve a pour montant (\\d+)€$")
    public void lastStatementHasAmountEqualTo(Float amount) {
        Statement lastStatement = this.getLastStatement();
        assertEquals(lastStatement.amount, amount);
    }

    @Then("^Le dernier releve a pour balance la balance actuelle du compte$")
    public void lastStatementBalanceIsEqualToCurrentBalance() {
        Statement lastStatement = this.getLastStatement();
        assertEquals(lastStatement.balance, this.user.getAccount().getBalance());
    }

    private Statement getLastStatement() {
        return this.user.getAccount().getHistory()
                .get(this.user.getAccount().getHistory().size() - 1);
    }


}
