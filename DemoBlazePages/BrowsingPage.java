package DemoBlazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowsingPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"cat\"]")
	WebElement Categorieslaptop;
	
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[1]/div/a/img")
	WebElement ImageClick;
	
	@FindBy(xpath="//*[@id=\"navbarExample\"]/ul/li[1]/a")
	WebElement Homebar;
	
	@FindBy(xpath="//a[@id='cartur']")
	WebElement CartLoginpage;
	
	
	@FindBy(xpath="//*[@id=\"navbarExample\"]/ul/li[2]/a")
	WebElement ContactLoginpage;
	
	
  
	@FindBy(xpath="//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]")
	WebElement ContactClosenpage;
	
	public BrowsingPage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getCategorieslaptop() {
		return Categorieslaptop;
	}


	public WebElement getImageClick() {
		return ImageClick;
	}


	public WebElement getHomebar() {
		return Homebar;
	}


	public WebElement getCartLoginpage() {
		return CartLoginpage;
	}


	public WebElement getContactLoginpage() {
		return ContactLoginpage;
	}


	public WebElement getContactClosenpage() {
		return ContactClosenpage;
	}
	

}
