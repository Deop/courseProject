package twitter.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

public class LoginForm extends BaseForm {

    private TextBox txbPassword = new TextBox(By.xpath("//input[@type='password']"), "Password textbox");
    private Button btnLogin = new Button(By.xpath("//button[@type='submit']"), "Login");
    private Label lblLoginLink = new Label(By.id("signin-link"));

    public LoginForm() {
        super(By.id("message-drawer"), "Incorrect login form");
    }

    public void enterCorrectPasswordAndLogin(String password) {
        txbPassword.type(password);
        btnLogin.click();
    }
}
