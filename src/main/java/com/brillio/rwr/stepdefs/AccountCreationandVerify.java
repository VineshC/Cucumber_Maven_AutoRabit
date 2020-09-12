package com.brillio.rwr.stepdefs;

import java.awt.AWTException;


import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.MobileAdaptorException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.brillio.rwr.pageobjects.AccountPage;
import cucumber.api.java.en.And;
 

public class AccountCreationandVerify {
	
	AccountPage account;
	
	public AccountCreationandVerify() throws DriverScriptException{
		account = new AccountPage();
		 }
	
	  @And("^Click on Account Tab and click on New button$")
	    public void click_on_account_tab_and_click_on_new_button() throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException, InterruptedException, AWTException {
		  account.clickOnAccountsTab();
		  account.clickOnNewButton();
	  }

	    @And("^Create an account by providing account name$")
	    public void create_an_account_by_providing_account_name() throws Throwable {
	      account.addAccountName();
	      account.clickOnSaveButton();
	    }

	    @And("^Verify the account is created$")
	    public void verify_the_account_is_created() throws Throwable {
	     account.clickOnAccountsDetailTab();
	     account.verifyAccount();
	     

}
}
