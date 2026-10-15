package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final WebDriver driver;
    private final By productName =
            By.className("inventory_item_name");

    private final By price =
            By.className("inventory_item_price");
    private final By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();

    }

    public String getPrice() {
        return driver.findElement(price).getText();
    }

    public void addProductToCart() {
        driver.findElement(addToCart).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }


    public String getCartCount(){
         return driver.findElement(cartBadge).getText();
    }
}


