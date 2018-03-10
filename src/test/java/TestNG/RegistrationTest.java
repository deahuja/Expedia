package TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageLayer.RegistrationPage;
import TestBase.ExpediaTestBase;
import Utility.ExpediaUtility;
import Utility.RegistrationUtility;

public class RegistrationTest extends ExpediaTestBase {
	
	RegistrationPage reg;
	RegistrationUtility utility;
	String SheetName = "registration";
	
	
	RegistrationTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		
		initialization();
		reg = new RegistrationPage();
		utility = new RegistrationUtility();
		
		
	}
	
	
/*	@Test (priority=1)
	public void Signin() throws InterruptedException {
			
	reg.Signin();
			
	}
	*/
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = utility.getTestData(SheetName);
		return data;

	}

	@Test(dataProvider = "getData")
	public void Registration (String firstname, String lastname, String email, String password, String confirmpassword) throws InterruptedException {
		
		reg.Signin();
		reg.Registration(firstname, lastname, email, password, confirmpassword);
			

	}

	
	
	
	
	
	@AfterTest
	public void teardown() {
		
		//driver.quit();
	}
}
