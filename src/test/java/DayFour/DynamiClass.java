package DayFour;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamiClass {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.out.println("Running before Method");
		driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void tearnow() {
		driver.quit();
		System.out.println("Running after method");
	}
	@Test(dataProvider="testdata")
	public void myTest(String email,String password) {
		driver.findElement(By.xpath("//input [@placeholder = 'Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input [@placeholder = 'Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Practise']")).getText(),"Practise");
        driver.findElement(By.xpath("//button[text()='Sign out']")).click();
	}
	
	
	@DataProvider(name = "testdata")
	public Object[][] testdataGeneration() throws IOException {
		Object[][] arr = null;
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("\"C:\\Users\\abishett\\Desktop\\SapienTestData.xlsx\"")));
			int rows = wb.getSheet("LoginData").getPhysicalNumberOfRows();
			int colums = wb.getSheet("LoginData").getRow(0).getPhysicalNumberOfCells();
			arr = new Object[rows][colums];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; i < colums; j++) {
					arr[i][j] = wb.getSheet("LoginData").getRow(i).getCell(j).getStringCellValue();
				}
			}
			System.out.println(arr);
			wb.close();
		} catch (FileNotFoundException e) {
			System.out.println("Please check the file" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Something went wrong" + e.getMessage());
		}
		return arr;
	}
}
