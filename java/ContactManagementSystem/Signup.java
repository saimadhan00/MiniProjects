package ContactManagementSystem;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import HerokuappPages.SignupPage;
@Listeners(ContactManagementSystem.Listner.class)


public class Signup {

	WebDriver driver;
	
	@Test(priority=1)// Verify sign-up with valid inputs
	public void SignupValid() throws InterruptedException {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		
		SignupPage sp=new SignupPage(driver);
		sp.getSignupButton().click();
		sp.getFirstName().sendKeys("Madhan");
		sp.getLastName().sendKeys("Kumar");
		sp.getEmail().sendKeys("saimadhan009@gmail.com");
		sp.getPassword().sendKeys("9688317700@ss");
		sp.getSubmit().click();
		Thread.sleep(3000);
		sp.getLogout().click();
		driver.navigate().refresh();
	}


	@Test (priority=2)//registration with already registered email
	public void registrationwithalreadyregisteredemail() throws InterruptedException, IOException {
		SignupPage sp=new SignupPage(driver);
		sp.getFirstName().sendKeys("Madhan");
		sp.getLastName().sendKeys("Kumar");
		sp.getEmail().sendKeys("saimadhan009@gmail.com");
		sp.getPassword().sendKeys("9688317700@ss");
		sp.getSubmit().click();
	
	TakesScreenshot shot= (TakesScreenshot) driver;
	File Source = shot.getScreenshotAs(OutputType.FILE);
	File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\SignupScreenshots\\alreadyRegisteredEmail.png");
	FileUtils.copyFile(Source, destination);	
			
	Thread.sleep(3000);
	driver.navigate().refresh();
	}   
	@Test (priority=3)//registration with blank fields
	public void registrationwithblankfields() throws InterruptedException {
	
		SignupPage sp=new SignupPage(driver);
		sp.getFirstName().sendKeys("Madhan");
		sp.getLastName().sendKeys("Kumar");
		sp.getEmail().sendKeys("");
		sp.getPassword().sendKeys("9688317700@ss");
		sp.getSubmit().click();

	    driver.navigate().refresh();
	}  
	@Test (priority=4)//password and confirm password mismatch
	public void passwordandconfirmpasswordmismatch() throws InterruptedException {
		
		SignupPage sp=new SignupPage(driver);
		sp.getFirstName().sendKeys("Madhan");
		sp.getLastName().sendKeys("Kumar");
		sp.getEmail().sendKeys("saimadhan009@gmail.com");
		sp.getPassword().sendKeys("(987654321");
		sp.getSubmit().click();
	Thread.sleep(3000);
	driver.navigate().refresh();
	}
	@Test (priority=5)//email format validation during sign-up
	public void emailformatvalidationduringsignup() throws InterruptedException {
	
		SignupPage sp=new SignupPage(driver);
		sp.getFirstName().sendKeys("Madhan");
		sp.getLastName().sendKeys("Kumar");
		sp.getEmail().sendKeys("saimadhan@#009@gmail.com");
		sp.getPassword().sendKeys("9688317700@ss");
		sp.getSubmit().click();
	} 
    }