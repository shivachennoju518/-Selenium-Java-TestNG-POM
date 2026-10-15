package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By username=By.id("user-name");  // locators
    private final By password=By.id("password");
    private final By loginButton=By.id("login-button");
    private final By errorMessage=By.cssSelector("[data-test='error']");


    public LoginPage(WebDriver driver){ // construtor

        this.driver=driver;
    }

    public void enterUserName(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }


    public String getErrorMessage(){
       return driver.findElement(errorMessage).getText();
    }

    public void login(String user, String pass) {
        enterUserName(user);
        enterPassword(pass);
        clickLogin();
    }


                                                }

