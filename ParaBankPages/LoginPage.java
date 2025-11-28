package ParaBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]/p[2]/a")
	WebElement RegisterButton;
	
	@FindBy(xpath="//input[@id='customer.firstName']")
	WebElement FirstName ;
	
	@FindBy(xpath="//input[@id='customer.lastName']")
	WebElement LastName ;
	
	@FindBy(xpath="//input[@id='customer.address.street']")
	WebElement  Address;
	
	@FindBy(xpath="//input[@id='customer.address.city']")
	WebElement City;
	
	@FindBy(xpath="//input[@id='customer.address.state']")
	WebElement State;
	
	
	@FindBy(xpath="//input[@id='customer.address.zipCode']")
	WebElement  ZipCode;
	
	@FindBy(xpath="//input[@id='customer.phoneNumber']")
	WebElement  PhoneNumber;
	
	@FindBy(xpath="//input[@id='customer.ssn']")
	WebElement SSN;
	
	@FindBy(xpath="//input[@id='customer.username']")
	WebElement  UserName;
	
	@FindBy(xpath="//input[@id='customer.password']")
	WebElement  PassWord;
	
	@FindBy(xpath="//input[@id='repeatedPassword']")
	WebElement  ConfirmPassword;
	
	@FindBy(xpath="//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
	WebElement RegisterButton2;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement UsernameButton;
	
	
	@FindBy(xpath="//input[@name='password']")
	WebElement PasswordButton;
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]/form/div[3]/input")
	WebElement LoginButton;
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[8]/a")
	WebElement LogoutButton;
	
	  public LoginPage(WebDriver driver1) {
			this.driver=driver1;
			PageFactory.initElements(driver, this);
  }


	  public WebDriver getDriver() {
		  return driver;
	  }


	  public WebElement getRegisterButton() {
		  return RegisterButton;
	  }


	  public WebElement getFirstName() {
		  return FirstName;
	  }


	  public WebElement getLastName() {
		  return LastName;
	  }


	  public WebElement getAddress() {
		  return Address;
	  }


	  public WebElement getCity() {
		  return City;
	  }


	  public WebElement getPhoneNumber() {
		  return PhoneNumber;
	  }



	  public WebElement getSSN() {
		return SSN;
	}


	  public WebElement getUserName() {
		  return UserName;
	  }


	  public WebElement getPassWord() {
		  return PassWord;
	  }


	  public WebElement getConfirmPassword() {
		  return ConfirmPassword;
	  }


	  public WebElement getRegisterButton2() {
		  return RegisterButton2;
	  }


	  public WebElement getState() {
		  return State;
	  }


	  public WebElement getZipCode() {
		  return ZipCode;
	  }


	  public WebElement getUsernameButton() {
		  return UsernameButton;
	  }


	  public WebElement getPasswordButton() {
		  return PasswordButton;
	  }


	  public WebElement getLoginButton() {
		  return LoginButton;
	  }


	  public WebElement getLogoutButton() {
		  return LogoutButton;
	  }
	  
}
