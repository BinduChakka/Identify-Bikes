package ZigWheels;

	import java.time.Duration;

	import java.util.Scanner;

	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.chrome.ChromeDriver;

	import org.openqa.selenium.edge.EdgeDriver;
	 
	public class DriverSetup {
	 
	    public WebDriver driver;

	    public WebDriver driverSet() {

	        Scanner sc = new Scanner(System.in);

	        try {

	            System.out.println("Enter the driver name (chrome/edge):");

	            String input = sc.nextLine();
	 
	            if (input.equalsIgnoreCase("chrome")) {

	                driver = new ChromeDriver();

	            } else if (input.equalsIgnoreCase("edge")) {

	                driver = new EdgeDriver();

	            } else {

	                System.out.println("Invalid driver name. Exiting...");

	                System.exit(1); // Exit the program if an invalid driver is provided

	            }
	 
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	            driver.manage().window().maximize();
	 
	            return driver;

	        } catch (Exception e) {

	            System.out.println("An error occurred: " + e.getMessage());

	            return null; // Return null in case of an error

	        } finally {

	            sc.close(); // Close the scanner in the finally block

	        }

	    }

	}