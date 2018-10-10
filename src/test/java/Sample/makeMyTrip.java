package Sample;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class makeMyTrip {
	makeMyTripMethod mTm=new makeMyTripMethod();
	
	@Test(priority = 0)
	public void driverIntialize() throws InterruptedException {
		//To Initialize driver
		mTm.intializeDriver();
		
	}

	@Test(priority = 1)
	public void url() throws InterruptedException {
		
		mTm.url();
		String actualUrl=mTm.driver.getCurrentUrl();
		System.out.println(actualUrl);
		Assert.assertEquals("https://www.makemytrip.com/",actualUrl);
		
	}

	@Test(priority = 2)
	public void fromField() throws InterruptedException {

		WebElement fromField=mTm.fromField();
		mTm.clickElement(fromField);	
		mTm.sendValues(fromField);
		String fromInput=mTm.driver.findElement(By.xpath("//div/input[@id='hp-widget__sfrom']")).getAttribute("value");
		System.out.println(fromInput);
		Assert.assertEquals("New Delhi (DEL)", fromInput);
	}

	@Test(priority = 3)
	public void toField() throws InterruptedException {

		List<WebElement> fromCity=mTm.toField();
		WebElement cityClick= mTm.loopList(fromCity,"Hyderabad, India");
		cityClick.click();
		String toInput=mTm.driver.findElement(By.xpath("//div/input[@id='hp-widget__sTo']")).getAttribute("value");
		Assert.assertEquals("Hyderabad (HYD)", toInput);		
	}
	
	@Test(priority = 4)
	public void departureDate() throws InterruptedException {
		
		List<WebElement> dates=mTm.departDatePicker();
		WebElement toDate= mTm.loopList(dates,"28");
		toDate.click();		
		}

	@Test(priority = 5)
	public void returnDate() throws InterruptedException
	{
		mTm.clickElement(mTm.clickablefield());
		Thread.sleep(2000);
		List<WebElement> returnDates=mTm.returnDatePicker();
		WebElement toDate= mTm.loopList(returnDates,"31");
		toDate.click();		
	}

	@Test(priority = 6)
	public void passengersClick() throws InterruptedException
	{
		mTm.passengersClick();
		Thread.sleep(2000);	
		String passenger=mTm.driver.findElement(By.id("hp-widget__paxCounter_pot")).getAttribute("value");	
		Assert.assertEquals("2 | Premium Economy", passenger);
	}
	
	@Test(priority = 7)
	public void searchClick() throws InterruptedException
	{
		mTm.searchButtonClick();
		Assert.assertTrue(mTm.driver.getCurrentUrl().contains("DEL_HYD_28-07-2018,HYD_DEL_31-08-2018"));
	}
	
	@Test(priority = 8)
	public void assertDates() throws InterruptedException
	{
		boolean result=false;
		HashMap<WebElement, String> dates=mTm.dates();
		String[] values = dates.values().toArray(new String[0]);
		WebElement[] key = dates.keySet().toArray(new WebElement[0]);
		for(int i=0;i<=dates.size()-1;i++)
		{
			if(key[i].getAttribute("value").toString().contains(values[i]))
			{
				result=true;
			}
			else
			{
				result=false;	
				Assert.fail();
				break;
			}
		}	
	}
	
	/*@AfterTest
	public void afterTest() {

		driver.quit();

	}*/

}
