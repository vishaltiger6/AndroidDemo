package com.GeneralStore.General_Store;

import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormFillup;
import pageObjects.Products;
import utilities.Utils;
import java.io.IOException;

public class Ecommerce_tc05 extends Base{

	@Test
	public void totalProducts() throws InterruptedException, IOException {
		
		startServer();
		startEmulator();
		AndroidDriver<AndroidElement> driver = Capabilities();
		
		
		FormFillup form = new FormFillup(driver);
		Utils util = new Utils(driver);
		Products product = new Products(driver);
		
		form.nameField().sendKeys("Vishal Mishra");
		driver.hideKeyboard();
		form.female().click();
		form.male().click();
		form.country().click();
		util.scroll("Argentina");
		form.letsShop().click();
		
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Vishal");
		//driver.hideKeyboard();
		//driver.findElementByXPath("//*[@text='Female']").click();
		//driver.findElementByXPath("//*[@text='Male']").click();
		//driver.findElementById("android:id/text1").click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));").click();
		//driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		product.selectItem().get(0).click();
		product.selectItem().get(0).click();
		product.clickCart().click();
		
		/*driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(3000);
		
		String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText().substring(1);
		String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText().substring(1);
		double amount1Value = Double.parseDouble(amount1);
		double amount2Value = Double.parseDouble(amount2);
		double sum = amount1Value+amount2Value;
		String total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText().substring(1).trim();
		double totalValue = Double.parseDouble(total);
		System.out.println("Calculated value: "+sum);
		System.out.println("Actual value: "+totalValue);
		Assert.assertEquals(sum, totalValue);
		
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		WebElement tc = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
		
		TouchAction action = new TouchAction(driver);
		
		action.tap(tapOptions().withElement(element(checkbox))).perform();
		action.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		
		driver.findElementById("android:id/button1").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();*/
		
	}

}
