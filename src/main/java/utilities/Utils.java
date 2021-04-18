package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utils {
	
	AndroidDriver<AndroidElement> driver;
	
	public Utils(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void scroll(String destination) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+destination+"\"));").click();
	}
}
