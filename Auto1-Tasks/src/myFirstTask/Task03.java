package myFirstTask;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task03 {
/*To create an automation script for search functionality with Researvation from zear 2015 and with price in descending order*/
	
	public static void main(String[] args) throws InterruptedException, AWTException{
		
		WebDriver driver = new ChromeDriver();
		
		//Open the URL
		driver.get("https://www.autohero.com/de/search/"); 
		
		//Filter for First Registration (Erstzallasung).
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Erstzulassung']")).click();
		System.out.println("click1");
		Thread.sleep(5000);
		
		//Filter for First Registration (Erstzallasung)FROM 2015
		driver.findElement(By.xpath("//*[text()='Erstzulassung']/ancestor::div[1]/following-sibling::div[1]/div[1]/div[1]/span")).click();
		System.out.println("click2");
		Thread.sleep(60000);
		driver.findElement(By.xpath("//*[text()='Erstzulassung']/ancestor::div[1]/following-sibling::div[1]/div[1]/div[1]/span[1]/div[2]/input")).sendKeys("2015");
		Thread.sleep(5000);
		
		
		//Apply the filter from 2015
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("filled from 2015");
		Thread.sleep(5000);
		
		//Find the Sortiert Nach dropdown
		driver.findElement(By.xpath("//*[text()='Sortiert nach']/following-sibling::div[1]")).click();
		System.out.println("dropdown clicked"); 
		Thread.sleep(30000);
		
		//Sort Car by Price Descending (Hˆchster Preis?) /*not working*/
		driver.findElement(By.xpath("//*[text()='Sortiert nach')]/following-sibling::div[1]//div[@aria-activedescendant='react-select-8--option-1']")).click();
		System.out.println("dropdown size check");
		//dropdown value not selected to option1 "Hˆchster Preis" due to uncertainity in the values changes under the attribute aria-activedescendant
		Thread.sleep(10000);		
		driver.close();
		}
		
	}