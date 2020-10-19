package com.margo.tt.tt.account.deposit;

import com.margo.tt.tt.user.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@CucumberContextConfiguration
@SpringBootTest
public class DepositStepsDefinition {

    private User user = new User();

    @Given("^Un utilisateur possède un compte avec comme solde (\\d+)€$")
    public void clientHasAnAccount(Float currentBalance) throws Exception {
        assertEquals(currentBalance, this.user.getAccount().getBalance());
    }

    @When("^Un utilisateur fait un depot de (\\d+)€$")
    public void clientDeposit(Float amountToDeposit) {
        this.user.getAccount().deposit(amountToDeposit);
    }

    @Then("^La somme de son compte en banque est (\\d+)€$")
    public void clientHasGoodBalance(Float newBalance) {
        assertEquals(this.user.getAccount().getBalance(), newBalance);
    }

}
