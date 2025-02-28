package com.automatedtest.sample.infrastructure.driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automatedtest.sample.basepage.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class TearDown extends BasePage{

    
    @After
    public void quitDriver(Scenario scenario){
        if(scenario.isFailed()){
           saveScreenshotsForScenario(scenario);
        }
        driver.quit();
    }

    private void saveScreenshotsForScenario(final Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
}
