package com.automatedtest.sample.shoppage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automatedtest.sample.basepage.BasePage;
import com.opencsv.CSVWriter;


public class ShopPage extends BasePage{


    @FindBy(xpath = "//input[@id='typeahead-input-desktop' and @class='typeahead-input' and @type='text']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@aria-label='Search Product']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class ='price']/span/span[@class = 'sr-only']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//*[@class=\"product-card-title\"]/a")
    private List<WebElement> productTitles;


    


    ShopPage() {
        PageFactory.initElements(driver, this);
    }

    void searchForProduct(String searchValue) {
        
        wait.forElementToBeDisplayed(10, this.searchBar, "Search Bar");
        this.searchBar.sendKeys(searchValue);

        wait.forElementToBeDisplayed(10, this.searchButton, "Search Buttton");
        this.searchButton.click();
    }

    void switchtoWindow() throws InterruptedException {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        this.wait.forLoading(10);
        Thread.sleep(10000);
    }

    public void captureProductInfo() {
        List<String> prodTitles = new ArrayList<>();
        List<String> priceTitles = new ArrayList<>();
    
        for (WebElement element : productTitles) {
            prodTitles.add(element.getAttribute("title"));
        }
        for (WebElement element : productPrices) {
            priceTitles.add(element.getText());
        }
    
        try (CSVWriter writer = new CSVWriter(new FileWriter("./output/productInfo.csv"))) {
            for (int i = 0; i < productTitles.size(); i++) {
                String title = productTitles.get(i).getText();
                String price = productPrices.get(i).getText();
                writer.writeNext(new String[]{title, price});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
