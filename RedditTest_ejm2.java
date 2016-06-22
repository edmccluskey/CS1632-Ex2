import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


/**
 * As a user,
 * I would like to see reddit links in all sorts of ways,
 * So that I can know what is happening in the world
 * @author wlaboon
 *
 */

public class RedditTest_ejm {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for reddit for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.reddit.com");
	}
	
	// Given that I am not logged on to Reddit
	// When I go to the front page
	// Then I should see that a search textbox appears
	@Test
	public void testSearchboxAppears() {
		
		//not logged in
		try {
			driver.findElement(By.id("login_login-main"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
		
		//check for search box
		try {
			driver.findElement(By.id("search"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
		
	}
	
	// Given that I am not logged in to Reddit
	// When I go to the "new" page
	// Then I should see that there are username and password textboxes
	@Test
	public void testNewPage_usernameandpwboxes() {
		//not logged in
		try {
			driver.findElement(By.id("login_login-main"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
		//click New page
		driver.findElement(By.linkText("new")).click();

		//check for username and pw
		try {
			driver.findElement(By.name("user"));
		} catch (NoSuchElementException nseex) {
			fail();
		}		
		try {
			driver.findElement(By.name("passwd"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	// Given some string for which I would like to search
	// And which has been used in a previous submission
	// When I search for that string
	// Then I should see at least one instance of that string in the search results
	@Test
	public void testStringsearch() {
		
		// Simply check that the title contains the word "reddit"
		
		String title = driver.getTitle();
		assertTrue(title.contains("reddit"));
	}
	
	// Given that I have logged in to Reddit
	// When I visit any page
	// Then I should see my username
	// And a link to log off
	@Test
	public void testLoginShowusername_logofflink() {
		// Enter username "meow", password "meow"
		
		driver.findElement(By.name("user")).sendKeys("meow");
		driver.findElement(By.name("passwd")).sendKeys("meow");
	
		//look for username
		try {
			driver.findElement(By.linkText("meow"));
		} catch (NoSuchElementException nseex) {
			fail();
		//look for logoff link
		try {
			driver.findElement(By.linkText("logout"));
		} catch (NoSuchElementException nseex) {
			fail();
				
	}
	
	// Given that I have logged in to Reddit
	// When I click on a comment thread
	// Then there should be a textbox where I can type in my witty comments
	@Test
	public void testLoginshowcommenttextbox() {
		// Enter username "meow", password "meow"
		
		driver.findElement(By.name("user")).sendKeys("meow");
		driver.findElement(By.name("passwd")).sendKeys("meow");
		
		
		//click a comments button
		WebElement commentsButton = driver.findElement(By.linkText("comments"));
		commentsButton.click();
		
		//look for textarea
		try {
			driver.findElement(By.name("textarea"));
		} catch (NoSuchElementException nseex) {
			fail();
				
	}
	
	// Given that I have logged in to Reddit
	// When I click my username
	// Then I should see my link karma
	// And my comment karma
	@Test
	public void testLoginShowlinkandcommentkarma() {
		// Enter username "meow", password "meow"
		
		driver.findElement(By.name("user")).sendKeys("meow");
		driver.findElement(By.name("passwd")).sendKeys("meow");
		
		// Look for the submit button (in the login div) and click
		// to attempt to login 
		

		//look for karma
		try {
			driver.findElement(By.id("span.userkarma"));
		} catch (NoSuchElementException nseex) {
			fail();
				
	}

	

}
