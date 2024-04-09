package asserdemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Day1 {
	public void openbrowser() {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		 String expected_title = "Practice Pa";
		 String actual_title = "Practice Page";
		
		 //Hard assertion
		
		//Assert.assertEquals(expected_title, actual_title);
		
		
		
		
		 //Soft Assertion
		
		SoftAssert sa = new SoftAssert();
		
		 sa.assertEquals(expected_title, actual_title);
		
		 WebElement check = driver.findElement(By.id("checkBoxOption1"));
		
		 sa.assertTrue(check.isDisplayed());
		// sa.assertTrue(check.isEnabled());
		
		 System.out.println((check.isDisplayed()));
		
		 check.click();
		 sa.assertTrue(check.isSelected());
		
		// System.out.println(check.isSelected());
		
		
		sa.assertAll();
	}
}