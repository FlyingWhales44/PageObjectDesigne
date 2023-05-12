package ArekCompany.reusable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ArekCompany.SeleniumFrameworkDesigne.CartPage;
import ArekCompany.SeleniumFrameworkDesigne.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	WebDriverWait wait;

	// ten element może być uniwersalnie używany
	@FindBy(css = "[routerlink='/dashboard/cart']")
	WebElement cart;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void waitForElementToAppear(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToDissapear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public CartPage goToCart() {
		cart.click();
		return new CartPage(driver);
	}

	public OrderPage goToOrderPage() {
		orderHeader.click();

		return new OrderPage(driver);
	}
}
