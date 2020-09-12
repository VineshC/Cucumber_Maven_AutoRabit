package com.brillio.rwr.stepdefs;

import com.automation.framework.exceptions.DriverScriptException;
import com.brillio.rwr.pageobjects.SetupPage;
import com.brillio.rwr.utilities.CucumberDriver;
import cucumber.api.java.en.And;


public class SetupPageStepDef {
	
	
		SetupPage setup_page ;
		public  SetupPageStepDef() throws DriverScriptException {
		setup_page =new SetupPage();
		}

		@And("^I search for \"([^\"]*)\" in search textbox$")
	    public void i_search_for_something_in_search_textbox(String quicksearch) throws Throwable {
			String qs=CucumberDriver.testDriver.getScenarioTestData().get(quicksearch);
			setup_page.quickSearch(qs);
		}
		
		 @And("^I click on Lightning App Builder$")
		    public void i_click_on_lightning_app_builder() throws Throwable {
			 setup_page.clickOnLightingAppBuilder();
		 }
		 
		 @And("^I click on Custom Metadata Types$")
		    public void i_click_on_custom_metadata_types() throws Throwable {
			 setup_page.clickOnCustomMetaData();
		    }
		
}
