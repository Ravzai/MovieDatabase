package org.example.tests;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySteps {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new FirefoxDriver();
    }

    @Given("I am on the movie database website")
    public void on_the_website() {
        webDriver.get("https://www.themoviedb.org/");
    }

    @Given("I search for Titanic")
    public void search_titanic() {
        WebElement searchInput = webDriver.findElement(By.cssSelector("input#inner_search_v4"));
        searchInput.sendKeys("Titanic");
    }

    @When("I click the search button")
    public void click_search_button() {
        WebElement searchButton = webDriver.findElement(By.cssSelector("input[type='submit'][value='Search']"));
        searchButton.click();
    }

    @Then("The first search result should be Titanic")
    public void first_search_result_Titanic() {
        WebElement firstSearch = webDriver.findElement(By.xpath("//h2[contains(text(),'Titanic')]"));
    }

    @After
    public void CleanUp(){
        webDriver.close();
    }
}