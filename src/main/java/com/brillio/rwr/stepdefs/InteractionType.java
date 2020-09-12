package com.brillio.rwr.stepdefs;

import com.automation.framework.exceptions.DriverScriptException;
import com.brillio.rwr.pageobjects.InteractionTypePage;
import com.brillio.rwr.utilities.CucumberDriver;

import cucumber.api.java.en.And;

public class InteractionType {
	InteractionTypePage interaction_type;
	public InteractionType() throws DriverScriptException {
		interaction_type=new InteractionTypePage();
	}
	
	 @And("^I click on Interaction Type tab$")
	    public void i_click_on_interaction_type_tab() throws Throwable {
		 interaction_type.clickInteractionType();
	    }
	
	 @And("^I select \"([^\"]*)\"$")
	    public void i_select_something(String name) throws Throwable {
		  String typeName=CucumberDriver.testDriver.getScenarioTestData().get(name);
		 
	       interaction_type.clickOnTypeName(typeName);
	    }
	 
	 @And("^I click on Edit button in Interaction$")
	    public void i_click_on_edit_button_in_interaction() throws Throwable {
	        interaction_type.clickOnEdit();
	    }

}
