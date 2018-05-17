package testngPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTestng {
	WebDriver driver;
	WebDriverWait myWaitVar;
	String baseUrl = "http://demo.guru99.com/test/newtours/";
	String driverPath = "C:\\Users\\I349534\\Documents\\geckodriver.exe";
	
  @Test
  public void f() {
	  	System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		myWaitVar = new WebDriverWait(driver,10);		
		driver.get(baseUrl);


		driver.manage().window().maximize();
		WebElement homelink = driver.findElement(By.linkText("Home"));
		WebElement icon_homelink = driver.findElement(By.xpath("//html/body/div"
              + "/table/tbody/tr/td"
              + "/table/tbody/tr/td"
              + "/table/tbody/tr/td"
              + "/table/tbody/tr"));
		Actions builder = new Actions(driver);
		String bgColor = icon_homelink.getCssValue("background-color");
		System.out.println(bgColor);
		
		Action moveOverHome = builder.moveToElement(homelink).build();
		moveOverHome.perform();
		bgColor = icon_homelink.getCssValue("background-color");
		System.out.println(bgColor);
		
		WebElement userName = driver.findElement(By.name("userName")); 
		Action seriesPerformKeyboard = builder.moveToElement(userName).click().keyDown(userName, Keys.SHIFT).sendKeys("quynh").keyDown(userName, Keys.SHIFT).doubleClick().contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build();
		seriesPerformKeyboard.perform();
  }
}
