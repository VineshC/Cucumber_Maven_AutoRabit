package com.brillio.rwr.stepdefs;


import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.brillio.rwr.pageobjects.HomePage;
import com.brillio.rwr.pageobjects.InteractionSetupPage;
import com.brillio.rwr.utilities.CucumberDriver;
import cucumber.api.java.en.And;

public class InteractionSetupPageStepDef {
	
	InteractionSetupPage interaction_setup;
	public InteractionSetupPageStepDef() throws DriverScriptException {
		interaction_setup = new InteractionSetupPage();
	}
	
	@And("^I enter title as \"([^\"]*)\" in title field$")
    public void i_enter_title_as_something_in_title_field(String strArg1) throws Throwable {
		String title=CucumberDriver.testDriver.getScenarioTestData().get(strArg1);
		interaction_setup.enterTitle(title);
    }
	
	 @And("^I add description of services as Test Description$")
	    public void i_add_description_of_services_as_test_description() throws Throwable {
		interaction_setup.addDescriptionServices();
    }
	@And("^I enter Start Date as \"([^\"]*)\" and select Start Time$")
    public void i_enter_start_date_as_something_and_select_start_time(String strArg1) throws Throwable {
		String startdate=CucumberDriver.testDriver.getScenarioTestData().get(strArg1);
		interaction_setup.enterStartDateAndTime(startdate);
    }
	@And("^I enter End Date as \"([^\"]*)\" and select End Time$")
    public void i_enter_end_date_as_something_and_select_end_time(String strArg1) throws Throwable {
		String enddate=CucumberDriver.testDriver.getScenarioTestData().get(strArg1);
		interaction_setup.enterEndDateAndTime(enddate);
    }
	@And("^I click on shareholder link$")
    public void i_click_on_shareholder_link() throws Throwable {
		interaction_setup.clickOnShareholderlink();
    }
}

