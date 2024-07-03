import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement usernamePF;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordPF;

    @FindBy(xpath = "//*[@id=\"login\"]/button/i")
    WebElement LoginButtonPF;

    public WebElement MessagePOM (){
        return driver.findElement(By.xpath("//*[@id=\"flash\"]"));
    }

    public void LoginSteps (String Username , String Password) {

        usernamePF.clear();
        usernamePF.sendKeys(Username);

        passwordPF.clear();
        passwordPF.sendKeys(Password);

        LoginButtonPF.click();

    }
}
