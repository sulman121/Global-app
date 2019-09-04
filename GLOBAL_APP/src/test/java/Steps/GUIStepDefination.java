package Steps;

import static org.testng.Assert.expectThrows;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import ExcelReader.ReadExcel;
import Util.Lib;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GUIStepDefination extends Lib {

	WebDriver driver;
	// ReadExcel Readexcel = new ReadExcel("C:\\Users\\ca2543\\EQRS GLOBAL
	// APP\\GLOBAL_APP\\Test.xlsx");
	Actions ac;
	Select select;

	@Before
	public void pre_testing() throws IOException {

		if (ReadProperties("Browser").equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (ReadProperties("Browser").equals("Internet Explorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.get(ReadProperties("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Given("user is at home page")
	public void user_is_at_home_page() {
		driver.getTitle();

	}

	@Then("user able to enter valid username and password")
	public void user_able_to_enter_valid_user_name_and_password() throws Exception {

		driver.findElement(By.xpath(ReadProperties("username"))).sendKeys("EQRS_QualCMSuserSatz1414");

		driver.findElement(By.xpath(ReadProperties("password"))).sendKeys("System@123456");

		ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//input[@id='input41']"))).click().build().perform();

		driver.findElement(By.xpath(ReadProperties("signinbutton"))).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(ReadProperties("PendingRequestLink"))).click();
//		
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='table-body']")));
//
//		System.out.println(driver.findElement(By.xpath("//tbody[@id='table-body']")).getText());

	}

}
