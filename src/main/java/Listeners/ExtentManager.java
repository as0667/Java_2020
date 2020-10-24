package Listeners;

//import org.openqa.selenium.Platform;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	private static ExtentReports extent;
	public static ExtentTest extLogger;
	
	//private static Platform platform;
	private static String reportFileName = "teckarch_Automation_Report.html";
	//private static String windowsPath = System.getProperty("user.dir")+"\\TestReport";
	private static String fileSeperator = System.getProperty("file.separator");
	
	private static String reportFilepath = System.getProperty("user.dir")+"\\TestReport";
	private static String reportFileLocation = reportFilepath + fileSeperator+ reportFileName;
	
	public static ExtentReports getInstance() {
		if(extent==null)
			createInstance();
		
		return extent;
	}

	public static ExtentReports  createInstance() {
		//platform = getCurrentPlatform();
		String fileName = getReportPath(reportFilepath);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		 htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(reportFileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(reportFileName);
		
		
		
		
	
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("AUT", "QA");
		
		return extent;
	}

	private static String getReportPath(String path) {
		
		File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }	
		
		

	}

	/*private static String getReportFileLocation(Platform platform) {
		String reportFileLocation = null;
		switch(platform) {
		case 
		}
		return null;
	}*/

	
	

