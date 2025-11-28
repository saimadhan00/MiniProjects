package ParaBank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ParaBankPages.CustomerSupportPage;
import ParaBankPages.LoginPage;

public class CustomerSupport {
	
	WebDriver driver;
	
	@BeforeClass
	public void login() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	
	@Test(priority=1)
 public void ParaLogin() throws InterruptedException, IOException {
		
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);

		DataFormatter format = new DataFormatter();
		String UserName = format.formatCellValue(row.getCell(8));
		String Password = format.formatCellValue(row.getCell(9));
		
		LoginPage Lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Lp.getUsernameButton().sendKeys(UserName);
		Lp.getPasswordButton().sendKeys(Password);
		Lp.getLoginButton().click();
		Thread.sleep(2000);
		wb.close();
    	fis.close();
		
	}	
	@Test(priority=2)
	 public void CustomerSupportForm() throws IOException, InterruptedException {
		
		File f2=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
		FileInputStream fis2=new FileInputStream(f2);
		XSSFWorkbook wb2=new XSSFWorkbook(fis2);
		XSSFSheet sheetAt2=wb2.getSheetAt(2);
		XSSFRow row = sheetAt2.getRow(1);
		
		DataFormatter format = new DataFormatter();
		String Name = format.formatCellValue(row.getCell(0));
		String Email = format.formatCellValue(row.getCell(1));
		String Phone = format.formatCellValue(row.getCell(2));
		String Text= format.formatCellValue(row.getCell(3));
		
		 CustomerSupportPage cp=new CustomerSupportPage(driver);
		 cp.getContactUs().click();
		 cp.getContactUsNameField().sendKeys(Name);
		 cp.getContactUsEmailField().sendKeys(Email);
		 cp.getContactUsPhoneField().sendKeys(Phone);
		 cp.getContactUsTextareaField().sendKeys(Text);
		 Thread.sleep(2000);
		 cp.getSendToCustomerCareField().click();
		 
		 wb2.close();
		 fis2.close();
		
		
	}

	@Test(priority=3)
	 public void CustomerSupportFormEmpty() throws IOException, InterruptedException {
		
		File f2=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
		FileInputStream fis2=new FileInputStream(f2);
		XSSFWorkbook wb2=new XSSFWorkbook(fis2);
		XSSFSheet sheetAt2=wb2.getSheetAt(2);
		XSSFRow row = sheetAt2.getRow(2);
		
		DataFormatter format = new DataFormatter();
		String Name = format.formatCellValue(row.getCell(0));
		String Email = format.formatCellValue(row.getCell(1));
		String Phone = format.formatCellValue(row.getCell(2));
		String Text= format.formatCellValue(row.getCell(3));
		
		 CustomerSupportPage cp=new CustomerSupportPage(driver);
		 cp.getContactUs().click();
		 cp.getContactUsNameField().sendKeys(Name);
		 cp.getContactUsEmailField().sendKeys(Email);
		 cp.getContactUsPhoneField().sendKeys(Phone);
		 cp.getContactUsTextareaField().sendKeys(Text);
		 Thread.sleep(2000);
		 cp.getSendToCustomerCareField().click();
		 
		 wb2.close();
		 fis2.close();
		
	}
	
	@Test(priority=4)
	 public void CustomerSupportConfirmationMessage() throws IOException, InterruptedException {
		
		File f2=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
		FileInputStream fis2=new FileInputStream(f2);
		XSSFWorkbook wb2=new XSSFWorkbook(fis2);
		XSSFSheet sheetAt2=wb2.getSheetAt(2);
		XSSFRow row = sheetAt2.getRow(1);
		
		DataFormatter format = new DataFormatter();
		String Name = format.formatCellValue(row.getCell(0));
		String Email = format.formatCellValue(row.getCell(1));
		String Phone = format.formatCellValue(row.getCell(2));
		String Text= format.formatCellValue(row.getCell(3));
		
		 CustomerSupportPage cp=new CustomerSupportPage(driver);
		 cp.getContactUs().click();
		 cp.getContactUsNameField().sendKeys(Name);
		 cp.getContactUsEmailField().sendKeys(Email);
		 cp.getContactUsPhoneField().sendKeys(Phone);
		 cp.getContactUsTextareaField().sendKeys(Text);
		 Thread.sleep(2000);
		 cp.getSendToCustomerCareField().click();
		 
		 String pageMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p[1]")).getText();

		    if (pageMessage.equals("Thank you Madhan")) {
		        System.out.println("Form Submitted Sucessfully.");
		    } else {
		        System.out.println("Form  not Submitted");
		    }
		 
		 wb2.close();
		 fis2.close();
	}	
	@AfterClass
	  public void Logout() {
		  driver.close();  
	  }
}
