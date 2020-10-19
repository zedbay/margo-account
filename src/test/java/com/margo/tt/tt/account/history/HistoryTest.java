package com.margo.tt.tt.account.history;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/history.feature", plugin = { "pretty", "html:target/report"})
public class HistoryTest {
}
