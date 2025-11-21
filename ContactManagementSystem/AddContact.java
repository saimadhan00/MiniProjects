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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import HerokuappPages.AddContactPage;
import HerokuappPages.Loginpage;
@Listeners(ContactManagementSystem.Listner.class)

public class AddContact{ 
	
	WebDriver driver;
	@Test(priority=1)
	@Parameters({"browser"})
	public void contactwithallvaliddetails() throws InterruptedException, IOException {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		
		File f1=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis1=new FileInputStream(f1);
		XSSFWorkbook wb = new XSSFWorkbook(fis1);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);
		
		DataFormatter format1 = new DataFormatter();
		String Email = format1.formatCellValue(row.getCell(2));
		String Password = format1.formatCellValue(row.getCell(3));

		Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys(Email);
		LP.getPasswordField().sendKeys(Password);
		LP.getSubmitBtnField().click();
		
		wb.close();
		fis1.close();
		
		File f2=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis2=new FileInputStream(f2);
		XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
		XSSFSheet sheetAt2 = wb2.getSheetAt(1);
		XSSFRow row2= sheetAt2.getRow(1);
		
		DataFormatter format2 = new DataFormatter();
		String FirstName = format2.formatCellValue(row2.getCell(0)); 
		String LastName = format2.formatCellValue(row2.getCell(1));
		String DateofBirth = format2.formatCellValue(row2.getCell(2));
		String Email2= format2.formatCellValue(row2.getCell(3));
		String Phone= format2.formatCellValue(row2.getCell(4));
		String StreetAddress1= format2.formatCellValue(row2.getCell(5));
		String StreetAddress2= format2.formatCellValue(row2.getCell(6));
		String City= format2.formatCellValue(row2.getCell(7));
		String StateOfProvince = format2.formatCellValue(row2.getCell(8));
		String PostalCode= format2.formatCellValue(row2.getCell(9));
		String Country= format2.formatCellValue(row2.getCell(10));


		AddContactPage ACP =new AddContactPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ACP.getAddcontact().click();
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
		Thread.sleep(3000);
		ACP.getSubmitField().click();
		Thread.sleep(4000);
	
	    TakesScreenshot shot=  (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\AddContactScreenshots\\contactwithallvaliddetails.png");
		FileUtils.copyFile(source, destination);
		driver.navigate().refresh();
		Thread.sleep(3000);
		wb2.close();
		fis2.close();
	}
	@Test(priority=2)
  public void contactwithmissingrequiredfields() throws InterruptedException, IOException {
	  
	File f2=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
	FileInputStream fis2=new FileInputStream(f2);
	XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
	XSSFSheet sheetAt2 = wb2.getSheetAt(1);
	XSSFRow row2= sheetAt2.getRow(2);
	
	DataFormatter format2 = new DataFormatter();
	String FirstName = format2.formatCellValue(row2.getCell(0)); 
	String LastName = format2.formatCellValue(row2.getCell(1));
	String DateofBirth = format2.formatCellValue(row2.getCell(2));
	String Email2= format2.formatCellValue(row2.getCell(3));
	String Phone= format2.formatCellValue(row2.getCell(4));
	String StreetAddress1= format2.formatCellValue(row2.getCell(5));
	String StreetAddress2= format2.formatCellValue(row2.getCell(6));
	String City= format2.formatCellValue(row2.getCell(7));
	String StateOfProvince = format2.formatCellValue(row2.getCell(8));
	String PostalCode= format2.formatCellValue(row2.getCell(9));
	String Country= format2.formatCellValue(row2.getCell(10));
	

	AddContactPage ACP =new AddContactPage(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	ACP.getAddcontact().click();
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
	Thread.sleep(2000);
	ACP.getSubmitField().click();
	Thread.sleep(2000);
	driver.navigate().refresh();
	wb2.close();
	fis2.close();

	TakesScreenshot shot= (TakesScreenshot) driver;
	File source = shot.getScreenshotAs(OutputType.FILE);
	File desitnation=new File ("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\AddContactScreenshots\\Missing fields.png");
	FileUtils.copyDirectory(source, desitnation);
	
  }
	@Test(priority=3)
	public void phonefieldacceptsonlynumericinput() throws InterruptedException, IOException {

		File f2=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis2=new FileInputStream(f2);
		XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
		XSSFSheet sheetAt2 = wb2.getSheetAt(1);
		XSSFRow row2= sheetAt2.getRow(3);
		
		DataFormatter format2 = new DataFormatter();
		String FirstName = format2.formatCellValue(row2.getCell(0)); 
		String LastName = format2.formatCellValue(row2.getCell(1));
		String DateofBirth = format2.formatCellValue(row2.getCell(2));
		String Email2= format2.formatCellValue(row2.getCell(3));
		String Phone= format2.formatCellValue(row2.getCell(4));
		String StreetAddress1= format2.formatCellValue(row2.getCell(5));
		String StreetAddress2= format2.formatCellValue(row2.getCell(6));
		String City= format2.formatCellValue(row2.getCell(7));
		String StateOfProvince = format2.formatCellValue(row2.getCell(8));
		String PostalCode= format2.formatCellValue(row2.getCell(9));
		String Country= format2.formatCellValue(row2.getCell(10));
		
		AddContactPage ACP =new AddContactPage(driver);
		Thread.sleep(2000);
		//ACP.getAddcontact().click();
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
		Thread.sleep(2000);
		wb2.close();
		fis2.close();
	
		TakesScreenshot shot=(TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File desination=new File ("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\AddContactScreenshots\\Numeric.png");
		FileUtils.copyFile(source, desination);
		
	}
	@Test(priority=4)
	public void  addingduplicatecontactdetails() throws InterruptedException, IOException {
		
		  
				File f2=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
				FileInputStream fis2=new FileInputStream(f2);
				XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
				XSSFSheet sheetAt2 = wb2.getSheetAt(1);
				XSSFRow row2= sheetAt2.getRow(1);
				
				DataFormatter format2 = new DataFormatter();
				String FirstName = format2.formatCellValue(row2.getCell(0)); 
				String LastName = format2.formatCellValue(row2.getCell(1));
				String DateofBirth = format2.formatCellValue(row2.getCell(2));
				String Email2= format2.formatCellValue(row2.getCell(3));
				String Phone= format2.formatCellValue(row2.getCell(4));
				String StreetAddress1= format2.formatCellValue(row2.getCell(5));
				String StreetAddress2= format2.formatCellValue(row2.getCell(6));
				String City= format2.formatCellValue(row2.getCell(7));
				String StateOfProvince = format2.formatCellValue(row2.getCell(8));
				String PostalCode= format2.formatCellValue(row2.getCell(9));
				String Country= format2.formatCellValue(row2.getCell(10));
		
		
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
		       wb2.close();
		       fis2.close();
	}
	@Test(priority=5)
	public void  formresetsaftercontactisadded() throws InterruptedException, IOException {
		File f2=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis2=new FileInputStream(f2);
		XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
		XSSFSheet sheetAt2 = wb2.getSheetAt(1);
		XSSFRow row2= sheetAt2.getRow(1);
		
		DataFormatter format2 = new DataFormatter();
		String FirstName = format2.formatCellValue(row2.getCell(0)); 
		String LastName = format2.formatCellValue(row2.getCell(1));
		String DateofBirth = format2.formatCellValue(row2.getCell(2));
		String Email2= format2.formatCellValue(row2.getCell(3));
		String Phone= format2.formatCellValue(row2.getCell(4));
		String StreetAddress1= format2.formatCellValue(row2.getCell(5));
		String StreetAddress2= format2.formatCellValue(row2.getCell(6));
		String City= format2.formatCellValue(row2.getCell(7));
		String StateOfProvince = format2.formatCellValue(row2.getCell(8));
		String PostalCode= format2.formatCellValue(row2.getCell(9));
		String Country= format2.formatCellValue(row2.getCell(10));


		AddContactPage ACP =new AddContactPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ACP.getAddcontact().click();
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
		ACP.getAddcontact().click();
		wb2.close();
		fis2.close();
		driver.close();
	
	}
}

