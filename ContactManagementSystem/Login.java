package ContactManagementSystem;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestListener;

import org.testng.annotations.Test;

import HerokuappPages.Loginpage;


public class Login implements ITestListener {
	
	WebDriver driver;
	
	@Test(priority=1)
	public void loginScenarios() throws IOException, InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");

		Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys("saimadhan009@gmail.com");
		LP.getPasswordField().sendKeys("9688317700@ss");
		LP.getSubmitBtnField().click();
		
		TakesScreenshot shot = (TakesScreenshot) driver;
		File Source = shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\LoginScreenshots.png");
		FileUtils.copyFile(Source, destination);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id=\"logout\"]")).click();
	
	}
	@Test(priority=2)
	public void  incorrectpassword() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("saimadhan0009@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("0000000000");
		driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
		
		TakesScreenshot shot = (TakesScreenshot) driver;
		File Source = shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\incorrectpasswordScreenshots.png");
		FileUtils.copyFile(Source, destination);
		Thread.sleep(3000);
		driver.navigate().refresh();
		
	}
	@Test(priority=3)
	public void loginwithemptyfields() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
		
		TakesScreenshot shot = (TakesScreenshot) driver;
		File Source = shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\EmptyScreenshots.png");
		FileUtils.copyFile(Source, destination);
		Thread.sleep(3000);
		driver.navigate().refresh();	
	}
	@Test(priority=4)
public void  loginwithinvalidemailformat() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("!@#$.com");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
		
		TakesScreenshot shot = (TakesScreenshot) driver;
		File Source = shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\invalidformatScreenshots.png");
		FileUtils.copyFile(Source, destination);
		Thread.sleep(3000);
		driver.navigate().refresh();	
	}
	
	@Test(priority=5)
	public void PasswordMaskCheck () throws IOException{
	    
	        // Locate the password field (change locator as needed)
	        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));

	        // Verify the type attribute is 'password' (masked)
	        String fieldType = passwordField.getAttribute("type");
	        if (fieldType.equals("password")) {
	            System.out.println("Password field is masked.");
	        } else {
	            System.out.println("Password field is NOT masked!");
	        }

	        TakesScreenshot shot = (TakesScreenshot) driver;
			File Source = shot.getScreenshotAs(OutputType.FILE);
			File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\MaskedScreenshots.png");
			FileUtils.copyFile(Source, destination);
	    }
	
	
	}

	

