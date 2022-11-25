package dayone;
/*
 * @author abishett
 */

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class Assignment {
	@Test
	public void assign() throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
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
		//driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
	}

}
