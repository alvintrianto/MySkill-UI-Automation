package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPages {
    WebDriver driver;

    public registerPages(WebDriver driver){
        this.driver=driver;
    }

    //Locator dari register button
    By firstnameField = By.id("customer.firstName");
    By lastnameField = By.name("customer.lastName");

    //Metode click register button
    public void inputNameData(String firstname, String lastname){
        driver.findElement(firstnameField).sendKeys(firstname);
        //User input lastname
        driver.findElement(lastnameField).sendKeys(lastname);
    }
}