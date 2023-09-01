package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected Logger log;

    public BasePage(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
    }

    // Open the given page
    protected void openURL(String url){
        log.info("Opening page: " + url);
        driver.get(url);
    }

    // Find element by locator
    protected WebElement find(By locator){
        //log.info("Finding element with locator [" + locator + "]");
        return driver.findElement(locator);
    }

    // Find all Web Elements with given locator
    protected List<WebElement> findAll(By locator){
        //log.info("Finding all elements with locator [" + locator + "]");
        return driver.findElements(locator);
    }

    // Click given element
    protected void click(By locator){
        //log.info("Clicking element with locator [" + locator + "]");
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    // Type text in the given element
    protected void type(String textToType, By locator){
        //log.info("Typing text in element with locator [" + locator + "]");
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(textToType);
    }

    // Get text from given element
    protected String getText(By locator){
        //log.info("Getting text from element with locator [" + locator + "]");
        waitForVisibilityOf(locator, 5);
        return find(locator).getText();
    }

    public void scrollToBottom(){
        log.info("Scrolling down to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds){
        int attempts = 0;
        while(attempts < 2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            }catch(StaleElementReferenceException e){

            }
        }
    }

    // Wait for the expected condition received. The time to wait will be received, otherwise, default to 30.
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(condition);
    }
}
