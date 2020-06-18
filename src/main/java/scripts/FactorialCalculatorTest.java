package scripts;

import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.FactorialCalculator;

import java.io.IOException;

public class FactorialCalculatorTest extends BaseTest {

    FactorialCalculator factorialCalculator = new FactorialCalculator();

    @BeforeSuite (alwaysRun = true)
    public void globalSetup () throws IOException { initializeDriver(); }

    @Test (priority = 1)
    public void testTittle () throws InterruptedException {

        factorialCalculator.checkTittle((IOSDriver) driver);
    }

    @Test (priority = 2)
    public void testFactorialResult () throws InterruptedException {

        factorialCalculator.calculatorResult((IOSDriver) driver);
    }

    @Test (priority = 3)
    public void testErrMsg () throws InterruptedException {

        factorialCalculator.errorMsg((IOSDriver) driver);
    }

    @AfterSuite (alwaysRun = true)
    public void globalTearDown () {
        driver.quit();
    }
}
