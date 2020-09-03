package week3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class learnContext {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("app", "D:\\Appium\\leaforg.apk");
		dc.setCapability("platform", "Android");
		dc.setCapability("noReset", true);
		dc.setCapability("fastClear", false);
		

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.isAppInstalled("com.testleaf.leaforg"));
		driver.findElementByXPath("(//*[@class = 'android.widget.EditText'])[1]").sendKeys("rajkumar@testleaf.com");
		driver.findElementByXPath("(//*[@class = 'android.widget.EditText'])[2]").sendKeys("Leaf@123");
		//driver.findElementByXPath("//*[@text = \"LOGIN\"]").click();
		
		Set<String> contextHandles = driver.getContextHandles();
		for (String string : contextHandles) {
			System.out.println(string);
		}

	}

}
