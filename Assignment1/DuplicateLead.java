package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
//DuplicateLead extending parent class BaseClass
public class DuplicateLead extends BaseClass{

	@Test
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
