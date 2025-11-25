package DemoBlazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='login2']")
	WebElement LoginButton1;
	
	@FindBy (xpath="//input[@id=\"loginusername\"]")
	WebElement UserName;
	
	@FindBy (xpath="//input[@id=\"loginpassword\"]")
	WebElement Userpassword;
	
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
	WebElement LoginButton2;
	
	@FindBy(xpath="//a[@id='logout2']")
	WebElement LogoutButton;
	
	@FindBy(xpath="//a[@id='login2']")
	WebElement LoginButton3;
	
	public LoginPage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);

		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLoginButton1() {
		return LoginButton1;
	}

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getUserpassword() {
		return Userpassword;
	}

	public WebElement getLoginButton2() {
		return LoginButton2;
	}

	public WebElement getLogoutButton() {
		return LogoutButton;
	}

	public WebElement getLoginButton3() {
		return LoginButton3;
	}
	

}
