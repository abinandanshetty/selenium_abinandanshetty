package pJava;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DayOnePracticeOne {
	@Test
	
	public void login() {
		WebDriver D = new ChromeDriver();
		D.manage().window().maximize();
		D.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		D.get("https://ineuron-courses.vercel.app/login");
		D.findElement(By.xpath("//a[contains(text(),'Signup')]")).click();
		Assert.assertEquals(D.findElement(By.xpath("//h4[contains(text(),'Interests')]")).isDisplayed(), true);
		D.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("SampleUser");
		D.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("suser@123");
		D.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("sample123");
		D.findElement(By.xpath("//label[contains(text(),'Quantum Physics')]")).click();
		
//		D.findElement(By.xpath("//input[@value='Male']")).click();
		
		WebElement stateDropDown= D.findElement(By.id("state"));
		Select state = new Select(stateDropDown);
		
		state.selectByIndex(2);

	}
}
