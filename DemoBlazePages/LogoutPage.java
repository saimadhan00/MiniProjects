package DemoBlazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	
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
	
	

}
