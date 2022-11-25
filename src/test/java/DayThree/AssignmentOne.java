package DayThree;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentOne {
	@Test
	public void assOne() {
		int count = 0;
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		d.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		d.get("https://ineuron-courses.vercel.app/login");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.findElement(By.xpath("//input [@placeholder = 'Email']")).sendKeys("ineuron@ineuron.ai");
		d.findElement(By.xpath("//input [@type = 'password']")).sendKeys("ineuron");
		d.findElement(By.xpath("//button [text() = 'Sign in']")).click();
		Assert.assertEquals(d.findElement(By.xpath("//span[contains(text(), 'Manage')]")), true);

		WebElement e = d.findElement(By.xpath("//span[contains(text(), 'Manage')]"));
		Actions a = new Actions(d);
		a.moveToElement(e).perform();
		d.findElement(By.xpath("//a [@href ='/category/manage']")).click();
		ArrayList<String> tabs2 = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window(tabs2.get(1));
		d.findElement(By.xpath("//button [contains(text(), 'Add New Category')]")).click();

		Alert b = d.switchTo().alert();
		b.sendKeys("Abinandan Shetty");
		b.accept();
	//        count++;
		System.out.println("Abinandan Shetty is craeated");
		Assert.assertEquals(d.findElement(By.xpath("//*[contains(text(),'Abinandan')]//following::button[1]")), true);
		d.findElement(By.xpath("//*[contains(text(),'Abinandan')]//following::button[1]")).click();
		d.findElement(By.xpath("//button [text()= 'Delete']")).click();
		d.close();

		d.switchTo().window(tabs2.get(0));
		d.findElement(By.xpath("//button [text()= 'Sign out']")).click();

	}

}