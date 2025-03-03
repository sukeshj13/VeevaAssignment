package com.automatedtest.sample.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automatedtest.sample.basepage.BasePage;
import com.opencsv.CSVWriter;

import io.cucumber.java.Scenario;


public class ShopPage extends BasePage{


    @FindBy(xpath = "//input[@id='typeahead-input-desktop' and @class='typeahead-input' and @type='text']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@aria-label='Search Product']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class ='price']/span/span[@class = 'sr-only']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//*[@class=\"product-card-title\"]/a")
    private List<WebElement> productTitles;

    @FindBy(xpath = "//i[@class='icon icon-right-arrow' and @role='presentation']")
    private WebElement nextpage;


    


    public ShopPage() {
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String searchValue) {
        
        wait.forElementToBeDisplayed(10, this.searchBar, "Search Bar");
        this.searchBar.sendKeys(searchValue);

        wait.forElementToBeDisplayed(10, this.searchButton, "Search Buttton");
        this.searchButton.click();
    }

    public void switchtoWindow() throws InterruptedException {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        this.wait.forLoading(10);
        Thread.sleep(10000);
    }

    public void captureProductInfo(Scenario scenario) {
        List<String> prodTitles = new ArrayList<>();
        List<String> priceTitles = new ArrayList<>();

        while (true) {
            wait.forElementToBeDisplayed(10, this.nextpage, "Next Page");
            for (WebElement element : productTitles) {
                prodTitles.add(element.getAttribute("title"));
            }
            for (WebElement element : productPrices) {
                priceTitles.add(element.getText());
            }

            try {     
                if (this.nextpage.isEnabled()) {
                    this.nextpage.click();
                    Thread.sleep(2000);
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("./output/productInfo.csv"))) {
            for (int i = 0; i < prodTitles.size(); i++) {
                String title = prodTitles.get(i);
                String price = priceTitles.get(i);
                writer.writeNext(new String[]{title, price});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filePath = "./output/productInfo.csv";
        try {
            byte[] csvContent = Files.readAllBytes(Paths.get(filePath)); 
            scenario.embed(csvContent, "text/csv", "Product Info");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    
}
