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


public class InitiateInteractionPage {
	
TestDriver testDriver;
	
	public InitiateInteractionPage() throws DriverScriptException {
		testDriver =CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}
	
	public void SelectInteractionCategory() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "InteractionCategory");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "InteractionCategory");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.doubleClick, "InteractionCategory");
			Web.webAdaptor(testDriver, WebAction.click, "SelectInteractionCategory");
//			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.doubleClick, "SelectInteractionCategory");
		
			
			DriverScript.logMessage(testDriver, "testStepDone", "Select Interaction Category successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "SelectInteractionCategory unsuccessful");
			throw new WebAdaptorException(new Throwable("Select Interaction Category unsuccessful", e.getCause())); 
		}

	}
	public void SelectInteractionType() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "InteractionType");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "InteractionType");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.doubleClick, "InteractionType");
			Web.webAdaptor(testDriver, WebAction.click, "SelectInteractionType");
			
			Web.webAdaptor(testDriver, WebAction.doubleClick, "SelectInteractionType");
			
			DriverScript.logMessage(testDriver, "testStepDone", "Select InteractionTypesuccessful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Select Interaction Type unsuccessful");
			throw new WebAdaptorException(new Throwable("Select Interaction Type unsuccessful", e.getCause())); 
		}

	}

	public void clickOnNextButton() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ClickOnNextBtn");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ClickOnNextBtn");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ClickOnNextBtn");
			
			DriverScript.logMessage(testDriver, "testStepDone", "Select Interaction Category successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "SelectInteractionCategory unsuccessful");
			throw new WebAdaptorException(new Throwable("Select Interaction Category unsuccessful", e.getCause())); 
		}

	}
}
