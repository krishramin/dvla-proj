package cucumber.stepdefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@CucumberOptions(
        format ={"pretty","html:target/cucumber"},
        features={"classpath:features/"}
)
@RunWith(Cucumber.class)
public class CucumberJvmRunner {
}
