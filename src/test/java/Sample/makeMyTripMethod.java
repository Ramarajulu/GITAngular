package Sample;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class makeMyTripMethod {

	public WebDriver driver;

	public void intializeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ramarajulu.M\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();			
	}

	public void url() 
	{
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	}
	
/*	public WebDriver getDriver()
    {
        return driver;
    }	*/
	
	public WebElement fromField() throws InterruptedException 
	{		
		Thread.sleep(2000);		
		return driver.findElement(By.xpath("//div/input[@id='hp-widget__sfrom']"));		
	}
	
	public void sendValues(WebElement ele) throws InterruptedException 
	{		
		ele.sendKeys("New Delhi (DEL)");
		ele.sendKeys(Keys.ENTER);
	}
	
	public List<WebElement> toField() throws InterruptedException {
		Thread.sleep(2000);				
		//List<WebElement> cities= driver.findElements(By.xpath("//div[@id='js-filterOptins']/descendant::div[@class='locationFilter autocomplete_to']/ul/li"));
		WebElement autoOptions = driver.findElement(By.id("ui-id-2"));
		List<WebElement> cities = autoOptions.findElements(By.tagName("li"));
		return cities;
	}	
	
	public List<WebElement> departDatePicker() throws InterruptedException {
		WebElement element= driver.findElement(By.xpath("//div[@class='dateFilter hasDatepicker']/descendant::div[@class='ui-datepicker-group ui-datepicker-group-first'][1]/table[@class='ui-datepicker-calendar']"));		
		List<WebElement> rows = element.findElements(By.xpath("./tbody/tr[5]/td[6]"));	
		return rows;
	}
	
	public List<WebElement> returnDatePicker() throws InterruptedException {
		WebElement element= driver.findElement(By.xpath("//div[@class='dateFilterReturn hasDatepicker']/descendant::div[@class='ui-datepicker-group ui-datepicker-group-last']/table[@class='ui-datepicker-calendar']"));			
		List<WebElement> rows = element.findElements(By.xpath("./tbody/tr[5]/td[5]"));	
		return rows;
	}
	
	public WebElement loopList( List<WebElement> values, String Clickable) throws InterruptedException {
	
		WebElement valueToBeClickable = null;		
		for (WebElement cell : values) {			
			if (cell.getText().contains(Clickable)) {
				valueToBeClickable=cell;
				break;
			}
		}
		Thread.sleep(2000);
		return valueToBeClickable;
	}
	
	public void clickLogin() throws InterruptedException {
		driver.findElement(By.name("ctl00$ContentMainHolder$btnLogin")).click();
		Thread.sleep(2000);
	}
	
	public WebElement clickablefield() throws InterruptedException {
		return driver.findElement(By.id("hp-widget__return"));	
		
	}
	
	public void passengers() throws InterruptedException 
	{	
		driver.findElement(By.xpath("//div[@class='filterOptins']/descendant::ul[@class='adult_counter']/li[2]")).click();
		driver.findElement(By.xpath("//div/input[@id='hp-widget__sfrom']")).sendKeys(Keys.ENTER);
	}
	
	public void passengersClick() throws InterruptedException {		
		driver.findElement(By.id("hp-widget__paxCounter_pot")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='filterOptins']/descendant::ul[@class='adult_counter']/li[2]")).click();
		driver.findElement(By.xpath("//div[@class='filterOptins']/descendant::ul[@id='pot_ul']/li[2]")).click();
	}	

	public void clickElement(WebElement element) throws InterruptedException {
		element.click();
	}
	
	public WebElement searchButtonClick() throws InterruptedException {
		return driver.findElement(By.id("searchBtn"));			
	}
	
	public HashMap<WebElement, String> dates() throws InterruptedException {					
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='modify_top col-md-12 col-sm-12 hidden-xs visible-stb ng-scope']/div/a/p[1]]"));	
		int i=0;
		HashMap<WebElement, String> geeks = new HashMap<WebElement, String>();
		for(WebElement a: rows)
		{
			geeks.put(a, a.getText());
			i++;
		}		
		return geeks;
	}

	
	
	//div[@class='modify_top col-md-12 col-sm-12 hidden-xs visible-stb ng-scope']/div/a/p[1]
	
	

			
}
