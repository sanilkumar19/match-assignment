package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DriverFactory;

public class Registration extends DriverFactory {

	public Registration(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement cookieButton;

	@FindBy(name = "ggs")
	private WebElement interestedDropdown;

	@FindBy(name = "lage")
	private WebElement lowerAge;

	@FindBy(name = "uage")
	private WebElement upperAge;

	@FindBy(name = "postalCode")
	private WebElement poCode;

	@FindBy(id = "viewSingles")
	private WebElement viewSingles;

	@FindBy(id = "birthDate")
	private WebElement birthDay;

	@FindBy(css = "#dobStep button")
	private WebElement thatsIt;

	@FindBy(name = "firstname")
	private WebElement firstName;

	@FindBy(css = "#firstnameStep button")
	private WebElement thatsMe;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(css = "#emailStep button")
	private WebElement thatsTheOne;

	@FindBy(name = "password")
	private WebElement passWord;

	@FindBy(css = "#passwordStep button.button-progressive")
	private WebElement thatsItPassword;

	@FindBy(css = ".skipSurvey")
	private List<WebElement> randomSkipCount;

	@FindBy(css = ".skipSurvey")
	private WebElement randomSkip;

	@FindBy(css = "[src*='circleNextButton']")
	private WebElement arrow;

	@FindBy(xpath = "(.//*[contains(text(),'Skip')])[1]")
	private WebElement skipButton;

	@FindBy(xpath = "(.//*[contains(text(),'Continue')])[1]")
	private WebElement continueButton;

	@FindBy(css = "#app button[class^='css']")
	private WebElement continueWithFreeButton;

	@FindBy(xpath = "(.//*[contains(text(),'Skip')])[3]")
	private WebElement skipVerificationPage;

	public void registration() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
		cookieButton.click();

		wait.until(ExpectedConditions.elementToBeClickable(interestedDropdown));
		Select intIn = new Select(interestedDropdown);
		intIn.selectByVisibleText("I am a Man seeking a Woman");

		wait.until(ExpectedConditions.elementToBeClickable(lowerAge));
		Select lage = new Select(lowerAge);
		lage.selectByVisibleText("25");

		wait.until(ExpectedConditions.elementToBeClickable(upperAge));
		Select uage = new Select(upperAge);
		uage.selectByVisibleText("30");

		wait.until(ExpectedConditions.elementToBeClickable(poCode));
		poCode.sendKeys("02740");

		wait.until(ExpectedConditions.elementToBeClickable(viewSingles));
		viewSingles.click();

		wait.until(ExpectedConditions.elementToBeClickable(birthDay));
		birthDay.sendKeys("06/06/1995");

		wait.until(ExpectedConditions.elementToBeClickable(thatsIt));
		thatsIt.click();

		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys("John");

		wait.until(ExpectedConditions.elementToBeClickable(thatsMe));
		thatsMe.click();

		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(System.currentTimeMillis()+"_@testxp.com");

		wait.until(ExpectedConditions.elementToBeClickable(thatsTheOne));
		thatsTheOne.click();

		wait.until(ExpectedConditions.elementToBeClickable(passWord));
		passWord.sendKeys("passw0rd");

		wait.until(ExpectedConditions.elementToBeClickable(thatsItPassword));
		thatsItPassword.click();
		Thread.sleep(3000);
		
		if (!(browser == "localfirefox")) {
			if (randomSkipCount.size() > 0) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(250,800)");
				Thread.sleep(1000);
				randomSkip.click();
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(arrow));
		arrow.click();

		wait.until(ExpectedConditions.elementToBeClickable(skipButton));

		for (int i = 1; i < 14; i++) {
			if (i == 12) {
				wait.until(ExpectedConditions.elementToBeClickable(continueButton));
				continueButton.click();
				wait.until(ExpectedConditions.elementToBeClickable(skipButton));
			}
			skipButton.click();
			Thread.sleep(2000);
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(continueWithFreeButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,800)");
        Thread.sleep(1000);
		continueWithFreeButton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(skipVerificationPage));
		skipVerificationPage.click();
		
	}
}
