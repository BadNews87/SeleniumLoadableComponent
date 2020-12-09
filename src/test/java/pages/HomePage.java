package pages;

import helpermethods.PageLoad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class HomePage extends LoadableComponent<HomePage> {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;		
	}
	
	@Override
	protected void isLoaded() throws Error {
		
		if(!PageLoad.myElementIsClickable(this.driver, By.xpath("//h2[text()='Account Services']"))) {
			throw new Error("HomePage was not successfully loaded");
		}
	}

	@Override
	protected void load() {		
	}
		
	public String getWelcomeString() {
		
		return driver.findElement(By.className("smallText")).getText();
	}
	
}