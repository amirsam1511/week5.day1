package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//Declare ChromeDriver
	public ChromeDriver driver;
	//Used @BeforeMethod Annotation
	@BeforeMethod
	public void preCondition() {
		//ChromeDriver Setup
		WebDriverManager.chromedriver().setup();
		//Initialize ChromeDriver
		driver = new ChromeDriver();
		//Pass the url of the application
		driver.get("http://leaftaps.com/opentaps/control/main");
		//Maximize the window
		driver.manage().window().maximize();
		//Added a Implicit wait of 5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Get the username using id and pass the value as DemoSalesManager
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		//Get the password using id and pass the value
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click Submit using className
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click CRMSFA link using linkText
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click Leads link using linkText
		driver.findElement(By.linkText("Leads")).click();
	}
	@AfterMethod
	public void postCondition() {
		//Close the browser
		driver.close();
	}
}
