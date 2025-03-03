package com.automatedtest.sample.stepDefinition;

import com.automatedtest.sample.pages.ShopPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopPageSteps {


    public ShopPage shopPage;
    private Scenario scenario;

    public ShopPageSteps() {
        shopPage = new ShopPage();
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @When("^I search for \"([^\"]*)\" on the shopping page$")
    public void searchForProduct(String searchValue) throws InterruptedException {
        shopPage.switchtoWindow();
        shopPage.searchForProduct(searchValue);
    }

    @Then("^I capture title and price for products in CSV file$")
    public void captureProductDetails() {
        shopPage.captureProductInfo(scenario);
    }

}
