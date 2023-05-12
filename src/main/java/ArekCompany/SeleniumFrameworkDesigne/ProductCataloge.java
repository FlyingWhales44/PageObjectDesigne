package ArekCompany.SeleniumFrameworkDesigne;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ArekCompany.reusable.AbstractComponent;

public class ProductCataloge extends AbstractComponent {

	WebDriver driver;

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	@FindBy(css = "[routerlink='/dashboard/cart']")
	WebElement cart;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.xpath("//button[contains(@class,'w-10 rounded')]");
	By toastMessage = By.cssSelector("#toast-container");

	ProductCataloge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getProducts() {
		waitForElementToAppear(productsBy);

		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement product = getProducts().stream()
				.filter(p -> p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);

		return product;
	}

	public void addProductToCart(String productName) {
		getProductByName(productName).findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		// waitForElementToDissapear(spinner);

		// aplikacja jest zle zaprojektowana :/
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
