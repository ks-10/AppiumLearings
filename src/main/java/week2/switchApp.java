package week2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class switchApp {
	static AndroidDriver<WebElement> driver ;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("noReset", true);
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.startActivity(new Activity("com.google.android.apps.messaging","com.google.android.apps.messaging.ui.ConversationListActivity"));
		driver.startActivity(new Activity("com.the511plus.MultiTouchTester","com.the511plus.MultiTouchTester.MultiTouchTester"));
		
		//closes the backend Activity
	//	driver.startActivity(new Activity("com.the511plus.MultiTouchTester","com.the511plus.MultiTouchTester.MultiTouchTester").setStopApp(false));
		
		
		
	}

}
