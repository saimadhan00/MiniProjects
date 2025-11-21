package ContactManagementSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public void SignupValid() throws InterruptedException, IOException {
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);
		
		DataFormatter format = new DataFormatter();
		String FirstName = format.formatCellValue(row.getCell(0));
		String LastName = format.formatCellValue(row.getCell(1));
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));

		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		
	
		SignupPage sp=new SignupPage(driver);
		sp.getSignupButton().click();
		sp.getFirstName().sendKeys(FirstName);
		sp.getLastName().sendKeys(LastName);
		sp.getEmail().sendKeys(Email);
		sp.getPassword().sendKeys(Password);
		sp.getSubmit().click();
		Thread.sleep(3000);
		sp.getLogout().click();
		driver.navigate().refresh();
		wb.close();
		fis.close();
	}


	@Test (priority=2)//registration with already registered email
	public void registrationwithalreadyregisteredemail() throws InterruptedException, IOException {
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(2);
		
		DataFormatter format = new DataFormatter();
		String FirstName = format.formatCellValue(row.getCell(0));
		String LastName = format.formatCellValue(row.getCell(1));
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));
		
		
		SignupPage sp=new SignupPage(driver);
		sp.getFirstName().sendKeys(FirstName);
		sp.getLastName().sendKeys(LastName);
		sp.getEmail().sendKeys(Email);
		sp.getPassword().sendKeys(Password);
		sp.getSubmit().click();
	
	TakesScreenshot shot= (TakesScreenshot) driver;
	File Source = shot.getScreenshotAs(OutputType.FILE);
	File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\SignupScreenshots\\alreadyRegisteredEmail.png");
	FileUtils.copyFile(Source, destination);	
			
	Thread.sleep(3000);
	driver.navigate().refresh();
	wb.close();
	fis.close();
	}   
	@Test (priority=3)//registration with blank fields
	public void registrationwithblankfields() throws InterruptedException, IOException {
	
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(3);
		
		DataFormatter format = new DataFormatter();
		String FirstName = format.formatCellValue(row.getCell(0));
		String LastName = format.formatCellValue(row.getCell(1));
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));
		

		SignupPage sp=new SignupPage(driver);
		sp.getFirstName().sendKeys(FirstName);
		sp.getLastName().sendKeys(LastName);
		sp.getEmail().sendKeys(Email);
		sp.getPassword().sendKeys(Password);
		sp.getSubmit().click();

	    driver.navigate().refresh();
	    wb.close();
	    fis.close();
	}  
	@Test (priority=4)//password and confirm password mismatch
	public void passwordandconfirmpasswordmismatch() throws InterruptedException, IOException {
		
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(4);
		
		DataFormatter format = new DataFormatter();
		String FirstName = format.formatCellValue(row.getCell(0));
		String LastName = format.formatCellValue(row.getCell(1));
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));
				
		SignupPage sp=new SignupPage(driver);
		sp.getFirstName().sendKeys(FirstName);
		sp.getLastName().sendKeys(LastName);
		sp.getEmail().sendKeys(Email);
		sp.getPassword().sendKeys(Password);
		sp.getSubmit().click();
		
	Thread.sleep(3000);
	driver.navigate().refresh();
	wb.close();
	fis.close();
	}
	@Test (priority=5)//email format validation during sign-up
	public void emailformatvalidationduringsignup() throws InterruptedException, IOException {
	
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(5);
		
		DataFormatter format = new DataFormatter();
		String FirstName = format.formatCellValue(row.getCell(0));
		String LastName = format.formatCellValue(row.getCell(1));
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));
				
		SignupPage sp=new SignupPage(driver);
		sp.getFirstName().sendKeys(FirstName);
		sp.getLastName().sendKeys(LastName);
		sp.getEmail().sendKeys(Email);
		sp.getPassword().sendKeys(Password);
		sp.getSubmit().click();
		wb.close();
		fis.close();
	} 
    }