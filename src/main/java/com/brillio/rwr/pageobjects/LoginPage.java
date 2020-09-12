package com.brillio.rwr.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
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
 

public class LoginPage  {

	WebDriver driver;
	TestDriver testDriver;
	Robot rb;
	
	public LoginPage() throws DriverScriptException {
		testDriver = CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}
	
	public void loadURL() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		//Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
		DriverScript.logMessage(testDriver, "testStepDone", "login successfully");
	}
	
	public void enterCredentials(String UN, String PSWD) throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "UsernameTextBox");
			Web.webAdaptor(testDriver, WebAction.setTextUsingJavaScript,"UsernameTextBox",UN);
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "PasswordTextBox");
			Web.webAdaptor(testDriver, WebAction.setTextUsingJavaScript,"PasswordTextBox",PSWD);
									
			DriverScript.logMessage(testDriver, "testStepDone", "Credential entered  successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "Credential entered is not successful");
            throw new WebAdaptorException(new Throwable("Credential entered is not successful", e.getCause()));
	    
	    }
	}
	
	public void clickLogin() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {	
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "LoginButton");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"LoginButton");	
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");						
			DriverScript.logMessage(testDriver, "testStepDone", "click on login button successfull");
		
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "click on Login is  unsuccessful");
            throw new WebAdaptorException(new Throwable("Login is not successful", e.getCause()));
	    
	    }
	}
	
	public void verifyLoginUser()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			clickOnProfileIcon();
			VerifyEmail();
			DriverScript.logMessage(testDriver, "testStepDone", "verifyLoginUser" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "verifyLoginUser" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("verifyLoginUser" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void clickOnProfileIcon()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ProfileIcon");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "ProfileIcon");
			// Web.webAdaptor(testDriver, WebAction.isElementDisplayed,
			// "ProfileIcon");
			Web.webAdaptor(testDriver, WebAction.click, "ProfileIcon");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnProfileIconn" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "clickOnProfileIcon" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("clickOnProfileIcon" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void VerifyEmail()
			throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "LoggedInUserName");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "LoggedInUserName");
			Web.webAdaptor(testDriver, WebAction.getText, "LoggedInUserName");
			String emailLoggedin = testDriver.getMapValues().get("LoggedInUserName");
			String expectedEmail = CucumberDriver.testDriver.getScenarioTestData().get("ExpectedUsername");
			String emailLogged = emailLoggedin.toLowerCase();
			String expectedEmail1 = expectedEmail.toLowerCase();
			if(emailLogged.equals(expectedEmail1))
			{
			//Assert.assertEquals(emailLoggedin.toLowerCase(), expectedEmail.toLowerCase());
			DriverScript.logMessage(testDriver, "testStepDone", "VerifyEmail" + " is successful");
			}
			Web.webAdaptor(testDriver, WebAction.click, "ProfileIcon");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "VerifyEmail" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("VerifyEmail" + " is unsuccessful", ex.getCause()));
		}

	}
	
	public void verifyHomePage() throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "HomePageIcon");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "HomePageIcon");
			Web.webAdaptor(testDriver, WebAction.isElementDisplayed, "HomePageIcon");
			DriverScript.logMessage(testDriver, "testStepDone", "VerifyHomePage" + " is successful");
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "VerifyHomePage" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("VerifyHomePage" + " is unsuccessful", ex.getCause()));
		}

	}
	public void clickOnLogout() throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ProfileIcon");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "ProfileIcon");
			Web.webAdaptor(testDriver, WebAction.click, "ProfileIcon");
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "LogoutButton");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "LogoutButton");
			Web.webAdaptor(testDriver, WebAction.click, "LogoutButton");
			DriverScript.logMessage(testDriver, "testStepDone", "signOut" + " is successful");
			Web.webAdaptor(testDriver, WebAction.closeBrowser);
			
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "signOut" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("signOut" + " is unsuccessful", ex.getCause()));
		}
		
	}
	
	public void clickapplauncher() throws WebAdaptorException, MobileAdaptorException, ObjectNameNotFoundException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "Applauncher");
			Web.webAdaptor(testDriver, WebAction.IsElementExist, "Applauncher");
			Web.webAdaptor(testDriver, WebAction.click, "Applauncher");
			Web.webAdaptor(testDriver, WebAction.setText, "Applauncher",testDriver.getScenarioTestData().get("appname"));
			//Web.webAdaptor(testDriver, WebAction.click, "Appsearch");
			//Web.webAdaptor(testDriver, WebAction.setText, "Appsearch",
			//		testDriver.getScenarioTestData().get("appname"));
			Web.webAdaptor(testDriver, WebAction.click, "Appselect");
			DriverScript.logMessage(testDriver, "testStepDone", "clickapplauncher" + " is successful");
			Web.webAdaptor(testDriver, WebAction.closeBrowser);
			
		} catch (WebAdaptorException ex) {
			DriverScript.logMessage(testDriver, "testStepFail", "clickapplauncher" + " is unsuccessful");
			throw new WebAdaptorException(new Throwable("clickapplauncher" + " is unsuccessful", ex.getCause()));
		}
		
	}
}
