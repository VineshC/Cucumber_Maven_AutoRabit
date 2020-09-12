package com.brillio.rwr.stepdefs;

import com.automation.framework.exceptions.DriverScriptException;

import com.brillio.rwr.pageobjects.ContactPage;

import cucumber.api.java.en.And;

public class ContactCreationAndVerify {
	
	ContactPage contact;
	
	public ContactCreationAndVerify() throws DriverScriptException{
		contact = new ContactPage();
		 }
    @And("^Click on Contact Tab and click on New button$")
    public void click_on_contact_tab_and_click_on_new_button() throws Throwable {
    	contact.clickOnContactsTab();
    	contact.clickOnNewButton();
    	
    }

    @And("^Create a contact by providing mandatory fields$")
    public void create_a_contact_by_providing_mandatory_fields() throws Throwable {
    	contact.addContactsName();
    	contact.clickOnSaveButton(); 	
    }

    @And("^Verify the contact is created$")
    public void verify_the_contact_is_created() throws Throwable {
    	//contact.clickOnContactDetailTab();;
    	contact.verifyContacts();
    }
}
