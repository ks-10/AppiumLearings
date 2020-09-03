package week2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class longPressAction {
	
	static AndroidDriver<WebElement>  driver;
	public static void main(String[] args) throws MalformedURLException {
		//launchMessenger();
		launchMessenger();

	}
	
	
	public static void  launchMessenger() {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appPackage", "com.google.android.apps.messaging");
			dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
			dc.setCapability("deviceName", "emulator-5554");
			dc.setCapability("platform", "Android");
			//Do not Stop the App, Do not erase the data , Do not unistall apk 
			dc.setCapability("noReset", true);
			TouchAction<?> action = new TouchAction<>(driver);
			
			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId("Search messages").click();
			driver.findElementById("com.google.android.apps.messaging:id/conversation_name").click();
		
			action.longPress(LongPressOptions.longPressOptions()
					.withElement(ElementOption.element(driver.findElementById("com.google.android.apps.messaging:id/message_text"))).withDuration(Duration.ofSeconds(3))).release().perform();
			driver.findElementByAccessibilityId("Delete").click();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
