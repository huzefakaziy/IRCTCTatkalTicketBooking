package irctc;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import irctc.pageFactoryObject.LandingPageFactory;
import irctc.testComponents.Base;

public class TicketBookingTest extends Base {
	
	@Test
	public void bookTicket() throws InterruptedException, IOException
	{		
		String username = "myUserName";
		String password = "MyPassword";
		String source = "PUNE JN - PUNE";
		String destination = "NAGPUR - NGP"; 
				
		//Login to application		
		landingPageFactory.loginToApplication(username, password);		
		System.out.println("Login completed");
	    
		driver.findElement(By.xpath("//p-autocomplete[@formcontrolname='origin']/span/input")).clear();
		driver.findElement(By.xpath("//p-autocomplete[@formcontrolname='origin']/span/input")).sendKeys(source);
		
		List<WebElement> elementListOrigin = driver.findElements(By.xpath("//p-autocomplete[@formcontrolname='origin']/span/div/ul/li/span"));
		
		for( WebElement ele :elementListOrigin)
		{
			if(ele.getText().contains(source))
			{
				ele.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//p-autocomplete[@formcontrolname='destination']/span/input")).clear();
		driver.findElement(By.xpath("//p-autocomplete[@formcontrolname='destination']/span/input")).sendKeys(destination);
		
		List<WebElement> elementListDestination = driver.findElements(By.xpath("//p-autocomplete[@formcontrolname='destination']/span/div/ul/li/span"));
		Thread.sleep(Duration.ofSeconds(1));
		for( WebElement ele :elementListDestination)
		{
			if(ele.getText().contains(destination))
			{
				ele.click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector("button[label='Find Trains']")).click();
	}

}
