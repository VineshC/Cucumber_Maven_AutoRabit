package com.brillio.rwr.stepdefs;

import com.automation.framework.exceptions.DriverScriptException;


import com.brillio.rwr.pageobjects.LoginPagePOC;
import com.brillio.rwr.utilities.CucumberDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Login {

	LoginPagePOC login;
	
	public Login() throws DriverScriptException{
		 login = new 	LoginPagePOC();
		 }
	
	@Given("^I navigate to salesforce url$")
	public void navigateToSalesforce() throws Throwable {
		 
		 login.loadURL();
		 //System.out.println("user logged in");
    }
	

	@And("^I enter \"([^\"]*)\" and \"([^\"]*)\"$" )
	public void enterCredential(String username, String password ) throws Throwable {
		String UN=CucumberDriver.testDriver.getScenarioTestData().get(username);
		String PSWD=CucumberDriver.testDriver.getScenarioTestData().get(password);
		 
		 login.enterCredentials(UN,PSWD);
		 //System.out.println("user logged in");
    }
	@And("^I click on login button$")
	public void clickOnLogin() throws Throwable {
		 login.clickLogin();
		 
    }
	
	 @And("^I verify the classic mode$")
	    public void i_verify_the_classic_mode() throws Throwable {
	       login.verifyClassicMode();
	    }
	
	 @And("^I verify the Lighting mode$")
	    public void i_verify_the_lighting_mode() throws Throwable {
	        login.verifyLightingMode();
	    }
	 
	 @And("^I logout from the application$")
	    public void i_logout_from_the_application() throws Throwable {
		 login.clickOnLogout();
	    }
}
