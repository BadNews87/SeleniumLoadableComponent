package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.*;

public class LoginTests {

	WebDriver driver;

	@BeforeMethod
	public void startBrowser() {

		System.setProperty("webdriver.gecko.driver", "/Volumes/Untitled/Projects/SeleniumLoadableComponent/geckodriver");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void validLoginTest() {

		// Load login page
		LoginPage loginPage = new LoginPage(driver).get();

		// Log in using valid credentials
		HomePage homePage = loginPage.correctLogin("john", "demo").get();

		// Load home page and check welcome text
		Assert.assertEquals("Welcome John Smith", homePage.getWelcomeString());
	}

	@Test
	public void invalidLoginTest() {

		// Load login page
		LoginPage loginPage = new LoginPage(driver).get();

		// Attempt to log in using invalid credentials
		ErrorPage errorPage = loginPage.incorrectLogin("john", "invalidpassword").get();

		// Load error page and check error text
		Assert.assertEquals("The username and password could not be verified.", errorPage.getErrorText());
	}

	@SuppressWarnings("unused")
	@Test
	public void loginTestWithError() {

		// Load login page
		LoginPage loginPage = new LoginPage(driver).get();

		// Log in using valid credentials, return a page that does not load correctly
		FaultyHomePage faultyHomePage = loginPage.anotherCorrectLogin("john", "demo").get();
	}

	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}

}
