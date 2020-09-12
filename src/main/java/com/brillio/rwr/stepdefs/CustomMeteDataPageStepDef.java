package com.brillio.rwr.stepdefs;


import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.brillio.rwr.pageobjects.CustomMetaDataPage;
import com.brillio.rwr.pageobjects.HomePage;
import com.brillio.rwr.utilities.CucumberDriver;
import cucumber.api.java.en.And;

public class CustomMeteDataPageStepDef {
	
	CustomMetaDataPage custome_page;
	public CustomMeteDataPageStepDef() throws DriverScriptException {
		custome_page = new CustomMetaDataPage();
	}
	
	 @And("^I click on Manage Screen Configurations button$")
	    public void i_click_on_manage_screen_configurations_button() throws Throwable {
		 custome_page.manageScreenConfigButton();
	    }
	 @And("^I change the Fieldproperty in the Screen Configuration Component Detail$")
	    public void i_change_the_fieldproperty_in_the_screen_configuration_component_detail() throws Throwable {
		 custome_page.changeFieldState();
	    }
	 @And("^I click on \"([^\"]*)\" button in setup page$")
	    public void i_click_on_something_button_in_setup_page(String strArg1) throws Throwable {
		 String savebtn =CucumberDriver.testDriver.getScenarioTestData().get(strArg1);
		 custome_page.clickOnSave(savebtn);
	    }


}

