package DayFive;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

public class GridTest {
	WebDriver driver;

	@BeforeMethod
	public void Setup() {
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("osVersion", "16");
		browserstackOptions.put("deviceName", "iPhone 14");
		browserstackOptions.put("local", "false");
		capabilities.setCapability("bstack:options", browserstackOptions);

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

		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a//b[text()='Admin']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).sendKeys("Mukesh Otwani");
		driver.findElement(By.xpath("//input[@name='systemUser[userName]']")).sendKeys("Abinandan");
		driver.findElement(By.xpath("//input[@name='systemUser[password]']")).sendKeys("Abinandan@2929");
		driver.findElement(By.xpath("//input[@name='systemUser[confirmPassword]']")).sendKeys("Abinandan@2929");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='btnSave']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("index.php"));
//		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Abinandan");
//		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Abinandan@2929");

		Thread.sleep(2000);
		// driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

	}

}
