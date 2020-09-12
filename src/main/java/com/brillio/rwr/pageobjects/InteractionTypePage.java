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

public class InteractionTypePage {
	
	TestDriver testDriver;
	
	public InteractionTypePage() throws DriverScriptException {
		testDriver =CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}
	
	public void clickInteractionType() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "InteractionTypeTab");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "InteractionTypeTab");
			DriverScript.logMessage(testDriver, "testStepDone", "Navigate to Interaction Type page is successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Navigate to Interaction Type page is not successful");
			throw new WebAdaptorException(new Throwable("Navigate to Interaction Type page is not successful", e.getCause())); 
		}
	}

	public void clickOnTypeName(String name) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.setValueToXpathAndClickUsingJavscript, "TypeName", name);
//		0	Web.webAdaptor(testDriver, WebAction.wai, "TypeName");
			DriverScript.logMessage(testDriver, "testStepDone", "click on Interaction type name is successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "click on Interaction type name is unsuccessful");
			throw new WebAdaptorException(new Throwable("click on Interaction type name is unsuccessful", e.getCause())); 
		}
	}
	
	public void clickOnEdit() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "EditButton");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "EditButton");
			DriverScript.logMessage(testDriver, "testStepDone", "click on edit button successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "click on edit button unsuccessful");
			throw new WebAdaptorException(new Throwable("click on edit button unsuccessful", e.getCause())); 
		}
	}
}
