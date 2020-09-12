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


public class LightingAppBuilder {
	
TestDriver testDriver;
	
	public LightingAppBuilder() throws DriverScriptException {
		testDriver =CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}
	
	public void scrollToLightingPage(String code) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			//Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ScrollWizard",code);
			Web.webAdaptor(testDriver, WebAction.setXpathAndScrollAndClick, "ScrollWizard",code);
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "Scroll to SelectWizard successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Scroll to rulecode unsuccessful");
			throw new WebAdaptorException(new Throwable("scroll to SelectWizard unsuccessful", e.getCause())); 
		}

	}

	public void clickToSelectWizard(String code) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.setXpathAndwaitForObjectToLoad, "SelectWizard",code);
			Web.webAdaptor(testDriver, WebAction.setValueToXpathAndClick, "SelectWizard",code);
			//Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "click to SelectWizard successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Scroll to rulecode unsuccessful");
			throw new WebAdaptorException(new Throwable("click to SelectWizard unsuccessful", e.getCause())); 
		}

	}
	public void clickOnEditButton() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad,"ClickOnEdit" );
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ClickOnEdit");
			DriverScript.logMessage(testDriver, "testStepDone", "click on Edit Button successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Scroll to rulecode unsuccessful");
			throw new WebAdaptorException(new Throwable("click on Edit unsuccessful", e.getCause())); 
		}

	}
	public void componentQuickSearch(String qs) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ComponentQuickSearch",qs);
			Web.webAdaptor(testDriver, WebAction.setTextUsingJavaScript, "ComponentQuickSearch",qs);
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "componentQuickSearch is working successfully");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Navigate to setup wizard page is not successful");
			throw new WebAdaptorException(new Throwable("componentQuickSearch is not working  successfully", e.getCause())); 
		}
	}

	public void selectComponent() throws ObjectNameNotFoundException, WebAdaptorException {

		try {
		//	Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SelectFlexiEditor");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
		//	Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SelectFlexiEditor");
		//	Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "SelectFlexiEditor");
			//Web.webAdaptor(testDriver, WebAction.,"SwitchToMain");
			Web.webAdaptor(testDriver, WebAction.switchToFrameBasedOnWebElement, "SelectFlexiEditor");
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "SelectComponent");
			Web.webAdaptor(testDriver, WebAction.setXpathAndScrollAndClick, "SelectComponent");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "SelectComponent");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			//driver.switchTo().defaultContent();
			DriverScript.logMessage(testDriver, "testStepDone", "SelectComponent is working successfully");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Navigate to setup wizard page is not successful");
			throw new WebAdaptorException(new Throwable("SelectComponent is not working  successfully", e.getCause())); 
		}
	}

	public void clickToSelectComponent() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			
			//Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad,"SearchCustom" );
		//	Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "SearchCustom");
			Web.webAdaptor(testDriver, WebAction.switchBackFromFrameBasedWebElement,"" );
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad,"ClickToComponent" );
			Web.webAdaptor(testDriver, WebAction.setXpathAndScrollAndClick, "ClickToComponent");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ClickToComponent");
			DriverScript.logMessage(testDriver, "testStepDone", "click To Select Component successful");
			
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Scroll to rulecode unsuccessful");
			throw new WebAdaptorException(new Throwable("click To Select Component unsuccessful", e.getCause())); 
		}

	}
	
	public void enterStepName(String sn) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			Web.webAdaptor(testDriver, WebAction.switchBackFromFrameBasedWebElement,"" );
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "StepName",sn);
			Web.webAdaptor(testDriver, WebAction.click, "StepName",sn);
			Web.webAdaptor(testDriver, WebAction.setText, "StepName",sn);
//			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "entering Step Name is working successfully");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "entering Step Name is not successful");
			throw new WebAdaptorException(new Throwable("entering Step Name is not working  successfully", e.getCause())); 
		}
	}
	
	public void clickOnSaveButton() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad,"SaveButton" );
			Web.webAdaptor(testDriver, WebAction.click, "SaveButton");
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "click on Save Button successful");
			
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Save Button  works unsuccessful");
			throw new WebAdaptorException(new Throwable("click on Save Button  unsuccessful", e.getCause())); 
		}

	}
	
	public void clickOnBackButton() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad,"BackButton" );
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "BackButton");
			DriverScript.logMessage(testDriver, "testStepDone", "click on Back Button successful");
			
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Back Button  works unsuccessful");
			throw new WebAdaptorException(new Throwable("click on Back Button  unsuccessful", e.getCause())); 
		}

	}
	
	public void clickOnAllTabsLink() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad,"AllTabs" );
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "AllTabs");
			DriverScript.logMessage(testDriver, "testStepDone", "click on All Tabs link successful");
			
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "All Tabs link  works unsuccessful");
			throw new WebAdaptorException(new Throwable("click on All tabs link  unsuccessful", e.getCause())); 
		}

	}
	
	public void clickOnUserFlowManagement(String scode) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			
//			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "UserFlowManagement");
//			Web.webAdaptor(testDriver, WebAction.scrollAndClick, "UserFlowManagement");
//			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "UserFlowManagement");
			Web.webAdaptor(testDriver, WebAction.setXpathAndwaitForObjectToLoad, "UserFlowManagement",scode);
			Web.webAdaptor(testDriver, WebAction.setXpathAndScrollAndClick, "UserFlowManagement",scode);
			Web.webAdaptor(testDriver, WebAction.setValueToXpathAndClickUsingJavscript, "UserFlowManagement",scode);
		//	Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "UserFlowManagement");
//			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "click On User Flow Management successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnUserFlowManagement unsuccessful");
			throw new WebAdaptorException(new Throwable("clickOnUserFlowManagement unsuccessful", e.getCause())); 
		}

	}
}
