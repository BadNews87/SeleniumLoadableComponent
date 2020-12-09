package pages;

import helpermethods.PageLoad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ErrorPage extends LoadableComponent<ErrorPage> {
	
	private WebDriver driver;
	
	public ErrorPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	@Override
	protected void isLoaded() throws Error {
		
		if(!PageLoad.myElementIsClickable(this.driver, By.className("error"))) {
			throw new Error("ErrorPage was not successfully loaded"); 
		}
	}

	@Override
	protected void load() {		
	}
	
	public String getErrorText() {
		
		return driver.findElement(By.className("error")).getText();
	}
}