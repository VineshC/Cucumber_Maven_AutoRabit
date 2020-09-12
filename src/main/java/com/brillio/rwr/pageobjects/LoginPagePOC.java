package com.brillio.rwr.pageobjects;

import com.automation.framework.actionInterpreter.Web;
import com.automation.framework.actionInterpreter.Web.WebAction;
import com.automation.framework.core.DriverScript;
import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.automation.framework.pojs.TestDriver;
import com.automation.framework.utilities.ObjectRead;
import com.brillio.rwr.utilities.CucumberDriver;

import groovyjarjarantlr.collections.List;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
public class LoginPagePOC {

	WebDriver driver;
	TestDriver testDriver;
	Robot rb;
	
	public LoginPagePOC() throws DriverScriptException {
		testDriver = CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}

	
	public void loadURL() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		//Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
		DriverScript.logMessage(testDriver, "testStepDone", "login successfully");
	}
	
	public void enterCredentials(String UN, String PSWD) throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "Username");
			Web.webAdaptor(testDriver, WebAction.setTextUsingJavaScript,"Username",UN);
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "Password");
			Web.webAdaptor(testDriver, WebAction.setTextUsingJavaScript,"Password",PSWD);
									
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
	
	public void verifyClassicMode() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			Web.webAdaptor(testDriver, WebAction.isElementDisplayed, "Lighting");
//			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"User");	
//			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "");
//			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"");	
									
			DriverScript.logMessage(testDriver, "testStepDone", "User is in Lighting mode");
		
	    } 
		catch(WebAdaptorException e) {
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "User");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "User");
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "Classic");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"Classic");
			//Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "User");
			DriverScript.logMessage(testDriver, "testStepDone", "change to classic mode successful");
		}
	}
	
	public void verifyLightingMode() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {	
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "User");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "User");
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "Classic");
			Web.webAdaptor(testDriver, WebAction.isElementDisplayed, "Classic");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "User");
//			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"User");	
//			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "");
//			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"");	
									
			DriverScript.logMessage(testDriver, "testStepDone", "User is in Lighting mode");
		
	    } 
		catch(WebAdaptorException e) {
			Web.webAdaptor(testDriver, WebAction.isElementDisplayed, "Lighting");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"Lighting");
		DriverScript.logMessage(testDriver, "testStepDone", "change to Lighting mode successful");
		}
	}
	public void clickOnLogout() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "User");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"User");
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "Logout");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"Logout");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnLogout  successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "clickOnLogout not successful");
            throw new WebAdaptorException(new Throwable("clickOnLogout is not successful", e.getCause()));
	    
	    }
	}

}
