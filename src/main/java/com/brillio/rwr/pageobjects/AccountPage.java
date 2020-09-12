package com.brillio.rwr.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

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

public class AccountPage {
	
	WebDriver driver;
	TestDriver testDriver;
	Robot rb;
	ObjectRead objectRead;
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 10;
	
	public AccountPage() throws DriverScriptException {
		testDriver = CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}
	
	public void clickOnAccountsTab() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {
			Web.webAdaptor(testDriver, WebAction.wait,"wait.low");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ComponentDropDown");
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "AccountsTab");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "AccountsTab");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "AccountsTab");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnAccountsTab" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "clickOnAccountsTab" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("clickOnAccountsTab" + " is unsuccessful", ex.getCause()));
		}
	}
	
	public void clickOnNewButton()throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "NewButtonInAccountsPage");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "NewButtonInAccountsPage");
			Web.webAdaptor(testDriver, WebAction.click, "NewButtonInAccountsPage");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnNewButton" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "clickOnNewButton" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("clickOnNewButton" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void addAccountName()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "AccountName");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "AccountName");
		 	testDriver.setAccountName("Account " + generateRandomString());
			Web.webAdaptor(testDriver, WebAction.setText, "AccountName", testDriver.getAccountName());
			DriverScript.logMessage(testDriver, "testStepDone", "addAccountName" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "addAccountName" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("addAccountName" + " is unsuccessful", ex.getCause()));
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


	public void clickOnAccountsDetailTab()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.wait,"wait.medium");
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "DetailsTab");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "DetailsTab");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "DetailsTab");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnAccountsDetailTab" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "clickOnAccountsDetailTab" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("clickOnAccountsDetailTab" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void verifyAccount()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "AccountNameInAccountsDetailPage");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "AccountNameInAccountsDetailPage");
			Web.webAdaptor(testDriver, WebAction.isElementDisplayed, "AccountNameInAccountsDetailPage");
			Web.webAdaptor(testDriver, WebAction.getText, "AccountNameInAccountsDetailPage");
			String Account_Name= testDriver.getMapValues().get("AccountNameInAccountsDetailPage");
			System.out.println("**********************"+Account_Name+"******************");
			Web.webAdaptor(testDriver, WebAction.verifyElementText, "AccountNameInAccountsDetailPage",
					testDriver.getAccountName());
			DriverScript.logMessage(testDriver, "testStepDone", "verifyAccount" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "verifyAccount" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("verifyAccount" + " is unsuccessful", ex.getCause()));
		}

	}
	
	/**
	 * This method generates random string
	 * 
	 * @return int
	 */
		
	public String generateRandomString() {

		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	/**
	 * This method generates random numbers
	 * 
	 * @return int
	 */
	private int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}
}
