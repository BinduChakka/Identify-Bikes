package StepDefinition;
import java.io.IOException;
import java.util.Properties;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageFactory.CucumberBaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 
 
public class Hooks {
 
	public static WebDriver driver;
	static Properties p;
	@Before
    public static void beforeAll() throws IOException
    {
    	driver=CucumberBaseClass.initilizeBrowser();
    	
    	
    	p=CucumberBaseClass.getProperties();
    	driver.get(p.getProperty("appURL"));
    	driver.manage().window().maximize();

	}

	@After
    public  void tearDown() {
       driver.quit();
    }
    
 
    @AfterStep
    public static void addScreenShot(Scenario scenario) throws IOException
    {
    	// this is for cucumber junit report

        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());


    }
}


