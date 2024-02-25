package com.ptdeanz;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    public WebDriver driver;

    @BeforeTest
    public void login(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @Test
    public void checkSearchResult() {
        driver.findElement(By.xpath("//*[@title='Tìm kiếm']")).click();
        driver.findElement(By.xpath("//*[@title='Tìm kiếm']")).sendKeys("hello worlds" + Keys.ENTER);
        String words = driver.findElement(By.name("q")).getText();
        Assert.assertEquals(words, "hello worlds");
    }

    @AfterTest
    public void logOut(){
        driver.quit();
    }

}
