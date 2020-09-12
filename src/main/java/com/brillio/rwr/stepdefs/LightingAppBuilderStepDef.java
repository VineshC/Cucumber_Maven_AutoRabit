package com.brillio.rwr.stepdefs;


import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.brillio.rwr.pageobjects.HomePage;
import com.brillio.rwr.pageobjects.LightingAppBuilder;
import com.brillio.rwr.utilities.CucumberDriver;
import cucumber.api.java.en.And;

public class LightingAppBuilderStepDef {
	
	LightingAppBuilder app_builder;
	public LightingAppBuilderStepDef() throws DriverScriptException {
		app_builder = new LightingAppBuilder();
	}
	
	 @And("^I scrolldown to \"([^\"]*)\"$")
	    public void i_scrolldown_to_something(String code) throws Throwable {
		 String scrollCode= CucumberDriver.testDriver.getScenarioTestData().get(code);
		 app_builder.scrollToLightingPage(scrollCode);
	 }
	 @And("^I click on \"([^\"]*)\"$")
	    public void i_click_on_something(String code) throws Throwable {
		 String selectCode= CucumberDriver.testDriver.getScenarioTestData().get(code);
		// setup_page.scrollToLightingPage(selectCode);
		 app_builder.clickToSelectWizard(selectCode);
	 }
	 @And("^I click on Edit button in setup page$")
	 public void i_click_on_edit_button_in_setup_page() throws Throwable {
		 app_builder.clickOnEditButton();
	 }
	 
	 @And("^I search for component \"([^\"]*)\" in search textbox$")
	    public void i_search_for_component_something_in_search_textbox(String compsearch) throws Throwable {
		 String cs=CucumberDriver.testDriver.getScenarioTestData().get(compsearch);
		 app_builder.componentQuickSearch(cs);
	 }
	 
	 @And("^I scroll down and click on SelectComponent link in component editor$")
	    public void i_scroll_down_and_click_on_selectcomponent_link_in_component_editer() throws Throwable {
		 app_builder.selectComponent();
	 }
	 @And("^I click to select on ManageExpertCompensation component$")
	    public void i_click_to_select_on_manageexpertcompensation_component() throws Throwable {
		 app_builder.clickToSelectComponent();
	 }
	 @And("^I enter the Step name as \"([^\"]*)\" in textbox$")
	    public void i_enter_the_step_name_as_something_in_textbox(String arg) throws Throwable {
		 String sn=CucumberDriver.testDriver.getScenarioTestData().get(arg);
		 app_builder.enterStepName(sn);
	    }
	 @And("^I click on Save button in setup page$")
	    public void i_click_on_save_button_in_setup_page() throws Throwable {
		 app_builder.clickOnSaveButton();
	 }
	 @And("^I click on Back button in setup page$")
	    public void i_click_on_back_button_in_setup_page() throws Throwable {
		 app_builder.clickOnBackButton();
	  }
	 @And("^I click on All Tabs link in setup page$")
	    public void i_click_on_all_tabs_link_in_setup_page() throws Throwable {
		 app_builder.clickOnAllTabsLink();
	    }
	 @And("^I scrolldown and click on \"([^\"]*)\" link$")
	    public void i_scrolldown_and_click_on_something_link(String strArg1) throws Throwable {
		 String userflow = CucumberDriver.testDriver.getScenarioTestData().get(strArg1);
		 app_builder.clickOnUserFlowManagement(userflow);
	    }

}

