package TestData.TestData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class TC_BIS_001 {

	
	@Test(priority=1)
	public void TC_001() throws InterruptedException, IOException
	
	{
		
		System.setProperty("webdriver.chrome.driver","D:\\Automation_Tool\\Test\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://newbsl.pivotroots.com/");
		WebElement loginicon = driver
		.findElement(By.xpath("//header/div[1]/div[2]/div[2]/div[2]/div[1]/span[1]/span[4]"));
		Actions actions7 = new Actions(driver);
		actions7.moveToElement(loginicon);
		actions7.click().build().perform();
		Thread.sleep(2000);
		WebElement Login = driver.findElement(
		By.xpath("/html[1]/body[1]/header[1]/div[1]/div[2]/div[2]/div[2]/div[2]/ul[1]/li[1]/a[1]"));
		Actions actions8 = new Actions(driver);
		actions8.moveToElement(Login);
		actions8.click().build().perform();
		Thread.sleep(6000);


		FileInputStream file = new FileInputStream("D:\\Ajinkya\\Desktop\\Project\\Bisleri\\Bisleri_Test_Cases.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet Sheet3 = wb.getSheetAt(0);
		wb.close();
		XSSFRow CurrentRow5 = Sheet3.getRow(23);
		XSSFRow CurrentRow6 = Sheet3.getRow(24);
		Long UserName3 = (long) CurrentRow5.getCell(5).getNumericCellValue();
		String Password3 = CurrentRow6.getCell(5).getStringCellValue();
		       Thread.sleep(2000);
		driver.findElement(By.id("login-username")).sendKeys(String.valueOf(UserName3));
		Thread.sleep(2000);
		driver.findElement(By.id("login-password")).sendKeys(Password3);
		driver.findElement(By.id("login-submit")).click();
		Thread.sleep(5000);
	}
}
