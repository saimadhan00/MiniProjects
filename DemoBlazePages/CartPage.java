package DemoBlazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	ChromeDriver WebDriver;
	
	@FindBy(xpath="//a[@class='hrefch']")
	WebElement ProdouctClick;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-lg']")
	WebElement AddCartClick;
	
	@FindBy(xpath="//a[@id='cartur']")
	WebElement CartLoginpage;
	
	@FindBy(xpath=" //*[@id=\"tbodyid\"]/tr/td[4]/a")
	WebElement DeleteProduct;
	
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")
	WebElement ProdouctClick2;
	
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[5]/div/div/h4/a")
	WebElement ProdouctClick3;
	
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a")
	WebElement ProdouctClick4;

	
	@FindBy(xpath="//*[@id=\"navbarExample\"]/ul/li[1]/a")
	WebElement Homepage;

	

	private org.openqa.selenium.WebDriver driver;
	
	public CartPage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}

	public ChromeDriver getWebDriver() {
		return WebDriver;
	}

	public WebElement getProdouctClick() {
		return ProdouctClick;
	}

	public WebElement getAddCartClick() {
		return AddCartClick;
	}

	public WebElement getCartLoginpage() {
		return CartLoginpage;
	}

	public WebElement getDeleteProduct() {
		return DeleteProduct;
	}

	public WebElement getProdouctClick2() {
		return ProdouctClick2;
	}

	public WebElement getProdouctClick3() {
		return ProdouctClick3;
	}

	public WebElement getProdouctClick4() {
		return ProdouctClick4;
	}

	public WebElement getHomepage() {
		return Homepage;
	}

	public org.openqa.selenium.WebDriver getDriver() {
		return driver;
	}
	

}
