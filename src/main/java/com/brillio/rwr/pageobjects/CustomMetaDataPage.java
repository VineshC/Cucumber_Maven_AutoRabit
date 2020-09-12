package com.brillio.rwr.pageobjects;

import java.util.regex.Matcher;

import com.automation.framework.actionInterpreter.Web;
import com.automation.framework.actionInterpreter.Web.WebAction;
import com.automation.framework.core.DriverScript;
import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.exceptions.ObjectNameNotFoundException;
import com.automation.framework.exceptions.WebAdaptorException;
import com.automation.framework.pojs.TestDriver;
import com.automation.framework.utilities.ObjectRead;
import com.brillio.rwr.utilities.CucumberDriver;


public class CustomMetaDataPage {
	
TestDriver testDriver;
	
	public CustomMetaDataPage() throws DriverScriptException {
		testDriver =CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}
	
	public void manageScreenConfigButton() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "ManageScreenConfig");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "ManageScreenConfig");
			DriverScript.logMessage(testDriver, "testStepDone", "manageScreenConfigButton  is successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Navigate to Interaction Type page is not successful");
			throw new WebAdaptorException(new Throwable("manageScreenConfigButton  is not successful", e.getCause())); 
		}
	}
	public void changeFieldState() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "FieldState");
			 Web.webAdaptor(testDriver, WebAction.getTextUsingJavascript, "FieldState");
			 Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "FieldState");
			
			 String componentDetail =testDriver.getMapValues().get("FieldState");
			System.out.println(componentDetail);
			 String key = "classificationFieldState";
			 String changedComponentDetail = componentDetail.replaceAll("\\{\""+key+"\":\"([^\"]*)\"\\}", Matcher.quoteReplacement("{\""+key+"\":\"Write\"}"));
			 Web.webAdaptor(testDriver, WebAction.setTextUsingJavaScript,"FieldState",changedComponentDetail);
			
			 /*Pattern keyValuePattern = Pattern.compile("\\{\""+key+"\":\"([^\"]*)\"\\}");
			 Matcher keyValueMatcher = keyValuePattern.matcher(componentDetail);
			 keyValueMatcher.re
			 StringBuffer sb = new StringBuffer();
			 String replacementString;
			 while(keyValueMatcher.find()) {
				if( keyValueMatcher.group(1).contains("classificationFieldState")) {
					replacementString = keyValueMatcher.group().replace(keyValueMatcher.group(2), "Write");
					keyValueMatcher.appendReplacement(sb, Matcher.quoteReplacement(replacementString));
					break;
				}
			 }
			 keyValueMatcher.appendTail(sb);*/
			 }		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "changeFieldState is not successful");
			throw new WebAdaptorException(new Throwable("changeFieldState  is not successful", e.getCause())); 
		}
	}
	
	public void clickOnSave(String save) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.setXpathAndwaitForObjectToLoad, "ClickOnSave", save);
			Web.webAdaptor(testDriver, WebAction.setValueToXpathAndClick, "ClickOnSave",save);
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnSave  is successful");
		}
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnSave is not successful");
			throw new WebAdaptorException(new Throwable("clickOnSave  is not successful", e.getCause())); 
		}
	}
	
	
}
