import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowserTest {


    WebDriver driver = new ChromeDriver();
    LoginPage login = new LoginPage();

    @BeforeTest
    public void OpenBrowser(){
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }
    @Test
    public void ValidData() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        login.UsernamePOM(driver).clear();
        login.UsernamePOM(driver).sendKeys("tomsmith");

        login.PasswordPOM(driver).clear();
        login.PasswordPOM(driver).sendKeys("SuperSecretPassword!");

        login.LoginButtonPOM(driver).click();

        String expectedResult = "You logged into a secure area!";
        String actualResult = login.MessagePOM(driver).getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(700);

    }

    @Test
    public void InValidUsername() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        login.UsernamePOM(driver).clear();
        login.UsernamePOM(driver).sendKeys("MyLoveFatema");

        login.PasswordPOM(driver).clear();
        login.PasswordPOM(driver).sendKeys("SuperSecretPassword!");

        login.LoginButtonPOM(driver).click();

        String expectedResult = "Your username is invalid!";
        String actualResult = login.MessagePOM(driver).getText();
        Assert.assertTrue(actualResult.contains(expectedResult) , "Error : InValidUsername");

        Thread.sleep(700);
    }

    @Test
    public void InValidPassword() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        login.UsernamePOM(driver).clear();
        login.UsernamePOM(driver).sendKeys("tomsmith");

        login.PasswordPOM(driver).clear();
        login.PasswordPOM(driver).sendKeys("inValid!");

        login.LoginButtonPOM(driver).click();

        String expectedResult = "Your password is invalid!";
        String actualResult = login.MessagePOM(driver).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        Thread.sleep(700);
    }

    @AfterTest
    public void ClosedDriver(){
        driver.quit();
    }
}
