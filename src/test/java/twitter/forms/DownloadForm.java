package twitter.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;

public class DownloadForm extends BaseForm {

    public DownloadForm() {
        super(By.className("PageDownload-title"), "Download the app form");
    }

}
