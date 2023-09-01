package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By searchBar = By.id("cb1-edit");
    private By searchButton = By.className("nav-search-btn");

    private String url = "https://www.mercadolibre.com.uy";

    public HomePage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void openPage(){
        openURL(url);
        log.info("Page opened");
    }

    public ResultsPage searchProducts(String search){
        log.info("Searching product by: [" + search + "]");
        type(search, searchBar);
        click(searchButton);
        return new ResultsPage(driver, log);
    }
}
