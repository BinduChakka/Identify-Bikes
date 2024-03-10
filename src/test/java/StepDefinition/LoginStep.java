package StepDefinition;

import org.openqa.selenium.WebDriver;

import PageFactory.CucumberBaseClass;
import PageObjectModel.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep 
{
	public WebDriver driver=CucumberBaseClass.getDriver();
	Login login = new Login(driver);
	@Given("navigate to homepage of zigwheels")
	public void navigate_to_homepage_of_zigwheels() {
	    // Write code here that turns the phrase above into concrete actions
	   login.NavigateTo();
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	  login.ClickOnLogin();
	}

	@Then("click on google")
	public void click_on_google() {
	    // Write code here that turns the phrase above into concrete actions
	    login.ClickOnGoogle();
	}

	@Then("provide invalid email-id")
	public void provide_invalid_email_id() {
	    // Write code here that turns the phrase above into concrete actions
	   login.HandleWindow();
	   login.setEmail("abcd@gmail.com");
	}

	@Then("click on next")
	public void click_on_next() {
	    // Write code here that turns the phrase above into concrete actions
	   login.ClickNext();
	}

	@Then("capture the error message")
	public void capture_the_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	    login.Capturerror();
	}
}
