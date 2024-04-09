package Report_Create;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1 {
	WebDriver driver;
	ExtentReports er;
	ExtentTest test;
	
	@BeforeClass
	public void reportgenerate ()
	{
		 er = new ExtentReports(System.getProperty("user.dir")+"/Reportsclass.html");
	     test = er.startTest("Rahulshettytest");
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		    driver = new ChromeDriver();
		   
		    test.log(LogStatus.PASS, "Browser is successfully opened");
			
			
			driver.manage().window().maximize();
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			Thread.sleep(4000);
			
		    test.log(LogStatus.PASS, "URL is opened");
	}
	@Test (priority =0)
	public void checkbox() throws InterruptedException
	{
      WebElement check1 = driver.findElement(By.id("checkBoxOption1"));	
      check1.click();
      Thread.sleep(4000);
	    test.log(LogStatus.PASS, "checkbox is selected");
	   
	    if(!check1.isSelected())
	    {
	    	 test.log(LogStatus.FAIL, "checkbox is not selected");
	}
	}
	@Test (priority =1)
	public void multiplecheckbox () throws InterruptedException
	{
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
			for (WebElement check: checkboxes)
			{
				check.click();
			}
			
		      Thread.sleep(4000);
		     
			    test.log(LogStatus.PASS, "multiple checkboxes are selected");
			
	}
	@Test(priority =2)
		public void radiobutton() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
	      Thread.sleep(4000);
		    test.log(LogStatus.PASS, "radiobutton is selected");
	}
	@Test(priority =3)
		public void multipleradiobutton() throws InterruptedException
		{
        List<WebElement> radios = driver.findElements(By.name("radioButton"));
		
		for (WebElement check: radios)
		{
			check.click();
		}
	      Thread.sleep(4000);
		    test.log(LogStatus.PASS, "multiple radiobutton is selected");
		}
	@Test (priority =4)
		public void textbox() throws InterruptedException
		{
			driver.findElement(By.id("autocomplete")).sendKeys("India");
		      Thread.sleep(4000);
			    test.log(LogStatus.PASS, "check values are entered");
		}
	@Test (priority =5)
		public void dropdown() throws InterruptedException
		{
	   WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("Option2");
	      Thread.sleep(4000);
	     
		    test.log(LogStatus.PASS, "dropdown is selected");
		}
	
	@AfterMethod
		public void teardown ()
		{
			driver.close();
			
		    test.log(LogStatus.PASS, "browser is closed");
		}
	
	@AfterClass
	public void reportflush()
	{
		er.endTest(test);
		er.flush();
	}
}