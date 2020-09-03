package week1;

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

public class InstallApplication {
static AndroidDriver<WebElement> driver ;
	public static void main(String[] args) throws MalformedURLException {
		//installAndLaunchApp();
		LaunchApp();

	}
	
	public static void installAndLaunchApp() {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("deviceName", "emulator-5554");
			dc.setCapability("app", "C:\\Users\\karup\\Downloads\\leaforg.apk");
			dc.setCapability("platform", "Android");
			dc.setCapability("noReset", true);
			dc.setCapability("fastClear", false);
			

			AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println(driver.isAppInstalled("com.testleaf.leaforg"));
			driver.findElementByXPath("(//*[@class = 'android.widget.EditText'])[1]").sendKeys("rajkumar@testleaf.com");
			driver.findElementByXPath("(//*[@class = 'android.widget.EditText'])[2]").sendKeys("Leaf@123");
			//driver.findElementByXPath("//*[@text = \"LOGIN\"]").click();
			driver.findElementByClassName("android.widget.Button").click();
			driver.findElementByXPath("//*[@resource-id = 'tab-t0-2']").click(); 
			driver.findElementByXPath("//*[@text = 'My Profile']").click();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void LaunchApp() throws MalformedURLException {
	
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appPackage", "com.google.android.apps.messaging");
			dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
			dc.setCapability("deviceName", "emulator-5554");
			dc.setCapability("platform", "Android");
			dc.setCapability("noReset", true);
			dc.setCapability("fastClear", false);
			
		
			
			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			TouchAction<?> action = new TouchAction<>(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId("Search messages").click();
			driver.findElementById("com.google.android.apps.messaging:id/conversation_name").click();
		
			action.longPress(LongPressOptions.longPressOptions()
					.withElement(ElementOption.element(driver.findElementById("com.google.android.apps.messaging:id/message_text"))).withDuration(Duration.ofSeconds(3))).release().perform();
			driver.findElementByAccessibilityId("Delete").click();
			
		
	}
}
