package Steps;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class updatePasswordSteps{
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	@After
	public void clenup() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
	
	
	@Given("I login to the timetracker as an existing user")
	public void i_login_to_the_timetracker_as_an_existing_user(DataTable testData) throws Exception {
		List<String> details = testData.asList(String.class);
		try {
	
		driver.get("https://timetracker.anuko.com/login.php");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.findElement(By.id("login")).sendKeys(details.get(0));
		Thread.sleep(20);
		System.out.println("Entered Username");
		driver.findElement(By.id("password")).sendKeys(details.get(1));

		Thread.sleep(10);
		System.out.println("Entered Password");
		driver.findElement(By.id("btn_login")).click();
		System.out.println("Clicked on Login button");
		
		WebElement Logoutele = driver.findElement(By.linkText("Profile"));
		Logoutele.isDisplayed();
		System.out.println("Logged in successfully");
		}
		catch (Exception e){
	    	System.out.println("Something went wrong. Got exception:"+ (e).toString());
	    	
	    }
		Thread.sleep(30);
		
	}
	
	
	@And("I update the Password of the user")
	public void i_update_the_Password_of_the_user(DataTable testData1) throws Exception {
		List<String> newdetails = testData1.asList(String.class);
	  try {
	  driver.findElement(By.linkText("Profile")).click();
	  System.out.println("Clicked on Profile link");
	  
	  driver.findElement(By.id("password1")).clear();
	  driver.findElement(By.id("password1")).sendKeys(newdetails.get(0));
	  System.out.println("Entered new password");
	  
	  driver.findElement(By.id("password2")).clear();
	  driver.findElement(By.id("password2")).sendKeys(newdetails.get(1));
	  System.out.println("Entered new password in Confirm password field");
	  
	  driver.findElement(By.id("btn_save")).click();
	  System.out.println("Clicked on Save button");
	  }
	  catch (Exception e){
	    	System.out.println("Something went wrong. Got exception:"+ (e).toString());
	    	
	    }
	  Thread.sleep(40);
	}
	  
	@And("I update the Login of the user")
	public void i_update_the_login_of_the_user(DataTable testData4) throws Exception {
		List<String> newdetails = testData4.asList(String.class);
		  try {
		  driver.findElement(By.linkText("Profile")).click();
		  System.out.println("Clicked on Profile link");
		  
		  driver.findElement(By.id("login")).clear();
		  driver.findElement(By.id("login")).sendKeys(newdetails.get(0));
		  System.out.println("Entered new password");
		  
  		  driver.findElement(By.id("btn_save")).click();
		  System.out.println("Clicked on Save button");
		  }
		  catch (Exception e){
		    	System.out.println("Something went wrong. Got exception:"+ (e).toString());
		    	
		    }
		  Thread.sleep(40);
	}

	@And("I logout from the timetracker")
	public void i_logout_from_the_timetracker() throws Exception {
	    try {
		driver.findElement(By.linkText("Logout")).click();
	    WebElement elelogintitle = driver.findElement(By.className("page-title"));
	    elelogintitle.isDisplayed();
	    System.out.println("Logged out successfully");
	}
	    catch (Exception e){
	    	System.out.println("Something went wrong. Got exception:"+ (e).toString());
	    	
	    }
	    	Thread.sleep(40);
	    }

	@When("I login with the updated timetracker user details")
	public void i_login_with_the_updated_timetracker_user_details(DataTable testData3) throws Exception {
	 List<String> updatedcreds = testData3.asList(String.class);
	 try {
				driver.get("https://timetracker.anuko.com/login.php");
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				
				driver.findElement(By.id("login")).clear();
				driver.findElement(By.id("login")).sendKeys(updatedcreds.get(0));
				Thread.sleep(20);
				System.out.println("Entered Username");
				driver.findElement(By.id("password")).clear();
				driver.findElement(By.id("password")).sendKeys(updatedcreds.get(1));
				Thread.sleep(10);
				System.out.println("Entered Password");
				driver.findElement(By.id("btn_login")).click();
				System.out.println("Clicked on Login button");
				
				WebElement Logoutele = driver.findElement(By.linkText("Profile"));
				Logoutele.isDisplayed();
				System.out.println("Logged in successfully");
				}
				catch (Exception e){
			    	System.out.println("Something went wrong. Got exception:"+ (e).toString());
			    	
			    }
	 Thread.sleep(40);
	 }
		


	@Then("I am able to login successfully")
	public void i_am_able_to_login_successfully() throws Exception {
		try {
			WebElement Logoutlink = driver.findElement(By.linkText("Logout"));
			Logoutlink.isDisplayed();
		}
		catch (Exception e) {
			System.out.println("Something went wrong. Got Exception:"+(e).toString());
		}
	   
	}
	
	

}
