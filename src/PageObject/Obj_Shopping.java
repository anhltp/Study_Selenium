package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Obj_Shopping {
	WebDriver driver;
	public static By LinkMobile = By.linkText("Mobile");
	public static By BtnAddToCart = By.xpath(".//div[3]/button");
	public static By TxtSearch = By.id("search");
	//Qty
	public static By TxtQty = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input");
	public static By BtnUpdateQty = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button");
	//Checkout
	public static By BtnCheckOut = By.xpath(".//button[@title='Proceed to Checkout']");
	public static By BtnContinueCheckOut = By.xpath(".//*[@id='billing-buttons-container']/button");
	public static By BtnContinue2 = By.xpath(".//*[@id='shipping-method-buttons-container']/button");

	//Pay Money
	public static By OptPayMoney = By.id("p_method_checkmo");
	public static By BtnPayMoney = By.xpath(".//*[@id='payment-buttons-container']/button");

	public static By ActualTextSearch = By.xpath(".//*[@id='checkout-review-table']/tbody/tr/td[1]/h3");
	public static By BtnPlaceHolder = By.xpath(".//*[@id='review-buttons-container']/button");
	public static final String ExpectOrderSucess = "Your order has been received.";




}
