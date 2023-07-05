package Lesson14;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class LaunchAppTest {
    public static void main(String[] args){
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("udid","R58M56XSDQH");
        desiredCapabilities.setCapability("appPackages","com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");
//        desiredCapabilities.setCapability("appPackages","com.setel.mobile.staging2");
//        desiredCapabilities.setCapability("appActivity","com.zapmobile.zap.splash.SplashActivity");

        //init appium server
        try {
            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);

            //DEBUG PURPOSE ONLY
            Thread.sleep(5000);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        if(appiumDriver!=null)
            appiumDriver.quit();
    }
}
