package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
//EditLead extending parent class BaseClass
public class EditLead extends BaseClass{
	@Test
	public void editLead() throws InterruptedException {
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

}
