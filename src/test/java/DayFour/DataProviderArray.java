package DayFour;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderArray{
	WebDriver driver;
	@BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://ineuron-courses.vercel.app/login");
        driver.manage().window().maximize();
    }
    
    @AfterMethod
    public void teardown() {
        driver.quit();
        System.out.println("Running After Method - Browser session closed");
    }

    @Test(dataProvider = "testdata")
    public void myTest(String username, String password) {
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Java Selenium')]")).isDisplayed(), true);
        System.out.println("Test 1 executed "+ username +" "+ password);
    }
	
    @DataProvider(name = "testdata")
    public Object[][] testDataGeneration() {
        Object[][] arr = new Object [4][2];
        
        arr[0][0] = "sample9@gmail.com";
        arr[0][1] = "Mukesh1234";
        arr[1][0] = "samplemukesh@gmail.com";
        arr[1][1] = "Mukesh1234";
        arr[2][0] = "samplemukesh1@gmail.com";
        arr[2][1] = "Mukesh1234";
        arr[3][0] = "samplemukesh2@gmail.com";
        arr[3][1] = "Mukesh1234";
        return arr;
    }
}