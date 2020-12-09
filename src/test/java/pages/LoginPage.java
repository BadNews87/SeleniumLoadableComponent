package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import helpermethods.PageLoad;

public class LoginPage extends LoadableComponent<LoginPage> {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		driver.get("http://parabank.parasoft.com");
	}
	
	@Override
	protected void isLoaded() throws Error {
		
		if(!PageLoad.myElementIsClickable(this.driver, By.name("username"))) {
			throw new Error("LoginPage was not successfully loaded");
		}
	}

	@Override
	protected void load() {		
	}
	
	public ErrorPage incorrectLogin(String username, String password) {
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		return new ErrorPage(driver);
	}
	
	public HomePage correctLogin(String username, String password) {
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		return new HomePage(driver);
	}
	
	public FaultyHomePage anotherCorrectLogin(String username, String password) {
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		return new FaultyHomePage(driver);
	}
}