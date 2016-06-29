package twitter.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import twitter.forms.*;
import webdriver.BaseTest;

public class VerifyLoginLogoutProcedureTest extends BaseTest {

    private String login;
    private String password;
    private String incorrectPassword;

    @BeforeTest
    @Parameters({"Login", "Password", "IncorrectPassword"})
    public void readParams(String login, String password, String incorrectPassword){
        this.login = login;
        this.password = password;
        this.incorrectPassword = incorrectPassword;
    }

    public void runTest() {
        logger.step(1);
        MainForm mainPage = new MainForm();

        logger.step(2);
        mainPage.login(login, incorrectPassword);
        LoginForm loginForm = new LoginForm();

        logger.step(3);
        loginForm.enterCorrectPasswordAndLogin(password);
        HomeForm homeForm = new HomeForm();

        logger.step(4);
        homeForm.clickProfileIcon();
        homeForm.waitForUserDropDown();

        logger.step(5);
        homeForm.logout();
        DownloadForm downloadForm = new DownloadForm();
    }

}
