package ContactManagementSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import HerokuappPages.Loginpage;

@Listeners(ContactManagementSystem.Listner.class)

public class Login implements ITestListener {
	
	WebDriver driver;
	
	@Test(priority=1)
	public void loginScenarios() throws IOException, InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");

		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);
		
		DataFormatter format = new DataFormatter();
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));

		Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys(Email);
		LP.getPasswordField().sendKeys(Password);
		LP.getSubmitBtnField().click();
		
		TakesScreenshot shot = (TakesScreenshot) driver;
		File Source = shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\LoginScreenshots.png");
		FileUtils.copyFile(Source, destination);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id=\"logout\"]")).click();
		wb.close();
		fis.close();
	
	}
	@Test(priority=2)
	public void  incorrectpassword() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(4);
		
		DataFormatter format = new DataFormatter();
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));

		Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys(Email);
		LP.getPasswordField().sendKeys(Password);
		LP.getSubmitBtnField().click();
		TakesScreenshot shot = (TakesScreenshot) driver;
		File Source = shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\incorrectpasswordScreenshots.png");
		FileUtils.copyFile(Source, destination);
		Thread.sleep(3000);
		driver.navigate().refresh();
		wb.close();
		fis.close();
		
	}
	@Test(priority=3)
	public void loginwithemptyfields() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(6);
		
		DataFormatter format = new DataFormatter();
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));
		Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys(Email);
		LP.getPasswordField().sendKeys(Password);
		LP.getSubmitBtnField().click();
		
		TakesScreenshot shot = (TakesScreenshot) driver;
		File Source = shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\EmptyScreenshots.png");
		FileUtils.copyFile(Source, destination);
		Thread.sleep(3000);
		driver.navigate().refresh();
		wb.close();
		fis.close();
	}
	@Test(priority=4)
public void  loginwithinvalidemailformat() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(5);
		
		DataFormatter format = new DataFormatter();
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));
		Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys(Email);
		LP.getPasswordField().sendKeys(Password);
		LP.getSubmitBtnField().click();
		TakesScreenshot shot = (TakesScreenshot) driver;
		File Source = shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\invalidformatScreenshots.png");
		FileUtils.copyFile(Source, destination);
		Thread.sleep(3000);
		driver.navigate().refresh();
		wb.close();
		fis.close();
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

	

