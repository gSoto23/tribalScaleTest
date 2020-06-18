package pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class FactorialCalculator extends BasePage {

    public final By inputField = By.id("number");
    public final By calculatedBtn = By.id("getFactorial");
    public final By result = By.id("resultDiv");
    public final By title = By.cssSelector("h1");
    private String testNumber = "6";
    private String expectedResult = "The factorial of 6 is: 720";
    private String testErr = " ";
    private String expectedErr = "Please enter an integer";
    private String expectedTitle = "The greatest factorial calculator!";

    /**
     * This method use '6' as input data to verify the factorial calculation.
     * @param driver
     * @throws InterruptedException
     */
    public void calculatorResult (IOSDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(inputField));
        fillInput( driver.findElement(inputField), testNumber );
        driver.findElement(calculatedBtn).click();
        wait.until(ExpectedConditions.attributeContains(result,"style","color: rgb(0, 0, 0);"));
        Assert.assertEquals(driver.findElement(result).getText(),expectedResult);
    }

    /**
     * This method checks the error message after click on submit button with no data in the input.
     * @param driver
     * @throws InterruptedException
     */
    public void errorMsg (IOSDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(inputField));
        fillInput( driver.findElement(inputField), testErr );
        driver.findElement(calculatedBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(result));
        Assert.assertEquals(driver.findElement(result).getText(), expectedErr);
    }

    /**
     * This Method checks the tittle of the page.
     * @param driver
     */
    public void checkTittle (IOSDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(title));
        Assert.assertEquals(driver.findElement(title).getText(), expectedTitle);
    }
}
