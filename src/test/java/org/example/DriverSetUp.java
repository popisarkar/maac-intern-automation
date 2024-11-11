package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSetUp

{
    WebDriver browser;

    @BeforeSuite
    public void openBrowser(){
        browser = new ChromeDriver();
    }


    @AfterSuite
    public void quiteBrowser(){
        browser.quit();
    }
}
