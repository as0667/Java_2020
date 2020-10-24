package Interaction;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POInteraction.POInteraction;

import Testng.Demo_POM.TestBase;
import Testng.Demo_POM.commonUtilities;

public class Interaction extends TestBase {
	
	
	POInteraction OInteraction;
	
	 static final Logger logger = LogManager.getLogger(commonUtilities.class);
	@BeforeTest
	public void triggerdependency() {
		OInteraction = new POInteraction(driver);
	}

	@Test
	public void InteractionPage() throws Exception {
		
		OInteraction.Interaction();
		PropertyConfigurator.configure("Properties/log4j2.properties");
		BasicConfigurator.configure();
		 
	}

	
	
	
	
}
