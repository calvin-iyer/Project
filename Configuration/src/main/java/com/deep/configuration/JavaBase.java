/**
 * 
 */
package com.deep.configuration;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * @author DiptmanG
 *
 */
public class JavaBase {

	// initialize xpath and config properties

	public static Properties CONFIGPROP = null;
	public static Properties XPATHPROP = null;
	public static WebDriver driver = null;
	public static boolean isLoggedIn = false;

	public void Initialize() throws IOException {

		if (driver == null) {
			CONFIGPROP = new Properties();
			
			CONFIGPROP.load(JavaBase.class.getClassLoader().getResourceAsStream("config.properties"));

			XPATHPROP = new Properties();
			XPATHPROP.load(JavaBase.class.getClassLoader().getResourceAsStream(
					"xpath.properties"));
		}

		// initialize browser web driver

		if (CONFIGPROP.getProperty("Browser").equalsIgnoreCase("Mozilla"))
		{
			driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	else if (CONFIGPROP.getProperty("Browser").equalsIgnoreCase("Chrome"))
	{
		//System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		
		
		//System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C://Users//DiptmanGupta//Desktop//Practice//TestingProject//Configuration//ChromeDriver//chromedriver.exe");
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
		}
		// get object defination 
	public static WebElement getObject(String xpathKey) {
		try {
			return driver.findElement(By.xpath(XPATHPROP.getProperty(xpathKey)));
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	}