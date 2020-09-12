package com.brillio.rwr.stepdefs;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automation.framework.core.BaseTest;
import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.pojs.TestDriver;
import com.automation.framework.utilities.XLUtil;
import com.brillio.rwr.utilities.CucumberDriver;
import com.itextpdf.text.log.SysoCounter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	 private ScreenRecorder screenRecorder;
	 public static WebDriver driver ;
	 
	@Before
	public void beforeScenario(Scenario scenario) throws Exception {
		String rawFeatureName = scenario.getId().replaceAll("-", " ").split(";")[0];
		System.out.println("Feature Name:"+rawFeatureName);
		System.out.println("Scenario Name:"+scenario.getName());
		
			System.out.println("Recording started");
			//this.startRecording();
		
		
		TestDriver testDriver = new TestDriver();
		testDriver.setCucumber(true);		
		new BaseTest(scenario.getName(), testDriver, null);
		BaseTest.loadTestData(rawFeatureName,scenario.getName(),testDriver);
		CucumberDriver.driver = testDriver.getWebDriver();
		CucumberDriver.testDriver = testDriver;
		}
		

	

	@After
	public void tearDown(Scenario scenario) throws Exception {

		if (scenario.isFailed()) {
			byte[] screenshotBytes = ((TakesScreenshot) CucumberDriver.driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotBytes, "image/png");
			
			

		} else {

		}
//		CucumberDriver.driver.quit();
		System.out.println("Recording is completed");
		//this.stopRecording();

	}
	
	public void startRecording() throws Exception
    {
         GraphicsConfiguration gc = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .getDefaultConfiguration();

        this.screenRecorder = new ScreenRecorder(gc,
            new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                 CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                 DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                 QualityKey, 1.0f,
                 KeyFrameIntervalKey, 15 * 60),
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                 FrameRateKey, Rational.valueOf(30)),
            null);
       this.screenRecorder.start();
      
    }

    public void stopRecording() throws Exception
    {
      this.screenRecorder.stop();
      Hook.driver.close();
    }
}
