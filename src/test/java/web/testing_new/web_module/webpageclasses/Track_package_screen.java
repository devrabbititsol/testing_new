package web.testing_new.web_module.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class Track_package_screen extends BaseClass {
	
	public static String primaryInfo  = "{\"user_id\":85,\"executed_user_id\":85,\"is_generate\":false,\"is_execute\":false,\"is_web\":true,\"project_url\":\"https://www.devrabbitdev.com/login.php\",\"report_upload_url\":\"https://smartqe.io:443/UploadReportFile\",\"project_name\":\"Testing_new\",\"project_description\":\"desc\",\"project_id\":423,\"module_name\":\"web_module\",\"module_description\":\"desc\",\"sub_module_id\":0,\"module_id\":716,\"testcase_name\":\"TC_Notifii\",\"testcase_id\":579,\"testset_id\":0,\"executed_timestamp\":-602463760,\"browser_type\":\"chrome\",\"testcase_overwrite\":true,\"client_timezone_id\":\"Asia/Calcutta\"}";

	public static String projectName = "testing_new";
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public static final int datasetsLength = 1;

	public Track_package_screen(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "#tab-track-primary > div.L2-menu > ul > li.active-L2 > a")	
	private WebElement	Packages_405370a;
	public String clkaPackages_405370() {
		waitForExpectedElement(driver, Packages_405370a);		
		String text = Packages_405370a.getText();
		Packages_405370a.click();
		return text;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Log Packages In')]")	
	private WebElement	LogPackagesIn_405391a;
	public String clkaLogPackagesIn_405391() {
		waitForExpectedElement(driver, LogPackagesIn_405391a);		
		String text = LogPackagesIn_405391a.getText();
		LogPackagesIn_405391a.click();
		return text;
	}

}