package DayFive;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserGrid {
	WebDriver driver;

	@Parameters({ "os", "osVersion,", "browser", "browserVersion" })
	@BeforeMethod
	public void Setup(String os, String osVersion, String browser, String browserVersion) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("os", os);
		capabilities.setCapability("osVersion", osVersion);
		capabilities.setCapability("browser", browser);
		capabilities.setCapability("browserVersion", browserVersion);
		

		URL url = null;
		try {
			url = new URL("https://abinandanshetty_wDqoSj:yMSfQT1hQVbQC1EniYzM@hub-cloud.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver = new RemoteWebDriver(url, capabilities);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

	@Test
	public void myTest() throws InterruptedException {

		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");

		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

		driver.findElement(By.xpath("//a//b[text()='Admin']")).click();

		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();

		driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).sendKeys("Mukesh Otwani");
		driver.findElement(By.xpath("//input[@name='systemUser[userName]']")).sendKeys("Abinandan");
		driver.findElement(By.xpath("//input[@name='systemUser[password]']")).sendKeys("Abinandan@2929");
		driver.findElement(By.xpath("//input[@name='systemUser[confirmPassword]']")).sendKeys("Abinandan@2929");

		driver.findElement(By.xpath("//input[@name='btnSave']")).click();

		driver.findElement(By.xpath("//a[@id='welcome']")).click();

		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("index.php"));

	}

}
