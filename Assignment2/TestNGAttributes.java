package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
//TestNGAttributes extending parent class BaseClass
public class TestNGAttributes extends BaseClass{
	//Added invocationCount attribute to 2 to run createLead 2 times
	@Test(invocationCount = 2)
	public void createLead() {
		//Click Create using xpath
		driver.findElement(By.xpath("//a[contains(text() ,'Create')]")).click();
		//Given CompanyName as TestLeaf using xpath
		driver.findElement(By.xpath("//input[contains(@id,'company') ]")).sendKeys("TestLeaf");
		//Given firstName as XXX using xpath
		driver.findElement(By.xpath("//input[contains(@id,'firstName') ]")).sendKeys("XXX");
		//Given lastName as YYY using xpath
		driver.findElement(By.xpath("//input[contains(@id,'lastName') ]")).sendKeys("YYY");
		//Given firstNameLocal as ZZZ using xpath
		driver.findElement(By.xpath("//input[contains(@id,'firstNameLocal') ]")).sendKeys("ZZZ");
		//Given departmentName as IT using xpath
		driver.findElement(By.xpath("//input[contains(@id,'department') ]")).sendKeys("IT");
		//Given description using xpath
		driver.findElement(By.xpath("//textarea[contains(@id,'description') ]")).sendKeys("TestLeaf started up in 2009, and we’ve been on an epic ride ever since. From our beginnings as an training company, we’ve tried to stay true to our core beliefs and to deliver an exceptional learning experience and job support for our customers and learners.");
		//Given email as sdet@testleaf.com using xpath
		driver.findElement(By.xpath("//input[contains(@id,'Email') ]")).sendKeys("sdet@testleaf.com");
		//Get the value of State using xpath and assign it to Webelement
		WebElement option = driver.findElement(By.xpath("//select[contains(@id,'StateProvinceGeoId') ]"));
		//Get the options using select
		Select selectOption = new Select(option);
		//Select the State as New York using selectByVisibleText
		selectOption.selectByVisibleText("New York");
		//Click Submit
		driver.findElement(By.xpath("//input[contains(@class,'Submit') ]")).click();
	}
	//Used dependsOnMethods and priority attributes for editLead
	@Test(dependsOnMethods = "createLead",priority=-1)
	public void editLead() throws InterruptedException{
		//Click Find Leads using linktext
		driver.findElement(By.linkText("Find Leads")).click();
		//Added a Implicit Wait of 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Click the First Resulting Id
		driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//Print the title
		System.out.println(driver.getTitle());
		//Click Edit using linkText
		driver.findElement(By.linkText("Edit")).click();
		//Get the company Name using Id locator
		WebElement beforeUpdate = driver.findElement(By.id("updateLeadForm_companyName"));
		//Clear the existing value
		beforeUpdate.clear();
		//Given value as Updated Company Name
		beforeUpdate.sendKeys("Updated Company Name");
		//Added a sleep of 3 secs
		Thread.sleep(3000);
		//Click Update using xpath
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
		//Get the name of updated company Name using id locator
		WebElement updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp"));
		//Check the companyName is updated using if-else condition
		if(updatedCompanyName.isDisplayed()==true) {
			System.out.println("Company Name is Updated");
		}
		else {
			System.out.println("Company Name is not Updated");
		}

	}
	//Used dependsOnMethods attributes for deleteLead
	@Test(dependsOnMethods = "createLead")
	public void deleteLead() throws InterruptedException {
		//Click Find Leads using linktext
		driver.findElement(By.linkText("Find Leads")).click();
		//Click Phone using xpath
		driver.findElement(By.xpath("//a[contains(@class,'x-tab-right')]/following::span")).click();
		//Given 9 as phone number using name
		driver.findElement(By.name("phoneNumber")).sendKeys("9");
		//Click FindLeads using xpath
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		//Added a sleep of 3secs
		Thread.sleep(3000);
		//Get the text of First Resulting lead using xpath
		String text = driver.findElement(By.xpath("//td[contains(@class,'first ')]/div/a[1]")).getText();
		//Print the lead
		System.out.println(text);
		//Added a sleep of 3 secs
		Thread.sleep(3000);
		//Click the first resulting lead
		driver.findElement(By.xpath("//td[contains(@class,'first ')]/div/a[1]")).click();
		//Added a sleep of 3 secs
		Thread.sleep(3000);
		//Click Delete using xpath
		driver.findElement(By.xpath("//a[text() = 'Delete']")).click();
		//Click Find Leads using xpath
		driver.findElement(By.xpath("//a[text() = 'Find Leads']")).click();
		//Search the resulting id using name
		driver.findElement(By.name("id")).sendKeys(text);
		//Click Find Leads using xpath
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		//Added a sleep of 3 secs
		Thread.sleep(3000);
		//Get the number of records present using xpath
		String recordDeleted = driver.findElement(By.xpath("//div[@class = 'x-paging-info']")).getText();
		//Check if record is deleted using if-else condition
		if(recordDeleted.equals("No records to display")) {
			System.out.println("Record has been deleted");
		}
		else {
			System.out.println("Record has not been deleted");
		}
	}
	//Used enabled attribute and Ignored duplicateLead execution
	@Test(enabled = false)
	public void duplicateLead() throws InterruptedException {
		//Click FindLeads using link text
		driver.findElement(By.linkText("Find Leads")).click();
		//Click Phone using xpath
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//Given 99 as phone number using xpath
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		//Click Find Leads using xpath
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Added a sleep of 2 secs
		Thread.sleep(2000);
		//Click the first resulting id using xpath
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//Click duplicate lead using link text
		driver.findElement(By.linkText("Duplicate Lead")).click();
		//Click Submit button
		driver.findElement(By.name("submitButton")).click();

	}
}