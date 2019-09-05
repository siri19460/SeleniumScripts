package keywordDrivenFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Methods {
	static WebDriver driver;

	public static void openBrowser() {
		driver = new ChromeDriver();

	}

	public static void maximizeBrowser() {
		driver.manage().window().maximize();

	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static void navigateToApplication(String url) {

		driver.get(url);
	}

	public static void enterUserId(String loc, String locvalue, String userId) {
		if (loc.equals("id")) {
			driver.findElement(By.id(locvalue)).sendKeys(userId);

		} else if (loc.equals("name")) {
			driver.findElement(By.name(locvalue)).sendKeys(userId);

		}
	}

	public static void enterPassword(String loc, String locvalue, String userId) {
		if (loc.equals("id")) {

			driver.findElement(By.id(locvalue)).sendKeys(userId);
		} else if (loc.equals("name")) {
			driver.findElement(By.name(locvalue)).click();
		}

	}

	public static void clickLoginButton(String loc, String locvalue) {
		if (loc.equals("id")) {
			driver.findElement(By.id(locvalue)).click();
		} else if (loc.equals("name")) {
			driver.findElement(By.name(locvalue)).click();
		}

	}

	public static String VerifyErrMsg(String locvalue) {

		String actualMsg = driver.findElement(By.cssSelector(locvalue)).getText();
		return actualMsg;
	}

	public static void closeApplication() {
		driver.close();
	}

}
