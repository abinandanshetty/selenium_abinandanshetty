package dayone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentOne {
	@Test
	
	public static void assOne() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='New user? Signup']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Abinandan Shetty");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("mr.abshetty@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("abcde");
		Assert.assertTrue(true);
	}

}
