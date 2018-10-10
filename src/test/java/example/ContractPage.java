package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class ContractPage {
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
		WebElement clickGoals = driver.findElement(By.xpath(
				"//a[@class='ctl00_MainMenu_1 Menu ctl00_MainMenu_3' and contains(text(),'Create/Modify Contract')]"));
		action.clickAndHold(mouseHover).click(clickGoals).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$ImgAdd")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$txtContractTitleInsert")).sendKeys("testContract" + this.getTime());
		Thread.sleep(2000);
		//driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$txtContractProviderName")).sendKeys("Provider1Test");
		driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$txtContractProviderName")).sendKeys("AMCS&CO");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$txtContractProviderName")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$txtContractProviderName")).sendKeys(Keys.ENTER);
		Thread.sleep(6000);
		driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$txtContractProviderName")).sendKeys(Keys.TAB);
		driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$txtContractNumberInsert")).sendKeys(""+this.getTime());
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$txtContractAmountInsert")).sendKeys("10000");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$txtBeginDateInsert")).sendKeys("01/01/2018");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$txtEndDateInsert")).sendKeys("12/31/2018");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentMainHolder_frmContract_txtContractDescriptionInsert")).sendKeys("test description");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$frmContract$btnSave")).click();
		Thread.sleep(4000);
		
		//Add New Line Item
		driver.findElement(By.id("ctl00_ContentMainHolder_tabContract_tpLineItem_btnAddLineItem")).click();
		Thread.sleep(4000);
		//Line Item Name
		driver.findElement(By.name("ctl00$ContentMainHolder$txtLineItemName")).sendKeys("Line Item Name");
		Thread.sleep(2000);
		//Goal Select
		Select s1=new Select(driver.findElement(By.name("ctl00$ContentMainHolder$ddlProgram")));
		s1.selectByVisibleText("testA");
		Thread.sleep(2000);
		//Fund Source Select
		Select s2=new Select(driver.findElement(By.name("ctl00$ContentMainHolder$ddlFund")));
		s2.selectByIndex(1);
		Thread.sleep(2000);
		//Service Area Select
		Select s3=new Select(driver.findElement(By.name("ctl00$ContentMainHolder$ddlServiceArea")));
		s3.selectByValue("29");;
		Thread.sleep(2000);
		//Service Type Select
		Select s4=new Select(driver.findElement(By.name("ctl00$ContentMainHolder$ddlServiceType")));
		s4.selectByValue("14");;
		Thread.sleep(2000);
		//Allocation
		driver.findElement(By.name("ctl00$ContentMainHolder$txtBudget")).sendKeys("500");
		Thread.sleep(2000);
		//Start Date
		driver.findElement(By.name("ctl00$ContentMainHolder$txtLineItemBeginDate")).sendKeys("04/01/2018");
		Thread.sleep(2000);
		//End Date
		driver.findElement(By.name("ctl00$ContentMainHolder$txtLineItemEndDate")).sendKeys("12/31/2018");
		Thread.sleep(2000);
		//Support Documentation
		driver.findElement(By.id("ctl00_ContentMainHolder_radSupportDocumentationNo")).click();
		Thread.sleep(2000);
		//Save
		driver.findElement(By.name("ctl00$ContentMainHolder$btnLineItemSave")).click();
		Thread.sleep(4000);
		//Continue Save
		driver.findElement(By.id("ctl00_ContentMainHolder_btnRemitOkSave")).click();
		Thread.sleep(2000);
		//Close
		driver.findElement(By.name("ctl00$ContentMainHolder$btnWarningClose")).click();
		Thread.sleep(4000);
		
		
		//Deliverables
		
		//Click Deliverables
		driver.findElement(By.xpath("//span[@id='__tab_ctl00_ContentMainHolder_tabContract_tpDeliverables']")).click();
		Thread.sleep(2000);
		//Select Line Item
		Select s5=new Select(driver.findElement(By.xpath("//select[@name='ctl00$ContentMainHolder$tabContract$tpDeliverables$ddlSearchLineItem']")));
		s5.selectByVisibleText("Line Item Name");
		Thread.sleep(2000);
		//Add New Deliverables
		driver.findElement(By.name("ctl00$ContentMainHolder$tabContract$tpDeliverables$btnAddNewDeliverable")).click();
		Thread.sleep(2000);
		//Deliverable Name
		driver.findElement(By.name("ctl00$ContentMainHolder$txtDeliverableName")).sendKeys("Test Deliverable Name");
		Thread.sleep(2000);
		//Deliverable Type Select
		Select s6=new Select(driver.findElement(By.name("ctl00$ContentMainHolder$ddlDeliverabelType")));
		s6.selectByValue("12");
		//Unit of Measure
		Select s7=new Select(driver.findElement(By.name("ctl00$ContentMainHolder$ddlUOM")));
		s7.selectByValue("2");
		Thread.sleep(2000);
		//Add Deliverable Rate
		driver.findElement(By.id("ctl00_ContentMainHolder_btnAddDeliverableRate")).click();
		Thread.sleep(2000);
		//Click Save icon
		driver.findElement(By.name("ctl00$ContentMainHolder$grdDeliverableRate$ctl02$ctl00")).click();
		Thread.sleep(2000);
		//Save
		driver.findElement(By.name("ctl00$ContentMainHolder$btnDeliverableSave")).click();
		Thread.sleep(4000);
		
		//Contract Reviews
		
		driver.findElement(By.xpath("//span[@id='__tab_ctl00_ContentMainHolder_tabContract_tpContractServiceNotes']")).click();
		Thread.sleep(2000);
		//Add
		driver.findElement(By.name("ctl00$ContentMainHolder$tabContract$tpContractServiceNotes$ucContractServiceNotes$btnAddServiceNotes")).click();
		Thread.sleep(2000);
		Select s8=new Select(driver.findElement(By.name("ctl00$ContentMainHolder$tabContract$tpContractServiceNotes$ucContractServiceNotes$ddlServiceNotes")));
		s8.selectByValue("17");
		//Notes
		driver.findElement(By.name("ctl00$ContentMainHolder$tabContract$tpContractServiceNotes$ucContractServiceNotes$txtNotesDescription")).sendKeys("test note");
		Thread.sleep(2000);
		//Save
		driver.findElement(By.name("ctl00$ContentMainHolder$tabContract$tpContractServiceNotes$ucContractServiceNotes$btnSaveServiceNotes")).click();
		Thread.sleep(4000);
		
		//LineItem Reviews
		
		driver.findElement(By.xpath("//span[@id='__tab_ctl00_ContentMainHolder_tabContract_TabPanel1']")).click();
		Thread.sleep(2000);
		//Select Line Item
		Select s9=new Select(driver.findElement(By.name("ctl00$ContentMainHolder$tabContract$TabPanel1$ddlSearchLineItemForNotes")));
		s9.selectByVisibleText("Line Item Name");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$tabContract$TabPanel1$ucLineItemServiceNotes$btnAddServiceNotes")).click();
		Thread.sleep(2000);
		//Note Type Select
		Select s10=new Select(driver.findElement(By.name("ctl00$ContentMainHolder$tabContract$TabPanel1$ucLineItemServiceNotes$ddlServiceNotes")));
		s10.selectByValue("19");
		Thread.sleep(2000);
		//Notes
		driver.findElement(By.name("ctl00$ContentMainHolder$tabContract$TabPanel1$ucLineItemServiceNotes$txtNotesDescription")).sendKeys("test note");
		Thread.sleep(2000);
		//Save
		driver.findElement(By.name("ctl00$ContentMainHolder$tabContract$TabPanel1$ucLineItemServiceNotes$btnSaveServiceNotes")).click();
		Thread.sleep(4000);
		
		
		//Final OK
		driver.findElement(By.name("ctl00$ContentMainHolder$btnFinalCancel")).click();
		Thread.sleep(2000);
		
/*	//*******************************REMOVE**************************************************	
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
		WebElement clickGoals = driver.findElement(By.xpath(
				"//a[@class='ctl00_MainMenu_1 Menu ctl00_MainMenu_3' and contains(text(),'Create/Modify Contract')]"));
		action.clickAndHold(mouseHover).click(clickGoals).build().perform();
		Thread.sleep(2000);
	//*******************************REMOVE**************************************************		*/
		
		//Search
		driver.findElement(By.xpath("//img[@id='ctl00_ContentMainHolder_ImgView']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$txtProviderNameSearch")).sendKeys("AMCS&CO");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$txtProviderNameSearch")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$txtProviderNameSearch")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
				
		//Select Status
		Select s11=new Select(driver.findElement(By.name("ctl00$ContentMainHolder$ddlContractStatusSearch")));
		s11.selectByVisibleText("Draft");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$txtBeginDateSearch")).sendKeys("04/01/2018");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$ContentMainHolder$txtEndDateSearch")).sendKeys("12/31/2018");
		//Click Search
		driver.findElement(By.name("ctl00$ContentMainHolder$btnContractSearch")).click();
		Thread.sleep(6000);
		
		
		//Action
		driver.findElement(By.xpath("//table[@id='ctl00_ContentMainHolder_grdViewContract']/tbody/tr[last()]/td[17]")).click();
		Thread.sleep(2000);
		//Activate
		driver.findElement(By.xpath("//table[@id='ctl00_ContentMainHolder_grdViewContract']/tbody/tr[last()]/td[17]/div/a[1]")).click();
		Thread.sleep(2000);
		//Continue
		driver.findElement(By.name("ctl00$ContentMainHolder$btnContinueActivation")).click();
		Thread.sleep(2000);
		
		//Delete
		
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
