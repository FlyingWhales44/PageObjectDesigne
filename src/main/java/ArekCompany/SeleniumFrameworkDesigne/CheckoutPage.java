package ArekCompany.SeleniumFrameworkDesigne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ArekCompany.reusable.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement selectCountry;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectIndia;

	@FindBy(css = ".action__submit")
	WebElement submit;

	By result = By.cssSelector(".ta-results");

	CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	void selectCountry(String name) {
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry, name).build().perform();

		waitForElementToAppear(result);

		selectIndia.click();
	}

	ConfirmationPage submit() {
		submit.click();
		return new ConfirmationPage(driver);
	}

}
