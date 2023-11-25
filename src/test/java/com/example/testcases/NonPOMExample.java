package com.example.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class NonPOMExample {
 
     WebDriver driver;
 
     @BeforeTest
     public void setup() {           
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
           driver.get("https://opensource-demo.orangehrmlive.com/");
     }
 
     @Test(priority = 0)
     public void Login() {
           String pageTitle = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/h5")).getText();
           Assert.assertTrue(pageTitle.contains("Login"));
     }
 
     @Test(priority = 1)
     public void HomePage() throws InterruptedException {
 
           driver.findElement(By.name("username")).sendKeys("Admin");
           driver.findElement(By.name("password")).sendKeys("admin123");
           driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).submit();
           Thread.sleep(3000);
           String homePageText = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div/div/span/h6")).getText();
           Assert.assertTrue(homePageText.contains("Dashboard"));
     }
 
     @AfterTest
     public void close() {
           driver.quit();
     } 
}