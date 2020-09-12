package com.brillio.rwr.pageobjects;

import java.awt.AWTException;

import com.automation.framework.actionInterpreter.Web;
import com.automation.framework.actionInterpreter.Web.WebAction;
import com.automation.framework.core.DriverScript;
import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.automation.framework.pojs.TestDriver;
import com.automation.framework.utilities.ObjectRead;
import com.brillio.rwr.utilities.CucumberDriver;


public class InteractionSetupPage {
	
TestDriver testDriver;
	
	public InteractionSetupPage() throws DriverScriptException {
		testDriver =CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}

	public void enterTitle(String title) throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "EnterTitle");
//			Web.webAdaptor(testDriver, WebAction.IsElementExist, "EnterTitle");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "EnterTitle");
			
			//Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"EnterTitle");
			Web.webAdaptor(testDriver, WebAction.setText,"EnterTitle",title);
			
			DriverScript.logMessage(testDriver, "testStepDone", "title entered  successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "title entered is not successful");
            throw new WebAdaptorException(new Throwable("title entered is not successful", e.getCause()));
	    
	    }
	}
	
	public void addDescriptionServices() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			String testdescription = "test Description"; 	
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "AddDescriptionBtn");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"AddDescriptionBtn");
//			Web.webAdaptor(testDriver, WebAction.IsElementExist, "AddDescriptionText");
//			Web.webAdaptor(testDriver, WebAction.switchBetweenWindows, "AddDescriptionWindow");
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "AddDescriptionText");
//			Web.webAdaptor(testDriver, WebAction.doubleClick,"AddDescriptionText");
			Web.webAdaptor(testDriver, WebAction.click,"AddDescriptionText");
			Web.webAdaptor(testDriver, WebAction.setText,"AddDescriptionText",testdescription);
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SaveBtn");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"SaveBtn");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			
			DriverScript.logMessage(testDriver, "testStepDone", "title entered  successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "title entered is not successful");
            throw new WebAdaptorException(new Throwable("title entered is not successful", e.getCause()));
	    
	    }
	}
	public void enterStartDateAndTime(String stdate) throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "EnterStartDate");
			//Web.webAdaptor(testDriver, WebAction.scrollAndClick, "EnterStartDate");
			
			//Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"EnterTitle");
			Web.webAdaptor(testDriver, WebAction.setText,"EnterStartDate",stdate);
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "EnterStartTime");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "EnterStartTime");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.doubleClick, "EnterStartTime");
			Web.webAdaptor(testDriver, WebAction.click, "EnterStartTime");
			DriverScript.logMessage(testDriver, "testStepDone", "enter Start Date And Time successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "enter Start Date And Time is not successful");
            throw new WebAdaptorException(new Throwable("enter Start Date And Time is not successful", e.getCause()));
	    
	    }
	}
	public void enterEndDateAndTime(String enddate) throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "EnterEndDate");
			//Web.webAdaptor(testDriver, WebAction.scrollAndClick, "EnterEndDate");
			
			//Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"EnterTitle");
			Web.webAdaptor(testDriver, WebAction.setText,"EnterEndDate",enddate);
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "EnterEndTime");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "EnterEndTime");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.doubleClick, "EnterEndTime");
			Web.webAdaptor(testDriver, WebAction.click, "EnterEndTime");
			DriverScript.logMessage(testDriver, "testStepDone", "enterEndDateAndTime successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "enterEndDateAndTime is not successful");
            throw new WebAdaptorException(new Throwable("enterEndDateAndTime is not successful", e.getCause()));
	    
	    }
	}
	public void clickOnShareholderlink() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ClickOnShareholder");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"ClickOnShareholder");
		
			
			DriverScript.logMessage(testDriver, "testStepDone", "click On Shareholder  successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "click On Shareholder not successful");
            throw new WebAdaptorException(new Throwable("click On Shareholder is not successful", e.getCause()));
	    
	    }
	}
	
}
