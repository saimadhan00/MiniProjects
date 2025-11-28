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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ParaBankPages.LoginPage;
import ParaBankPages.NavigationAndUiPage;

public class NavigationAndUi {
	
	WebDriver driver;
	@BeforeClass
	public void LoginUrl() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
	}
	@Test(priority=1)
	public void login() throws InterruptedException, IOException {
		
		
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
	public void Navigation() throws InterruptedException {
		
		NavigationAndUiPage na=new NavigationAndUiPage(driver);
		na.getHomeButton().click();
		Thread.sleep(2000);
		na.getAccountOverviewButton().click();
		Thread.sleep(2000);
		na.getTransferFundsButton().click();
		Thread.sleep(2000);
		na.getLoanButton().click();
		Thread.sleep(2000);
		na.getContactUsButton().click();
		Thread.sleep(2000);

	}
	@Test(priority=3)
	public void NavigationToLogo() throws InterruptedException {
		
		NavigationAndUiPage na=new NavigationAndUiPage(driver);
		na.getLogLinkButton().click();
		Thread.sleep(2000);

	}
	
	@Test(priority=4)
	public void Visibility() throws InterruptedException {
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		boolean AccountOverviewButton = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a")).isDisplayed();
		boolean TransferFundsButton = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a")).isDisplayed();
		

		if (AccountOverviewButton && TransferFundsButton ) {
		    System.out.println("All buttons are visible and clickable");
		} else {
		    System.out.println("One or more buttons are not visible");
		}
		
	}
	
	@Test(priority=5)
	public void Allignment() throws InterruptedException {
		
		 String[] urls = {
			        "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC",
			        "https://parabank.parasoft.com/parabank/index.htm",
			    };

		
			    String commonElementSelector = "a.navbar-brand"; 

			    String expectedFontFamily = "";
			    String expectedFontSize = "";

			    for (int i = 0; i < urls.length; i++) {
			        driver.get(urls[i]);
			        Thread.sleep(2000);  

			        WebElement element = driver.findElement(By.cssSelector(commonElementSelector));
			        String fontFamily = element.getCssValue("font-family");
			        String fontSize = element.getCssValue("font-size");

			        System.out.println("Page: " + urls[i]);
			        System.out.println("Font family: " + fontFamily);
			        System.out.println("Font size: " + fontSize);

			        if (i == 0) {
			            
			            expectedFontFamily = fontFamily;
			            expectedFontSize = fontSize;
			        } else {
			            
			            if (!expectedFontFamily.equals(fontFamily) || !expectedFontSize.equals(fontSize)) {
			                System.out.println("Font inconsistency detected on page: " + urls[i]);
			            }
			            
			            
			        }
			    }
}

	@AfterClass
	  public void Logout() {
		  driver.close();  
	  }
}
