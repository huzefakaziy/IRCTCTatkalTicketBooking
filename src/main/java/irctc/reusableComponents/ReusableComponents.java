package irctc.reusableComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents {
	WebDriverWait wait;
	WebDriver driver;
	
	public ReusableComponents(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitForLocatorToBeVisible(int waitDuration, By byLocator)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	public void waitForWebElementToBeVisible(int waitDuration, WebElement webElement)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void waitForLocatorToBeInvisible(int waitDuration, By byLocator)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	public void waitWebElementToBeInvisible(int waitDuration, WebElement webElement)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
		wait.until(ExpectedConditions.invisibilityOf(webElement));
	}
	 
}
