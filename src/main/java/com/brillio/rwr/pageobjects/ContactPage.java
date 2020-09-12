package com.brillio.rwr.pageobjects;

import java.awt.Robot;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.automation.framework.actionInterpreter.Web;
import com.automation.framework.actionInterpreter.Web.WebAction;
import com.automation.framework.core.DriverScript;
import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.MobileAdaptorException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.automation.framework.pojs.TestDriver;
import com.automation.framework.utilities.ObjectRead;
import com.brillio.rwr.utilities.CucumberDriver;

public class ContactPage {
	
	WebDriver driver;
	TestDriver testDriver;
	Robot rb;
	ObjectRead objectRead;
	AccountPage accountsPage;
	String ContactFirstName;
	String ContactLastName;
	String ActualContactName;
	
	public ContactPage() throws DriverScriptException {
		testDriver = CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
		accountsPage = new AccountPage();
	}

	public void clickOnContactsTab()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.wait,"wait.low");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ComponentDropDown");
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ContactsTab");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "ContactsTab");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ContactsTab");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnContactsTab" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "clickOnContactsTab" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("clickOnContactsTab" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void clickOnNewButton()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "NewButtonInContactsPage");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "NewButtonInContactsPage");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.click, "NewButtonInContactsPage");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnNewButton" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "clickOnNewButton" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("clickOnNewButton" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void addContactsName()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			selectSalutationFromDropdown();
			addContactName();
			DriverScript.logMessage(testDriver, "testStepDone", "addContactsName" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "addContactsName" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("addContactsName" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void selectSalutationFromDropdown()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SalutationOfName");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "SalutationOfName");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.click, "SalutationOfName");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.setValueToXpathAndClickUsingJavscript, "SalutaionDropdownValues",
					testDriver.getScenarioTestData().get("Salutation"));
			DriverScript.logMessage(testDriver, "testStepDone", "selectSalutationFromDropdown" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "selectSalutationFromDropdown" + " is unsuccessful");
			throw new WebAdaptorException(
					new Throwable("selectSalutationFromDropdown" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void addContactName()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ContactsFirstName");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "ContactsFirstName");
			Web.webAdaptor(testDriver, WebAction.clear, "ContactsFirstName");
			ContactFirstName = "FN" + accountsPage.generateRandomString();
			Web.webAdaptor(testDriver, WebAction.setText, "ContactsFirstName", ContactFirstName);
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ContactsLastName");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "ContactsLastName");
			Web.webAdaptor(testDriver, WebAction.clear, "ContactsLastName");
			ContactLastName = "LN" + accountsPage.generateRandomString();
			Web.webAdaptor(testDriver, WebAction.setText, "ContactsLastName", ContactLastName);
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ContactsAccountNameTextBox");
			Web.webAdaptor(testDriver, WebAction.click, "ContactsAccountNameTextBox");
			if (testDriver.getScenarioTestData().get("AccountNameExists").equalsIgnoreCase("Yes"))
				selectGivenAccountName();
			else
				selectRandomAccountName();
			DriverScript.logMessage(testDriver, "testStepDone", "addContactName" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "addContactName" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("addContactName" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void selectGivenAccountName()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.setXpathAndwaitForObjectToLoad, "ContactsAccountName",
					testDriver.getScenarioTestData().get("ContactAccountName"));
			testDriver.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Web.webAdaptor(testDriver, WebAction.setValueToXpathAndClickUsingJavscript, "ContactsAccountName",
					testDriver.getScenarioTestData().get("ContactAccountName"));
			DriverScript.logMessage(testDriver, "testStepDone", "selectGivenAccountName" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "selectGivenAccountName" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("selectGivenAccountName" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void selectRandomAccountName()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.setXpathAndwaitForObjectToLoad, "ContactsAccountName",
					testDriver.getAccountName());
			testDriver.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Web.webAdaptor(testDriver, WebAction.setValueToXpathAndClickUsingJavscript, "ContactsAccountName",
					testDriver.getAccountName());
			DriverScript.logMessage(testDriver, "testStepDone", "selectRandomAccountName" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "selectRandomAccountName" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("selectRandomAccountName" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void clickOnSaveButton()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SaveButton");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "SaveButton");
			Web.webAdaptor(testDriver, WebAction.click, "SaveButton");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnSaveButton" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "clickOnSaveButton" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("clickOnSaveButton" + " is unsuccessful", ex.getCause()));
		}

	}

	public void verifyContacts()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			String ContactName=testDriver.getScenarioTestData().get("Salutation")+" "+ContactFirstName+" "+ContactLastName;
			System.out.println("Contact name to be displayed is "+ContactName);
			Web.webAdaptor(testDriver, WebAction.wait,"wait.low");
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "DetailsTab");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "DetailsTab");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "DetailsTab");
			//Web.webAdaptor(testDriver, WebAction.getText, "ContactNameInContactsPage");
			//String Contact_Name= testDriver.getMapValues().get("ContactNameInContactsPage");
			Web.webAdaptor(testDriver, WebAction.setValueToXpathAndGetText, "ContactNameInContactsPage",ContactName);
			String Contact_Name= testDriver.getMapValues().get("ContactNameInContactsPage");
			System.out.println("**********************"+Contact_Name+"******************");
			String ExpectedContactName=testDriver.getScenarioTestData().get("Salutation")+" "+ContactFirstName+" "+ContactLastName+"View Contact Hierarchy";
		 	if (Contact_Name.equalsIgnoreCase(ExpectedContactName))
	 		System.out.println("**********************"+"verifyContacts is successful"+"******************");
			DriverScript.logMessage(testDriver, "testStepDone", "verifyContacts" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "verifyContacts" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("verifyContacts" + " is unsuccessful", ex.getCause()));
		}

	}
	

public void clickOnContactDetailTab()
		throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
	try {
		Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ContactDetailsTab");
		//Web.webAdaptor(testDriver, WebAction.IsElementExist, "DetailsTab");
		Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ContactDetailsTab");
		DriverScript.logMessage(testDriver, "testStepDone", "clickOnContactDetailTab" + " is successful");
	} catch (WebAdaptorException ex) {
		DriverScript.logMessage(testDriver, "testStepFail", "clickOnContactDetailTab" + " is unsuccessful");
		throw new WebAdaptorException(new Throwable("clickOnContactDetailTab" + " is unsuccessful", ex.getCause()));
	}

}
}
