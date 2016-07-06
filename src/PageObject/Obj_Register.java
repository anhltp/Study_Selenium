package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Obj_Register {
	WebDriver driver;
	public static By linkRegister = By.xpath("//a[contains(text(),'Register')]"); 


	public static By txtFirstName = By.id("firstname");
	public static By txtLastName = By.id("lastname");
	public static By txtEmail = By.id("email_address");
	public static By txtPass = By.id("password");
	public static By txtConfirm = By.id("confirmation");
	public static By btnSubmit = By.xpath(".//button[@title='Register']");

	//Expected message
	public static final	String ExpectedMesage1 = "This is a required field.";
	public static final	String ExpectedMesage2 = "Please enter 6 or more characters. Leading or trailing spaces will be ignored.";
	public static final String ExpectedMesage3 = "Please make sure your passwords match.";
	public static final String ExpectedMesage4 = "Thank you for registering with Main Website Store.";
	public static final String ExpectedMesage6 = "There is already an account with this email address";



	//Actual message
	public static By ActualMessage1 = By.id("advice-required-entry-email_address");
	public static By ActualMessage2 = By.id("advice-validate-password-password");
	public static By ActualMessage3 = By.id("advice-validate-cpassword-confirmation");

	public Obj_Register(WebDriver driver){
		this.driver = driver;
	}

	/*
	 * Register Function with First Name, Last Name, Email, Pass, ConfirmPass
	 */
	public void RegisterWith(String First, String Last,String Email, String Pass, String Confirm) {
		driver.findElement(txtFirstName).sendKeys(First);
		driver.findElement(txtLastName).sendKeys(Last);
		driver.findElement(txtEmail).sendKeys(Email);
		driver.findElement(txtPass).sendKeys(Pass);
		driver.findElement(txtConfirm).sendKeys(Confirm);
		driver.findElement(btnSubmit).click();
	}
}
