package tests.products;

import base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultsPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetProductDetailsTest extends TestUtilities {

    @Parameters({"search"})
    @Test
    public void getProductDetailsAfterASearch(String search){

        // Create HomePage and set driver
        HomePage homePage = new HomePage(driver, log);

        // Open the home page
        homePage.openPage();

        // Searching product
        ResultsPage resultsPage = homePage.searchProducts(search);

        ArrayList<String> productsListData = new ArrayList<>();

        // Storing all results from first page
        List<WebElement> firstPageProducts = resultsPage.getAllResults();

        for (WebElement product : firstPageProducts){
            String productName = product.findElement(By.xpath(".//h2")).getText();
            String productPrice = product.findElement(By.xpath(".//span[@class='andes-money-amount__fraction']")).getText();
            String productUrl = product.findElement(By.xpath(".//a")).getAttribute("href");
            productsListData.add("Page: 1"+" - "+"Product Name: "+productName+" - "+"Product Price: "+productPrice+" - "+"Product URL: "+productUrl);
        }

        resultsPage.scrollToBottom();
        resultsPage.clickNextButton();

        // Storing all results from first page
        List<WebElement> secondPageProducts = resultsPage.getAllResults();

        for (WebElement product : secondPageProducts){
            String productName = product.findElement(By.xpath(".//h2")).getText();
            String productPrice = product.findElement(By.xpath(".//span[@class='andes-money-amount__fraction']")).getText();
            String productUrl = product.findElement(By.xpath(".//a")).getAttribute("href");
            productsListData.add("Page: 2"+" - "+"Product Name: "+productName+" - "+"Product Price: "+productPrice+" - "+"Product URL: "+productUrl);
        }

        resultsPage.scrollToBottom();
        resultsPage.clickNextButton();

        // Storing all results from first page
        List<WebElement> thirdPageProducts = resultsPage.getAllResults();

        for (WebElement product : thirdPageProducts){
            String productName = product.findElement(By.xpath(".//h2")).getText();
            String productPrice = product.findElement(By.xpath(".//span[@class='andes-money-amount__fraction']")).getText();
            String productUrl = product.findElement(By.xpath(".//a")).getAttribute("href");
            productsListData.add("Page: 3"+" - "+"Product Name: "+productName+" - "+"Product Price: "+productPrice+" - "+"Product URL: "+productUrl);
        }

        writeToFile("ProductResults", productsListData);

    }
}
