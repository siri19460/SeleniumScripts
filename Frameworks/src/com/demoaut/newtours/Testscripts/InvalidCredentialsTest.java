package com.demoaut.newtours.Testscripts;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.demoaut.newtours.Pages.Login;
import com.demoaut.newtours.Pages.SignOn;

import utils.GenericMethods;

public class InvalidCredentialsTest {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser) {
		if(browser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.geckodriver.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void applicationInvalidLogin() throws IOException {
		Login lp = new Login(driver);
		SignOn so = new SignOn(driver);

		String[][] data = GenericMethods.getData("C:\\Sridevi Personal\\selenium Meghana\\TestData.xlsx", "Sheet1");

		for (int i = 1; i < data.length; i++) {

			lp.applicationLogin(data[i][0], data[i][1]);
			String expectedMsg = so.getErrMsg();
			System.out.println(expectedMsg);
			String actualMsg = "Welcome back to Mercury Tours! Enter your user information to access the member-only areas of this site. If you don't have a log-in, please fill out the registration form.";
			Assert.assertEquals(actualMsg, expectedMsg);
			driver.navigate().back();
		}

	}

	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}
	

}
