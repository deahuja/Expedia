package PageLayer;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestBase.ExpediaTestBase;

public class FlightSearch extends ExpediaTestBase{
	
	
	@FindBy(id="flight-origin-hp-flight")
	WebElement sourcecity;
	
	@FindBy(id="flight-destination-hp-flight")
	WebElement destinationcity;
	
	
	public FlightSearch() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void Entersourcecity(String so, String des, String td, String rd, String ad, String ch, String child1a, String child2a) throws InterruptedException {
	 
	//	 driver.findElement(By.xpath("//*[@id=\"flight-origin-hp-flight\"]")).sendKeys(so);
	//	Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@id=\"flight-origin-hp-flight\"]")).sendKeys(so);
	
		sourcecity.sendKeys(so);
		sourcecity.click();
		
		destinationcity.sendKeys(des);
		destinationcity.click();
		
		WebElement date = driver.findElement(By.id("flight-departing-hp-flight"));
		String dateVal = td;
		selectDateByJS(driver, date, dateVal);
		

		
		WebElement date2 = driver.findElement(By.id("flight-returning-hp-flight"));
		String dateVal2 = rd;
		selectDateByJS1(driver, date2, dateVal2);
		
		
//		Thread.sleep(2000);
		Select sel = new Select(driver.findElement(By.id("flight-adults-hp-flight")));
		int adult = (int) Double.parseDouble(ad);
		sel.selectByIndex(adult);
		
		   
		//   Thread.sleep(2000);
		   Select sel1 = new Select(driver.findElement(By.id("flight-children-hp-flight")));
		   int child = (int) Double.parseDouble(ch);
		   sel1.selectByIndex(child);
		   
		  // Thread.sleep(2000);
		   Select child1 = new Select(driver.findElement(By.id("flight-age-select-1-hp-flight")));
		   int child1age = (int) Double.parseDouble(child1a);
		 
		   child1.selectByIndex(child1age);
		   Thread.sleep(2000);
		   
		   Select child2 = new Select(driver.findElement(By.id("flight-age-select-2-hp-flight")));
		   int child2age = (int) Double.parseDouble(child2a);
		   child2.selectByIndex(child2age);
		   
		   
		   driver.findElement(By.xpath("//label[@class='col search-btn-col']//button[@class='btn-primary btn-action gcw-submit' and @type='submit']")).click();
		   
		      
		   
		   System.out.println("Done");

	
		
	}
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) throws InterruptedException
	{
    JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	
	}


	public static void selectDateByJS1(WebDriver driver, WebElement element2, String dateVal2) throws InterruptedException{
    JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("arguments[0].setAttribute('value','"+dateVal2+"');", element2);
		
	}
	
}

