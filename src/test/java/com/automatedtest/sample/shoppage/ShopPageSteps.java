package com.automatedtest.sample.shoppage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopPageSteps {


    private ShopPage shopPage;

    public ShopPageSteps() {
        this.shopPage = new ShopPage();
    }

    @When("^I search for \"([^\"]*)\" on the shopping page$")
    public void searchForProduct(String searchValue) throws InterruptedException {
        shopPage.switchtoWindow();
        shopPage.searchForProduct(searchValue);
    }

    @Then("^I capture title and price for products in CSV file$")
    public void captureProductDetails() {
        shopPage.captureProductInfo();
    }

}
