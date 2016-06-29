package twitter.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

public class MainForm extends BaseForm {

    private TextBox txbUsername = new TextBox(By.id("signin-email"), "Username textbox");
    private TextBox txbPassword = new TextBox(By.id("signin-password"), "Password textbox");
    private Button btnLogin = new Button(By.xpath("//button[contains(@class, 'flex-table-btn')]"), "Login");

    public MainForm() {
        super(By.xpath("//div[contains(@class, 'front-signin')]"), "Sign in");
    }

    public void login(String username, String password) {
        txbUsername.type(username);
        txbPassword.type(password);
        btnLogin.click();
    }

}
