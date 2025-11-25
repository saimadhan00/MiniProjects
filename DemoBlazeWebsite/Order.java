package DemoBlazeWebsite;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import DemoBlazePages.CartPage;
import DemoBlazePages.LoginPage;
import DemoBlazePages.OrderPage;

public class Order {
	
	WebDriver driver;
	@BeforeClass
	public void login() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
	}
	@Test(priority=1)
	public void order() throws IOException, InterruptedException {
		
		
		
		File f=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);
		
		DataFormatter format = new DataFormatter();
		String Username = format.formatCellValue(row.getCell(0));
		String Password = format.formatCellValue(row.getCell(1));
		
		LoginPage Lp=new LoginPage (driver);
		Lp.getLoginButton1().click();
		Thread.sleep(4000);
		Lp.getUserName().sendKeys(Username);
		Lp.getUserpassword().sendKeys(Password);
		Thread.sleep(2000);
		Lp.getLoginButton2().click();
		Thread.sleep(3000);
		wb.close();
		fis.close();
		
		CartPage cp=new CartPage(driver);
		cp.getCartLoginpage().click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
	    File f2=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
		FileInputStream fis2 = new FileInputStream(f2);
		XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
		XSSFSheet sheetAt2 = wb2.getSheetAt(1);
		XSSFRow row2 = sheetAt2.getRow(1);
		
		DataFormatter format2 = new DataFormatter();
		String Name = format2.formatCellValue(row2.getCell(0));
		String Country = format2.formatCellValue(row2.getCell(1));
		String City = format2.formatCellValue(row2.getCell(2));
		String Card = format2.formatCellValue(row2.getCell(3));
		String Month = format2.formatCellValue(row2.getCell(4));
		String Year = format2.formatCellValue(row2.getCell(5));
	    
	    
	    OrderPage op=new OrderPage(driver);
	    op.getPlaceOrder().click();
	    Thread.sleep(2000);
	    op.getName().sendKeys(Name);
	    op.getCountry().sendKeys(Country);
	    op.getCity().sendKeys(City);
	    op.getCard().sendKeys(Card);
	    op.getMonth().sendKeys(Month);
	    op.getYear().sendKeys(Year);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    op.getPurchase().click();
	    Thread.sleep(2000);
	    op.getPurchaseOk().click();
	    wb2.close();
	    fis2.close();
	
	}
	
	@Test(priority=2)
	public void orderWithinvalidDetails() throws InterruptedException, IOException {
	
	CartPage cp=new CartPage(driver);
	cp.getCartLoginpage().click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    
    File f3=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
	FileInputStream fis3 = new FileInputStream(f3);
	XSSFWorkbook wb3 = new XSSFWorkbook(fis3);
	XSSFSheet sheetAt3 = wb3.getSheetAt(1);
	XSSFRow row3 = sheetAt3.getRow(2);
	
	DataFormatter format3 = new DataFormatter();
	String Name = format3.formatCellValue(row3.getCell(0));
	String Country = format3.formatCellValue(row3.getCell(1));
	String City = format3.formatCellValue(row3.getCell(2));
	String Card = format3.formatCellValue(row3.getCell(3));
	String Month = format3.formatCellValue(row3.getCell(4));
	String Year = format3.formatCellValue(row3.getCell(5));
    
    
    OrderPage op=new OrderPage(driver);
    op.getPlaceOrder().click();
    Thread.sleep(2000);
    op.getName().sendKeys(Name);
    op.getCountry().sendKeys(Country);
    op.getCity().sendKeys(City);
    op.getCard().sendKeys(Card);
    op.getMonth().sendKeys(Month);
    op.getYear().sendKeys(Year);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    op.getPurchase().click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.switchTo().alert().accept();
    Thread.sleep(3000);
    op.getClosepage().click();
    wb3.close();
    fis3.close();
}

	@Test(priority=3)
	public void verifyOrder() throws InterruptedException, IOException {
	    
	    File f2=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
			FileInputStream fis2 = new FileInputStream(f2);
			XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
			XSSFSheet sheetAt2 = wb2.getSheetAt(1);
			XSSFRow row2 = sheetAt2.getRow(1);

		DataFormatter format2 = new DataFormatter();
		String Name = format2.formatCellValue(row2.getCell(0));
		String Country = format2.formatCellValue(row2.getCell(1));
		String City = format2.formatCellValue(row2.getCell(2));
		String Card = format2.formatCellValue(row2.getCell(3));
		String Month = format2.formatCellValue(row2.getCell(4));
		String Year = format2.formatCellValue(row2.getCell(5)); 

		
		  OrderPage op =new OrderPage(driver);
		    op.getPlaceOrder().click();
		    Thread.sleep(2000);
		    op.getName().sendKeys(Name);
		    op.getCountry().sendKeys(Country);
		    op.getCity().sendKeys(City);
		    op.getCard().sendKeys(Card);
		    op.getMonth().sendKeys(Month);
		    op.getYear().sendKeys(Year);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    op.getPurchase().click();
		    Thread.sleep(3000);
		  

		    String pageMessage = driver.findElement(By.xpath("/html/body/div[10]/h2")).getText();

		    if (pageMessage.equals("Thank you for your purchase!")) {
		        System.out.println("purchase Sucessfully.");
		    } else {
		        System.out.println("purchase is not Sucessfully");
		    }

	    
	       Thread.sleep(2000);
		   op.getPurchaseOk().click();

	    wb2.close();
	    fis2.close();
	    
	}
	public void Logout() {
		  driver.close();  
	  }
}