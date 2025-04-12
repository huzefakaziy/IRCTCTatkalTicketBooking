package irctc.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeMethod;

import irctc.pageFactoryObject.LandingPageFactory;


public class Base { 
	
	protected WebDriver driver;
	protected LandingPageFactory landingPageFactory;
	String url;
		
	public WebDriver getDriver() throws IOException
	{		
		FileInputStream fileInputStream = new FileInputStream(new File("src//main//java//irctc//resources//globalData.properties"));
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String browser = properties.getProperty("browser");
		int timeout = Integer.parseInt(properties.getProperty("timeout"));
		url = properties.getProperty("url");
		switch (browser)
		{
			case "chrome":
			{
				Map<String, Object> preferences = new HashMap<>();
				preferences.put("profile.default_content_setting_values.notifications", 2);		
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", preferences);
				options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
				options.addArguments("--incognito");
				options.addArguments("--disable-blink-features=AutomationControlled");
				driver = new ChromeDriver(options);
				break;
			}
			case "edge":
			{
				Map<String, Object> preferences = new HashMap<>();
				preferences.put("profile.default_content_setting_values.notifications", 2);		
				EdgeOptions options = new EdgeOptions();
				options.setExperimentalOption("prefs", preferences);
				options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
				options.addArguments("--incognito");
				options.addArguments("--disable-blink-features=AutomationControlled");
				driver = new EdgeDriver(options);
				break;
			}
		}		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));		
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void launchApplication() throws IOException
	{			
		landingPageFactory = new LandingPageFactory(getDriver());
		landingPageFactory.loadURL(url);
	}

}
