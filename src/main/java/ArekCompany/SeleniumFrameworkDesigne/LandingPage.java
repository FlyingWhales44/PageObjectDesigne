package ArekCompany.SeleniumFrameworkDesigne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ArekCompany.reusable.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // dzięki temu możemy używać lokatorów
	}

	@FindBy(id = "userEmail") // driver.findElement(By.id("userEmail)
	WebElement userMail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement loginButton;

	@FindBy(css = "[class*='flyInOut'")
	WebElement errorMessage;

	ProductCataloge login(String userMail, String password) {
		this.userMail.sendKeys(userMail);
		this.password.sendKeys(password);
		loginButton.click();

		return new ProductCataloge(driver);
	}

	public void goTo() {
		driver.get("http://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
