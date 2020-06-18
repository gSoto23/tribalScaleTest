package scripts;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public WebDriver driver;
    private String siteUrl = "https://qainterview.pythonanywhere.com/";

    public void initializeDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.5");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability("newCommandTimeout", 2000);
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new IOSDriver(url, capabilities);
        driver.get(siteUrl);
    }
}
