package web.testing_new.web_module.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class Login_screen extends BaseClass {
	
	public static String primaryInfo  = "{\"user_id\":85,\"executed_user_id\":85,\"is_generate\":false,\"is_execute\":false,\"is_web\":true,\"project_url\":\"https://www.devrabbitdev.com/login.php\",\"report_upload_url\":\"https://smartqe.io:443/UploadReportFile\",\"project_name\":\"Testing_new\",\"project_description\":\"desc\",\"project_id\":0,\"module_name\":\"web_module\",\"module_description\":\"desc\",\"sub_module_id\":0,\"module_id\":716,\"testcase_name\":\"TC_Notifii\",\"testcase_id\":579,\"testset_name\":\"TS\",\"testset_id\":85,\"executed_timestamp\":-600871846,\"browser_type\":\"chrome\",\"testcase_overwrite\":true,\"client_timezone_id\":\"Asia/Calcutta\"}";

	public static String projectName = "testing_new";
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public static final int datasetsLength = 1;

	public Login_screen(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='username']")	
	private WebElement	Username_405287input;
	public void fillinputUsername_405287(String varInputValue) {
		waitForExpectedElement(driver, Username_405287input);
		Username_405287input.sendKeys(varInputValue);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='password']")	
	private WebElement	Password_405291input;
	public void fillinputPassword_405291(String varInputValue) {
		waitForExpectedElement(driver, Password_405291input);
		Password_405291input.sendKeys(varInputValue);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Log in')]")	
	private WebElement	LogIn_405300button;
	public String clkbuttonLogIn_405300() {
		waitForExpectedElement(driver, LogIn_405300button);		
		String text = LogIn_405300button.getText();
		LogIn_405300button.click();
		return text;
	}

}