package org.example.tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyStepsToFindUpcomingFilms {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new FirefoxDriver();
    }

    @Given("I am on the movie database website for upcoming movies")
    public void on_the_website_for_upcoming_movies() {
        webDriver.get("https://www.themoviedb.org/");
    }

    @Given("I navigate to movies")
    public void navigate_to_movies() {
        WebElement moviesLink = webDriver.findElement(By.linkText("Films"));
        moviesLink.click();
    }

    @When("I click on upcoming movies")
    public void i_click_on_upcoming_movies() {
        WebElement upcomingMovies = webDriver.findElement(By.cssSelector("a.k-link.k-menu-link[href='/movie/upcoming']"));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(upcomingMovies)).click();
    }

    @Then("I see all the upcoming movies")
    public void see_all_upcoming_movies() {
        WebElement upcomingMovies = webDriver.findElement(By.xpath("//*[@id=\"main\"]/section"));
        String sectionText = upcomingMovies.getText();
    }

    @After
    public void CleanUp(){
        webDriver.close();
    }
}
