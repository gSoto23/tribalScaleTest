package pages;

import org.openqa.selenium.WebElement;

public class BasePage {
    /**
     * This method get and clear an input field to send data.
     * @param element
     * @param text
     */
    public void fillInput( WebElement element, String text ) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }
}
