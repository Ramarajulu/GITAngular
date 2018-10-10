package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Test2 {
	private WebDriver driver;
	
	public int getTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyddmmss");
		Date date = new Date();
		String currenttime = dateFormat.format(date);
		int time = Integer.parseInt(currenttime);
		return time;

	}

	@Test
	public void f() throws InterruptedException {

		driver.get("http://192.168.0.67/csmtestsite/Default.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.name("ctl00$ContentMainHolder$txtUserName")).sendKeys("deeksha.singh@parthenonglobal.com");
		driver.findElement(By.name("ctl00$ContentMainHolder$txtPassword")).sendKeys("dsrc1234");
		driver.findElement(By.xpath("//label[@class='checkbox nomargin']/i")).click();		
		driver.findElement(By.name("ctl00$ContentMainHolder$btnLogin")).click();
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		WebElement mouseHover = driver
				.findElement(By.xpath("//a[@class='ctl00_MainMenu_1' and contains(text(),'Contract Manager')]"));
		WebElement clickFund = driver.findElement(By.xpath(
				"//a[@class='ctl00_MainMenu_1 Menu ctl00_MainMenu_3' and contains(text(),'Fund Manager')]"));
		action.clickAndHold(mouseHover).click(clickFund).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$btnAddFund")).click();
		Thread.sleep(2000);
		
		//Dropdown select with sendkeys
		//driver.findElement(By.name("ctl00$ContentMainHolder$ddlFundProgram")).sendKeys("Prestige Provider Goal II");
		Thread.sleep(2000);
		
		//Dropdown select using Select class
		Select select = new Select(	driver.findElement(By.name("ctl00$ContentMainHolder$ddlFundProgram")));
		select.selectByValue("21");
		
		//To get the size of the dropdown box
		
		List<WebElement> options=select.getOptions();
		System.out.println(options.size());
		
		//to print the dropdown text
		
		for (int i = 0; i < options.size(); i++) {
			
			System.out.println(options.get(i).getText());
			
		}
		
		//to print all links in the page displayed
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for (int i = 0; i < links.size(); i++) {
			
			System.out.println(links.get(i).getText());
		}
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
