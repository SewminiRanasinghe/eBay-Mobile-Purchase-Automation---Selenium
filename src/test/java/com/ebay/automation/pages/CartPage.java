package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddToCart(){
        WebElement addToCart = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='atcBtn_btn_1']"))
        );
        addToCart.click();
    }

    public void clickAddToCartIcon(){
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='https://cart.ebay.com']"))
        );
        cartIcon.click();
    }

    public void totalToPay(){
        WebElement subtotalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[data-test-id='SUBTOTAL'] span.text-display-span")
        ));

        // Get the text
        String subtotal = subtotalElement.getText();
        System.out.println("Total      : " + subtotal);
    }

    public void goToCheckOut(){
        WebElement goToCheckout = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href, '/checkout')] | //button[contains(text(), 'Go to checkout')]")
        ));
        goToCheckout.click();
    }

    public void goToCheckOutAsGuest() {
        try {
            // The previous code assumed an iframe, but the screenshot suggests a direct element.
            // Wait for the "Continue as guest" button to be clickable directly.
            WebElement guestCheckout = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Continue as guest']") // Using exact text from the screenshot
            ));
            guestCheckout.click();

        } catch (Exception e) {
            System.out.println("Error during guest checkout: " + e.getMessage());
            // It's helpful to print the stack trace for debugging
            e.printStackTrace();
        }
        // No finally block needed here as we are not switching frames
    }
}