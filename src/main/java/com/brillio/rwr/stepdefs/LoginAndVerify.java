package com.brillio.rwr.stepdefs;

import com.automation.framework.exceptions.DriverScriptException;
import com.brillio.rwr.pageobjects.LoginPage;
import com.brillio.rwr.utilities.CucumberDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 

public class LoginAndVerify {

	LoginPage login;
	
	public LoginAndVerify() throws DriverScriptException{
		 login = new 	LoginPage();
		 }
	   @Given("^Navigate to Salesforce Login URL$")
	    public void navigate_to_salesforce_login_url() throws Throwable {
		   login.loadURL();
	    }

	    @Then("^Click on the Login button$")
	    public void click_on_the_login_button() throws Throwable {
	    	login.clickLogin();
	    	
	    }

	   @When("^Enter the \"([^\"]*)\" and \"([^\"]*)\"$")	   
	    public void enter_the_something_and_something(String username, String password) throws Throwable {
	    	String UN=CucumberDriver.testDriver.getScenarioTestData().get(username);
			String PSWD=CucumberDriver.testDriver.getScenarioTestData().get(password);
			login.enterCredentials(UN,PSWD);
	    }

	    @And("^Verify the Logged in user$")
	    public void verify_the_logged_in_user() throws Throwable {
	       // login.verifyHomePage();
	    	login.verifyLoginUser();
	       
	    }
	    
	    @And("^Click on Applauncher and search app and select the app$")
	    public void click_on_applauncher_and_search_app_and_select_the_app() throws Throwable {
	        login.clickapplauncher();
	    }
	
	    @And("^Logged from the application$")
	    public void logged_from_the_application() throws Throwable {
	    	login.clickOnLogout();
	    }
}
