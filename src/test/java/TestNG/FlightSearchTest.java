package TestNG;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageLayer.FlightSearch;
import TestBase.ExpediaTestBase;
import Utility.ExpediaUtility;

public class FlightSearchTest extends ExpediaTestBase {

	ExpediaUtility utility;
	FlightSearch fsearch;
	String SheetName = "flightsearch";

	FlightSearchTest() {
		super();

	}

	@BeforeMethod
	public void setup() {

		initialization();
		utility = new ExpediaUtility();
		fsearch = new FlightSearch();

		System.out.println("Chrome Browser is launched ");
		// fsearch = new FlightSearch();
		driver.findElement(By.id("tab-flight-tab-hp")).click();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = utility.getTestData(SheetName);
		return data;

	}

	@Test(dataProvider = "getData")
	public void SearchFlight(String source, String destination, String tdate, String rdate, String adult, String child,
			String child1age, String child2age) throws InterruptedException {

		fsearch.Entersourcecity(source, destination, tdate, rdate, adult, child, child1age, child2age);
		// System.out.println(source);

	}

	@AfterMethod()

	public void teardown() {
		// driver.close();

	}

}
