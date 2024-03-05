package StepDefinition;

import org.openqa.selenium.WebDriver;


import PageFactory.CucumberBaseClass;
import PageObjectModel.UsedCars;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarsStep 
{
	public WebDriver driver=CucumberBaseClass.getDriver();
    UsedCars cars =new UsedCars(driver);
	@Given("user will navigate to ZigWheels Website")
	public void user_will_navigate_Back_zig_wheels_website() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("User navigated Back ZigWheels Website ");
	}

	@When("user hover on used cars")
	public void user_hover_on_used_cars() {
	    // Write code here that turns the phrase above into concrete actions
	   cars.GoToUsedCars();
	}

	@Then("click on chennai")
	public void click_on_chennai() {
	    // Write code here that turns the phrase above into concrete actions
	   cars.Chennai();
	}
	
	@Then("scrolldown1")
	public void scroll_down1()
	{
		cars.ScrollDown1();
		
	}

	@Then("get the information about popular models and print the same in excel")
	public void get_the_information_about_popular_models_and_print_the_same_in_excel() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println( cars.ListPoularCars());
	}
}
