package ContactManagementSystem;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import HerokuappPages.AddContactPage;
import HerokuappPages.Loginpage;

public class AddContact{ 
	
	WebDriver driver;
	

	
	@Test(priority=1)
	@Parameters({"browser"})
	public void contactwithallvaliddetails() throws InterruptedException, IOException {
		
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		Loginpage Lp=new Loginpage(driver);
		Lp.getEmailIdField().sendKeys("saimadhan0009@gmail.com");
		Lp.getPasswordField().sendKeys("9688317700@ss");
		Lp.getSubmitBtnField().click();
		
		//driver.findElement(By.xpath("//button[@id='add-contact']")).click();
		
		AddContactPage ACP =new AddContactPage(driver);
		ACP.getAddcontact().click();
		ACP.getFirstNameField().sendKeys("Madhan");
		ACP.getLastNameField().sendKeys("Kumar");
		ACP.getBirthdateField().sendKeys("1997-08-05");
		ACP.getEmailField().sendKeys("test123@gmail.com");
		ACP.getPhoneField().sendKeys("987654321");
		ACP.getStreet1Field().sendKeys("Main Road");
		ACP.getStreet2Field().sendKeys("S.pudur");
		ACP.getCityField().sendKeys("Kumbakonam");
		ACP.getStateProvinceField().sendKeys("TamilNadu");
		ACP.getPostalCodeField().sendKeys("612205");
		ACP.getCountryField().sendKeys("India");
		ACP.getSubmitField().click();
		
		Thread.sleep(4000);
	
		
	    TakesScreenshot shot=  (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\AddContactScreenshots\\contactwithallvaliddetails.png");
		FileUtils.copyFile(source, destination);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		
	}
	@Test(priority=2)
  public void contactwithmissingrequiredfields() throws InterruptedException, IOException {
	  
 
		AddContactPage ACP =new AddContactPage(driver);
		ACP.getFirstNameField().sendKeys("Madhan");
		ACP.getLastNameField().sendKeys("Kumar");
		ACP.getBirthdateField().sendKeys("1997-08-05");
		ACP.getEmailField().sendKeys("test123@gmail.com");
		ACP.getPhoneField().sendKeys("987654321");
		ACP.getStreet1Field().sendKeys("Main Road");
		ACP.getStreet2Field().sendKeys("S.pudur");
		ACP.getCityField().sendKeys("Kumbakonam");
		ACP.getStateProvinceField().sendKeys("TamilNadu");
		ACP.getPostalCodeField().sendKeys("612205");
		ACP.getCountryField().sendKeys("India");
		ACP.getSubmitField().click();
	
	TakesScreenshot shot= (TakesScreenshot) driver;
	File source = shot.getScreenshotAs(OutputType.FILE);
	File desitnation=new File ("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\AddContactScreenshots\\Missing fields.png");
	FileUtils.copyDirectory(source, desitnation);
	driver.navigate().refresh();
	Thread.sleep(6000);

  }
	@Test(priority=3)
	public void phonefieldacceptsonlynumericinput() throws InterruptedException, IOException {
		
		AddContactPage ACP =new AddContactPage(driver);
		ACP.getFirstNameField().sendKeys("Madhan");
		ACP.getLastNameField().sendKeys("Kumar");
		ACP.getBirthdateField().sendKeys("1997-08-05");
		ACP.getEmailField().sendKeys("test123@gmail.com");
		ACP.getPhoneField().sendKeys("MadhN@#$%123");
		ACP.getStreet1Field().sendKeys("Main Road");
		ACP.getStreet2Field().sendKeys("S.pudur");
		ACP.getCityField().sendKeys("Kumbakonam");
		ACP.getStateProvinceField().sendKeys("TamilNadu");
		ACP.getPostalCodeField().sendKeys("612205");
		ACP.getCountryField().sendKeys("India");
		ACP.getSubmitField().click();
	
		TakesScreenshot shot=(TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File desination=new File ("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\AddContactScreenshots\\Numeric.png");
		FileUtils.copyFile(source, desination);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	@Test(priority=4)
	public void  addingduplicatecontactdetails() throws InterruptedException, IOException {
		
		AddContactPage ACP =new AddContactPage(driver);
		ACP.getFirstNameField().sendKeys("Madhan");
		ACP.getLastNameField().sendKeys("Kumar");
		ACP.getBirthdateField().sendKeys("1997-08-05");
		ACP.getEmailField().sendKeys("test123@gmail.com");
		ACP.getPhoneField().sendKeys("987654321");
		ACP.getStreet1Field().sendKeys("Main Road");
		ACP.getStreet2Field().sendKeys("S.pudur");
		ACP.getCityField().sendKeys("Kumbakonam");
		ACP.getStateProvinceField().sendKeys("TamilNadu");
		ACP.getPostalCodeField().sendKeys("612205");
		ACP.getCountryField().sendKeys("India");
		ACP.getSubmitField().click();
	
		
		TakesScreenshot shot= (TakesScreenshot)driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File desination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\AddContactScreenshots\\Duplicate.png");
		FileUtils.copyFile(source, desination);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
	}
	@Test(priority=5)
	public void  formresetsaftercontactisadded() throws InterruptedException, IOException {
		
		AddContactPage ACP =new AddContactPage(driver);
		ACP.getFirstNameField().sendKeys("Madhan");
		ACP.getLastNameField().sendKeys("Kumar");
		ACP.getBirthdateField().sendKeys("1997-08-05");
		ACP.getEmailField().sendKeys("test123@gmail.com");
		ACP.getPhoneField().sendKeys("987654321");
		ACP.getStreet1Field().sendKeys("Main Road");
		ACP.getStreet2Field().sendKeys("S.pudur");
		ACP.getCityField().sendKeys("Kumbakonam");
		ACP.getStateProvinceField().sendKeys("TamilNadu");
		ACP.getPostalCodeField().sendKeys("612205");
		ACP.getCountryField().sendKeys("India");
		ACP.getSubmitField().click();
		TakesScreenshot shot=(TakesScreenshot)driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File desination =new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\AddContactScreenshots\\Referesh.png");
		FileUtils.copyDirectory(source, desination);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='add-contact']")).click();

		
	}
}

