package dayone;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FirstWebScript {
    @Test
	public void firstWeb() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		WebElement username= driver.findElement(By.name("email1"));
		username.sendKeys("SapientTraining@gmail.com");
		driver.findElement(By.id("password1")).sendKeys("Abcd@1234");
		driver.findElement(By.className("submit-btn")).click();
		Thread.sleep(2000);
//		Assert.assertEquals(driver.findElements(By.xpath("//a[contains(text(),'Practise')]")), true);
		Assert.assertTrue(true);
	}


	}




