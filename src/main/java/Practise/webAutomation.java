package Practise;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.LaunchSuite;

import mobileWrapper.MobileWrapper;
import week2.LaunchBrowser;

public class webAutomation extends MobileWrapper {
	@Test
	public  void main() {
		openURL();
	}

	public  void openURL() {
		launchBrowser("chrome","emulator-5554","https://www.ehealthinsurance.com/");
		System.out.println("URL Loaded Successfully");
		Select sel = new Select(driver.findElementByXPath("//*[@id='from-banner-destination']"));
		sel.selectByValue("small-business-health-insurance");
	}
	
}
