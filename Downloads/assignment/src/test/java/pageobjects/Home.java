package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import helper.DriverFactory;

public class Home extends DriverFactory {

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "a[href*='profile/me']")
	private List<WebElement> userIcon;
	
	@FindBy(css = "a[href*='/search']")
	private WebElement searchIcon;
	
	@FindBy(css = ".ReactVirtualized__Grid__innerScrollContainer")
	private List<WebElement> searchGrid;
	
	@FindBy(css = ".ReactVirtualized__List a h2 [aria-hidden*='true']")
	private WebElement storeProfileName;
	
	@FindBy(css = "button[aria-label*='menu']")
	private WebElement menuButton;
	
	@FindBy(css = "#popover-dialog li:nth-of-type(3) button")
	private WebElement blockUser;
	
	@FindBy(css = "#popover-dialog li:nth-of-type(2) button")
	private WebElement hideUser;
	
	@FindBy(css = "#modalHeader button")
	private WebElement skipVerificationPage;
	
	@FindBy(css = ".col-left .btn-continue")
	private WebElement waitForSubscriptionPage;
	
	@FindBy(css = "#rateCardControlPlaceholder h1, #rateCardControlPlaceholder h3")
	private WebElement subscriptionPage;

	public void homepageValidations() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
		Assert.assertTrue(userIcon.size()>0); 
		searchIcon.click();
		//Assert.assertTrue(searchGrid.size()>0);
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(storeProfileName));
		String blockedProfileName = storeProfileName.getText();
		menuButton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(blockUser));
		blockUser.click();
		driver.navigate().refresh();
		
		wait.until(ExpectedConditions.elementToBeClickable(skipVerificationPage));
		skipVerificationPage.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(storeProfileName));
		Assert.assertNotEquals(storeProfileName.getText(),blockedProfileName);
		menuButton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(hideUser));
		hideUser.click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(waitForSubscriptionPage));
		Assert.assertEquals(subscriptionPage.getText(),"Select Your Plan and Lock In Your Rate:");
	}
}
