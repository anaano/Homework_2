package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAlerts() {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

        Alert alert = driver.switchTo().alert();
        String inputName = "Anano Meskhi";
        alert.sendKeys(inputName);
        alert.accept();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo1")));
        String results = driver.findElement(By.id("demo1")).getText();
        String output = "Hay " + inputName;
        Assert.assertEquals(results, output, "The result is different!");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();


    }
}
