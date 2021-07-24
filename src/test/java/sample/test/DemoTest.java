package sample.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoTest {

    public void setDriver(WebDriver driver){
        this.driver=driver;
    }
    WebDriver driver=null;
    public WebDriver getDriver(){
        return driver;
    }
    @BeforeSuite
    public void setUp(){
        String browser=System.getProperty("Browser");
        if(browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            setDriver(driver);

        }
        else{
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver=new FirefoxDriver();
            setDriver(driver);
        }

    }
    @Test
    public void sampleTest(){
        WebDriver driverInstance=getDriver();
        //String player=System.getProperty("Player");
        driver.manage().window().maximize();
        driver.get("https://skysports.com");

    }
}
