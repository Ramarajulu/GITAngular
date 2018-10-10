package WebdriverTest.WebdriverTest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class link {
	//WebDriver driver;
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	
	@Test
	public void methodName() throws InterruptedException {

		driver.get("http://localhost:4200/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 120);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//Click Create Agent
		
		driver.findElement(By.linkText("Create Agent")).click();
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a")).click();
		
		/*WebElement element=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
		// Configure the Action
		Actions action = new Actions(driver);

		//Focus to element
		action.moveToElement(element).perform();

		// To click on the element
		action.moveToElement(element).click().perform();
		Thread.sleep(5000);*/
		
		/*JavascriptExecutor ex=(JavascriptExecutor)driver;
		WebElement element=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
		ex.executeScript("arguments[0].click()", element);
		Thread.sleep(5000);
		
		
		
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='panel panel-primary']/div[1]"))).click();
		
		//Assert 
		/*String expected="Agent";
		String actual=driver.findElement(By.xpath("//div[@class='panel panel-primary']/div[1]")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);*/
				
		
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramarajulu.M\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
		

	}

}
