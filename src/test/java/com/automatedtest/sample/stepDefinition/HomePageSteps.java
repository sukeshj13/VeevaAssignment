package com.automatedtest.sample.stepDefinition;

import com.automatedtest.sample.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {


    public HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage();
    }

    @Given("^I navigates to core product website \"([^\"]*)\"$")
    public void aUserNavigatesToHomePage(String url) {
        homePage.goToHomePage(url);
        homePage.closePopUp();

    }

    @Then("^I select menu Shop and sub menu Men's$")
    public void selectShoppingMenu() {
        homePage.selectShopMenu();
    }
    
}
