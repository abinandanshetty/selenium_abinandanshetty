package dayone;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumDemo {
	@Test
	public void selDemo() {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Your Name");
		String title=driver.getTitle();
		System.out.println("Title is "+title);
		String url=driver.getCurrentUrl();
		System.out.println("Url is URL"+url);
		Assert.assertTrue(true);
		driver.quit();
	}

}
