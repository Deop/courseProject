package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Label extends BaseElement {

	public Label(final By locator, final String name) {
		super(locator, name);
	}

	public Label(String string, String name) {
		super(string, name);
	}

	

	public Label(By locator) {
		super(locator);
	}

	protected String getElementType() {
		return getLoc("loc.label");
	}

	public String getText(){
		waitForIsElementPresent();
		if (browser.getDriver() instanceof JavascriptExecutor) {
			((JavascriptExecutor)browser.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
		}
		return element.getText();
	}

}
