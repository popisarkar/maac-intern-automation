package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RegisterTest extends DriverSetUp {


    @Test
    public void JsonDataTest() throws InterruptedException, IOException {
        browser.get("https://www.xampro.org//");

        Thread.sleep(4000);

        browser.findElement(By.xpath("//span[contains(text(),'Registration')]")).click();
        Thread.sleep(3000);

        String jsonData = new String(Files.readAllBytes(Paths.get("C:\\Users\\KHAN GADGET\\Desktop\\MAAC_INTERN\\src\\demo.json")));
        JSONArray jsonArray = new JSONArray(jsonData);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String fullName = jsonObject.getString("fullName");
            String email = jsonObject.getString("email");
            String phone = jsonObject.getString("phone");
            String password = jsonObject.getString("password");
            String confirmPassword = jsonObject.getString("confirmPassword");

            WebElement fullNameField = browser.findElement(By.xpath("//input[@id='name']"));
            WebElement emailField = browser.findElement(By.xpath("//input[@id='email']"));
            WebElement phoneField = browser.findElement(By.xpath("//input[@id='phoneNumber']"));
            WebElement passwordField = browser.findElement(By.xpath("//input[@id='password']"));
            WebElement confirmPasswordField = browser.findElement(By.xpath("//input[@id='confirmPassword']"));

            fullNameField.clear();
            fullNameField.sendKeys(fullName);
            emailField.clear();
            emailField.sendKeys(email);
            phoneField.clear();
            phoneField.sendKeys(phone);
            passwordField.clear();
            passwordField.sendKeys(password);
            confirmPasswordField.clear();
            confirmPasswordField.sendKeys(confirmPassword);

            Thread.sleep(2000);

            // Click on the Register button
            WebElement registerButton = browser.findElement(By.cssSelector("button[type='submit']"));
            registerButton.click();
            Thread.sleep(5000);

            System.out.println("Registered user: " + fullName + " with email: " + email);
        }

    }
}
