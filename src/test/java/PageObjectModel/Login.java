package PageObjectModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage
{

	public Login(WebDriver driver) {
		super(driver);
		
	}
	
	//locators
	
	
	
	@FindBy(xpath="//*[@id='forum_login_title_lg']")
	WebElement Login;
	
	@FindBy(xpath="//*[text()='Google']")
	WebElement Google;
	
	@FindBy(xpath="//*[@id=\"identifierId\"]")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"identifierNext\"]")
	WebElement Next;
	
	@FindBy(xpath="//*[text()='Couldn’t find your Google Account']")////*[@class='o6cuMc Jj6Lae']
	WebElement CaptureError;
	
	
	//Actions Method
	
	public void NavigateTo()
	{
		driver.navigate().to("https://www.zigwheels.com/");
		//driver.navigate().back();
		//driver.navigate().refresh();
		System.out.println("Page Navigated Succesfully");
		
		
	}
	
	public void ClickOnLogin()
	{
		Login.click();
		System.out.println("Login is clicked");
		
	}
	
	public void ClickOnGoogle()
	{
		Google.click();
		System.out.println("Google is clicked");
	}
	
	public void HandleWindow()
   {
	 Set<String> windowids = driver.getWindowHandles();
		 List<String> windowid =new ArrayList<String>(windowids);
		 driver.switchTo().window(windowid.get(1));
		 System.out.println("Window is opened");
	}
	
	
	public void setEmail(String emaildata) 
	{
	
	
			Email.sendKeys(emaildata);
            driver.manage().window().maximize();
	}
	
	public void ClickNext()
	{
		Next.click();
		
	}
	
	public void Capturerror()
	{
		String warning_text = CaptureError.getText();
		System.out.println(warning_text);
	}
	
	
}
