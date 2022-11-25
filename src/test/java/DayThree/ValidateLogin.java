package DayThree;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ValidateLogin
{
    WebDriver driver;
    public void setup()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
    }
    public void tearDown()
    {
        driver.quit();
    }
    @Test
    public void validCredentials()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//b[text()='Admin']")).isDisplayed(), true);
        //Assert.assertEquals(driver.getCurrentUrl().contains("dashboard"), true);
    }
    
    @Test
    public void validUsernameInvalidPassword()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed(), true);
        
    }
    @Test
    public void invalidUsernameValidPassword()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Adm");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed(), true);
    }
    
    @Test
    public void invalidCredentials()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Adm");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed(), true);
    }
    
    @Test
     public void blankCredentials()
     {
        WebDriver driver=new ChromeDriver();
        driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
//        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Adm");
//        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed(), true);
     }



}