package week1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class firstApp {

	static AndroidDriver<WebElement>  driver;

	public static void main(String[] args) throws MalformedURLException {
		//launchMessenger();
		launchWhatsApp();

	}

	public static void  launchMessenger() {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appPackage", "com.google.android.apps.messaging");
			dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
			dc.setCapability("deviceName", "Moto G5 S Plus");
			//Do not Stop the App, Do not erase the data , Do not unistall apk 
			dc.setCapability("noReset", true);

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

	public static void launchWhatsApp()  {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appPackage", "com.whatsapp");
			dc.setCapability("appActivity", "com.whatsapp.HomeActivity	");
			dc.setCapability("deviceName", "Moto G5 S Plus");

			//Do not Stop the App, Do not erase the data , Do not unistall apk 
			dc.setCapability("noReset", true);
			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId("Search").click();
			driver.findElementById("com.whatsapp:id/search_src_text").sendKeys("Appium May 2020");
			driver.findElementByXPath("(//*[@text='APPIUM MAY 2020'])[1]").click();
			driver.findElementById("com.whatsapp:id/entry").sendKeys("Via Program - Kp");
			// driver.findElementByAccessibilityId("Send").click();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
