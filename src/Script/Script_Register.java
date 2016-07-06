package Script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.Common;
import PageObject.Obj_Login;
import PageObject.Obj_Register;

public class Script_Register {
	static Obj_Register PageRegister;
	static Obj_Login PageLogin;
	static Common pCommon;
	static WebDriver driver = new FirefoxDriver();
	String baseURL = "http://live.guru99.com/index.php/customer/account/create/";

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

	@BeforeTest
	public void beforeTest() {
		PageRegister = new Obj_Register(driver);
		PageLogin = new Obj_Login(driver);
		pCommon = new Common(driver);
		//open browser
		driver.get(baseURL);

		//maximize browser
		driver.manage().window().maximize();
	}

	@Test(priority =  0)
	public void Register_VerifyInvalidInformation() throws InterruptedException{
		PageRegister.RegisterWith(strFirst1,strLast1,strEmail1,strPass1,strConfirm1);

		//Verify 
		pCommon.CheckTextInPage(Obj_Register.ExpectedMesage1, "TC1. Verify Email Blank");
		pCommon.CheckTextInPage(Obj_Register.ExpectedMesage2, "TC2. Verify Pass must be at lease 6 Characters");
		pCommon.CheckTextInPage(Obj_Register.ExpectedMesage3, "TC3. Verify Pass and Confirm Pass must be match");

		//Refresh page
		driver.navigate().refresh();
	}

	@Test(priority =  1)
	public void Register_Sucessfully() throws InterruptedException{
		PageRegister.RegisterWith(strFirst,strLast,strEmail,strPass,strConfirm);

		//Verify create sucessfully
		pCommon.CheckTextInPage(Obj_Register.ExpectedMesage4, "TC4. Verify Create Customer sucessfully");
		PageLogin.Goto_Logout();
	}

	@Test(priority =  2)
	public void Register_AlreadyEmail() throws InterruptedException{
		driver.get(baseURL);
		Thread.sleep(5000);
		PageRegister.RegisterWith(strFirst,strLast,strEmail,strPass,strConfirm);

		//Verify text
		pCommon.CheckTextInPage(Obj_Register.ExpectedMesage6, "TC5. Verify already Email");	
	}
	@AfterTest
	public void afterTest() {
		//Quit
		PageLogin.Quit();

	}
}
