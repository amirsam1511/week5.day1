package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
//CreateLead extending parent class BaseClass
public class CreateLead extends BaseClass{
	@Test
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
		//Get the title of the resulting page
		String title = driver.getTitle();
		//Print the title
		System.out.println(title);

	}

}
