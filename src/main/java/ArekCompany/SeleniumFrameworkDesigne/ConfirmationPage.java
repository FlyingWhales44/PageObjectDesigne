package ArekCompany.SeleniumFrameworkDesigne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ArekCompany.reusable.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	WebDriver driver;

	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;

	ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // dzięki temu możemy używać lokatorów
	}

	String getConfirmationMessage() {
		return confirmationMessage.getText();
	}
}
