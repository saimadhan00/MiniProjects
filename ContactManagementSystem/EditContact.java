package ContactManagementSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import HerokuappPages.EditContactPage;
import HerokuappPages.Loginpage; 
@Listeners(ContactManagementSystem.Listner.class)

public class EditContact {
	WebDriver driver;
	@Test(priority=1)
	public void EditContactDetails() throws InterruptedException, IOException {
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
        //Loginpage
		Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys(Email);
		LP.getPasswordField().sendKeys(Password);
		LP.getSubmitBtnField().click();
		wb.close();
		fis.close();
		
		File f3=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis3=new FileInputStream(f3);
		XSSFWorkbook wb3 = new XSSFWorkbook(fis3);
		XSSFSheet sheetAt3 = wb3.getSheetAt(2);
		XSSFRow row3= sheetAt3.getRow(1);
		
		DataFormatter format3 = new DataFormatter();
		String FirstName = format3.formatCellValue(row3.getCell(0)); 
		String LastName = format3.formatCellValue(row3.getCell(1));
		String Email3= format3.formatCellValue(row3.getCell(3));
		String Phone2= format3.formatCellValue(row3.getCell(4));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //EditContactPage
		EditContactPage Epc= new EditContactPage(driver);
		Epc.getContactable().click();
		Thread.sleep(2000);
		Epc.getEditContact().click();
		Thread.sleep(2000);
		Epc.getFirstName().clear();
		Epc.getFirstName().sendKeys(FirstName);
		Epc.getLastName().clear();
		Epc.getLastName().sendKeys(LastName);
		Epc.getEmail().clear();
		Epc.getEmail().sendKeys(Email3);
		Epc.getPhone().clear();
		Epc.getPhone().sendKeys(Phone2);
		Epc.getSubmit().click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		wb3.close();
		fis3.close();

	}
	@Test(priority=2)
    public void cancel() throws InterruptedException, IOException {
		
		File f3=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis3=new FileInputStream(f3);
		XSSFWorkbook wb3 = new XSSFWorkbook(fis3);
		XSSFSheet sheetAt3 = wb3.getSheetAt(2);
		XSSFRow row3= sheetAt3.getRow(2);
		
		DataFormatter format3 = new DataFormatter();
		String FirstName = format3.formatCellValue(row3.getCell(0)); 
		EditContactPage Epc= new EditContactPage(driver);
		Epc.getReturntoContact().click();
		Thread.sleep(2000);
		Epc.getContactable().click();
		Thread.sleep(2000);
		Epc.getEditContact().click();
		Thread.sleep(2000);
		Epc.getFirstName().clear();
		Epc.getFirstName().sendKeys(FirstName);
		Thread.sleep(2000);
		Epc.getCancel().click();
		Thread.sleep(2000);
		Epc.getReturntoContact().click();
        wb3.close();
        fis3.close();
    	
    }
	@Test(priority=3)
	public void validation () throws InterruptedException{

		EditContactPage Epc= new EditContactPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Epc.getContactable().click();
		Thread.sleep(2000);
		Epc.getEditContact().click();
		Thread.sleep(2000);
		Epc.getLastName().clear();
		Thread.sleep(3000);
		Epc.getSubmit().click();
		Thread.sleep(2000);
		driver.close();
		
		
	}
}
