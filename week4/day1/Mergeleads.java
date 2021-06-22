package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mergeleads{

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//label[text()='Username']/following::input")).sendKeys("DemoSalesManager");
		
		driver.findElement(By.xpath("//label[text()='Password']/following::input")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//div[@id='label']//a[1]")).click();
		driver.findElement(By.xpath("(//div[@class='x-panel-header']//a)[2]")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeLeadsForm']")).click();
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		//String fName = driver.findElement(By.xpath("(//a[@class='linktext'])[3]")).getText();
		//driver.findElement(By.id("ComboBox_partyIdFrom")).sendKeys("10060");
		driver.findElement(By.xpath("//input[@name='ComboBox_partyIdFrom']")).sendKeys("10061");
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		//driver.findElement(By.xpath("(//td[contains(@class,'dijitReset dijitStretch')]//input)[2]")).sendKeys("10066");
		driver.findElement(By.xpath("(//input[@dojoattachevent='onkeypress, onkeyup, onfocus, onblur, compositionend'])[2]")).sendKeys("10071");
//		driver.findElement(By.xpath("//[@id='ext-gen597']"));
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//a)[3]")).click();
		driver.switchTo().alert().accept();
		
	
        Thread.sleep(2000);

driver.findElement(By.linkText("Find Leads")).click();
driver.findElement(By.xpath("//span[text()='Advanced']/following::input")).sendKeys("10061");
driver.findElement(By.xpath("//button[@id='ext-gen341']")).click();
//String leadList = driver.findElement(By.xpath("//div[@id='ext-gen387']")).getText();
//String noRecordsTo = driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor']//div[1]")).getText();
String noRecordsTo = driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor']//div[1]")).getText();		
System.out.println(noRecordsTo);
driver.close();
	}

}
