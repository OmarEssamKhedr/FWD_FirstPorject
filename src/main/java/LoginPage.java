import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebElement UsernamePOM (WebDriver driver){
        By username = By.xpath("//*[@id=\"username\"]");
        return driver.findElement(username);
    }
    public WebElement PasswordPOM (WebDriver driver){
        By password = By.xpath("//*[@id=\"password\"]");
        return driver.findElement(password);
    }
    public WebElement LoginButtonPOM (WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
    }
    public WebElement MessagePOM (WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"flash\"]"));
    }
}
