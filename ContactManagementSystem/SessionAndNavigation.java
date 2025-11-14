package ContactManagementSystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import HerokuappPages.Loginpage;

public class SessionAndNavigation {
	
	WebDriver driver;
	@Test(priority=1)
	public void loginpagetoLogout () throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		Loginpage Lp=new Loginpage(driver);
		Lp.getEmailIdField().sendKeys("saimadhan0009@gmail.com");
		Lp.getPasswordField().sendKeys("9688317700@ss");
		Lp.getSubmitBtnField().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='logout']")).click();
		Thread.sleep(3000);
		
	}
	@Test(priority=2)
	public void Refersh() throws InterruptedException {
		Loginpage Lp=new Loginpage(driver);
		Lp.getEmailIdField().sendKeys("saimadhan0009@gmail.com");
		Lp.getPasswordField().sendKeys("9688317700@ss");
		Lp.getSubmitBtnField().click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
	}
	
	@Test(priority=3)
	public void verifyUrl () throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(3000);
		driver.get("https://thinking-tester-contact-list.herokuapp.com/contactList");
		driver.navigate().refresh();
		Thread.sleep(3000);

	}
	@Test(priority=4)
	public void verifyBack () throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='logout']")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		
	}	

}
