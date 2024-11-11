package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LogIn extends DriverSetUp{




   @Test
    public void LogIn() throws InterruptedException, IOException {
        browser.get("https://www.xampro.org//");

        Thread.sleep(4000);
        String jsonData = new String(Files.readAllBytes(Paths.get("C:\\Users\\KHAN GADGET\\Desktop\\MAAC_INTERN\\src\\demo.json")));
        JSONArray jsonArray = new JSONArray(jsonData);
        JSONObject jsonObject = jsonArray.getJSONObject(1);
        String email = jsonObject.getString("email");
        String password = jsonObject.getString("password");

        browser.findElement(By.cssSelector("a[href='/login']")).click();
        Thread.sleep(3000);

        WebElement emailField = browser.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordField = browser.findElement(By.xpath("//input[@id='password']"));

        emailField.clear();
        emailField.sendKeys(email);

        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginButton =browser.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(5000);
        System.out.println("Logged in with email: " + email);
    }
}
