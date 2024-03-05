package PageObjectModel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UsedCars extends BasePage
{
	public List<String> cars = new ArrayList<String>();
	public UsedCars(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	
	@FindBy(xpath="//a[text()='Used Cars']")
	WebElement Usedcars;
	
	@FindBy(xpath="//*[text()='Chennai']")
	WebElement Chennai;
	
	@FindBy(xpath="//*[text()='Popular Models']")
	WebElement Scroll;
	
	@FindBy(xpath="//*[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']")
	List<WebElement> PopularCars;
	
	
	//Actions Methods
	
	  public void GoToUsedCars() 
	  {
		  Actions action =new Actions(driver);
          action.moveToElement(Usedcars).build().perform();
          System.out.println("Usedcars opened");
		  
		  
	  }
	  
	  public void Chennai()
	  {
		  Chennai.click();	
			System.out.println("Chennai is Opened");
		  
	  }
	  
	  public void ScrollDown1() 
	  {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("arguments[0].scrollIntoView();", Scroll);
          
       }
	  
	  public List<String> ListPoularCars()
	  {
		  for(WebElement models : PopularCars)
 		 {
			  cars.add(models.getText());
 			System.out.println(models.getText());
 		 }
		  return cars;
		  
	  }
	
}