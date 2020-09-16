import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = {"C:/Users/vinesh.c/git/Cucumber_Maven_AutoRabit/Cucumber_SFDC-master/files/LoginAndVerify.feature"},
plugin = {"json:target/cucumber-parallel/3.json"},
monochrome = true,
tags = {},
glue = { "com.brillio.rwr.stepdefs" })
public class Parallel03IT {
}
