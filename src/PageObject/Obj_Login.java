package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Obj_Login {

	WebDriver driver;
	//Base URL	
	public static final String BaseURL = "http://live.guru99.com";

	//Login
	public static By linkAccount = By.xpath(".//a/span[contains(text(),'Account')]");
	public static By linkLogin = By.xpath("//a[contains(text(),'Log In')]"); 

	//Logout
	public static By linkLogout = By.xpath(".//a[contains(text(),'Log Out')]");


	public static By txtEmail = By.id("email");
	public static By txtPass = By.id("pass");
	public static By btnSubmit = By.id("send2");


	//Wrong pass
	public static By Actual_WrongPass = By.xpath("//span[contains(.,'Invalid login or password.')]");
	public static final String Expected_WrongPass = "Invalid login or password.";



	//Invalid Email
	public static final String Expect_InvalidEmail  = "Please enter a valid email address. For example johndoe@domain.com.";
	public static By Actual_InvalidEmail = By.xpath("//div[@id='advice-validate-email-email']");

	//Go to Logout

	public void Goto_Logout() { 
		driver.findElement(linkAccount).click();
		driver.findElement(linkLogout).click();
	}

	//Go to Login
	public void Goto_Login(){
		driver.findElement(linkAccount).click();
		driver.findElement(linkLogin).click();	
	}


	public Obj_Login(WebDriver driver){
		this.driver = driver;
	}


	public void setEmail(String Email){
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(Email);
	}

	public void setPass(String Pass){
		driver.findElement(txtPass).clear();
		driver.findElement(txtPass).sendKeys(Pass);
	}

	public void clickSigninBtn() throws InterruptedException{
		driver.findElement(btnSubmit).click();
	}


	//Log in function

	public void LoginPage (String Email, String Password) throws InterruptedException{
		Thread.sleep(2000);
		setEmail(Email);
		setPass(Password);
		clickSigninBtn();
	}

	/*
	 * Quit browser
	 */
	public void Quit(){
		driver.quit();	
	}



}
