package Lesson14;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

public class XpathLearning {
    public static void main(String args[]){
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            MobileElement navigationLogin = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navigationLogin.click();
            Thread.sleep(5000);
            //find element all matching
            MobileElement userText = appiumDriver.findElement(MobileBy.xpath("//android.widget.EditText"));
            userText.sendKeys("teo@sth.com");

//            MobileElement passwordText = appiumDriver.findElement(MobileBy.xpath("//android.widget.EditText"));
//            passwordText.sendKeys("12345678");
//
//            MobileElement loginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
//            loginBtn.click();

            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(appiumDriver!=null)
            appiumDriver.quit();
    }
}
