package com.margo.tt.tt.account.withdrawal;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/withdrawal.feature", plugin = { "pretty", "html:target/report"})
public class WithdrawalTest {

}
