package helpermethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class PageLoad {
	
	public static boolean myElementIsClickable (WebDriver driver, By by) {
		
		try
        {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
    }
        catch (WebDriverException ex)
        {
            return false;
        }
        return true;		
	}
}
