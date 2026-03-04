package cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    WebDriver driver;

    @BeforeTest
    private void init() {
        // Selenium mencari driver yang cocok
        driver = new ChromeDriver();

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.manage().window().maximize();
    }

    @Test (priority = 0) //test case 4
    public void checkElement() {
        Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Login");
        Assert.assertEquals(driver.findElement(By.cssSelector("p")).getText(), "Please login to make appointment.");
        Assert.assertEquals(driver.findElement(By.id("txt-username")).getAttribute("placeholder"), "Username");
        Assert.assertEquals(driver.findElement(By.id("txt-password")).getAttribute("placeholder"), "Password");
    }

    @Test (priority = 1) //test case 5
    public void loginWithNullValues() {
        driver.findElement(By.id("btn-login")).click();
        Assert.assertEquals(driver.findElement(By.className("text-danger")).getText(), "Login failed! Please ensure the username and password are valid.");
    }

    @Test (priority = 2) //test case 6
    public void loginWithWrongValues(){
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("WrongValue");
        driver.findElement(By.id("btn-login")).click();
        Assert.assertEquals(driver.findElement(By.className("text-danger")).getText(), "Login failed! Please ensure the username and password are valid.");
    }

    @Test (priority = 3) //test case 7
    public void loginWithCorrectValues(){
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}