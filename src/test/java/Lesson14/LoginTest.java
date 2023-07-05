package Lesson14;

import driver.DriverFactory;
import driver.MobileCapabilityTypeEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

public class LoginTest {
    public static void main(String args[]){
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            MobileElement navigationLogin = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navigationLogin.click();
            Thread.sleep(5000);

            MobileElement loginText = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            loginText.sendKeys("teo@sth.com");

            MobileElement passwordText = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            passwordText.sendKeys("12345678");

            MobileElement loginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            loginBtn.click();

            WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 5);
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            MobileElement successTxt = appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println("HELLO " + successTxt.getText());
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(appiumDriver!=null)
            appiumDriver.quit();
    }
}
