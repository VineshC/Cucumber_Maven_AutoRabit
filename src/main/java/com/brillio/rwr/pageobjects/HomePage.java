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
import com.brillio.rwr.pageobjects.ExpertPage;

public class HomePage {
	
TestDriver testDriver;
ExpertPage expertpage;

	public HomePage() throws DriverScriptException {
		testDriver =CucumberDriver.testDriver;
		expertpage = new ExpertPage();
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}
	
	public void clickOnSetup() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SetupLink");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "SetupLink");
			DriverScript.logMessage(testDriver, "testStepDone", "click on Setup link successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "click on edit button unsuccessful");
			throw new WebAdaptorException(new Throwable("click on setup link unsuccessful", e.getCause())); 
		}
	}
	
	public void clickOnHomeTab() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ClickOnHomeTab");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ClickOnHomeTab");
			DriverScript.logMessage(testDriver, "testStepDone", "Click On Home Tab successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "ClickOnHomeTab unsuccessful");
			throw new WebAdaptorException(new Throwable("Click On Home Tab unsuccessful", e.getCause())); 
		}
	}
	
	public void clickOnInitiateProgramButton() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ClickOnInitiateprogramBtn");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ClickOnInitiateprogramBtn");
			DriverScript.logMessage(testDriver, "testStepDone", "click On Initiate Program Button successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnInitiateProgramButton unsuccessful");
			throw new WebAdaptorException(new Throwable("click On Initiate Program Button unsuccessful", e.getCause())); 
		}
	}
	public void searchForInteractionInSearchBox() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			System.out.println("Interaction number is " + ExpertPage.interactionnumber);
			String INT = ExpertPage.interactionnumber;
		
			

			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SearchBox");
//			Web.webAdaptor(testDriver, WebAction.doubleClick, "SearchBox");
			Web.webAdaptor(testDriver, WebAction.setText, "SearchBox",INT );
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SelectInteraction");
			Web.webAdaptor(testDriver, WebAction.click, "SelectInteraction");
			DriverScript.logMessage(testDriver, "testStepDone", "searchForInteractionInSearchBox successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "searchForInteractionInSearchBox unsuccessful");
			throw new WebAdaptorException(new Throwable("searchForInteractionInSearchBox unsuccessful", e.getCause())); 
		}
	}
	public void clickOnEditButton() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ClickOnEditbtn");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ClickOnEditbtn");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnEditButton successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnEditButton unsuccessful");
			throw new WebAdaptorException(new Throwable("clickOnEditButton unsuccessful", e.getCause())); 
		}
	}
}
