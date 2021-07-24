package test_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\resources\\Elearning"} , glue= {"step_Defenition"},
monochrome = true,
dryRun = false,
strict = true,
plugin = {"html:testoutput/cucumber.html","junit:testoutput/cucumber.xml","json:testoutput/cucumber.json"}
		)
public class Runner {

}
