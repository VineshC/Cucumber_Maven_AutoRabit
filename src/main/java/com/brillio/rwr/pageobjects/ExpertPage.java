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


public class ExpertPage {
	
	public static String interactionid ;
	public static String interactionnumber ;
TestDriver testDriver;
	
	public ExpertPage() throws DriverScriptException {
		testDriver =CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}
	
	public void verifyAddExpertButton() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "AddExpertBtn");
			Web.webAdaptor(testDriver, WebAction.IsElementExist,"AddExpertBtn");
			Web.webAdaptor(testDriver, WebAction.isElementDisplayed,"AddExpertBtn");
			
			DriverScript.logMessage(testDriver, "testStepDone", "verifyAddExpertButton  successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "verifyAddExpertButton not successful");
            throw new WebAdaptorException(new Throwable("verifyAddExpertButton is not successful", e.getCause()));
	    
	    }
	}

	public void storeInteractionNumber() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "StoreInteractionId");
			Web.webAdaptor(testDriver, WebAction.getText,"StoreInteractionId");
			interactionid =testDriver.getMapValues().get("StoreInteractionId");
		
			System.out.println("Interaction number is "+ interactionid);
			System.out.println("length is "+ interactionid.length());
			System.out.println("length is "+  interactionid.substring(18, 25));
			interactionnumber= interactionid.substring(18, 25);
			System.out.println("Interaction Number  "+ interactionnumber );
			DriverScript.logMessage(testDriver, "testStepDone", "storeInteractionNumber  successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "storeInteractionNumber not successful");
            throw new WebAdaptorException(new Throwable("storeInteractionNumber is not successful", e.getCause()));
	    
	    }
	}
	
}
