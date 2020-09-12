package com.brillio.rwr.stepdefs;


import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.brillio.rwr.pageobjects.HomePage;
import com.brillio.rwr.pageobjects.StakeholderPage;
import com.brillio.rwr.utilities.CucumberDriver;
import cucumber.api.java.en.And;

public class StakeholderPageStepDef {
	
	StakeholderPage stakeholderpage;
	public StakeholderPageStepDef() throws DriverScriptException {
		stakeholderpage = new StakeholderPage();
	}
	@And("^I click on Add Approvers button$")
    public void i_click_on_add_approvers_button() throws Throwable {
		stakeholderpage.clickOnAddApproversButton();
    }
	@And("^I select Approver Role$")
    public void i_select_approver_role() throws Throwable {
		stakeholderpage.SelectApprover();
    }
	@And("^I select Approver Level$")
    public void i_select_approver_level() throws Throwable {
		stakeholderpage.SelectApproverLevel();
    }
    @And("^I search for employee \"([^\"]*)\" in search textbox and select it$")
    public void i_search_for_employee_something_in_search_textbox_and_select_it(String strArg1) throws Throwable {
    	String emp =CucumberDriver.testDriver.getScenarioTestData().get(strArg1);
    	stakeholderpage.searchEmployeeAndSelect(emp);
    }
    @And("^I click on Done Button$")
    public void i_click_on_done_button() throws Throwable {
    	stakeholderpage.clickOnDoneButton();
    }
    @And("^I click on Expert link$")
    public void i_click_on_expert_link() throws Throwable {
    	stakeholderpage.clickOnExpertLink();
    }
}

