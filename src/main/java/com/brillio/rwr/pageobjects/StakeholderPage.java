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


public class StakeholderPage {
	
TestDriver testDriver;
	
	public StakeholderPage() throws DriverScriptException {
		testDriver =CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}
	
	public void clickOnAddApproversButton() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "AddApproversBtn");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"AddApproversBtn");
			DriverScript.logMessage(testDriver, "testStepDone", "click On Add Approvers Button  successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "click On AddApprovers Button is not successful");
            throw new WebAdaptorException(new Throwable("click On Add Approvers Button is not successful", e.getCause()));
	    
	    }
	}
	
	public void SelectApprover() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SelectApproverDropdown");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "SelectApproverDropdown");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.doubleClick, "SelectApproverRole");
			Web.webAdaptor(testDriver, WebAction.click, "SelectApproverRole");
//			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.doubleClick, "SelectApproverRole");
		
			
			DriverScript.logMessage(testDriver, "testStepDone", "Select Approver successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Select Approver unsuccessful");
			throw new WebAdaptorException(new Throwable("Select Approver unsuccessful", e.getCause())); 
		}
	}
	public void SelectApproverLevel() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SelectApproverLevel");
			//Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "SelectApproverLevelDropdown");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.doubleClick, "SelectApproverLevel");
			Web.webAdaptor(testDriver, WebAction.click, "SelectApproverLevel");
//			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.doubleClick, "SelectApproverLevel");
		
			
			DriverScript.logMessage(testDriver, "testStepDone", "Select Approver Level successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Select Approver Level unsuccessful");
			throw new WebAdaptorException(new Throwable("Select Approver Level unsuccessful", e.getCause())); 
		}
	}
	public void searchEmployeeAndSelect(String emp) throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SearchEmployee");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "SearchEmployee");
			
			//Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"EnterTitle");
			Web.webAdaptor(testDriver, WebAction.setText,"SearchEmployee",emp);
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ClickOnCheckboxToSelectEmp");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ClickOnCheckboxToSelectEmp");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "searchEmployeeAndSelect successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "searchEmployeeAndSelect is not successful");
            throw new WebAdaptorException(new Throwable("searchEmployeeAndSelect is not successful", e.getCause()));
	    
	    }
	}
	public void clickOnDoneButton() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "DoneBtn");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"DoneBtn");
		
			
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnDoneButton  successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "clickOnDoneButton not successful");
            throw new WebAdaptorException(new Throwable("clickOnDoneButton is not successful", e.getCause()));
	    
	    }
	}
	public void clickOnExpertLink() throws InterruptedException, AWTException, WebAdaptorException, ObjectNameNotFoundException   {
		try {			
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ExpertLink");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript,"ExpertLink");
		
			
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnExpertLink  successfully");
	    } 
	    catch (WebAdaptorException e) {
	    	DriverScript.logMessage(testDriver, "testStepFail", "clickOnExpertLink not successful");
            throw new WebAdaptorException(new Throwable("clickOnExpertLink is not successful", e.getCause()));
	    
	    }
	}



}
