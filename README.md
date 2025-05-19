# eBay Purchase Flow Automation (Selenium + TestNG)

This project automates a complete mobile phone purchase flow on [eBay](https://www.ebay.com) using Selenium WebDriver, TestNG, and the Page Object Model (POM). It covers the full journey from category selection to guest checkout.

## Features

- Launches Chrome and navigates to eBay
- Selects Electronics > Cell Phones & Smartphones
- Applies price and screen size filters
- Selects the first product from search results
- Captures and prints product name and price
- Adds the product to cart and verifies details
- Proceeds to guest checkout and fills in shipping info
- Uses WebDriverWait for dynamic element handling
- Organized using the Page Object Model (POM)

## Project Structure

src/test/java/com/ebay/automation
├── pages

│ ├── HomePage.java

│ ├── ElectronicsPage.java

│ ├── SearchResultsPage.java

│ ├── ProductDetailsPage.java

│ ├── CartPage.java

│ └── CheckoutPage.java

└── tests

└── PurchaseTest.java


## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver

## LinkedIn 
https://www.linkedin.com/feed/update/urn:li:activity:7327386644041416705/
