package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillDetails(){

        // Fill in First Name
        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName"))).sendKeys("Sewmini");

        // Fill in Last Name
        driver.findElement(By.id("lastName")).sendKeys("Ranasinghe");

        // Fill in Street Address
        driver.findElement(By.id("addressLine1")).sendKeys("123, ABC Lane");

        // Fill in Street Address 2 (optional)
        driver.findElement(By.id("addressLine2")).sendKeys("North place");

        // Fill in City
        driver.findElement(By.id("city")).sendKeys("Victoria");

        // Fill in State/Province/Region
        driver.findElement(By.id("stateOrProvince")).sendKeys("Australia");

        // Fill in ZIP Code
        driver.findElement(By.id("postalCode")).sendKeys("10500");

        // Fill in Email
        driver.findElement(By.id("email")).sendKeys("sakura@test.com");

        // Confirm Email
        driver.findElement(By.id("emailConfirm")).sendKeys("sakura@test.com");

        // Fill in Phone Number
        driver.findElement(By.id("phoneNumber")).sendKeys("0123456789");
    }
}
