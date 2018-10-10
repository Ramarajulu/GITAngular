package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleCode {
	private WebDriver driver;

	@Test
	public void url() throws InterruptedException {

		driver.get("http://192.168.0.67/csmtestsite/Default.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void userNameField() throws InterruptedException {

		driver.findElement(By.name("ctl00$ContentMainHolder$txtUserName"))
				.sendKeys("deeksha.singh@parthenonglobal.com");
	}

	@Test
	public void passWordField() throws InterruptedException {
		driver.findElement(By.name("ctl00$ContentMainHolder$txtPassword")).sendKeys("dsrc1234");
	}

	public void checkBox() throws InterruptedException {
		driver.findElement(By.xpath("//label[@class='checkbox nomargin']/i")).click();
	}

	public void clickLogin() throws InterruptedException {
		driver.findElement(By.name("ctl00$ContentMainHolder$btnLogin")).click();

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ramarajulu.M\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {

		driver.quit();

	}

}
