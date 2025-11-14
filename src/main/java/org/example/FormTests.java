package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.awt.*;

public class FormTests {
    private static Label modal;
    private WebDriver driver;

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Anano");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Meskhi");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400);");
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("22100495@ibsu.edu.ge");
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys("995555121212");
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText("2005");
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText("April");
        driver.findElement(By.xpath(
                "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[6]"
        )).click();

        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys("Maths");
        subjectsInput.sendKeys(Keys.ENTER);
        WebElement readingHobby = driver.findElement(By.xpath("//label[text()='Reading']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", readingHobby);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", readingHobby);
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Zugdidi, Khulishkari, i.meskhi N35");


        WebElement state=driver.findElement(By.id("state"));
        state.click();
        driver.findElement(By.xpath("//div[contains(text(),'Haryana')]")).click();

        WebElement city = driver.findElement(By.id("city"));
        city.click();
        driver.findElement(By.xpath("//div[contains(text(),'Karnal')]")).click();

        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td")).getText(),
                "Anano Meskhi"
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Student Email']/following-sibling::td")).getText(),
                "22100495@ibsu.edu.ge"
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(),
                "Female"
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Mobile']/following-sibling::td")).getText(),
                "995555121212"
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td")).getText(),
                "06 April,2005"
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Subjects']/following-sibling::td")).getText(),
                "Maths"
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Hobbies']/following-sibling::td")).getText(),
                "Reading"
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),
                "Zugdidi, Khulishkari, i.meskhi N35"
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='State and City']/following-sibling::td")).getText(),
                "NCR Delhi"
        );
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    }

