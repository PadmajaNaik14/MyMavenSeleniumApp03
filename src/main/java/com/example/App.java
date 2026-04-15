package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main(String[] args)
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");       // modern headless mode
        options.addArguments("--no-sandbox");         // required in Jenkins/Linux
        options.addArguments("--disable-dev-shm-usage"); // prevents crashes
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080"); // optional but useful

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://automationexercise.com/");
            driver.manage().window().maximize();

            Thread.sleep(2000); // wait 2 seconds after page load

            driver.findElement(By.className("add-to-cart")).click();

            Thread.sleep(2000); // wait after login

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // closes browser
        }
    }
}
