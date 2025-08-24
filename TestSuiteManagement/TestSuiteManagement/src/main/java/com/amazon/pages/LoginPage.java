package com.amazon.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openAmazon() {
        driver.get("https://www.amazon.in/");
    }

    public void clickSignIn() {
        try {
            WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList")));
            signInBtn.click();
        } catch (Exception e) {
            System.out.println("Sign In button not clickable: " + e.getMessage());
        }
    }

    public void enterPhoneNumber(String phoneNumber) {
        try {
            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
            Actions actions = new Actions(driver);
            actions.moveToElement(phoneInput).click().sendKeys(phoneNumber).perform();
        } catch (Exception e) {
            System.out.println("Phone number input failed: " + e.getMessage());
        }
    }

    public void clickContinue() {
        try {
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", continueBtn);
        } catch (Exception e) {
            System.out.println("Continue button click failed: " + e.getMessage());
        }
    }

    public void waitForOtpEntry() {
        System.out.println("🔐 Please enter OTP manually in the browser. Waiting 40 seconds...");
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickContinueAfterOtp() {
        try {
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", continueBtn);
        } catch (Exception e) {
            System.out.println("Continue after OTP click failed: " + e.getMessage());
        }
    }
}
