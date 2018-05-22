package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeworkLessonOne {

    //1 - Create a new test
    @Test
    public void WebPageTestJDI() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2 - Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI");

        // 3 - Assert Browser title
        Assert.assertEquals(driver.getTitle(),"Home Page");

        // 4 - Perform Login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.id("Name")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login button[type = 'submit']")).click();

        // 5 - Assert User name in the left-top side of screen that user logged in
        Assert.assertEquals(driver.findElement(By.cssSelector(".profile-photo span")).getText(), "PITER CHAILOVSKII");

        // 6 - Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        // 7 - Assert that there are 4 items on the header section are displayed and they have proper text
        List<String> menuExpectedItems = Arrays.asList("HOME","CONTACT FORM","SERVICE","METALS & COLORS");
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".uui-navigation.nav > li > a"));
        List<String> menuItemsText = new ArrayList<String>();

        for (WebElement item : menuItems) {
            menuItemsText.add(item.getText());
        }

        Assert.assertEquals(menuItemsText, menuExpectedItems);

        // 8 - Assert there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit .icons-benefit"));
        Assert.assertEquals(images.size(),4);

        for (WebElement element : images) {
            element.isDisplayed();
        }

        // 9 - Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> expectedTexts = Arrays.asList("To include good practices\n" + "and ideas from successful\n" +
                "EPAM project", "To be flexible and\n" + "customizable","To be multiplatform", "Already have good base\n" +
                "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
        List<WebElement> textELements = driver.findElements(By.cssSelector(".benefit .benefit-txt"));
        List<String> texts = new ArrayList<String>();

        for (WebElement element : textELements) {
            texts.add(element.getText());
        }

        Assert.assertEquals(expectedTexts,texts);

        // 10 - Assert the text of the main header
        Assert.assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        Assert.assertEquals(driver.findElement(By.name("jdi-text")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        // 11 - Assert the text of the sub header
        WebElement subHeader = driver.findElement(By.xpath("//*[text()='JDI Github']"));
        Assert.assertTrue(subHeader.isDisplayed());

        // 12 - Assert that JDI Github is a link and has a proper URL
        Assert.assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        // 13 - Assert that there is Left Section
        Assert.assertTrue(driver.findElement(By.name("navigation-sidebar")).isDisplayed());

        // 14 - Assert that there is Footer
        Assert.assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());

        // 15 - Close Browser
        driver.close();

    }

}
