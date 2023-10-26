import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;


public class Main {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        SoftAssert softAssert = new SoftAssert();

        driver.get("https://demowebshop.tricentis.com/register");


        WebElement genderField = driver.findElement(By.id("gender-male"));
        genderField.click();

        WebElement firstnameField = driver.findElement(By.id("FirstName"));
        firstnameField.sendKeys("Vito");

        WebElement lastnameField = driver.findElement(By.id("LastName"));
        lastnameField.sendKeys("Corleone");

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("vito.corleone@godfather.com");

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Godfather");

        WebElement confirmpasswordField = driver.findElement(By.id("ConfirmPassword"));
        confirmpasswordField.sendKeys("Godfather");

        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();

        WebElement successMessage = driver.findElement(By.className("result"));
        String expectedText = "Your registration completed";
        softAssert.assertTrue(successMessage.getText().contains(expectedText), "Error");
        softAssert.assertAll();

        driver.quit();



    }
}