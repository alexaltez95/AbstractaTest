package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends BasePage {
    private By allProducts = By.xpath("//li[@class='ui-search-layout__item shops__layout-item']");
    private By nextButton = By.xpath("//a[@title='Siguiente']");

    public ResultsPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public List<WebElement> getAllResults(){
        log.info("Returning all results using locator: [" + allProducts + "]");
        List<WebElement> list = findAll(allProducts);
        return list;
    }

    public void clickNextButton(){
        log.info("Clicking button 'Siguiente'");
        click(nextButton);
    }

}
