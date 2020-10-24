package POInteraction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Testng.Demo_POM.TestBase;

public class POInteraction extends TestBase {
	
	public POInteraction(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath ="//button[contains(text(),'Intractions')]")
		WebElement Interaction;
		
		@FindBy(xpath ="//a[contains(text(),'Mouse Hover')]")
		WebElement MouseHover;
		@FindBy(xpath ="//button[contains(text(),'mousehover')]")
		WebElement MouseHoverButton;
		
		@FindBy(xpath ="//div[@class='dropdown login']//a[contains(text(),'Alert')]")
		WebElement Alert;
		
		@FindBy(xpath ="//button[contains(text(),'Intractions')]")
		WebElement Interaction1;
		@FindBy(xpath ="//a[contains(text(),'Double Click')]")
		WebElement DoubleClick;
		@FindBy(xpath ="//button[contains(text(),'Double Click')]")
		WebElement DoubleClickButton ;
		
		@FindBy(xpath ="//p[@id='Selenium']")
		WebElement count;
	
	
	public void Interaction() throws Exception {
		loggers= reports.startTest("lInteraction started");
		
	oTeckUtil.explicitWaitFunctions(Interaction);	
	oTeckUtil.ufClickElement(Interaction);
		
	oTeckUtil.ufClickElement(MouseHover);
	oTeckUtil.explicitWaitFunctions(MouseHoverButton);
	oTeckUtil.MouseHoverOver(MouseHoverButton);
	oTeckUtil.ufClickElement(Alert);
	oTeckUtil.Alert();
	oTeckUtil.explicitWaitFunctions(Interaction1);
	oTeckUtil.ufClickElement(Interaction1);
	Thread.sleep(3000);
	oTeckUtil.ufClickElement(DoubleClick);
	Thread.sleep(3000);
	oTeckUtil.explicitWaitFunctions(DoubleClickButton);
	oTeckUtil.ufClickElement(DoubleClickButton);
	oTeckUtil.MouseHoverOver(DoubleClickButton);
	Thread.sleep(3000);
	oTeckUtil.MouseHoverOver(DoubleClickButton);
	Thread.sleep(3000);
	oTeckUtil.MouseHoverOver(DoubleClickButton);
	oTeckUtil.explicitWaitFunctions(count);
	oTeckUtil.Count(count);
	
	loggers.log(LogStatus.INFO, "count is done");
	reports.endTest(loggers);
	}
	
	
	
	
	

	
	
}	


