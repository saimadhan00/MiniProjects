package ContactManagementSystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import HerokuappPages.Loginpage;

public class ValidationAndSecurity {
	
	RemoteWebDriver driver;
	@Test(priority=1)
	public void MaximumCharcter() throws InterruptedException {
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		Loginpage Lp=new Loginpage(driver);
		Lp.getEmailIdField().sendKeys("saimadhan0009@gmail.com");
		Lp.getPasswordField().sendKeys("9688317700@ss");
		Lp.getSubmitBtnField().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='add-contact']")).click();
		
		String longFirstName = new String(new char[400]).replace('\0', 'a');
		WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstNameInput.clear();
		firstNameInput.sendKeys(longFirstName);
		System.out.println("Entered First Name length: " + longFirstName.length());
		driver.navigate().refresh();
		
	}
	@Test(priority=2)
	public void emojisCheck() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Madhan");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@id='birthdate']")).sendKeys("1997-08-05");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test123@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@id='street1']")).sendKeys("$%*&(*%^$#@%$^&%^^");
		driver.findElement(By.xpath("//input[@id='street2']")).sendKeys("!@#123445");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kumbakonam");
		driver.findElement(By.xpath("//input[@id='stateProvince']")).sendKeys("TamilNadu");
		driver.findElement(By.xpath("//input[@id='postalCode']")).sendKeys("612205");
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		driver.findElement(By.xpath("//button[@id='submit']")).click();	
		
	}

}
