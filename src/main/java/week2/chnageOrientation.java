 	 		package week2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.battery.BatteryInfo;

public class chnageOrientation {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("noReset", true);
		AndroidDriver<WebElement>  driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//orientation
	//	driver.rotate(ScreenOrientation.LANDSCAPE);
		
		//Using Key Events to type 
		
		//	KeyEvent key = new KeyEvent(AndroidKey.A);
		//	driver.pressKey(key);
			
		// to hide the keyboard
		//	driver.hideKeyboard();
			
		//to get information on battery - 1 way 
			AndroidBatteryInfo batteryInfo = driver.getBatteryInfo();
			
			batteryInfo.getLevel();
			
			batteryInfo.getState();
			
		// to get battery info using ADB commands 
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("command", "dumpsys");
			map.put("args", "battery");
			
		//	Object executeScript = driver.executeScript("mobile : shell", map);
		//	System.out.println(executeScript);
		//to enable WIFI
			
			ConnectionStateBuilder csb = new ConnectionStateBuilder();
			ConnectionState state = csb.withWiFiDisabled().build();
			
			driver.setConnection(state);
	}

}
