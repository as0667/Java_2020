package Testng.Demo_POM;

import java.sql.Driver;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.model.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TeckUtilityClass extends TestBase{
	
	
	public  WebDriver LaunchBrowser(String Browsername) {
	
		switch(Browsername) {
		case("ch"):
			
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
			
			break;
		case("FF"):
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
			break;
		
		default:
			break;
		}
		return driver;
	}
	public void TearDownBrowser() {
		
		driver.close();
		}
			
	
	public  void Login(String susername, String spassword) {
		WebDriverWait wait=new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
		
		driver.findElement(By.id("email_field")).click();
		
		driver.findElement(By.id("email_field")).clear();
		driver.findElement(By.id("email_field")).sendKeys(susername);
		
		driver.findElement(By.id("password_field")).click();
		driver.findElement(By.id("password_field")).clear();
		driver.findElement(By.id("password_field")).sendKeys(spassword);
		driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
		
	}
	public  void sendText(WebElement obj, String textval, String objName) throws InterruptedException {
		
		if(obj.isDisplayed()) {
			
			Thread.sleep(4000);
			obj.sendKeys(textval);
			System.out.println("pass"+obj+"obj is present");
		}else
		{
			System.out.println("fail"+obj+"obj is not present");
		}
	
	}
	
	public  void ValidateErrormsg(String actmsg, String errormsg) throws InterruptedException {
		
		if(actmsg.equals(errormsg)){
			
			Thread.sleep(4000);
			
			System.out.println("TC is passed");
		}else
		{
			System.out.println("TC is failed");
		}
	
	}
public  void Validatemsg(String actmsg, String errormsg) throws InterruptedException {
		
		if(actmsg.equals(actmsg)){
			
			Thread.sleep(4000);
			
			System.out.println("TC is passed");
		}else
		{
			System.out.println("TC is failed");
		}
	
	}
	public  void ValidateText(WebElement obj) {
		if(obj.isDisplayed()) {
			System.out.println(obj + "is displayed");
		}else
		{
			System.out.println("username is empty");
		}
	}
	public  void Click(WebElement obj) throws InterruptedException{
		if(obj.isDisplayed()) {
			
			Thread.sleep(4000);
			obj.click();
			System.out.println("pass"+obj+"obj is displayed");
		}else
		{
			System.out.println("fail"+obj+"obj is not displayed");
		}
	}
	public  void clear(WebElement obj) throws InterruptedException{
		if(obj.isDisplayed()) {
			
			Thread.sleep(4000);
			obj.clear();
			System.out.println("pass"+obj+"obj is displayed");
		}else
		{
			System.out.println("fail"+obj+"obj is not displayed");
		}
	}
	public  void MouseHover(WebElement obj) throws InterruptedException{
		if(obj.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(obj).click();
			
			System.out.println("pass"+obj+"obj is displayed");
		}else
		{
			System.out.println("fail"+obj+"obj is not displayed");
		}
	}
	public  void MouseHoverOver(WebElement ele) throws InterruptedException{
		if(ele.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			
			System.out.println("pass"+ele+"obj is displayed");
		}else
		{
			System.out.println("fail"+ele+"obj is not displayed");
		}
	}
	
	public  void explicitWaitFunction(WebElement ele, int iTime) {
		WebDriverWait wait=new WebDriverWait(driver,iTime);
		//wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	public  void explicitWaitFunctions(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,10);
	//	wait.until(ExpectedConditions.visibilityOf(ele));
		
	}

public void Alert() {	
	Alert a1=driver.switchTo().alert();
	System.out.println(a1.getText());
	a1.accept();	
}

public void Count(WebElement ele) {	
System.out.println(ele.getText());	
}
public  void windowsTabs(int value) throws InterruptedException {

ArrayList<String> windowsTabs = new ArrayList(driver.getWindowHandles());
System.out.println(windowsTabs.size());
Thread.sleep(1000);
driver.switchTo().window(windowsTabs.get(value));
//driver.manage().window().maximize();
Thread.sleep(2000);
//driver.close();

}

public  void ScrollToWebElement(WebElement obj) {
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()",  obj);
}
public  void ClosePopUp(WebElement obj) throws InterruptedException {
	
	if(obj.isDisplayed()) {
		
		Thread.sleep(2000);
		obj.click();
		System.out.println(obj + "obj is present");
	}else
	{
		System.out.println(obj + "obj is not present");
	}

}

public  void SwitchiFrame(WebElement obj) throws InterruptedException {
	driver.switchTo().frame(obj);
	Thread.sleep(1000);
}

public  void HorizontalScrollToWebElement(WebElement obj) {
	
	Actions act = new Actions(driver);
	WebElement horizontal_scroll=obj;
	act.clickAndHold(horizontal_scroll).moveByOffset(40, 0).release().perform();
}


//public static void movecursor(WebElement obj) {
	//driver.actions().mouseMove(obj).click().perform();
//}

public void ufClickElement(WebElement ele) {
	ele.click();
}

public void ufClearElement(WebElement ele) {
	ele.clear();
}public void ufSendKeys(WebElement ele, String text) {
	ele.sendKeys(text);
}
}
