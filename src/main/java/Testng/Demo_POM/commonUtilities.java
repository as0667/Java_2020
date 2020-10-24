package Testng.Demo_POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class commonUtilities extends TestBase{
	
	//public static TestBase oTest = new TestBase();
	//Logger log = Logger.getLogger(getClass().getSimpleName());
	 static final Logger logger = LogManager.getLogger(commonUtilities.class);
	//org.apache.logging.log4j.Logger logger = LogManager.getLogger(commonUtilities.class);
	Properties props;
	static FileInputStream fileIn = null;
	
	
	public  void loadPropertyFiles(String PropertiesFilePath)throws Exception{
		props = new Properties();
		log.info("Current dir using System:" + PropertiesFilePath);
		fileIn = new FileInputStream(PropertiesFilePath);
		props.load(fileIn);
		System.getProperties().putAll(props);
	
		
		
	}
	
	public void loadLog4jProperty(String PropertiesFilePath) throws Exception{
		log.info("Log4j Property file Path:" + PropertiesFilePath);
		fileIn = new FileInputStream(PropertiesFilePath);
		props.load(fileIn);
		PropertyConfigurator.configure(props);
	}
	
	public  void Loaddata() throws IOException {
		props = new Properties();
	File f = new File(System.getProperty("user dir")+"\\src\\main\\java\\Properties\\testdata.properties");
	FileReader obj = new FileReader(f);
	props.load(obj);
		
	}
	
public  String getobj(String Data) throws IOException {
	Loaddata();

	String data = props.getProperty(Data);
	return data;
	
}
}
