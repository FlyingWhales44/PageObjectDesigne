package ArekCompany.SeleniumFrameworkDesigne;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ArekCompany.reusable.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> products;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // ta linijka umożliwia używanie FindBy!
	}

	public Boolean verifyOrderDisplay(String productName) {
		return products.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));

	}
}
