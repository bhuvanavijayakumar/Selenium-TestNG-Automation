package sample_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Program_1 {

    WebDriver driver;// declaration
    @BeforeMethod
    public void setUp(){
System.setProperty("web-driver.chrome.driver","C:\\Codebase\\chromedriver_win32 (1)\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.numpyninja.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void verifyName()
    {
        String actualTitle=driver.getTitle();
        String expectedTitle="About | Numpy Ninja";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void verifyLogo()
    {
        boolean flag=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/header/div/div[2]/div[2]/div/div/div[1]/a/wow-image/img")).isDisplayed();
        Assert.assertTrue(flag);
    }
    @Test
    public void verifyInValidName()
    {
        String actualTitle=driver.getTitle();
        String expectedTitle="Numpy Ninja";
        Assert.assertNotEquals(actualTitle, expectedTitle);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
