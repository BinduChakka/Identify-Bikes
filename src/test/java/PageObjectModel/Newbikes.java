package PageObjectModel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Newbikes extends BasePage
{
	public List<String>  Model = new ArrayList<String>();
	public List<String> Price = new ArrayList<String>();
	public List<String> LaunchDate = new ArrayList<String>();
	public static List<Integer> index = new ArrayList<Integer>();
	public Newbikes(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(id="makeId")
	WebElement Manufactures;
	
	@FindBy(xpath="//*[contains(text(), '...Read More')]")
	WebElement ReadMore;
	//*[text()='Latest Bikes']  //*[@id=\"rhsDiv\"]/aside/div[3]/h2
	@FindBy(xpath="//*[@class='uc-heading-bikes']")
	WebElement ScrollDown;
	 
	@FindBy(xpath="//*[@class='zw i-b mt-10 pt-2 zw-srch-logo']")
	WebElement ZigWheels;
	
	@FindBy(xpath="//table[@class='tbl bdr fnt-12 pl-15 pr-15 mb-15']//tr[@class='ml-15 ']/td[1]")
	public List<WebElement>  Models;
	
	@FindBy(xpath="//table[@class='tbl bdr fnt-12 pl-15 pr-15 mb-15']//tr[@class='ml-15 ']//td[2]")
	public List<WebElement> Prices;
	
	@FindBy(xpath="//table[@class='tbl bdr fnt-12 pl-15 pr-15 mb-15']//tr[@class='ml-15 ']//td[3]")
	public List<WebElement> LaunchDates;
	
	
	//Action Methods
	
	
		public void ClickOnManufactures()
		{
			Manufactures.click();
			System.out.println("Manufactures is opened");
			//select honda
			Select dropdown = new Select(Manufactures);
		    dropdown.selectByValue("53");
		    System.out.println("Honda is selected");
		}
		
		public void ClickReadMore()
		{
			ReadMore.click();
			System.out.println("ReadMore is clicked");
			
			
		}
		
		public void ScrollDown()
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", ScrollDown);
			
		}
		
		
		public void LessThan4Lakhs()
		{
			
			for (int i = 0; i < Prices.size(); i++) 
			{
				
				 String  value=Prices.get(i).getText().replaceAll("[^0-9]","");			
	        	 if(Integer.parseInt(value)*1000<400000 &&  !(Prices.get(i).getText().contains("crore")))
	        	 {
	        		 index.add(i);
			     }
	        	 else if(!(Prices.get(i).getText().contains(" Lakh")))
	        	 {
	        		 index.add(i);
	        	}
	        }
			
		}
		public List<String> getModelNames()
		{
			for(WebElement model : Models )
			{
				Model.add(model.getText());
				System.out.println(model.getText());
			}
			return Model;
		}
		
		public List<String> getPrices()
		{
			for(WebElement price : Prices )
			{
				Price.add(price.getText());
				System.out.println(price.getText());
			}
			return Price;
		}
		
		public List<String> getLaunchDates()
		{
			for(WebElement date : LaunchDates  )
			{
				LaunchDate.add(date.getText());
				System.out.println(date.getText());
			}
			return LaunchDate;
		}
		
		public void ZigWheels()
		{
			ZigWheels.click();
		}
}
