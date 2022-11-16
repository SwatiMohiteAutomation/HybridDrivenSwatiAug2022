package testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import base.PredefinedActions;
import pages.LoginPage;

public class LoginTest {

	@Test(dataProvider = "LoginDataProvider")
	public void tc1(String url, String uname, String password, boolean isLoginsuccessful) {

		System.out.println("STEP - Launch Chrome Browser & Hit url");
		PredefinedActions.start("https://smohite-trials77.orangehrmlive.com/");

		System.out.println("STEP - Enter valid login credentials");
		LoginPage loginPage = new LoginPage();
		loginPage.login(uname, password);

		if (isLoginsuccessful) {
			System.out.println("VERIFY - home page is displayed");
			String expetedTitle = "Employee Management";
			String actualTitle = loginPage.getPageTitle();

			Assert.assertEquals(actualTitle, expetedTitle,
					"Expected title was " + expetedTitle + " but actual title was " + actualTitle);
		} else {

			System.out.println("VERIFY - home page is displayed");
			String expetedTitle = "OrangeHRM";
			String actualTitle = loginPage.getPageTitle();
			Assert.assertEquals(actualTitle, expetedTitle,
					"Expected title was " + expetedTitle + " but actual title was " + actualTitle);

			System.out.println("VERIFY - Retry loginpage is loaded");
			String expectedUrlContent = "retryLogin";
			String actualCurrentUrl = loginPage.getPageURL();
			Assert.assertTrue(actualCurrentUrl.endsWith(expectedUrlContent));

		}

		System.out.println("Clean up - Close browser");
		PredefinedActions.closeBrowser();
	}

	@DataProvider(name = "LoginDataProvider")
	public Object[][] getLoginData() {
		Object[][] data = new Object[2][4];
		data[0][0] = "https://smohite-trials77.orangehrmlive.com/";
		data[0][1] = "Admin";
		data[0][2] = "YK3bM@lgD0";
		data[0][3] = true;

		data[1][0] = "https://smohite-trials77.orangehrmlive.com/";
		data[1][1] = "Admin";
		data[1][2] = "YK3bM@lgD011";
		data[1][3] = false;

		return data;
	}

	@Test
	public void tc1_Negative() {
	
		System.out.println("STEP - Launch Chrome Browser & Hit url");
		PredefinedActions.start("https://smohite-trials77.orangehrmlive.com/");

			System.out.println("STEP - Enter valid login credentials");
			LoginPage loginPage = new LoginPage();
			loginPage.login("Admin", "YK3bM@lgD011");
			

			System.out.println("VERIFY - home page is displayed");
			String expetedTitle = "OrangeHRM";
			String actualTitle = loginPage.getPageTitle();

			Assert.assertEquals(actualTitle, expetedTitle, "Expected title was " + expetedTitle + " but actual title was " + actualTitle);

			System.out.println("VERIFY - Retry loginpage is loaded");
		String expectedUrlContent ="retryLogin";
			String actualCurrentUrl = loginPage.getPageURL();
			Assert.assertTrue(actualCurrentUrl.endsWith(expectedUrlContent));
			
			System.out.println("Clean up - Close browser");
			PredefinedActions.closeBrowser();
		}
}
