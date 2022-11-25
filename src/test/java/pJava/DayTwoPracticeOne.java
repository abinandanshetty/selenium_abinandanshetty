package pJava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DayTwoPracticeOne {
	public void frameswitch() {
		WebDriver D;
		D = new ChromeDriver();
		D.manage().window().maximize();
		D.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		D.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

		D.get("https://jqueryui.com/droppable/");
		WebElement cframe = D.findElement(By.xpath("//div[@id='draggable']"));
		WebElement des = D.findElement(By.xpath("//div[@id='droppable']"));
		D.switchTo().frame(cframe);
		Actions act = new Actions(D);
		act.clickAndHold(cframe);
		act.pause(2000);
		act.moveToElement(des);
		act.pause(2000);
		act.release(des).build().perform();

	}
}
