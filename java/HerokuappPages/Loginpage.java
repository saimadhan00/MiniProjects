package HerokuappPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id=\"email\"]")
	WebElement EmailIdField;
	
	@FindBy (xpath="//input[@id=\"password\"]")
	WebElement passwordfield;
	
	@FindBy(xpath = "//button[@id=\"submit\"]")
	WebElement SubmitBtnField;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEmailIdField() {
		return EmailIdField;
	}

	public WebElement getPasswordField() {
		return passwordfield;
	}

	public WebElement getSubmitBtnField() {
		return SubmitBtnField;
	}
	
	public Loginpage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}

}
