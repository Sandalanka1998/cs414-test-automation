import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestAutomation {

    private ChromeDriver driver;

    @Test
    public void login() {
    	//initialize chrome driver
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://demo.actitime.com/login.do");
        driver.manage().window().maximize();

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("pwd")).sendKeys("manager");
        driver.findElement(By.id("loginButton")).click();
    }
    
    @Test
    public void wrongCredentialsLogin() {
    	//initialize chrome driver
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://demo.actitime.com/login.do");
        driver.manage().window().maximize();

        driver.findElement(By.id("username")).sendKeys("kavinda");
        driver.findElement(By.name("pwd")).sendKeys("sandalanka");
        driver.findElement(By.id("loginButton")).click();
    }
    
	@Test
	public void loginAndLogout() {
    	//initialize chrome driver
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://demo.actitime.com/login.do");
        driver.manage().window().maximize();
        
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("pwd")).sendKeys("manager");
        driver.findElement(By.id("loginButton")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/user/submit_tt.do"));
        
        driver.findElement(By.id("logoutLink")).click();
    }

}