package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test1 {
    @Test
    public void TC_01(){
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");

        driver.findElement(By.xpath("//a[.='Input Form Submit']")).click(); // shortcut
//        WebElement inputForm = driver.findElement(By.xpath("//a[.='Input Form Submit']"));
//        inputForm.click();
        //hi

        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("Supattra");

        WebElement email = driver.findElement(By.cssSelector("#inputEmail4"));
        email.sendKeys("osdf@hotmail.com");
        WebElement password = driver.findElement(By.cssSelector("#inputPassword4"));
        password.sendKeys("fah01");

        WebElement company = driver.findElement(By.cssSelector("#company"));
        company.sendKeys("CodeFish");

        WebElement website = driver.findElement(By.cssSelector("#websitename"));
        website.sendKeys("fah.com");

        WebElement city = driver.findElement(By.cssSelector("#inputCity"));
        city.sendKeys("Victoria");

        WebElement address1 = driver.findElement(By.cssSelector("#inputAddress1"));
        address1.sendKeys("190 Mayfair");

        WebElement address2 = driver.findElement(By.cssSelector("#inputAddress2"));
        address2.sendKeys("128 Mayfair");

        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("Canada");

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='zip']"));
        zipCode.sendKeys("1900CV");

        List<WebElement> allButton = driver.findElements(By.xpath("//button[contains(text(),'Submit')]"));
        for(int i=0; i<allButton.size();i++){
            if(allButton.get(i).getText().equalsIgnoreCase("submit")){
                allButton.get(i).click();
            }

        }

        List<WebElement> allMessage = driver.findElements(By.xpath("//p"));
        for(int i=0;i<allMessage.size();i++){
            if(allMessage.get(i).getText().trim().contains("Thanks")){
                System.out.println(allMessage.get(i).getText().trim());

                Assert.assertTrue(allMessage.get(i).isDisplayed());
            }

        }
        System.out.println("This one for github");


    }
}
