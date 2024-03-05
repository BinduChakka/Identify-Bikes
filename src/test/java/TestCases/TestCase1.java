package TestCases;

import java.io.IOException;

import java.util.List;

import org.testng.annotations.Test;
import PageFactory.BaseClass;
import PageObjectModel.Home;
import PageObjectModel.Login;
import PageObjectModel.Newbikes;
import PageObjectModel.UsedCars;
import Utils.ExcelUtils;


public class TestCase1 extends BaseClass
{
	
	
	public Home homepage;
	public Newbikes NewBikes;
	public UsedCars Usedcars;
	public Login login;
	
	
	//Homes
	@Test(priority=1 ,groups= {"smoke"})
	 public void ZigWheelsHome() throws InterruptedException, IOException
	{
		homepage=new Home(driver);
		homepage.GoToNewBikes();
		//TakeScreenshot("ZigWheels Home");
		//homepage.clickOnUpcoming();
		//Thread.sleep(2000);
	
	}
	
	@Test(priority=2 ,groups= {"smoke"})
	public void ZigWheelsUpcoming() throws InterruptedException, IOException 
	{
		homepage.clickOnUpcoming();
		//TakeScreenshot("Upcoming");
		logger.info("Upcoming");
		//Thread.sleep(2000);
	}
	
	
			//NewBikes
	@Test(priority=3 ,groups= {"regression"})
	public void ZigWheelsNewBikes() throws IOException, InterruptedException
	{
		NewBikes=new Newbikes(driver);
		NewBikes.ClickOnManufactures();
		logger.info("Successfully clicked on Manufacture");
		//TakeScreenshot("Manufactures");
		
	}
	
	
	@Test(priority=4 ,groups= {"regression"})
	public void ZigWheelsReadMore() throws IOException
	{
		NewBikes.ClickReadMore();
		//TakeScreenshot("ReadMore");
		
		
	}
	
	@Test(priority=5 ,groups= {"smoke"})
	public void ZigWheelsScrollDown1() throws IOException
	{
		NewBikes.ScrollDown();
		logger.info("Bikes");
		//TakeScreenshot("List");
		
		
	}
	
	
	@Test(priority=6 ,groups= {"smoke"})
	public void ZigWheelsLessThan4Lakhs() throws IOException, InterruptedException
	{
		NewBikes.LessThan4Lakhs();
		//TakeScreenshot("Upcoming Bikes List");
		List<String> model=NewBikes.getModelNames();
		List<String> price=NewBikes.getPrices();
		List<String> date=NewBikes.getLaunchDates();
		logger.info("Bikes List");
		System.out.println(model);
		System.out.println(price);
		System.out.println(date);
		//Thread.sleep(2000);
		
		ExcelUtils.excelOutput(model,price,date);
		
	}
	
	@Test(priority=7 ,groups= {"smoke"})
	public void ZigWheels()
	{
		NewBikes.ZigWheels();
	}
	
	
	
	//UsedCars
	@Test(priority=8 ,groups= {"regression"})
	public void ZigWheelsUsedCars() throws IOException, InterruptedException
	{
		Usedcars=new UsedCars(driver);
		Usedcars.GoToUsedCars();
		//TakeScreenshot("Used Cars");
		
			
	}
	
	
	@Test(priority=9 ,groups= {"smoke"})
	public void ZigWheelsChennai()
	{
		Usedcars.Chennai();
		logger.info("Selected chennai");
		
		
	}
	
	
	@Test(priority=10 ,groups= {"smoke"})
	public void ZigWheelsScrollDown() throws IOException
	{
		Usedcars.ScrollDown1();
		//TakeScreenshot("List");
		ExcelUtils.excelOutput(Usedcars.ListPoularCars());
		
		
	}
	
	
	//Login
	
	@Test(priority=11 ,groups= {"regression"})
	public void ZigWheelsLogin() throws IOException, InterruptedException
	{
		login=new Login(driver);
		//Thread.sleep(3000);
		login.NavigateTo();
		logger.info("Successfully navigated to ZigWheels");
		
	}
	
	
	@Test(priority=12 ,groups= {"smoke"})
	public void ZigWheelsClickOnLogin() throws IOException
	{
		login.ClickOnLogin();
		//TakeScreenshot("Login");
		
		
	}
	
	
	@Test(priority=13 ,groups= {"smoke"})
	public void ZigWheelsClickOnGoogle()
	{
		login.ClickOnGoogle();
		logger.info("Clicked on login");
		
	}
	
	
	@Test(priority=14 ,groups= {"regression"})
	public void ZigWheelsHandleWindow()
	{
		login.HandleWindow();
		
	}
	
	
	@Test(priority=15 ,groups= {"smoke"})
	public void ZigWheelssetEmail() throws IOException, InterruptedException
	{
		login.setEmail("abcd@gmail.com");
		//TakeScreenshot("Email");
		logger.info("Email entered");
		//Thread.sleep(2000);
		
	}
	
	
	@Test(priority=16 ,groups= {"regression"})
	public void ZigWheelsClickNext()
	{
		login.ClickNext();
		
	}
	
	
	@Test(priority=17 ,groups= {"regression"})
	public void ZigWheelsCapturerror() throws IOException
	{
		login.Capturerror();
		logger.info("Error Captured");
		//TakeScreenshot("Capture Error");
	}	
	
	
}