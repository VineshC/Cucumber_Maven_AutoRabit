package com.brillio.rwr.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;

import com.automation.framework.actionInterpreter.Web;
import com.automation.framework.actionInterpreter.Web.WebAction;
import com.automation.framework.core.DriverScript;
import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.automation.framework.pojs.TestDriver;
import com.automation.framework.utilities.ObjectRead;
import com.brillio.rwr.utilities.CucumberDriver;
import com.sun.glass.events.KeyEvent;

public class InteractionTypeEditPage {
	
	TestDriver testDriver;
	Robot rb;
	 
	public InteractionTypeEditPage() throws DriverScriptException {
		testDriver= CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}

	public void scrollToRuleCode(String code) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.setXpathAndScrollAndClick, "SelectRuleCode",code);
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "Scroll to rulecode successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Scroll to rulecode unsuccessful");
			throw new WebAdaptorException(new Throwable("scroll to rulecode unsuccessful", e.getCause())); 
		}

	}
	
	public void selectRole(String role) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.doubleClick, "ClickNoneBR116");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.selectValueFromDropdown, "SelectVal", role);

			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "Role selected successfully");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "select role unsuccessful");
			throw new WebAdaptorException(new Throwable("select role unsuccessful", e.getCause())); 
		}
	}
	
	public void selectRoles(String[] names) throws ObjectNameNotFoundException, WebAdaptorException, AWTException {
		try {
			rb=new Robot();
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SelectVal");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "SelectVal");
			
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "SelectVal");
			for(int i=0;i<names.length;i++) {
				String role=names[i];
				Web.webAdaptor(testDriver, WebAction.setXpathAndScrollAndClick, "SelectOpt",role);
				Web.webAdaptor(testDriver, WebAction.setValueToXpathAndDoubleClick, "SelectOpt",role);
				rb.keyPress(KeyEvent.VK_CONTROL);
			}
			rb.keyRelease(KeyEvent.VK_CONTROL);
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "Select multiple role successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Select multiple role unsuccessful");
			throw new WebAdaptorException(new Throwable("Select multiple role unsuccessful", e.getCause())); 
		}
	}
	
	public void selectMultipleRoles(String role1, String role2) throws ObjectNameNotFoundException, WebAdaptorException, AWTException {
		try {
			
			Web.webAdaptor(testDriver, WebAction.doubleClick, "ClickNone");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			
			Web.webAdaptor(testDriver, WebAction.selectValueFromDropdown, "SelectVal", role1);
			Web.webAdaptor(testDriver, WebAction.selectValueFromDropdown, "SelectVal", role2);	
	
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
//			rb=new Robot();
//			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SelectVal");
//			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "SelectVal");
//			Web.webAdaptor(testDriver, WebAction.scrollAndClick, "SelectOpt1");
//			Web.webAdaptor(testDriver, WebAction.doubleClick, "SelectOpt1");				
//			rb.keyPress(KeyEvent.VK_CONTROL);
//			rb.keyPress(KeyEvent.VK_DOWN);
//			Web.webAdaptor(testDriver, WebAction.scrollAndClick, "SelectOpt2");
//			Web.webAdaptor(testDriver, WebAction.doubleClick, "SelectOpt2");

//			rb.keyRelease(KeyEvent.VK_DOWN);
//			rb.keyRelease(KeyEvent.VK_CONTROL);
//			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "Role selected successfully");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "select role unsuccessful");
			throw new WebAdaptorException(new Throwable("select role unsuccessful", e.getCause())); 
		}
	}
	
	public void clickOnSave() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.scrollAndClick, "Save" );
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "Save" );
//			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "click on save button successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "click on save button unsuccessful");
			throw new WebAdaptorException(new Throwable("click on save button unsuccessful", e.getCause())); 
		}
	}
	
}
