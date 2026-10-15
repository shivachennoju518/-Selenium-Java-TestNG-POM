package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {
    @Test
    public void completeCheckout() {

        // Step 1: Login
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");
//        lp.clickLogin();


        // Step 2: Product page
        InventoryPage ip = new InventoryPage(driver);

        Assert.assertEquals(
                ip.getProductName(),
                "Sauce Labs Backpack"
        );

        Assert.assertEquals(
                ip.getPrice(),
                "$29.99","Product price mismatch"
        );

        ip.addProductToCart();

        Assert.assertEquals(ip.getCartCount(), "1");

        // Step 3: Cart page
        ip.openCart();

        CartPage cp = new CartPage(driver);
        System.out.print("Cart product: " + cp.getProductName());

        Assert.assertEquals(cp.getProductName(),
                "Sauce Labs Backpack","Product name mismatch on Inventory page"
        );

        cp.clickCheckout();

        // Step 4: Checkout information
        CheckoutPage ch = new CheckoutPage(driver);

        ch.enterDetails("John", "Tester", "500001");
        ch.clickContinue();

        Assert.assertEquals(
                ch.getSummaryProductName(),
                "Sauce Labs Backpack"
        );

        Assert.assertTrue(
                ch.getTotal().contains("$")
        );

        // Step 5: Complete order
        ch.clickFinish();

        Assert.assertEquals(
                ch.getConfirmationMessage(),
                "Thank you for your order!"
        );
    }
}
