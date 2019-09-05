package keywordDrivenFramework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {

	@Test
	public void verifyInvalidlogintest() throws IOException {
		String[][] data = GenericMethods.getData("C:\\Sridevi Personal\\selenium Meghana\\TestData.xlsx", "Sheet2");
		for (int i = 1; i < data.length; i++) {

			switch (data[i][3]) {
			case "OpenBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowser();
				break;
			case "impWait":
				Methods.implicitWait();
				break;			
				case "navToAUT":
				Methods.navigateToApplication(data[i][6]);
				break;
			case "enterUserId":
				Methods.enterUserId(data[i][4],data[i][5],data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4],data[i][5],data[i][6]);
				break;	
			case "ClickLogin":
				Methods.clickLoginButton(data[i][4],data[i][5]);
				break;
			case"VerifyErrMsg":
			String actualMsg =	Methods.VerifyErrMsg(data[i][5]);
			Assert.assertEquals(actualMsg, data[i][6]);
			break;
			case "CloseApplication":
				Methods.closeApplication();
				break;
				

			}
		}
	}

}
