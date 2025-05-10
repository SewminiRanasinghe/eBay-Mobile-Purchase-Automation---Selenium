/*************************************************************************************************
 If this ask for human verification through the process, have to verify that and rerun the program
 *************************************************************************************************/

package com.ebay.automation.tests;

import com.ebay.automation.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class EbayMobilePhonePurchase {

    private WebDriver driver;

    private HomePage homePage;
    private SearchResultPage mobilePhonesPage;
    private SeeAllPage allPhonesPage;
    private FirstResultPage firstResultPage;
    private CartPage CartPage;
    private CheckoutPage checkoutPage;
    private NewWindow newWindow;


    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Auto-downloads compatible version
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        mobilePhonesPage = new SearchResultPage(driver);
        allPhonesPage = new SeeAllPage(driver);
        firstResultPage = new FirstResultPage(driver);
        CartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        newWindow = new NewWindow(driver);
    }


    @Test(priority = 0)
    public void goToURL() {

        homePage.openURL("https://www.ebay.com/");
        //Verify the correct page has loaded
        String homePageURL = driver.getCurrentUrl();
        Assert.assertEquals(homePageURL, "https://www.ebay.com/", "Incorrect page has been loaded.");
        homePage.getElectronics();
        homePage.getAllPhones();
    }

    @Test(priority = 1)
    public void seeAll () {
        mobilePhonesPage.allMobilePhones();
    }

    @Test(priority = 2)
    public void selectFirstPhone() {
        allPhonesPage.selectFirstItem();
    }

    @Test(priority = 3)
    public void searchResultDetails() {
        firstResultPage.getPhoneName();
        firstResultPage.getPhonePrice();
        firstResultPage.getAllDetails();
    }

    @Test(priority = 4)
    public void openNewWindow(){
        newWindow.changeToNextWindow();
    }

    @Test(priority = 5)
    public void addToCart(){
        CartPage.clickAddToCart();
        CartPage.clickAddToCartIcon();
        CartPage.totalToPay();
        CartPage.goToCheckOut();
        CartPage.goToCheckOutAsGuest();
    }

    @Test(priority = 6)
    public void placeOrder() throws InterruptedException {
        checkoutPage.fillDetails();
        // Add a wait here to keep the browser open for observation
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for a condition that is already true, effectively pausing for the timeout duration
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }


    @AfterTest
    public void tearDown() {
        try {
            // Wait for a known element to confirm the page is loaded before closing
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))); // or any element that signifies checkout completion

        } catch (Exception e) {
            System.out.println("Timeout or error during wait before quitting: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit(); // quit() closes all windows and ends the session
            }
        }
    }
}
