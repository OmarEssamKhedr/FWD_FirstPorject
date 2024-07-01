import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowser {
    //psvm
    /*
    public static void main(String[] args) throws InterruptedException {


        Thread.sleep(3000);

    }
 */

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void OpenBrowser(){

        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }
    @Test
    public void ValidData() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tomsmith");

        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();

        String expectedResult = "You logged into a secure area!";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(2000);

    }

    @Test
    public void InValidUsername() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("inValid");

        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();

        String expectedResult = "Your username is invalid!";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult) , "Error : InValidUsername");

        Thread.sleep(2000);
    }

    @Test
    public void InValidPasswor() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tomsmith");

        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("inValid!");

        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();

        String expectedResult = "Your password is invalid!";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        Thread.sleep(2000);
    }

    @AfterTest
    public void Closeddriver(){
        driver.quit();
    }
}
