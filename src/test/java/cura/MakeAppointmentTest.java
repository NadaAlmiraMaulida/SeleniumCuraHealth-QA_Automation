package cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class MakeAppointmentTest {

    WebDriver driver;

    @BeforeTest
    private void init() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
            put("credentials_enable_service", false);
            put("profile.password_manager_enabled", false);
        }});

        driver = new ChromeDriver(options);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.manage().window().maximize();

        // login
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/#appointment");
    }

     @Test (priority = 0)
    public void checkElement() {
        //check h2 element
        Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Make Appointment");

        //check dropdown element
         Select dropDownFacility = new Select(driver.findElement(By.id("combo_facility")));
         List<WebElement> dropDownOptions = dropDownFacility.getOptions();
         Assert.assertEquals(dropDownOptions.get(0).getAttribute("value"), "Tokyo CURA Healthcare Center");
         Assert.assertEquals(dropDownOptions.get(1).getAttribute("value"),"Hongkong CURA Healthcare Center");
         Assert.assertEquals(dropDownOptions.get(2).getAttribute("value"),"Seoul CURA Healthcare Center");

         //check text area
         Assert.assertEquals(driver.findElement(By.id("txt_comment")).getAttribute("placeholder"), "Comment");
     }


     @Test(priority = 1)
    public void makeAppointmentWithCorrectValues() {
         //dropdown
         Select dropDownFacility = new Select(driver.findElement(By.id("combo_facility")));
         dropDownFacility.selectByValue("Hongkong CURA Healthcare Center");

         //check box
         driver.findElement(By.id("chk_hospotal_readmission")).click();

         //radio button
         driver.findElement(By.id("radio_program_medicaid")).click();

         //date
         driver.findElement(By.id("txt_visit_date")).sendKeys("15/09/2023");

         //text area
         driver.findElement(By.id("txt_comment")).sendKeys("Test Text Area");

         //click button
         driver.findElement(By.id("btn-book-appointment")).click();

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.urlContains("appointment.php#summary"));

         Assert.assertEquals(driver.getCurrentUrl(),
                 "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

     }

     @Test (priority = 2, dependsOnMethods = {"makeAppointmentWithCorrectValues"})
    public void checkAppointmentSummary(){
    //check h2 element
    Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Appointment Confirmation");

    //check facility
    Assert.assertEquals(driver.findElement(By.id("facility")).getText(), "Hongkong CURA Healthcare Center");

    //check readmission
    Assert.assertEquals(driver.findElement(By.id("hospital_readmission")).getText(), "Yes");

    //check healthcare program
    Assert.assertEquals(driver.findElement(By.id("program")).getText(), "Medicaid");

    //check visit date
    Assert.assertEquals(driver.findElement(By.id("visit_date")).getText(), "15/09/2023");

    //check comment
    Assert.assertEquals(driver.findElement(By.id("comment")).getText(), "Test Text Area");

    //homepage
         driver.findElement(By.className("btn-default")).click();
         Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
     }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
