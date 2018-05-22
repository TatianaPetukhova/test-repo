package lesson2;

import base.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class LessonTwo extends TestBaseClass {

    //private WebDriver driver; // in real life don;t move tests into tests themselves because there iwll be issues with parallel
    private ChromeOptions options;

    @BeforeClass
    public void beforeClass() {
        options = new ChromeOptions();
        // for example path to exe with driver
    }

    @BeforeMethod
    public void beforeMethod() {
        // e.g. time = System.currentTimeMillis();
        // what to do with browser
        //driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        //to measure diff between times
        // driver.close();
    }

    @AfterClass
    public void afterClass() {

    }

    //@Test(invocationCount = 3, threadPoolSize = 3)
    @Test(timeOut = 1000) // редко вообще используется
    public void seleniumTest() {

        WebDriver driver = new ChromeDriver(); // for parallel runs
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI");
        Assert.assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.id("Name")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login button[type = 'submit']")).click();
        driver.close();
    }


}



