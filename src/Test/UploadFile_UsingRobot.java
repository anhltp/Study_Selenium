package Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UploadFile_UsingRobot {
	//Copy path of file
	public static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard()
		.setContents(stringSelection, null);
	}

	public static void main(String[] args) { 

		String filepath = "C:\\Users\\PhuongAnhLT\\Desktop\\image\\logo.png";  
		setClipboardData(filepath);

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();        
		driver.get("http://only-testing-blog.blogspot.in/2013/09/test.html");

		//Click on the File Upload
		WebElement fileInput = driver.findElement(By.name("img"));
		fileInput.click();

		//Paste the file's absolute path into the File name field of the File Upload dialog box
		//native key strokes for CTRL, V and ENTER keys
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V); 
			robot.keyRelease(KeyEvent.VK_V); 
			robot.keyRelease(KeyEvent.VK_CONTROL); 
			robot.keyPress(KeyEvent.VK_ENTER); 
			robot.keyRelease(KeyEvent.VK_ENTER);  
		} catch (AWTException e) {
			e.printStackTrace();
		}

		driver.quit();
	}
}
