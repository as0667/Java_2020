package Login;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POLogin.POLogin;
import Testng.Demo_POM.TestBase;
import Testng.Demo_POM.commonUtilities;


public class Login extends TestBase{

	
	POLogin OLogin; // instantiale the POLogin class we have to create object of Login
	//Logger log =Logger.getLogger(getClass().getSimpleName());
	 static final Logger logger = LogManager.getLogger(commonUtilities.class);
@BeforeTest
public void triggerdependency() {
	OLogin = new POLogin(driver);
}

@Test
public void LoginToWebSite () throws IOException {
	
	OLogin.LoginToWebSite();
	PropertyConfigurator.configure("Properties/log4j2.properties");
	BasicConfigurator.configure();
	 
}


}
