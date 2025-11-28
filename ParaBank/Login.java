package ParaBank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ParaBankPages.LoginPage;

import org.testng.annotations.*;

public class Login {
	
	WebDriver driver;
	@BeforeClass
	public void LoginUrl() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
	}
	@Test(priority=1)
	public void RegisterUser() throws IOException, InterruptedException {
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);
		
		DataFormatter format = new DataFormatter();
		String FirstName = format.formatCellValue(row.getCell(0));
		String LastName = format.formatCellValue(row.getCell(1));
		String Address = format.formatCellValue(row.getCell(2));
		String City = format.formatCellValue(row.getCell(3));
		String State = format.formatCellValue(row.getCell(4));
		String Zipcode = format.formatCellValue(row.getCell(5));
		String Phone = format.formatCellValue(row.getCell(6));
		String SSN = format.formatCellValue(row.getCell(7));
		String UserName = format.formatCellValue(row.getCell(8));
		String Password = format.formatCellValue(row.getCell(9));
		String ConfirmPassword = format.formatCellValue(row.getCell(10));
		
		LoginPage Lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Lp.getRegisterButton().click();
		Lp.getFirstName().sendKeys(FirstName);
		Lp.getLastName().sendKeys(LastName);
		Lp.getAddress().sendKeys(Address);
		Lp.getCity().sendKeys(City);
		Lp.getState().sendKeys(State);
		Lp.getZipCode().sendKeys(Zipcode);
		Lp.getPhoneNumber().sendKeys(Phone);
		Lp.getSSN().sendKeys(SSN);
		Lp.getUserName().sendKeys(UserName);
		Lp.getPassWord().sendKeys(Password);
		Lp.getConfirmPassword().sendKeys(ConfirmPassword);
		Thread.sleep(2000);
		Lp.getRegisterButton2().click();
		Thread.sleep(2000);
		Lp.getLogoutButton().click();
		Thread.sleep(3000);
		Lp.getUsernameButton().sendKeys(UserName);
		Lp.getPasswordButton().sendKeys(Password);
		Lp.getLoginButton().click();
		Thread.sleep(2000);
		Lp.getLogoutButton().click();
		wb.close();
		fis.close();	
	}
	@Test(priority=2)
	public void IncorrectPassword() throws IOException, InterruptedException {
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(2);
		
		DataFormatter format = new DataFormatter();
		String UserName = format.formatCellValue(row.getCell(0));
		String Password = format.formatCellValue(row.getCell(1));
		
		LoginPage Lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Lp.getUsernameButton().sendKeys(UserName);
		Lp.getPasswordButton().sendKeys(Password);
		Lp.getLoginButton().click();
		Thread.sleep(2000);
		wb.close();
		fis.close();	
	}
	@Test(priority=3)
public void unregister() throws IOException, InterruptedException {
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(3);
		
		DataFormatter format = new DataFormatter();
		String UserName = format.formatCellValue(row.getCell(0));
		String Password = format.formatCellValue(row.getCell(1));
		
		LoginPage Lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Lp.getUsernameButton().sendKeys(UserName);
		Lp.getPasswordButton().sendKeys(Password);
		Lp.getLoginButton().click();
		Thread.sleep(2000);
		wb.close();
		fis.close();
}
	@Test(priority=4)
public void Empty() throws IOException, InterruptedException {
	
	File f=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
	FileInputStream fis=new FileInputStream(f);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheetAt = wb.getSheetAt(0);
	XSSFRow row = sheetAt.getRow(4);
	
	DataFormatter format = new DataFormatter();
	String UserName = format.formatCellValue(row.getCell(0));
	String Password = format.formatCellValue(row.getCell(1));
	
	LoginPage Lp=new LoginPage(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Lp.getUsernameButton().sendKeys(UserName);
	Lp.getPasswordButton().sendKeys(Password);
	Lp.getLoginButton().click();
	Thread.sleep(2000);
	wb.close();
	fis.close();
}
	@Test(priority=5)
public void InvaliadEmail() throws IOException, InterruptedException {
	
	File f=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
	FileInputStream fis=new FileInputStream(f);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheetAt = wb.getSheetAt(0);
	XSSFRow row = sheetAt.getRow(5);
	
	DataFormatter format = new DataFormatter();
	String UserName = format.formatCellValue(row.getCell(0));
	String Password = format.formatCellValue(row.getCell(1));
	
	LoginPage Lp=new LoginPage(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Lp.getUsernameButton().sendKeys(UserName);
	Lp.getPasswordButton().sendKeys(Password);
	Lp.getLoginButton().click();
	Thread.sleep(2000);
	wb.close();
	fis.close();
}
	@Test(priority=6)
	public void PasaswordMaskCheck() throws IOException, InterruptedException {
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(5);
		
		DataFormatter format = new DataFormatter();
		String UserName = format.formatCellValue(row.getCell(0));
		String Password = format.formatCellValue(row.getCell(1));
		
		LoginPage Lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Lp.getUsernameButton().sendKeys(UserName);
		Lp.getPasswordButton().sendKeys(Password);
		Thread.sleep(3000);
		
		WebElement passwordField = driver.findElement(By.xpath("///input[@name='password']"));
	    String fieldType = passwordField.getAttribute("type");
        if (fieldType.equals("password")) {
        System.out.println("Password field is masked.");
        } else {
        System.out.println("Password field is NOT masked!");
       }
        Lp.getLoginButton().click();
		wb.close();
		fis.close();
		
	    
	}
	@Test(priority=7)
	public void Timeout(ServletRequest request, ServletResponse response, FilterChain chain)throws ServletException, IOException, InterruptedException {
		
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

		        HttpServletRequest req = (HttpServletRequest) request;
		        HttpServletResponse res = (HttpServletResponse) response;

		        HttpSession session = req.getSession(false);

		        if (session == null || session.isNew()) {
		            
		            res.sendRedirect(req.getContextPath() + "/login.jsp");
		        } else {
		           
		            chain.doFilter(request, response);
		        }
		    }

		    public void destroy() {
		        
		    }
		    @AfterClass
		    public void Logout() {
		  	  driver.close();  
		    }
		}


		
	
