package irctc.pageFactoryObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;

import irctc.reusableComponents.ReusableComponents;

public class LandingPageFactory extends ReusableComponents {

	private WebDriver driver;
	
	public LandingPageFactory(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="a[aria-label='Click here to Login in application']")
	private WebElement btnLogin;
	
	@FindBy(css="input[formcontrolname='userid']")
	private WebElement txtUserName;
		
	@FindBy(css="input[formcontrolname='password']")
	private WebElement txtPassword;
	
	private By txtUserNameByLocator = By.cssSelector("input[formcontrolname='userid']");
	private By btnSearchByLocator = By.cssSelector(".train_Search_custom_hover");
	
	public void loadURL(String URL)
	{
		driver.get(URL);
	}
		
	public void loginToApplication(String userName, String password)
	{
		btnLogin.click();
		waitForLocatorToBeVisible(20, txtUserNameByLocator);
		txtUserName.clear();
		txtUserName.sendKeys(userName);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		System.out.println("Please enter CAPTCHA manually and click 'Sign In'. Waiting for login to complete...");
		waitForLocatorToBeInvisible(200, btnSearchByLocator);
	}
	
	
}
