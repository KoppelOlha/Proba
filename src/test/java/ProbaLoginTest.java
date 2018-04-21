import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ProbaLoginTest {

    private WebDriver browser;
    private static final String LOGIN = "380956320587";
    private static final String PASSWORD = "olga10071981";

    @BeforeClass
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void loginFacebook() {
        browser.get("https://www.facebook.com");
        browser.findElement(By.cssSelector("[type~=email]")).sendKeys(LOGIN);
        browser.findElement(By.cssSelector("#pass")).sendKeys(PASSWORD);
        browser.findElement(By.xpath(".//label[@id='loginbutton']")).click();
        assertTrue(browser.findElement(By.cssSelector("[data-testid~=left_nav_section_Интересное]")).isDisplayed());

    }

    @AfterClass
    public void closedBrowser() {
        browser.quit();
    }
}
