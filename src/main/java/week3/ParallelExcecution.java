package week3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ParallelExcecution {
	AndroidDriver<WebElement>  driver;
	
	@Test
	public void run() throws MalformedURLException {
		launchEmulatorLeafOrg();
		//launchPhoneMsg();
	}
	
	
	public void launchEmulatorLeafOrg() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("noReset", true);
		dc.setCapability("udid", "emulator-5554");

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("LeafOrg Opened Successfully");
	}
	
	public void  launchPhoneMsg() {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appPackage", "com.google.android.apps.messaging");
			dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
			dc.setCapability("deviceName", "Moto G5 S Plus");
			dc.setCapability("noReset", true);
			dc.setCapability("udid", "ZY3229PVC7");
			
			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId("Search messages").click();
			System.out.println("Search Button - Clicked Successfully");
			driver.findElementById("com.google.android.apps.messaging:id/zero_state_search_box_auto_complete").sendKeys("Srini");
			System.out.println("Value 'Srini' is Passed");
			//driver.fin
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
