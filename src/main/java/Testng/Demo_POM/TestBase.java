package Testng.Demo_POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Listeners.ExtentManager;





//@Listeners(Listeners.TestListener.class)
public class TestBase {
	Properties properties;
	public static TeckUtilityClass oTeckUtil =new TeckUtilityClass();
	public static commonUtilities ocomnUtil = new commonUtilities();
	
	public static ExtentManager  oExt = new ExtentManager();
	Logger log = Logger.getLogger(getClass().getSimpleName());
	public static HashMap<String, String> sMapAuthorizationHeader = new HashMap<String, String>();
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(commonUtilities.class);
	
	public  WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest loggers;
	Properties props;
String sPath=System.getProperty("user.dir")+"/ExtentReport/Samplereport.html";


	@BeforeSuite
	public void LaunchingTheBrowser() {
		reports= new ExtentReports(sPath);
	driver = oTeckUtil.LaunchBrowser("ch");	
	}
public void TriggerDependencies()throws Exception{
		
		ocomnUtil.loadPropertyFiles(System.getProperty("user.dir")+"/src/main/java/Properties/log4j2.properties");
		ocomnUtil.loadPropertyFiles(System.getProperty("user.dir")+"/src/main/java/Properties/testdata.properties");
		
		if(System.getProperty("Enviornment")== null || System.getProperty("Enviornment").isEmpty())
			System.setProperty("Enviornment",System.getProperty("Enviornmentconf"));
			
				
	}

public  void Loaddata() throws IOException {
	props = new Properties();
FileInputStream f = new FileInputStream(System.getProperty("C:\\Users\\as\\tecarchworkspace\\Demo_POM_Framework") + "/src/main/java/Properties/testdata.properties");
//FileReader obj = new FileReader(f);
props.load(f);
	
}

public  String getobj(String Data) throws IOException {
Loaddata();

String data = props.getProperty(Data);
return data;

}

	@AfterSuite
	public void closeBrowser() {
		oTeckUtil.TearDownBrowser();
		reports.flush();
	}
	
}
