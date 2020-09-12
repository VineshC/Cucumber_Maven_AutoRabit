package com.brillio.rwr.stepdefs;

import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.pojs.TestDriver;
import com.brillio.rwr.pageobjects.InteractionTypeEditPage;
import com.brillio.rwr.utilities.CucumberDriver;

import cucumber.api.java.en.And;

public class InteractionTypeEdit {

	InteractionTypeEditPage editRole;
	
	public InteractionTypeEdit() throws DriverScriptException {
		editRole = new InteractionTypeEditPage();
	}
	
	@And("^I scroll down to \"([^\"]*)\"$")
    public void i_scroll_down_to_something(String code) throws Throwable {
        String ruleCode= CucumberDriver.testDriver.getScenarioTestData().get(code);
        editRole.scrollToRuleCode(ruleCode);
    }
	
	@And("^I select the role \"([^\"]*)\"$")
    public void i_select_the_role_something(String rolename) throws Throwable {
		
		
        String role=CucumberDriver.testDriver.getScenarioTestData().get(rolename);
        editRole.selectRole(role);
    }
	
	 @And("^I select multiple roles such as \"([^\"]*)\"$")
	    public void i_select_multiple_roles_such_as_something(String roles) throws Throwable {
		 String rolenames=CucumberDriver.testDriver.getScenarioTestData().get(roles);
		 String[] names=rolenames.split(",");
		 editRole.selectRoles(names);
		 }
	 
	 @And("^I select multiple roles such as \"([^\"]*)\" and \"([^\"]*)\"$")
	    public void i_select_multiple_roles_such_as_something_and_something(String role1, String role2) throws Throwable {
		 String roles1= CucumberDriver.testDriver.getScenarioTestData().get(role1);
		 String roles2= CucumberDriver.testDriver.getScenarioTestData().get(role2); 
	       editRole.selectMultipleRoles(roles1, roles2); 
	    }

	 
	 @And("^I click on Save button$")
	    public void i_click_on_save_button() throws Throwable {
	        editRole.clickOnSave();
	    }
	
	

}
