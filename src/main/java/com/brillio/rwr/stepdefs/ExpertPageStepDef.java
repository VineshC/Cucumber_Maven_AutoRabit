package com.brillio.rwr.stepdefs;


import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.brillio.rwr.pageobjects.ExpertPage;
import com.brillio.rwr.pageobjects.HomePage;
import com.brillio.rwr.utilities.CucumberDriver;
import cucumber.api.java.en.And;

public class ExpertPageStepDef {
	
	ExpertPage expertpage;
	public ExpertPageStepDef() throws DriverScriptException {
		expertpage = new ExpertPage();
	}
	@And("^I verify the Add Expert button in Expert link$")
    public void i_verify_the_add_expert_button_in_expert_link() throws Throwable {
		expertpage.verifyAddExpertButton();
		expertpage.storeInteractionNumber();
    }
	
	
	
}

