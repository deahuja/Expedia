package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

//import Utilities.Utility;
//import Utilities.WebEventListener;

public class ExpediaTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	
	public ExpediaTestBase()
	{
				
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Deepak Ahuja\\New_Selnium\\ExpediaFramework\\src\\main\\java\\Configuration\\configuration.properties");
			prop.load(fis);
		
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
					
	}
	
	public static void initialization()
	{
		
		String browsername= prop.getProperty("browser");
		System.out.println(browsername);
		
	if (browsername.equals("Chrome"))
			{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chrome\\chromedriver.exe");

		driver = new ChromeDriver(); // launch chrome

			
			}
		
	else if (browsername.equals("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");	
		driver = new FirefoxDriver();
	}
	
	
/*	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebDriverEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	*/
	
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();

	
	
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
//	driver.manage().timeouts().pageLoadTimeout(Utility.pageLoadTime, TimeUnit.SECONDS);
//	driver.manage().timeouts().implicitlyWait(Utility.implicitwait, TimeUnit.SECONDS);
	
	String url = prop.getProperty("URL");
	System.out.println(url);
	driver.get(url);
	
	}
	
	
	

}
