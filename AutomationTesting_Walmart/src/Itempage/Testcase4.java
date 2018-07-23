package Itempage;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
@Test
public class Testcase4 {

	public void tc4() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/srava/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
	  	// Maximize browser		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Step#1 - Navigate to https://www.walmart.ca/en/ip/oaty-chomps-blueberry-carrot/6000188116060
		driver.get("https://www.walmart.ca/en/ip/oaty-chomps-blueberry-carrot/6000188116060");
		
		//Scroll down using Javascript
				JavascriptExecutor je = (JavascriptExecutor) driver;
				je.executeScript("window.scrollBy(0,450)",  ""); 
				System.out.println("***********Page Scrolled down****************");
				Reporter.log("***********Page Scrolled down****************");
				
		
		//Step#2 - Click on the button "Pickup"
		driver.findElement(By.id("pf-tab-pickup")).click();
		
		driver.findElement(By.id("tab-fulfillment-pickup")).isSelected();
		
		List<WebElement> allHeadersOfTable= driver.findElements(By.xpath("//table[@id=\"tab-fulfillment-pickup\"]/thead/tr/th"));
		System.out.println("Headers in table are below:");
		System.out.println("Total headers found: "+allHeadersOfTable.size());
		for(WebElement header:allHeadersOfTable)
		{
			System.out.println(header.getText());
		}
			//*WebElement ActualValue = driver.findElement(By.xpath("//*[@id=\"tab-fulfillment-pickup\"]/thead/tr/th[1]"));
			//String ActualCellValue = ActualValue.getText();
		String txt1 = driver.findElement(By.xpath("//*[@id=\"tab-fulfillment-pickup\"]/thead/tr/th[1]")).getText();
		Assert.assertEquals(txt1, "Where can you get it?" , "Heading not displayed on the window Pickup");
		
		//Step#3 - Click on button "Shipping"
		driver.findElement(By.id("pf-tab-shipping")).click();
		
		List<WebElement> allHeadersOfTable1= driver.findElements(By.xpath("//table[@id=\"tab-fulfillment-shipping\"]/thead/tr/th"));
		System.out.println("Headers in table are below:");
		System.out.println("Total headers found: "+allHeadersOfTable1.size());
		for(WebElement header:allHeadersOfTable1)
		{
			System.out.println(header.getText());
		}
		String txt2 = driver.findElement(By.xpath("//*[@id=\"tab-fulfillment-shipping\"]/thead/tr/th[1]")).getText();
		Assert.assertEquals(txt2, "How can you get it?" , "Heading not displayed on the window Shipping");
		
		//Step#4 - Click on button "Buy-in-Store"
		driver.findElement(By.id("pf-tab-store-avail")).click();
		
		List<WebElement> allHeadersOfTable2= driver.findElements(By.xpath("//table[@id=\"tab-fulfillment-store-availability\"]/thead/tr/th"));
		System.out.println("Headers in table are below:");
		System.out.println("Total headers found: "+allHeadersOfTable2.size());
		for(WebElement header:allHeadersOfTable2)
		{
			System.out.println(header.getText());
		}
		String txt3 = driver.findElement(By.xpath("//*[@id=\"tab-fulfillment-store-availability\"]/thead/tr/th[1]")).getText();
		Assert.assertEquals(txt3, "Where can you get it?" , "Heading not displayed on the window Buy-In Store");
		
		
		driver.close();
		driver.quit();
	}
}
