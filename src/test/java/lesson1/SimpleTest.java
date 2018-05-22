package lesson1;

import oracle.jrockit.jfr.ActiveSettingEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;

public class SimpleTest {

    @Test
    public void simpleSeleniumTest() {
        //System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver2.exe");
        //DesiredCapabilities cap = DesiredCapabilities.chrome();
        //cap.setJavascriptEnabled(true);
        //cap.setBrowserName("chrome");

        //String downloadFilepath = "C:\\Users\\Tata\\Documents\\kek";
        //HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        //chromePrefs.put("download.default_directory", "target");
        //chromePrefs.put("profile.default_content_settings.popups", 0);


/*d

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals(driver.getTitle(), "Index Page");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".fa-sign-in")).click();

        WebElement element = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(element.isDisplayed());
        String text = element.getText();
        Assert.assertEquals(text, "PITER CHAILOVSKII");

*/

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI");
        Assert.assertEquals(driver.getTitle(),"Home Page");

        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.id("Name")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login button[type = 'submit']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector(".profile-photo span")).getText(), "PITER CHAILOVSKII");
        Assert.assertEquals(driver.getTitle(), "Home Page");

        List<WebElement> menuItems = driver.findElements(By.cssSelector(".uui-navigation.nav > li > a"));
        ArrayList<String> menuText = new ArrayList<String>();

        for (WebElement item : menuItems) {
            menuText.add(item.getText());
        }
        List<String> menuExpectedItems = Arrays.asList("HOME","CONTACT FORM","SERVICE","METALS & COLORS");
        Assert.assertEquals(menuText, menuExpectedItems);

        Assert.assertEquals(driver.findElements(By.cssSelector(".benefit .icons-benefit")).size(), 4);
        //Assert.assertEquals(driver.findElements(By.cssSelector(".benefit .benefit-txt")).size(), 4);
        //List<WebElement> textList = driver.findElements(By.cssSelector(".benefit .benefit-txt"));
        List<WebElement> elementsList = driver.findElements(By.cssSelector(".benefit .benefit-txt"));
        List<String> textList = new ArrayList<String>();

        for (WebElement element : elementsList) {
            textList.add(element.getText());
            System.out.println(element.getText());
        }

        List<String> expectedTextList = Arrays.asList("To include good practices\n" + "and ideas from successful\n" +
                "EPAM project", "To be flexible and\n" + "customizable","To be multiplatform", "Already have good base\n" +
                "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
        Assert.assertEquals(expectedTextList,textList);

        Assert.assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        Assert.assertEquals(driver.findElement(By.name("jdi-text")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        WebElement subHeader = driver.findElement(By.xpath("//*[text()='JDI Github']"));
        Assert.assertTrue(subHeader.isDisplayed());
        Assert.assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        Assert.assertTrue(driver.findElement(By.name("navigation-sidebar")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());
        driver.close();


    }

}
