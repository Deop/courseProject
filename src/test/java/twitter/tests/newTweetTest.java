package twitter.tests;

import org.testng.Assert;
import twitter.forms.HomeForm;
import twitter.forms.MainForm;
import twitter.forms.NewTweetForm;
import webdriver.BaseTest;

public class newTweetTest extends BaseTest {

    private String initialTweetsNumber;

    public void runTest() {
        logger.step(1);
        MainForm mainPage = new MainForm();

        logger.step(2);
        mainPage.login("qatester11593@gmail.com", "twAt09#");
        HomeForm homeForm = new HomeForm();

        logger.step(3);
        initialTweetsNumber = homeForm.getTweetsNumber();
        info("Initial tweets number - " + initialTweetsNumber);

        logger.step(4);
        homeForm.clickNewTweetButton();
        NewTweetForm newTweetForm = new NewTweetForm();

        logger.step(5);
        newTweetForm.enterMessage("test");
        newTweetForm.sendTweet();
        homeForm.waitForTweetsBlock();

        logger.step(6);
        homeForm.refreshAndWait();
        homeForm.verifyTweetsNumberIncreasedByOne(initialTweetsNumber);
    }

}
