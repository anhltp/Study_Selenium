package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Common.Common;
import PageObject.Obj_Register;
import PageObject.Obj_Login;;
public class Test_Register {

	static Obj_Register PageRegister;
	static Obj_Login PageLogin;
	static Common pCommon;
	static WebDriver driver = new FirefoxDriver();

	//Information of Register Sucessfully
	public static final	String strFirst = "Tran";
	public static final	String strLast = "Bin";
	public static final	String strEmail = "fuonganh" + Common.getRandomNumber(1000) + "@gmail.com";
	public static final	String strPass = "abc123";
	public static final	String strConfirm = "abc123";

	//Verify User registers unsucessfully 

	public static final	String strFirst1 = "Fuong";
	public static final	String strLast1 = "Fuong";
	public static final	String strEmail1 = "";
	public static final	String strPass1 = "123";
	public static final	String strConfirm1 = "abc123";

	/**
	 * TC1: Verify User registers unsucessfully 
	 * 1. Email Blank
	 * 2. Pass < 6 Character
	 * 3. Pass & Confirm Pass not match
	 */
	static void Register_VerifyInvalidInformation() throws InterruptedException{
		PageRegister.RegisterWith(strFirst1,strLast1,strEmail1,strPass1,strConfirm1);

		//Verify create sucessfully
		pCommon.CheckTextInPage(Obj_Register.ExpectedMesage1, "TC1. Verify Email Blank");
		pCommon.CheckTextInPage(Obj_Register.ExpectedMesage2, "TC2. Verify Pass must be at lease 6 Characters");
		pCommon.CheckTextInPage(Obj_Register.ExpectedMesage3, "TC3. Verify Pass and Confirm Pass must be match");
		
		//Refresh page
		driver.navigate().refresh();
	}

	//----------------------Function Register Sucessfully
	static void Register_Sucessfully() throws InterruptedException{
		PageRegister.RegisterWith(strFirst,strLast,strEmail,strPass,strConfirm);

		//Verify create sucessfully
		pCommon.CheckTextInPage(Obj_Register.ExpectedMesage4, "TC4. Verify Create Customer sucessfully");
	}	

	//-----------------------Register with already email
	static void Register_AlreadyEmail() throws InterruptedException{
		PageRegister.RegisterWith(strFirst,strLast,strEmail,strPass,strConfirm);

		//Verify text
		pCommon.CheckTextInPage(Obj_Register.ExpectedMesage6, "TC5. Verify already Email");	
	}

	/*
	 * ----------------------MAIN FUNCTION
	 */
	public static void main(String[] args) throws InterruptedException{ 
		String baseURL = "http://live.guru99.com/index.php/customer/account/create/";
		PageRegister = new Obj_Register(driver);
		PageLogin = new Obj_Login(driver);
		pCommon = new Common(driver);
		//open browser
		driver.get(baseURL);

		//maximize browser
		driver.manage().window().maximize();

		/**
		 * TC1: Verify User registers unsucessfully 
		 * 1. Email Blank
		 * 2. Pass < 6 Character
		 * 3. Pass & Confirm Pass not match
		 */

		Register_VerifyInvalidInformation();

		/**
		 * TC2: Verify User registers sucessfully 
		 * 1. Create new Customer successfully
		 */
		Register_Sucessfully();
		PageLogin.Goto_Logout();

		/**
		 * TC3: Verify already Email address 
		 * 
		 */
		driver.get(baseURL);
		Thread.sleep(5000);
		Register_AlreadyEmail();

		//Quit
		PageLogin.Quit();
	}

}
