package twitter.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.lift.find.InputFinder;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

import java.util.List;

public class HomeForm extends BaseForm {

    private Label lblTweetCounter = new Label(By.xpath("//a[contains(@data-element-term, 'tweet_stats')]/span[contains(@class, 'statValue')]"), "Tweet counter");
    private Button lblFollowingCounter = new Button(By.xpath("//a[contains(@data-element-term, 'following_stats')]/span[contains(@class, 'statValue')]"), "Following counter");
    private Button btnNewTweet = new Button(By.id("global-new-tweet-button"), "New Tweet");
    private Label lblTweetPosted = new Label(By.xpath("//div[@id='message-drawer']/div"), "Tweet Posted");
    private Button btnProfileIcon = new Button(By.id("user-dropdown-toggle"), "Profile Icon");
    private Label lblUserDropdown = new Label(By.id("user-dropdown"), "User Dropdown menu");
    private Button btnLogout = new Button(By.id("signout-button"), "Sign Out");
    private String btnFollowRecommendedUserPattern = "//div[contains(@class, 'js-recommended-followers')]/div[%s]//button";
    private String btnFollowingRecommendedUserPattern = "//div[contains(@class, 'js-recommended-followers')]/div[%s]//button/div[contains(@class, 'following-text')]";
    private String lblRecommendedUserFullName = "//div[contains(@class, 'js-recommended-followers')]/div[%s]//b[@class='fullname']";

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

    public void waitForTweetPostedMessage(){
        lblTweetPosted.waitForIsElementPresent();
    }

    public void clickProfileIcon(){
        btnProfileIcon.clickAndWait();
    }

    public void waitForUserDropDown(){
        lblUserDropdown.waitForIsElementPresent();
    }

    public void logout(){
        btnLogout.click();
    }

    public String getFollowingNumber(){
        return lblFollowingCounter.getText();
    }

    public String getRecommendedUserName(String userNumber){
        Label lblRecommendedUserName = new Label(By.xpath(String.format(lblRecommendedUserFullName, userNumber)));
        return lblRecommendedUserName.getText();
    }

    public void followRecommendedUser(String userNumber){
        Button btnRecommendedUser = new Button(By.xpath(String.format(btnFollowRecommendedUserPattern, userNumber)), "Follow");
        btnRecommendedUser.clickAndWait();
    }

    public void verifyFollowingButton(String userNumber){
        Button btnRecommendedUser = new Button(By.xpath(String.format(btnFollowingRecommendedUserPattern, userNumber)), "Following");
        Assert.assertTrue(btnRecommendedUser.isPresent());
    }

    public void verifyFollowingNumberIncreasedByOne(String initialFollowingNumber){
        info("Verifying that following counter increased by 1");
        String followingNumber = getFollowingNumber();
        Assert.assertTrue(Integer.parseInt(followingNumber) - Integer.parseInt(initialFollowingNumber) == 1, "Following counter did not increase by 1");
    }

    public void clickFollowingButton(){
        lblFollowingCounter.clickAndWait();
    }

}
