package ZigWheels;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



      public class Bikes {
	        public WebDriver driver;
	        DriverSetup ds=new DriverSetup();
	
       public void test() throws IOException, InterruptedException {
			this.driver=ds.driverSet();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
			// Maximise browser window
			
		    driver.manage().window().maximize();
		    
		    //TestCase 1
		    //open Application
		    //zigwheels.com 
		    
		    driver.get("https://www.zigwheels.com/");
		    Thread.sleep(10000);
		    
		    //move to New Bikes
		    
            WebElement element=driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/a"));
            Actions act = new Actions(driver);
            act.moveToElement(element).build().perform();

            //click on upcoming
		    
		    driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/ul/li[5]/span")).click();
		    
		    //click on manufactures
		    
		    WebElement w=driver.findElement(By.xpath("//*[@id=\"makeId\"]"));
		    Thread.sleep(3000);
		    
		    
		    //click Honda from the Dropdown
		    
		    Select dropdown = new Select(w);
		    dropdown.selectByValue("53");
		    
		    //click read more
		    
		    driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[1]/div/div[2]/span/span")).click();
		    Thread.sleep(5000);
		    
		    //Display bikes details
		    
		    List<WebElement> model= driver.findElements(By.xpath("//tr[@class=\"ml-15 \"]//td[1]"));
		    List<WebElement> price= driver.findElements(By.xpath("//tr[@class=\"ml-15 \"]//td[2]"));
		    List<WebElement> launch= driver.findElements(By.xpath("//tr[@class=\"ml-15 \"]//td[3]"));	
		    List<Integer> index = new ArrayList<Integer>();
		    
		         for(int i=0;i<price.size();i++)
		         {
		        	 String  value=price.get(i).getText().replaceAll("[^0-9]","");			
		        	 if(Integer.parseInt(value)*1000<400000 &&  !(price.get(i).getText().contains("crore")))
		        	 {
		        		 index.add(i);
				     }
		        	 else if(!(price.get(i).getText().contains(" Lakh")))
		        	 {
		        		 index.add(i);
		        		 }
		        	 }
		         for(int i=0;i<model.size();i++) {
		        	 if(index.contains(i))
		        	 {
		        		 System.out.println(model.get(i).getText()+"-->"+price.get(i).getText()+"-->"+launch.get(i).getText());
		        	 }
		        	 }
                 Thread.sleep(5000);
                 
                 
                 //scrolldown
                 WebElement Element = driver.findElement(By.xpath("//*[@id=\"rhsDiv\"]/aside/div[3]/h2"));
                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("arguments[0].scrollIntoView();", Element);
                 Thread.sleep(5000);
                 
                 //click on zigwheels
                 driver.findElement(By.xpath("//*[@id=\"Header\"]/div/div[1]/div[1]/a")).click();
                 
		    
		    
		     //TestCase 2
		     //go to used cars
		    
		     WebElement ele=driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/a"));
             Actions action =new Actions(driver);
             action.moveToElement(ele).build().perform();
             Thread.sleep(5000);
            
             //click on chennai
            
             driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/ul/li/div[2]/ul/li[4]/span")).click();

		     //scroll until popular models
            
             WebElement Elements = driver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div[1]/div[1]/div[2]/ul/li[2]/div[2]/div[4]"));
             JavascriptExecutor jas = (JavascriptExecutor) driver;
             jas.executeScript("arguments[0].scrollIntoView();", Elements);
             Thread.sleep(5000);
            
             //Display popular car models
            
             List<WebElement> popular_models = driver.findElements(By.xpath("//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li"));
    		 for(WebElement models : popular_models)
    		 {
    			System.out.println(models.getText());
    		 }
    		 Thread.sleep(5000);
    		 
    		 
    		 //TestCase 3
    		 //Navigate back
    		 
    		 driver.navigate().back();
    		 driver.navigate().refresh();
    		 //driver.navigate().to("https://www.zigwheels.com/");
    		 
    		 //click on login
    		 
    		 driver.findElement(By.xpath("//*[@id=\"des_lIcon\"]")).click();
    		 Thread.sleep(5000);
    		 
    		 //click on google
    		 
    		 driver.findElement(By.xpath("//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")).click();
    		 
    		 //handling window
    		 
    		 Set<String> windowids = driver.getWindowHandles();
    		 List<String> windowid =new ArrayList<String>(windowids);
    		 driver.switchTo().window(windowid.get(1));
    		 
    		 //maximise window
    		 
    		 driver.manage().window().maximize();
    		 
    		 //enter email
    		 
    		 driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("abcd@gmail.com");
    		 
    		 //click next
    		 
    		 driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
    		 Thread.sleep(5000);
    		 
    		 //capture error
    		 
    		 String warning_text=driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")).getText();
    			System.out.println(warning_text);
  
             //close
     
             driver.quit();
      
             }
             public static void main(String[] args) throws InterruptedException, IOException 
             {
  		
  		        Bikes obj=new Bikes ();
  		        obj.test();
             }
          }
      
      
      
      