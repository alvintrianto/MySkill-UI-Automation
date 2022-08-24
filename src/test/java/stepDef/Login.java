package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Login extends env_target {
    Duration duration = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(driver, duration);
    @Given("User is on login page")
    public void user_is_on_login_page() {


        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
    }
    @When("User fill username and password")
    public void user_fill_username_and_password() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @And("User click login button")
    public void user_click_login_button() {
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }
    @Then("User verify login result")
    public void user_verify_login_result() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
        );
        driver.quit();
    }

    @When("User fill password but invalid username")
    public void user_fill_password_but_invalid_username() {
        driver.findElement(By.name("user-name")).sendKeys("standard");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("User get error username password not match")
    public void user_get_error_not_match_username() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
        );
        driver.quit();
    }

    @When("^User input (.*) and (.*)$")
    public void user_input_username(String username, String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("^User verify login (.*)$")
    public void user_verify_login_result_tdd(String result) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if (result == "Passed"){
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
            ));
        } else if (result == "Failed") {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error'][contains(text(),'Username and password do not match')]"))
            ));
        }
        driver.quit();
    }
}
