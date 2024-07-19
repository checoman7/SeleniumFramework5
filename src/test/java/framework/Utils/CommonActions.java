package framework.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActions {
    WebDriver driver;
     WebDriverWait wait;

    public CommonActions(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickElement(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void enterText(By locator, String message){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.clear();
        element.sendKeys(message);
    }

    // Get text from an element
    public String getText(By selector) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return element.getText();
    }

    // Check if an element is present
    public boolean isElementPresent(By selector) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Check if an element is visible
    public boolean isElementVisible(By selector) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for an element to be invisible
    public void waitForElementToBeInvisible(By selector) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    // Wait for an element to be present
    public void waitForElementToBePresent(By selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    // Wait for an element to be clickable
    public void waitForElementToBeClickable(By selector) {
        wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    // Select a dropdown option by visible text
    public void selectDropdownOption(By selector, String optionText) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        dropdown.click();
        By optionSelector = By.xpath(String.format("//option[text()='%s']", optionText));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionSelector));
        option.click();
    }

    // Scroll to an element
    public void scrollToElement(By selector) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Hover over an element
    public void hoverOverElement(By selector) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Wait for a specific text to be present in an element
    public void waitForTextToBePresentInElement(By selector, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector, text));
    }

}
