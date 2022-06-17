package helper;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageobjects.Home;
import pageobjects.Registration;

//driver specific code
public class DriverFactory {
	public WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	public Registration reg;
	public Home home;
	protected String browser;

	@BeforeTest
	@Parameters(value = { "browser" })
	public void beforeMethod(String browser) throws MalformedURLException, InterruptedException {
		this.browser = browser;
		switch (browser.toLowerCase()) {

		case "localchrome":
			io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup(); //chrome driver
			driver = new ChromeDriver();
			break;
			
		case "localfirefox":
			io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup(); // gecko driver 
			driver = new FirefoxDriver();
			break;

		default:
			throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
		}
		//driver initialization
		reg = PageFactory.initElements(driver, Registration.class);
		home = PageFactory.initElements(driver, Home.class);
		reg.setBrowser(this.browser);
		home.setBrowser(this.browser);
		driver.get("https://www.match.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
