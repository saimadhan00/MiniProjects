package DemoBlazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement PlaceOrder;
	

	
	@FindBy(xpath="//input[@id='name']")
	WebElement Name;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement Country;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement City;
	
	@FindBy(xpath="//input[@id='card']")
	WebElement Card;
	
	@FindBy(xpath="//input[@id='month']")
	WebElement Month;
	
	@FindBy(xpath="//input[@id='year']")
	WebElement Year;

	@FindBy(xpath=" //*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
	WebElement Purchase;

	
	@FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']")
	WebElement PurchaseOk;
	
	@FindBy(xpath="//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")
	WebElement Closepage;
	
	public OrderPage(WebDriver driver1) {  
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPlaceOrder() {
		return PlaceOrder;
	}

	public WebElement getName() {
		return Name;
	}

	public WebElement getCountry() {
		return Country;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getCard() {
		return Card;
	}

	public WebElement getMonth() {
		return Month;
	}

	public WebElement getYear() {
		return Year;
	}

	public WebElement getPurchase() {
		return Purchase;
	}

	public WebElement getPurchaseOk() {
		return PurchaseOk;
	}
	public WebElement getClosepage() {
		return Closepage;
	}
	
}
