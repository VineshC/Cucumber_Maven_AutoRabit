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


public class UserFlowManagement {
	
TestDriver testDriver;
	
	public UserFlowManagement() throws DriverScriptException {
		testDriver =CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}
	
	public void clickOnPublishNewLightningPageButton() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "PublishNewLightningPage");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "PublishNewLightningPage");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnPublishNewLightningPageButton successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnPublishNewLightningPageButton unsuccessful");
			throw new WebAdaptorException(new Throwable("clickOnPublishNewLightningPageButton  unsuccessful", e.getCause())); 
		}

	}
	
	public void SelectLightingPageToPublish(String pagecode) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ClickOnDropDown");
			Web.webAdaptor(testDriver, WebAction.doubleClick, "ClickOnDropDown");
			//Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.click, "SelectLightingPage");
		//	Web.webAdaptor(testDriver, WebAction.setValueToXpathAndClick, "SelectLightingPage",pagecode);
			
			DriverScript.logMessage(testDriver, "testStepDone", "SelectLightingPageToPublish successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "SelectLightingPageToPublish unsuccessful");
			throw new WebAdaptorException(new Throwable("SelectLightingPageToPublish unsuccessful", e.getCause())); 
		}

	}
	
	public void ClickOnPublishButton() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ClickOnPublish");
			Web.webAdaptor(testDriver, WebAction.click, "ClickOnPublish");
			
		
			
			DriverScript.logMessage(testDriver, "testStepDone", "ClickOnPublishButton successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "ClickOnPublishButton unsuccessful");
			throw new WebAdaptorException(new Throwable("ClickOnPublishButton unsuccessful", e.getCause())); 
		}

	}
	
	public void VerifyPublishSuccess() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "PublishSuccess");	
			Web.webAdaptor(testDriver, WebAction.isElementDisplayed, "PublishSuccess");
			 String publish_messgae =testDriver.getMapValues().get("PublishSuccess");
			 System.out.println(":::"+ publish_messgae);
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			 Web.webAdaptor(testDriver, WebAction.navigateToPreviousPage, "");
			 }
				
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "VerifyPublishSuccess unsuccessful");
			throw new WebAdaptorException(new Throwable("VerifyPublishSuccess unsuccessful", e.getCause())); 
		}

	}
	
}
