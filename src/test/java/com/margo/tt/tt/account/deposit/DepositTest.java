package com.margo.tt.tt.account.deposit;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/deposit.feature", plugin = { "pretty", "html:target/report"})
public class DepositTest { }
