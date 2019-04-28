package DDF;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Library.ExcelDataConfig;

public class Facebook_Login {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","/home/hp/Documents/Testing/JARS/browser drivers/chromedriver");
		 driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com");
	}
	
	@Test(dataProvider="logindata")
	public  void facebook_logintest(String username, String password){
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		//System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Facebook"));
	}
	
	@DataProvider(name="logindata")
	public Object[][] getData() throws Exception{
		
		ExcelDataConfig config= new ExcelDataConfig("/home/hp/eclipse-workspace/Data_Driven_Apache/src/main/java/ExcelFile/TestDataDDA.xlsx", "Data_Sheet");
		int rowcount=config.getrowcount("Data_Sheet");
		System.out.println("Rowcount is " + rowcount);
		Object [][] data= new Object[rowcount][2];
		for (int i=1; i<rowcount;i++) {
			data[i][0]=config.getData(i, 0);
			data[i][1]=config.getData(i, 1);
			
		}
		
		
		
		/*data[0][0]="Abhijeet";
		data[0][1]="Gujarathi";
		data[1][0]="Anurag";
		data[1][1]="Gujarathi";*/
		return data;
	}

}
