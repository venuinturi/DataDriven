package com.w2a.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties or = new Properties();
	public static Properties Config = new Properties();
	public static WebDriver driver = null;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel;
	public static WebDriverWait wait;


	public static FileInputStream fis;

	@BeforeSuite
	public void setup() throws IOException {

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Or.properties");
		or.load(fis);
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");

		Config.load(fis);
		log.debug("config file loaded!!!!!");

		if (Config.get("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.debug("Chrome Launched!!!!!");

		} else if (Config.get("browser").equals("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.debug("firefox Launched!!!!!");
		} else if (Config.get("browser").equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.debug("Efge Launched!!!!!");
		}

		driver.get(Config.getProperty("baseurl"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 4);
	}

	
	public boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e) {
		return false;
		}
	}
	
	
	
	@AfterSuite
	public void TearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		log.debug("Quitting browser");
	}
}
