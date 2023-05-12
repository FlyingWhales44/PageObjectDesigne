package ArekCompany.SeleniumFrameworkDesigne;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ArekCompany.reusable.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	@FindBy(css = ".cartSection h3")
	List<WebElement> products;

	@FindBy(css = ".totalRow .btn.btn-primary")
	WebElement checkoutButton;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // ta linijka umożliwia używanie FindBy!
	}

	public Boolean verifyIfProductIsInCart(String productName) {
		return products.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));

	}

	public CheckoutPage goToCheckout() {
		checkoutButton.click();
		return new CheckoutPage(driver);
	}
}
