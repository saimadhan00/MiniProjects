package DemoBlazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	 WebDriver   driver;
	
	@FindBy(xpath=" //*[@id=\"signin2\"]")
	WebElement  SignupButton ;
	
	@FindBy (xpath="//input[@id='sign-username']")
	WebElement UserName;
	
	@FindBy (xpath="//input[@id='sign-password']")
	WebElement Userpassword;
	
	@FindBy (xpath="  //button[text()='Sign up']")
	WebElement Signupclick;
	
	
	public SignUpPage(WebDriver driver1) {
	     this.driver=driver1;
		PageFactory.initElements(driver, this);
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSignupButton() {
		return SignupButton;
	}

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getUserpassword() {
		return Userpassword;
	}

	public WebElement getSignupclick() {
		return Signupclick;
	}

}
