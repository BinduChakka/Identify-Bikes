package StepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import PageFactory.CucumberBaseClass;
import PageObjectModel.Home;
import PageObjectModel.Newbikes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BikesStep 
{
	public WebDriver driver=CucumberBaseClass.getDriver();
	Home home = new Home(driver);
	Newbikes bikes = new Newbikes(driver);
	public List<Integer> index = new ArrayList<Integer>();
	@Given("user navigated to ZigWheels Website")
	public void user_navigated_to_zig_wheels_website() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("User navigated");
	}

	@When("user hover on NewBikes")
	public void user_hover_on_new_bikes() {
	    // Write code here that turns the phrase above into concrete actions
	   home.GoToNewBikes();
	}

	@Then("click on upcoming bikes")
	public void click_on_upcoming_bikes() {
	    // Write code here that turns the phrase above into concrete actions
	    home.clickOnUpcoming();
	}

	@Then("click on manufacturer")
	public void click_on_manufacturer() {
	    // Write code here that turns the phrase above into concrete actions
	   bikes.ClickOnManufactures();
	}

	@Then("click on readmore")
	public void click_on_readmore() {
	    // Write code here that turns the phrase above into concrete actions
		bikes.ClickReadMore();
	}
	
	@Then("scrolldown")
	public void scroll_Down() 
	{
		bikes.ScrollDown();
	}
	

	@Then("get the information about upcoming bikes and print the same in excel")
	public void get_the_information_about_upcoming_bikes_and_print_the_same_in_excel() {
	    // Write code here that turns the phrase above into concrete actions

		for (int i = 0; i < bikes.Prices.size(); i++) 
		{
			
			 String  value=bikes.Prices.get(i).getText().replaceAll("[^0-9]","");			
        	 if(Integer.parseInt(value)*1000<400000 &&  !(bikes.Prices.get(i).getText().contains("crore")))
        	 {
        		 index.add(i);
		     }
        	 else if(!(bikes.Prices.get(i).getText().contains(" Lakh")))
        	 {
        		 index.add(i);
        	 }
        }
		for(int i=0;i<bikes.Model.size();i++)
		{
       	 if(index.contains(i))
       	 {
       		 System.out.println(bikes.Model.get(i)+"-->"+bikes.Price.get(i)+"-->"+bikes.LaunchDate.get(i));
       	 }
        }
	}
	
	@Then("click on zigwheels")
    public void zig_wheels()
    {
    	bikes.ZigWheels();
    }

	

}
