package Common;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Common {
	WebDriver driver;

	/*
	 * Get random number
	 */
	public static int getRandomNumber(int number){
		int randomNumber=0;
		Random objGenerator = new Random();
		for (int iCount = 0; iCount< number; iCount++){
			randomNumber = objGenerator.nextInt(10000);
		}
		return randomNumber;
	}

	/*
	 * Verify Actual Text vs. expected Text
	 */
	public void VerifyText(By ActualElment, String EpectedText, String TestCaseName) { 
		if(driver.findElement(ActualElment).getText().contains(EpectedText))
		{
			System.out.println(TestCaseName + ": Pass");
		}else{

			System.out.println(TestCaseName + ": Not Pass");
		} 
	}
	
	/*
	 * Verify Actual Text by getPageSource vs. expected Text
	 */
	public void CheckTextInPage(String EpectedText, String TestCaseName) { 
		if(driver.getPageSource().contains(EpectedText))
		{
			System.out.println(TestCaseName + ": Pass");
		}else{

			System.out.println(TestCaseName + ": Not Pass");
		} 
	}
	
	public Common(WebDriver driver){
  		this.driver = driver;
  	}
}
