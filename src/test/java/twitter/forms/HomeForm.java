package twitter.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.lift.find.InputFinder;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

public class HomeForm extends BaseForm {

    private Label lblTweetCounter = new Label(By.xpath("//a[contains(@data-element-term, 'tweet_stats')]/span[contains(@class, 'statValue')]"), "Tweet counter");
    private Button btnNewTweet = new Button(By.id("global-new-tweet-button"), "New Tweet");
    private Label lblTweetBlock = new Label(By.xpath("//div[@class='stream']/ol[contains(@class, 'stream-items')]"), "Tweets");
    private Label lblTweetPosted = new Label(By.xpath("//div[@id='message-drawer']/div"), "Tweet Posted");
    private Button btnProfileIcon = new Button(By.id("user-dropdown-toggle"), "Profile Icon");
    private Label lblUserDropdown = new Label(By.id("user-dropdown"), "User Dropdown menu");
    private Button btnLogout = new Button(By.id("signout-button"), "Sign Out");

    public HomeForm() {
        super(By.xpath("//div[@class='stream']/ol[contains(@class, 'stream-items')]"), "Tweets");
    }

    public String getTweetsNumber(){
        return lblTweetCounter.getText();
    }

    public void clickNewTweetButton(){
        btnNewTweet.click();
    }

    public void verifyTweetsNumberIncreasedByOne(String initialTweetsNumber){
        info("Verifying that tweets counter increased by 1");
        String tweetsNumber = getTweetsNumber();
        Assert.assertTrue(Integer.parseInt(tweetsNumber) - Integer.parseInt(initialTweetsNumber) == 1, "Tweets counter did not increase by 1");
    }

    public void waitForTweetsBlock(){
        lblTweetBlock.waitForIsElementPresent();
    }

    public void waitForTweetPostedMessage(){
        lblTweetPosted.waitForIsElementPresent();
    }

    public void clickProfileIcon(){
        btnProfileIcon.click();
    }

    public void waitForUserDropDown(){
        lblUserDropdown.waitForIsElementPresent();
    }

    public void logout(){
        btnLogout.click();
    }
}
