package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Home extends BasePage {

	public Home(WebDriver driver) {
		super(driver);
		
	}
	//Locators
	
	@FindBy(xpath="//a[text()='New Bikes']")
	WebElement NewBikes;
	
	@FindBy(xpath="//*[text()='Upcoming Bikes']")
	WebElement UpComing;
	
	//Action Methods
	
			public void GoToNewBikes()
			{
				//NewBikes.build.perform();	
				Actions act = new Actions(driver);
				act.moveToElement(NewBikes).build().perform();
				System.out.println("NewBikes opened");			
			}
			public void clickOnUpcoming()
			{
				UpComing.click();	
				System.out.println("UpComing is Opened");
				
				
			}


	}


