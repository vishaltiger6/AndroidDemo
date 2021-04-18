package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormFillup {
	
	public FormFillup(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement name;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	private WebElement genderFemale;
	
	@AndroidFindBy(xpath="//*[@text='Male']")
	private WebElement genderMale;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement country;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShop;
	
	public WebElement nameField() {
		return name;
	}
	
	public WebElement male() {
		return genderMale;
	}
	
	public WebElement female() {
		return genderFemale;
	}
	
	public WebElement country() {
		return country;
	}
	
	public WebElement letsShop() {
		return letsShop;
	}

}
