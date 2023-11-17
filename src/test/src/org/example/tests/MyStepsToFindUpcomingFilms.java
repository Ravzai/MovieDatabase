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

    // Solve this!! It doesn't work, should this wait for a solution? We will see...... ;)
    @Given("I click on movies")
    public void click_on_movies() {
        WebElement filmsLink = webDriver.findElement((By.cssSelector("a.no_click.k-link.k-menu-link.k-state-active.k-state-border-down[href='/movie']")));
        filmsLink.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 10); // Wacht 10 seconden maximaal
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.no_click.k-link.k-menu-link.k-state-active.k-state-border-down[href='/movie']")));
        element.click(); // Voer de actie uit nadat het element aanklikbaar is geworden

    }

    @When("I navigate to upcoming movies")
    public void i_go_navigate_to_upcoming_movies() {
        WebElement upcomingMovies = webDriver.findElement((By.cssSelector("a.k-link.k-menu-link[href='/movie/upcoming']")));
        upcomingMovies.click();
    }

    @Then("I see all the upcoming movies")
    public void see_all_upcoming_movies() {
        WebElement movieTitle = webDriver.findElement(By.cssSelector(".title.result"));
        String titleText = movieTitle.getText();
    }

    @After
    public void CleanUp(){
        webDriver.close();
    }

    private class WebDriverWait {
    }
}
