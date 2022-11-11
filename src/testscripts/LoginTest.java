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

	public void tc1() {
		
			System.out.println("STEP - Launch Chrome Browser & Hit url");
			PredefinedActions.start("smohite-trials77.orangehrmlive.com");

			System.out.println("STEP - Enter valid login credentials");
			LoginPage loginPage = new LoginPage();
			loginPage.login("admin", "YK3bM@lgD0");
			

			System.out.println("VERIFY - home page is displayed");
			String expetedTitle = "Employee Management";
			
			String actualTitle = loginPage.getPageTitle();

			Assert.assertEquals(actualTitle, expetedTitle, "Expected title was " + expetedTitle + " but actual title was " + actualTitle);

			System.out.println("VERIFY - Retry login page is loaded");
			String expectedUrlContent = "retryLogin";
			String actualCurrentURL = loginPage.getPageURL();
			Assert.assertTrue(actualCurrentURL.endsWith(expectedUrlContent));

			System.out.println("Clean up - Close browser");
			PredefinedActions.closeBrowser();
		}
	}


