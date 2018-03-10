package PageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.ExpediaTestBase;

public class RegistrationPage extends ExpediaTestBase {

	@FindBy(id = "header-account-menu")
	WebElement account;

	@FindBy(id = "header-account-register")
	WebElement signin;

	@FindBy(id = "create-account-firstname")
	WebElement firstname;

	@FindBy(id = "create-account-lastname")
	WebElement lastname;

	@FindBy(id = "create-account-emailId")
	WebElement email;

	@FindBy(id = "create-password")
	WebElement password;

	@FindBy(id = "create-account-confirm-password")
	WebElement confirmpassword;
	
	@FindBy(id="create-account-expedia-policy")
	WebElement termsandconditions;
	
	@FindBy(id="create-account-submit-button")
	WebElement submit;
	

	public RegistrationPage() {

		PageFactory.initElements(driver, this);
	}

	public void Signin() throws InterruptedException {

		account.click();
		Actions action = new Actions(driver);
		action.moveToElement(account).build().perform();
		Thread.sleep(3000);

		signin.click();

	}

	public void Registration(String fn, String ln, String em, String pa, String cp) {
	
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		email.sendKeys(em);
		password.sendKeys(pa);
		confirmpassword.sendKeys(cp);
		
		// Checkbox
		termsandconditions.click();
		
		//Submitbutton
		submit.click();

	}

}
