package Itempage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Testcase7 {
	public void Tc7() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/srava/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
	  	// Maximize browser		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Step#1 - Navigate to https://www.walmart.ca/en/ip/oaty-chomps-blueberry-carrot/6000188116060
		driver.get("https://www.walmart.ca/en/ip/oaty-chomps-blueberry-carrot/6000188116060");
	
		//QTY field
		WebElement inputvalue = driver.findElement(By.cssSelector("input.qty-input"));
		inputvalue.clear();
		//Clear the value in QTY
		String mainpage = driver.getWindowHandle();
		Actions Act1 = new Actions(driver);
		System.out.println("Clear the Input value using backspace");
		Act1.sendKeys(Keys.BACK_SPACE).build().perform();
		driver.switchTo().window(mainpage);
		//Step#2 - Enter the value in QTY "4"
		inputvalue.sendKeys("4");
		
		//Step#3 - Click on the Radiobutton "Subscribe  to Autosave and receive 5%off"
		driver.findElement(By.xpath("//*[@id=\"og-on-pdp-6000188116061\"]")).click();
		
		//Step#4 - Select from dropdown "Deliver every" to 6months
		Select Slt = new Select(driver.findElement(By.name("frequency")));
		Slt.selectByIndex(8);
		
		//Step#5 - Click on the button "Add to Cart"	
		driver.findElement(By.xpath("//*[@id=\"favourite-a2c-container\"]/div[2]/button")).click();
		
		//Step#5 - Check for the Radiobutton  "Subscribe  to Autosave and receive 5%off" 
		boolean chk = driver.findElement(By.xpath("//*[@id=\"og-on-cart_modal-6000188116061\"]")).isSelected();
		Assert.assertTrue(chk, "Radiobutton is not selected");
		
		WebElement selecttxt = Slt.getFirstSelectedOption();
		String Actual = selecttxt.getText();
		System.out.print(Actual);
		Assert.assertEquals(Actual, "6 months");
		
		driver.close();
		driver.quit();
	}

}
