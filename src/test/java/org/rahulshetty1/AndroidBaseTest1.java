package org.rahulshetty1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.rahulshettyacademy.pageObjects.android1.FormPage1;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest1 {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage1 formpage;
	@BeforeMethod
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException, Exception
	{
	 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Administrator\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
			service.start();
				UiAutomator2Options options = new UiAutomator2Options();
			//options.setDeviceName("RahulPhone"); //emulator
				Thread.sleep(2000);		
				options.setDeviceName("test");// real device
			options.setApp("C:\\Users\\Administrator\\eclipse-workspace\\rahulshetty1\\src\\test\\java\\org\\rahulshetty\\resources\\General-Store.apk");
			 driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options); // Create a new instance of AndroidDriver
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 formpage=new FormPage1(driver);}	}
	
	
	

	
