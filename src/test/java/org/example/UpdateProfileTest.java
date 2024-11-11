package org.example;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class UpdateProfileTest extends DriverSetUp{

   @Test
    public void UpdateTest() throws InterruptedException {

        browser.get("https://www.xampro.org/login");
        WebElement emailField = browser.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordField = browser.findElement(By.xpath("//input[@id='password']"));
        emailField.clear();
        emailField.sendKeys("popysarkar025@gmail.com");

        passwordField.clear();
        passwordField.sendKeys("Popi@6767");

        WebElement loginButton =browser.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);



         WebElement ProFileclick =browser.findElement(By.xpath("//div[@class='profile-view-btn nav-item dropdown']//a[@id='basic-nav-dropdown']"));

        ProFileclick.click();
        Thread.sleep(3000);
        WebElement drop= browser.findElement(By.xpath("//span[normalize-space()='Profile']"));
        drop.click();
        Thread.sleep(3000);
        WebElement img = browser.findElement(By.xpath("//input[@type='file']"));
        img.sendKeys("\"C:\\Users\\KHAN GADGET\\Desktop\\download (1).jpg\"");

       WebElement date =browser.findElement(By.xpath("//input[@id='dob']"));
       date.sendKeys("12/26/2000");
       Thread.sleep(3000);
       WebElement genderField =browser.findElement(By.xpath("//input[@id='radio-gender-female']"));
       genderField.click();
       Thread.sleep(3000);


       WebElement educationDropdown =browser.findElement(By.xpath("//select[@id='education']"));
       Select select = new Select(educationDropdown);
       educationDropdown.click();
       select.selectByVisibleText("MBA");
       educationDropdown.click();
       Thread.sleep(3000);

       WebElement dropdown = browser.findElement(By.cssSelector("path[d='M4.516 7.548c0.436-0.446 1.043-0.481 1.576 0l3.908 3.747 3.908-3.747c0.533-0.481 1.141-0.446 1.574 0 0.436 0.445 0.408 1.197 0 1.615-0.406 0.418-4.695 4.502-4.695 4.502-0.217 0.223-0.502 0.335-0.787 0.335s-0.57-0.112-0.789-0.335c0 0-4.287-4.084-4.695-4.502s-0.436-1.17 0-1.615z']"));
       Select University = new Select(dropdown);
       dropdown.click();
       University.selectByVisibleText("Brac University");
       dropdown.click();
       Thread.sleep(3000);

       WebElement Update = browser.findElement(By.xpath("(//button[normalize-space()='Update'])[1]"));
       Update.click();
       Thread.sleep(3000);



   }
}
