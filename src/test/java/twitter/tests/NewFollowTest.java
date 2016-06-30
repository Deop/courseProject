package twitter.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import twitter.forms.HomeForm;
import twitter.forms.MainForm;
import twitter.forms.NewTweetForm;
import twitter.forms.UserFollowingForm;
import webdriver.BaseTest;

public class NewFollowTest extends BaseTest {

    private String initialFollowingNumber;
    private String login;
    private String password;
    private String userNumber;
    private String recommendedUserName;

    @BeforeTest
    @Parameters({"Login", "Password", "UserNumber"})
    public void readParams(String login, String password, String userNumber){
        this.login = login;
        this.password = password;
        this.userNumber = userNumber;
    }

    public void runTest() {
        logger.step(1);
        MainForm mainPage = new MainForm();

        logger.step(2);
        mainPage.login(login, password);
        HomeForm homeForm = new HomeForm();

        logger.step(3);
        initialFollowingNumber = homeForm.getFollowingNumber();
        info("Initial following number - " + initialFollowingNumber);

        logger.step(4);
        recommendedUserName = homeForm.getRecommendedUserName(userNumber);
        homeForm.followRecommendedUser(userNumber);
        homeForm.verifyFollowingButton(userNumber);

        logger.step(5);
        homeForm.refreshAndWait();
        homeForm.verifyFollowingNumberIncreasedByOne(initialFollowingNumber);

        logger.step(6);
        homeForm.clickFollowingButton();
        UserFollowingForm userFollowingForm = new UserFollowingForm();
        userFollowingForm.verifyFollowingUserPresent(recommendedUserName);
        //homeForm.verifyTweetsNumberIncreasedByOne(initialTweetsNumber);
    }

}
