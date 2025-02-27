package com.automatedtest.sample.homepage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {


    private HomePage homePage;

    public HomePageSteps() {
        this.homePage = new HomePage();
    }

    @Given("^I navigates to core product website \"([^\"]*)\"$")
    public void aUserNavigatesToHomePage(String url) {
        this.homePage.goToHomePage(url);
        this.homePage.closePopUp();

    }

    @Then("^I select menu Shop and sub menu Men's$")
    public void selectShoppingMenu() {
        this.homePage.selectShopMenu();
    }
    
}
