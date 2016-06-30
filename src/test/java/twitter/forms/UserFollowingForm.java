package twitter.forms;

import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Label;

public class UserFollowingForm extends BaseForm {

    private String lblFollowingUserNamePattern = "//div[@class='js-stream-item']//div[contains(@class,'ProfileNameTruncated')]//a[contains(text(), '%s')]";

    public UserFollowingForm() {
        super(By.xpath("//div[contains(@class, 'AppContent-main')]"), "User Following form");
    }

    public void verifyFollowingUserPresent(String userName){
        Label lblFollowingUserName = new Label(By.xpath(String.format(lblFollowingUserNamePattern, userName)), "UserName");
        Assert.assertTrue(lblFollowingUserName.isPresent());
    }

}
