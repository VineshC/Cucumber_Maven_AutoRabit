package com.brillio.rwr.stepdefs;


import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.brillio.rwr.pageobjects.HomePage;
import com.brillio.rwr.utilities.CucumberDriver;
import cucumber.api.java.en.And;

public class HomePageStepDef {
	
	HomePage homepage;
	public HomePageStepDef() throws DriverScriptException {
		homepage = new HomePage();
	}
	
	

	@And ("^I click on Setup link$")
    public void i_click_on_setup() throws Throwable {
	   homepage.clickOnSetup();
	   }
	@And("^I click on Home Tab and click on Initaite Program Button$")
    public void i_click_on_home_tab_and_click_on_initaite_program_button() throws Throwable {
		homepage.clickOnHomeTab();
		homepage.clickOnInitiateProgramButton();
    }
	@And("^I search for created Interaction in searchbox$")
    public void i_search_for_created_interaction_in_searchbox() throws Throwable {
		homepage.searchForInteractionInSearchBox();
    }
	@And("^I click on Edit Button for selected Interaction$")
    public void i_click_on_edit_button_for_selected_interaction() throws Throwable {
        homepage.clickOnEditButton();
    }
}

