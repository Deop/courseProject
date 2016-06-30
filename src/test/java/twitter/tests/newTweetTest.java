package twitter.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import twitter.forms.HomeForm;
import twitter.forms.MainForm;
import twitter.forms.NewTweetForm;
import webdriver.BaseTest;

public class NewTweetTest extends BaseTest {

    private String initialTweetsNumber;
    private String login;
    private String password;
    private String tweetMessage;

    @BeforeTest
    @Parameters({"Login", "Password", "TweetMessage"})
    public void readParams(String login, String password, String tweetMessage){
        this.login = login;
        this.password = password;
        this.tweetMessage = tweetMessage;
    }

    public void runTest() {
        logger.step(1);
        MainForm mainPage = new MainForm();

        logger.step(2);
        mainPage.login(login, password);
        HomeForm homeForm = new HomeForm();

        logger.step(3);
        initialTweetsNumber = homeForm.getTweetsNumber();
        info("Initial tweets number - " + initialTweetsNumber);

        logger.step(4);
        homeForm.clickNewTweetButton();
        NewTweetForm newTweetForm = new NewTweetForm();

        logger.step(5);
        newTweetForm.enterMessage(tweetMessage);
        newTweetForm.sendTweet();
        homeForm.waitForTweetPostedMessage();

        logger.step(6);
        homeForm.refreshAndWait();
        homeForm.verifyTweetsNumberIncreasedByOne(initialTweetsNumber);
    }

}
