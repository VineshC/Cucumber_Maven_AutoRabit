package com.brillio.rwr.stepdefs;


import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.brillio.rwr.pageobjects.HomePage;
import com.brillio.rwr.pageobjects.InitiateInteractionPage;
import com.brillio.rwr.utilities.CucumberDriver;
import cucumber.api.java.en.And;

public class InitiateInteractionPageStepDef {
	
	InitiateInteractionPage interaction_page;
	public InitiateInteractionPageStepDef() throws DriverScriptException {
		interaction_page = new InitiateInteractionPage();
	}
	
	 @And("^I select interaction category as consulting services$")
	    public void i_select_interaction_category_as_consulting_services() throws Throwable {
		 interaction_page.SelectInteractionCategory();
	    }

	 @And("^I select interaction Type as Ltng: Advisory Board$")
	    public void i_select_interaction_type_as_ltng_advisory_board() throws Throwable {
		 interaction_page.SelectInteractionType();
	    }

	 @And("^I click on Next Button$")
	    public void i_click_on_next_button() throws Throwable {
		 interaction_page.clickOnNextButton();
	    }
}

