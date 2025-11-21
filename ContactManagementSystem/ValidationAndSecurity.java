package ContactManagementSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import HerokuappPages.AddContactPage;
import HerokuappPages.Loginpage;
@Listeners(ContactManagementSystem.Listner.class)

public class ValidationAndSecurity {
	
	RemoteWebDriver driver;
	@Test(priority=1)
	public void MaximumCharcter() throws InterruptedException, IOException {
		
		driver =new ChromeDriver();
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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='add-contact']")).click();
		
		String longFirstName = new String(new char[400]).replace('\0', 'a');
		WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstNameInput.clear();
		firstNameInput.sendKeys(longFirstName);
		System.out.println("Entered First Name length: " + longFirstName.length());
		driver.navigate().refresh();
		wb.close();
		fis.close();
		
	}
	@Test(priority=2)
	public void emojisCheck() throws InterruptedException, IOException {

		
		File f4=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis4=new FileInputStream(f4);
		XSSFWorkbook wb4 = new XSSFWorkbook(fis4);
		XSSFSheet sheetAt4 = wb4.getSheetAt(3);
		XSSFRow row4= sheetAt4.getRow(1);
		
		DataFormatter format2 = new DataFormatter();
		String FirstName = format2.formatCellValue(row4.getCell(0)); 
		String LastName = format2.formatCellValue(row4.getCell(1));
		String DateofBirth = format2.formatCellValue(row4.getCell(2));
		String Email2= format2.formatCellValue(row4.getCell(3));
		String Phone= format2.formatCellValue(row4.getCell(4));
		String StreetAddress1= format2.formatCellValue(row4.getCell(5));
		String StreetAddress2= format2.formatCellValue(row4.getCell(6));
		String City= format2.formatCellValue(row4.getCell(7));
		String StateOfProvince = format2.formatCellValue(row4.getCell(8));
		String PostalCode= format2.formatCellValue(row4.getCell(9));
		String Country= format2.formatCellValue(row4.getCell(10));

		
		AddContactPage ACP =new AddContactPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		ACP.getFirstNameField().sendKeys(FirstName);
		ACP.getLastNameField().sendKeys(LastName);
		ACP.getBirthdateField().sendKeys(DateofBirth);
		ACP.getEmailField().sendKeys(Email2);
		ACP.getPhoneField().sendKeys(Phone);
		ACP.getStreet1Field().sendKeys(StreetAddress1);
		ACP.getStreet2Field().sendKeys(StreetAddress2);
		ACP.getCityField().sendKeys(City);
		ACP.getStateProvinceField().sendKeys(StateOfProvince);
		ACP.getPostalCodeField().sendKeys(PostalCode);
		ACP.getCountryField().sendKeys(Country);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ACP.getSubmitField().click();
		Thread.sleep(2000);
       driver.navigate().refresh();
       Thread.sleep(3000);
       wb4.close();
       fis4.close();
       driver.close();
	
	}

}
