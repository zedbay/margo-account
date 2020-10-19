package com.margo.tt.tt.account.withdrawal;

import com.margo.tt.tt.account.AccountNotEnoughProvisioned;
import com.margo.tt.tt.user.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@CucumberContextConfiguration
@SpringBootTest
public class WithdrawalStepsDefinition {

    private User user = new User();
    private Exception exception;

    @Given("^Un utilisateur possède un compte avec comme solde (\\d+)€$")
    public void clientHasAnAccount(Float initialBalance) throws Exception {
        this.user.getAccount().deposit(initialBalance);
        assertEquals(initialBalance, this.user.getAccount().getBalance());
    }

    @When("^Un utilisateur fait un retrait de (\\d+)€$")
    public void clientDeposit(Float amountToDeposit) {
        try {
            this.user.getAccount().withdrawal(amountToDeposit);
        } catch (AccountNotEnoughProvisioned e) {
            this.exception = e;
        }
    }

    @Then("^La somme de son compte en banque est (\\d+)€$")
    public void clientHasGoodBalance(Float newBalance) {
        assertEquals(this.user.getAccount().getBalance(), newBalance);
    }

    @And("^Une erreur doit etre leve$")
    public void anAccountNotEnoughProvisionedShouldBeRaised() {
        assertNotNull(this.exception);
    }


}
