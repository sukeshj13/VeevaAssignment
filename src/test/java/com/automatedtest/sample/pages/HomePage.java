package com.automatedtest.sample.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automatedtest.sample.basepage.BasePage;


public class HomePage extends BasePage{


    @FindBy(xpath = "//*[@class = 'w-full flex flex-end']/div")
    private WebElement closePopUp;

    @FindBy(xpath = "//a[@class='accent-primary-border _link_ob2qz_1 text-2sm']/span[text()='Shop']")
    private WebElement mainMenu;

    @FindBy(xpath = "//a[@title=\"Men's\" and @class='_link_47u7w_11 text-2sm']")
    private WebElement subMenu;

    @FindBy(xpath = "//a[@class=' _link_ob2qz_1 text-2sm']/span")
    private WebElement threeDots;

    @FindBy(xpath = "//a[@title='News & Features' and @href='/warriors/news' and contains(@class, '_link_47u7w_11')]")
    private WebElement newsAndFeatures;

    @FindBy(xpath="//h3[@class='wp-block-heading' and text()='VIDEOS']")
    private WebElement videoSection;

    @FindBy(xpath= "//li[@class='accent-primary-border pt-3 sm:pt-0 ContentGrid_contentGridColumnQuarter__wKkp2']")
    private List<WebElement> videoList;
    


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage(String url){
        driver.get(url);
        wait.forLoading(2);
    }

    public void closePopUp() {
        wait.forElementToBeDisplayed(10, this.closePopUp, "Home Page Pop Up");
        this.closePopUp.click();
    }

    public void selectShopMenu() {
        wait.forElementToBeDisplayed(10, this.mainMenu, "Main menu shopping button");
        Actions actions = new Actions(driver);
        actions.moveToElement(this.mainMenu).perform();

        wait.forElementToBeDisplayed(10, this.subMenu, "Sub menu shopping button");
        this.subMenu.click();
    }

    public void selectNewsAndFeatures() {
        wait.forElementToBeDisplayed(10, this.threeDots, "Three dots on home page");
        Actions actions = new Actions(driver);
        actions.moveToElement(this.threeDots).perform();

        wait.forElementToBeDisplayed(10, this.newsAndFeatures, "News and Features on home page");
        this.newsAndFeatures.click();
    }

    public void captureVideoFeed() {
        wait.forElementToBeDisplayed(10, this.videoSection, "Video section");
        System.out.println("Total number of video feed present on the page: " + videoList.size());
    }
}
