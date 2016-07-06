package Script;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.Common;
import PageObject.Obj_Login;
import PageObject.Obj_Shopping;

public class Script_Shopping {
	static Obj_Login PageLogin;
	static Common pCommon;
	static WebDriver driver = new FirefoxDriver();
	//Account
	public static final String StrEmail  = "fuonghanh14@yahoo.com";
	public static final String StrPass  = "abc123";

	//Search
	public static final String StrSearch  = "IPHONE";

	@BeforeTest
	public void beforeTest() {
		PageLogin = new Obj_Login(driver);
		pCommon = new Common(driver);

		//load page
		driver.get(Obj_Login.BaseURL);
		//maximize browser
		driver.manage().window().maximize();
		//Goto Login
		PageLogin.Goto_Login();
	}

	@Test
	public void Shopping_Sucess() throws InterruptedException{
		//1. Login
		PageLogin.LoginPage(StrEmail, StrPass);

		//2. Search Iphone in Searchbox
		driver.findElement(Obj_Shopping.TxtSearch).sendKeys(StrSearch);
		driver.findElement(Obj_Shopping.TxtSearch).sendKeys(Keys.ENTER);

		//3. Add to Cart
		driver.findElement(Obj_Shopping.BtnAddToCart).click();

		//4. Update Qty
		driver.findElement(Obj_Shopping.TxtQty).clear();
		driver.findElement(Obj_Shopping.TxtQty).sendKeys("2");
		driver.findElement(Obj_Shopping.BtnUpdateQty).click();

		//5. Checkout
		driver.findElement(Obj_Shopping.BtnCheckOut).click();
		driver.findElement(Obj_Shopping.BtnContinueCheckOut).click();
		Thread.sleep(3000);
		driver.findElement(Obj_Shopping.BtnContinue2).click();

		//6. Pay money
		Thread.sleep(3000);
		driver.findElement(Obj_Shopping.OptPayMoney).click();
		driver.findElement(Obj_Shopping.BtnPayMoney).click();
		Thread.sleep(3000);

		//7. Verify Iphone
		pCommon.VerifyText(Obj_Shopping.ActualTextSearch, StrSearch, "TC1. Veriy choosen product in order");

		//8. Click Place Holder
		driver.findElement(Obj_Shopping.BtnPlaceHolder).click();
		Thread.sleep(3000);

		//verify Your order has been received.
		pCommon.CheckTextInPage(Obj_Shopping.ExpectOrderSucess, "TC2. Verfy Order Sucessfully");
	}

	@AfterTest
	public void afterTest() {
		//Logout
		PageLogin.Goto_Logout();
		//Quit
		PageLogin.Quit();

	}
}
