import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
public class Login {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();


        SoftAssert softAssert = new SoftAssert();

        driver.get("https://demowebshop.tricentis.com/login");

        WebElement loginEmailField = driver.findElement(By.id("Email"));
        loginEmailField.sendKeys("vito.corleone@godfather.com");

        WebElement loginPasswordField = driver.findElement(By.id("Password"));
        loginPasswordField.sendKeys("Godfather");

        WebElement loginButton = driver.findElement(By.cssSelector(".login-button"));
        loginButton.click();

        WebElement loginSuccessMessage = driver.findElement(By.className("result"));
        String expectedLoginText = "Welcome, Vito Corleone!";
        softAssert.assertTrue(loginSuccessMessage.getText().contains(expectedLoginText), "Error");
        softAssert.assertAll();

        driver.quit();
    }
}
