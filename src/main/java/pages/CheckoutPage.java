package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
     private final WebDriver driver;
    private final  By firstName = By.id("first-name");
    private final  By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");

    private final By summaryProduct =
            By.className("inventory_item_name");

    private final  By total =
            By.className("summary_total_label");

    private final  By confirmation =
            By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String first, String last,
                             String postal) {
        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(postalCode).sendKeys(postal);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getSummaryProductName() {
        return driver.findElement(summaryProduct).getText();
    }

    public String getTotal() {
        return driver.findElement(total).getText();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmation).getText();
    }
}
