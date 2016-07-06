package Script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.Common;
import PageObject.Obj_Login;

public class Script_Login {
	static Obj_Login PageLogin;
	static Common pCommon;
	static WebDriver driver = new FirefoxDriver();

	/*
	 * TEST DATA
	 */
	//Account
	public static final String StrEmail  = "fuonghanh14@yahoo.com";
	public static final String StrPass  = "abc123";
	//Invalid Email
	public static final String StrInvalidEmail  = "fuonghanh14@yahoo";
	//Wrong pass
	public static final String StrWrongPass  = "123456";

	@BeforeTest
	public void beforeTest() {
		driver.get(Obj_Login.BaseURL);
		//maximize browser
		driver.manage().window().maximize();

		PageLogin = new Obj_Login(driver);
		pCommon = new Common(driver);

		//Goto Login
		PageLogin.Goto_Login();
	}

	@Test(priority =  0)
	public void Login_WrongPass() throws InterruptedException{
		PageLogin.LoginPage(StrEmail, StrWrongPass);

		//verify text
		pCommon.VerifyText(Obj_Login.Actual_WrongPass, Obj_Login.Expected_WrongPass, "TC1 Verify Wrong Password");
	}

	@Test(priority =  1)
	public void Login_InvalidEmail() throws InterruptedException{
		PageLogin.LoginPage(StrInvalidEmail, StrPass);

		//verify text
		pCommon.VerifyText(Obj_Login.Actual_InvalidEmail, Obj_Login.Expect_InvalidEmail, "TC2 Verify Invalid Email");
	}

	@Test(priority =  2)
	public void LoginSucessfully() throws InterruptedException{
		PageLogin.LoginPage(StrEmail, StrPass);

		//verify text
		if(driver.getPageSource().contains(StrEmail))
		{
			System.out.println("TC3 verify login sucess: Pass");
		}
		else
		{
			System.out.println("TC3 verify login sucess: Fail");
		} 
	}
	@AfterTest
	public void afterTest() {
		//Logout
		PageLogin.Goto_Logout();

		//Quit
		PageLogin.Quit();

	}
}
