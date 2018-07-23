package Itempage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class Testcase3 {
	public void tc3() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/srava/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
	  	// Maximize browser		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Step#1 - Navigate to https://www.walmart.ca/en/ip/oaty-chomps-blueberry-carrot/6000188116060
		driver.get("https://www.walmart.ca/en/ip/oaty-chomps-blueberry-carrot/6000188116060");
		
		//QuantityCalc qc = new QuantityCalc();
		//qc.Backspace();
		
		//Step#2 - Enter the value 5 in Qty	
		//QTY field
		WebElement inputvalue = driver.findElement(By.cssSelector("input.qty-input"));
		inputvalue.clear();	
		String mainpage = driver.getWindowHandle();
		Actions Act1 = new Actions(driver);
		System.out.println("Clear the Input value using backspace");
		Act1.sendKeys(Keys.BACK_SPACE).build().perform();
		driver.switchTo().window(mainpage);
		inputvalue.sendKeys("5");

       driver.findElement(By.xpath("//*[@id=\"favourite-a2c-container\"]/div[2]/button")).click();
		
		
		String outputvalue = driver.findElement(By.xpath("//*[@id=\"qty-input-popup\"]")).getText();	
		System.out.println(outputvalue);
		Assert.assertEquals(outputvalue, "5");
		String Text =driver.findElement(By.id("ac-title")).getText();
		System.out.println(Text);
		//Check for the value 5
		
		
		
		Actions Act2 = new Actions(driver);
		System.out.println("Clear the Input value using backspace");
		Act2.sendKeys(Keys.BACK_SPACE).build().perform();
		driver.switchTo().window(mainpage);
		//Step#3 - Enter the value 0 in Qty	
		inputvalue.sendKeys("0");
		//Check for the value 5 as it does not accept 0 value
		String ActualValue1 = inputvalue.getText();
		Assert.assertEquals(ActualValue1, "5", "Qty field is not taking the value 0");
		
		//Step#4 - Click on "+" button	
		driver.findElement(By.xpath("//*[@id=\"more-btn-productQty-6000188116061\"]")).click();
		String ActualValue2 = inputvalue.getText();
		Assert.assertEquals(ActualValue2, "6", "Qty field is not incrementing/Adding to the Existing value");
		
		//Step#5 - Click on "-" button
		driver.findElement(By.xpath("//*[@id=\"less-btn-productQty-6000188116061\"]")).click();
		String ActualValue3 = inputvalue.getText();
		Assert.assertEquals(ActualValue3, "5", "Qty field is not decrementing/Subtracting from the Existing value");
		
		//Step#6 - Enter the alphabet "s"
		Actions Act3 = new Actions(driver);
		System.out.println("Clear the Input value using backspace");
		Act3.sendKeys(Keys.BACK_SPACE).build().perform();
		driver.switchTo().window(mainpage);
		inputvalue.sendKeys("s");
		String ActualValue4 = inputvalue.getText();
		Assert.assertEquals(ActualValue4, "", "Qty field is not null");
		
		//Step#7 - Enter the alphabet "#"	
		inputvalue.sendKeys("#");
		String ActualValue5 = inputvalue.getText();
		Assert.assertEquals(ActualValue5, "", "Qty field is not null");
		
		driver.close();
		driver.quit();
	}
}
