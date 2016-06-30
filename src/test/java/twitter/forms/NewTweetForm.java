package twitter.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

import java.util.Random;

public class NewTweetForm extends BaseForm {

    private TextBox txbTweetBox = new TextBox(By.id("tweet-box-global"), "Tweet Box");
    private Button btnSendTweet = new Button(By.xpath("//div[contains(@class, 'modal-tweet-form-container')]//button[contains(@class, 'tweet-action')]"), "Send Tweet");

    public NewTweetForm() {
        super(By.className("modal-tweet-form-container"), "New Tweet Form Container");
    }

    public void enterMessage(String message){
        txbTweetBox.type(generateTweetMessage(message));
    }

    public void sendTweet(){
        btnSendTweet.clickAndWait();
    }

    public String generateTweetMessage(String message){
        Random random = new Random();
        int randomNumber = random.ints(1, 0, 200).findFirst().getAsInt();
        return message + " " + randomNumber;
    }

}
