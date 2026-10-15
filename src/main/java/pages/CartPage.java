package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
     private final By cartProduct=By.className("inventory_item_name");
    private final  By removeButton=By.id("remove-sauce-labs-backpack");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    public String getProductName(){
       return  driver.findElement(cartProduct).getText();
    }
    public void removeProduct(){
        driver.findElement(removeButton).click();
    }
    public void clickCheckout(){
        driver.findElement(checkoutButton).click();
    }
}
