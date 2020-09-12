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

import groovyjarjarantlr.collections.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

public class SetupPage {
	WebDriver driver;
	TestDriver testDriver;
	
	public SetupPage() throws DriverScriptException {
		testDriver =CucumberDriver.testDriver;
		new ObjectRead(CucumberDriver.testDriver, this.getClass().getSimpleName());
	}

	
	public void quickSearch(String qs) throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "QuickSearch");
			Web.webAdaptor(testDriver, WebAction.setTextUsingJavaScript, "QuickSearch",qs);
			Web.webAdaptor(testDriver, WebAction.wait, "wait.low");
			DriverScript.logMessage(testDriver, "testStepDone", "quickSearch is working successfully");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Navigate to Interaction Type page is not successful");
			throw new WebAdaptorException(new Throwable("quickSearch is not working  successfully", e.getCause())); 
		}
	}
	
	public void clickOnLightingAppBuilder() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "LightingAppBuilder");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "LightingAppBuilder");
			DriverScript.logMessage(testDriver, "testStepDone", "click on LightingAppBuilder is successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Navigate to Interaction Type page is not successful");
			throw new WebAdaptorException(new Throwable("click on LightingAppBuilder is not successful", e.getCause())); 
		}
	}
	public void clickOnCustomMetaData() throws ObjectNameNotFoundException, WebAdaptorException {
		try {
			Web.webAdaptor(testDriver, WebAction.waitForObjectToLoad, "CustomMetaData");
			Web.webAdaptor(testDriver, WebAction.clickUsingJavascript, "CustomMetaData");
			DriverScript.logMessage(testDriver, "testStepDone", "clickOnCustomMetaData  is successful");
		}		
		catch(WebAdaptorException e){
			DriverScript.logMessage(testDriver, "testStepDone", "Navigate to Interaction Type page is not successful");
			throw new WebAdaptorException(new Throwable("clickOnCustomMetaData  is not successful", e.getCause())); 
		}
	}
	
	
	
}