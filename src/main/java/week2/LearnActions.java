package week2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LearnActions {
	static AndroidDriver<WebElement>  driver;

	@Test
	public void runMultiTouch()  {
		launchMultiTouch();
		//	scrollDown();
		//scrollUp();
		//SwipeLeftToRight();
		//multipleActions();
		//actionsUsingPointerInput();
		//actionsUsingPointerInputForMultiFinger();
		zoomActionUsingPointerInput();

	}

	public static void launchMultiTouch()  {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
			dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
			dc.setCapability("deviceName", "emulator-5554");
			dc.setCapability("noReset", true);
			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

	}

	public static void scrollDown() {

		//Get the Screen Size 
		Dimension size = driver.manage().window().getSize();

		//Scroll Down Scenario X,Y Coordinates 
		int startX = (int) ((size.getWidth())*0.5);
		int endX = (int) ((size.getWidth())*0.5);

		int startY = (int) ((size.getHeight())*0.2);
		int endY = (int) ((size.getHeight())*0.8);

		TouchAction<?> action = new TouchAction<>(driver);

		action.press(PointOption.point(startX, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
		.moveTo(PointOption.point(endX, endY))
		.release().perform();	

	}

	public static void scrollUp() {

		//Get the Screen Size 
		Dimension size = driver.manage().window().getSize();

		//Scroll Up Scenario X,Y Coordinates 
		int startX = (int) ((size.getWidth())*0.5);
		int endX = (int) ((size.getWidth())*0.5);

		int startY = (int) ((size.getHeight())*0.8);
		int endY = (int) ((size.getHeight())*0.2);

		TouchAction<?> action = new TouchAction<>(driver);

		action.press(PointOption.point(startX, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
		.moveTo(PointOption.point(endX, endY))
		.release().perform();	

	}

	public static void SwipeLeftToRight() {

		//Get the Screen Size 
		Dimension size = driver.manage().window().getSize();

		//Scroll Up Scenario X,Y Coordinates 
		int startX = (int) ((size.getWidth())*0.2);
		int endX = (int) ((size.getWidth())*0.8);

		int startY = (int) ((size.getHeight())*0.5);
		int endY = (int) ((size.getHeight())*0.5);

		TouchAction<?> action = new TouchAction<>(driver);

		action.press(PointOption.point(startX, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
		.moveTo(PointOption.point(endX, endY))
		.release().perform();	

	}

	public static void multipleActions() {

		//Get the Screen Size 
		Dimension size = driver.manage().window().getSize();

		//Scroll Up Scenario X,Y Coordinates 
		int startX = (int) ((size.getWidth())*0.2);
		int endX = (int) ((size.getWidth())*0.8);

		int startY = (int) ((size.getHeight())*0.5);
		int endY = (int) ((size.getHeight())*0.5);

		TouchAction<?> action = new TouchAction<>(driver);

		action.press(PointOption.point(startX, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
		.moveTo(PointOption.point(endX, endY))
		.release();
		//.perform();	

		TouchAction<?> action1 = new TouchAction<>(driver);

		action1.press(PointOption.point(startX, startY +400 ))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
		.moveTo(PointOption.point(endX, endY+400))
		.release();
		//.perform();	

		//<------	MultiActions is a know Bug for multiple fingers so we use PointerInput ------>


	}

	public static void actionsUsingPointerInput() {

		//Get the Screen Size 
		Dimension size = driver.manage().window().getSize();

		//Scroll Up Scenario X,Y Coordinates 
		int startX = (int) ((size.getWidth())*0.2);
		int endX = (int) ((size.getWidth())*0.8);

		int startY = (int) ((size.getHeight())*0.5);
		int endY = (int) ((size.getHeight())*0.5);

		PointerInput finger =  new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence dragaNdrop = new Sequence(finger, 1);

		//createPointerDown --> Press Action 
		//createPointerUp --> Release Action

		//------bottom------
		//Action------------time to start --------------------------------,where to perform eg. in screen---positions of X coordinates
		dragaNdrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
		//position to start 
		dragaNdrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		//End Point ---- 
		dragaNdrop.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, startY));
		//position to start 
		dragaNdrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(dragaNdrop));

	}


	public static void actionsUsingPointerInputForMultiFinger() {

		//Get the Screen Size 
		Dimension size = driver.manage().window().getSize();

		//Scroll Up Scenario X,Y Coordinates 
		int startX = (int) ((size.getWidth())*0.2);
		int endX = (int) ((size.getWidth())*0.8);

		int startY = (int) ((size.getHeight())*0.5);
		int endY = (int) ((size.getHeight())*0.5);

		PointerInput finger =  new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence dragaNdrop = new Sequence(finger, 1);

		// Action 1 
		dragaNdrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));

		dragaNdrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		dragaNdrop.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));

		dragaNdrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


		// Action 2
		PointerInput finger2=  new PointerInput(PointerInput.Kind.TOUCH, "finger2");
		Sequence dragaNdrop2 = new Sequence(finger2, 2);

		dragaNdrop2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY +500));

		dragaNdrop2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		dragaNdrop2.addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY +500));

		dragaNdrop2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(dragaNdrop, dragaNdrop2));


	}

	public static void zoomActionUsingPointerInput() {

		//Get the Screen Size 
		Dimension size = driver.manage().window().getSize();

		//Scroll Up Scenario X,Y Coordinates 
		int startX = (int) ((size.getWidth())*0.5);
		int endX = (int) ((size.getWidth())*0);

		int startY = (int) ((size.getHeight())*0.5);
		int endY = (int) ((size.getHeight())*0.9);

		PointerInput finger =  new PointerInput(PointerInput.Kind.TOUCH, "touch1");
		Sequence dragaNdrop = new Sequence(finger, 1);

		// Action 1 
		dragaNdrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));

		dragaNdrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		dragaNdrop.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));

		dragaNdrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Action 2
		int startX1 = (int) ((size.getWidth())*0.5);
		int endX1= (int) ((size.getWidth())*0.9);

		int startY1 = (int) ((size.getHeight())*0.5);
		int endY1 = (int) ((size.getHeight())*0);

		PointerInput finger2=  new PointerInput(PointerInput.Kind.TOUCH, "touch2");
		Sequence dragaNdrop2 = new Sequence(finger2, 2);

		dragaNdrop2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX1, startY1 ));

		dragaNdrop2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		dragaNdrop2.addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX1, endY1 ));

		dragaNdrop2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(dragaNdrop,dragaNdrop2));


	}



}
