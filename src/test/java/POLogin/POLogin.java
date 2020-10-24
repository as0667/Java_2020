package POLogin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Testng.Demo_POM.TestBase;

public class POLogin extends TestBase{

	
	//all anotations which are page objects web elements are locators but we have to load them
	//we will load it by loading page factory class
	// we are going to create a constructor of this calss and a local driver. we have driver in TestBsae.
	public POLogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="email_field")	
	WebElement  ph_emailField;
	@FindBy(id="password_field")	
	WebElement  ph_password_field;
	@FindBy(xpath ="//button[contains(text(),'Login to Account')]")
	WebElement button_LoginToAccount;
	@FindBy(xpath ="//a[contains(text(),'Home')]")
	WebElement Home;

public  void LoginToWebSite() {
	driver.get("https://www.google.com/");
	driver.get("https://qa-tekarch.firebaseapp.com/");
	driver.manage().window().maximize();
	loggers= reports.startTest("logingIntoBrowserWithTestData");
	WebDriverWait wait=new WebDriverWait(driver,5);
	//wait.until(ExpectedConditions.visibilityOf(ph_emailField));
	oTeckUtil.ufClickElement(ph_emailField);
	
oTeckUtil.ufClearElement(ph_emailField);
oTeckUtil.ufSendKeys(ph_emailField, "admin123@gmail.com");	
oTeckUtil.ufClickElement(ph_password_field);

oTeckUtil.ufClearElement(ph_password_field);
oTeckUtil.ufSendKeys(ph_password_field, "admin123");	
	
oTeckUtil.ufClickElement(button_LoginToAccount);
loggers.log(LogStatus.INFO, "Login button is clicked");

reports.endTest(loggers);
	
	
}	
public  void LoginToWebSiteU() throws IOException {
	driver.get("https://www.google.com/");
	driver.get("https://qa-tekarch.firebaseapp.com/");
	driver.manage().window().maximize();
	loggers= reports.startTest("logingIntoBrowserWithTestData");
	//WebDriverWait wait=new WebDriverWait(driver,5);
	//wait.until(ExpectedConditions.visibilityOf(ph_emailField));
	oTeckUtil.ufClickElement(ph_emailField);
	
oTeckUtil.ufClearElement(ph_emailField);
//String susername =ocomnUtil.getobj("emailId");
//System.out.println(susername);
oTeckUtil.ufSendKeys(ph_emailField,System.getProperty("emailId"));	
//oTeckUtil.ufSendKeys(ph_emailField,susername);
String spassword =ocomnUtil.getobj("password");
oTeckUtil.ufClickElement(ph_password_field);

oTeckUtil.ufClearElement(ph_password_field);
oTeckUtil.ufSendKeys(ph_password_field, spassword);	
	
oTeckUtil.ufClickElement(button_LoginToAccount);
loggers.log(LogStatus.INFO, "Login button is clicked");

reports.endTest(loggers);
	
	
}	
}
