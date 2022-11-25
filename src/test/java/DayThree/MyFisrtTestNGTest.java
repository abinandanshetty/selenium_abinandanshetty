package DayThree;

import org.testng.annotations.Test;
import org.testng.Assert;

public class MyFisrtTestNGTest {
	@Test(priority=2)
	
	public void login() {
		Assert.assertTrue(false);
		System.out.println("Login done");
	}
	@Test
	public void createAccont() {
		System.out.println("Account created");
	}
	
	@Test
	public void deleteAccount() {
		System.out.println("Account deleted");
	}
	@Test(priority=1)
		public void logOutFromAccount() {
		System.out.println("Log out");
	}
	
}
