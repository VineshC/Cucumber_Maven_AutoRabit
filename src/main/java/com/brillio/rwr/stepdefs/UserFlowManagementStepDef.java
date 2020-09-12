package com.brillio.rwr.stepdefs;


import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.brillio.rwr.pageobjects.HomePage;
import com.brillio.rwr.pageobjects.UserFlowManagement;
import com.brillio.rwr.utilities.CucumberDriver;
import cucumber.api.java.en.And;

public class UserFlowManagementStepDef {
	
	UserFlowManagement user;
	public UserFlowManagementStepDef() throws DriverScriptException {
		user = new UserFlowManagement();
	}
	 @And("^I click on Publish New Lightning Page Button$")
	    public void i_click_on_publish_new_lightning_page_button() throws Throwable {
		 user.clickOnPublishNewLightningPageButton();
	    }
	 
	 @And("^I select component \"([^\"]*)\" from the dropdown$")
	    public void i_select_component_something_from_the_dropdown(String strArg1) throws Throwable {
		 String pagecode=CucumberDriver.testDriver.getScenarioTestData().get(strArg1);
		 user.SelectLightingPageToPublish(pagecode);
	    }
	 @And("^I click on Publish button$")
	    public void i_click_on_publish_button() throws Throwable {
		 user.ClickOnPublishButton();
	    }

	 @And("^I verify the successful Publish Message and navigate to previous page$")
	    public void i_verify_the_successful_publish_message_and_navigate_to_previous_page() throws Throwable {
		 user.VerifyPublishSuccess();
	    }
	

	

}

