package com.automatedtest.sample;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/automatedtest/sample/Core_Product.feature"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/report.json",
        "html:target/report-html"},
        glue = {"com.automatedtest.sample.infrastructure.driver",
                "com.automatedtest.sample.homepage",
                "com.automatedtest.sample.shoppage"})
public class HomePageTest {
}
