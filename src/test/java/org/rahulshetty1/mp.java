package org.rahulshetty1;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.rahulshettyacademy.pageObjects.android1.FormPage1;
import org.rahulshettyacademy.utils.AppiumUtils;
import org.testng.annotations.AfterClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class mp extends AppiumUtils{

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage1 formPage;
	 
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//rahulshettyacademy//resources//data.properties");
		//String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		service = startAppiumServer(ipAddress,Integer.parseInt(port));
			
								
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName(prop.getProperty("AndroidDeviceNames")); //emulator
			options.setApp(System.getProperty("user.dir")+"//src//test//java//org//rahulshetty//resources//General-Store.apk");
			
			 driver = new AndroidDriver(service.getUrl(), options);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 formPage= new FormPage1(driver);
			 
		     
	}
	
}


/*	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
        service.stop();
		}
	
}*/
