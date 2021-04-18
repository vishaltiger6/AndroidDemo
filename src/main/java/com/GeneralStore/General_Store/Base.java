package com.GeneralStore.General_Store;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public void startServer() throws IOException {
		//Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\resources\\startEmulator.bat");
		Thread.sleep(5000);
	}
	
	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\testScreenshots"+ System.currentTimeMillis()+"\\"+s+".png"));
	
	}
	

	public static AndroidDriver<AndroidElement> Capabilities() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\GeneralStore\\General_Store\\projectConfig.properties");
		prop.load(fis);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("device_name")); // open emulator
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "\\resources\\General-Store.apk"); //open the app
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");	
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10"); //appium should wait for next command
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap); //connect to server

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}
}
