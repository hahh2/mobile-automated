package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import platform.Platform;
import java.net.URL;

public class DriverFactory implements MobileCapabilityTypeEx {
    public static AppiumDriver<MobileElement> getDriver(Platform platform){
        AppiumDriver<MobileElement> appiumDriver =  null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME,"android");
        desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(UDID,"R58M56XSDQH");
        desiredCapabilities.setCapability(APP_PACKAGE,"com.wdiodemoapp");
        desiredCapabilities.setCapability(APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
//        desiredCapabilities.setCapability("appPackages","com.setel.mobile.staging2");
//        desiredCapabilities.setCapability("appActivity","com.zapmobile.zap.splash.SplashActivity");
        URL appiumServer = null;
        try {
            appiumServer = new URL("http://localhost:4723/wd/hub");
        }catch (Exception e){
            e.printStackTrace();
        }
       if(appiumServer == null){
           throw new RuntimeException("Can't construct the appium server url http://localhost:4723/wd/hub");
       }
       switch (platform){
           case ANDROID:
               appiumDriver = new AndroidDriver<>(appiumServer, desiredCapabilities);
               break;
           case IOS:
               appiumDriver = new IOSDriver<>(appiumServer, desiredCapabilities);
               break;
       }
        return appiumDriver;
    }
}
