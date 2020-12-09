package pages;

import helpermethods.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaultyHomePage extends CustomLoadableComponent<FaultyHomePage> {
	
	private WebDriver driver;
	
	public FaultyHomePage(WebDriver driver) {
		
		this.driver = driver;		
	}
	
	@Override
	protected void isLoaded() throws Error {
		
		if(!PageLoad.myElementIsClickable(this.driver, By.id("thiselementdoesnotexist"))) {
			throw new Error("FaultyHomePage was not successfully loaded");
		}
	}

	@Override
	protected void load() {		
	}
}