package lambda_test;

import Utils.BrowserUtils;
import com.sun.source.tree.Tree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Test2 {

    /*
    print out names and emails as a key - value pair
    use map interface, try to use assSelectors
     */

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");

        driver.findElement(By.xpath("//a[.='Table Pagination']")).click();
        Thread.sleep(2000);
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(dropDown,"Show ALL Rows","text");
        List<WebElement> allName = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmail = driver.findElements(By.xpath("//tr//td[3]"));

        Thread.sleep(2000);
        TreeMap<String,String> map= new TreeMap<>();
        for(int i=0; i<allName.size(); i++){
            map.put(BrowserUtils.getText(allName.get(i)),BrowserUtils.getText(allEmail.get(i)));

        }
        System.out.println( "map" + map);







    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.findElement(By.xpath("//a[.='Table Pagination']")).click();
        Thread.sleep(2000);


        WebElement showAllRow = driver.findElement(By.xpath("//select[@class='form-control']"));
        BrowserUtils.selectBy(showAllRow,"5000","value");
        List<WebElement> allName = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allPhoneNumber = driver.findElements(By.xpath("//tr//td[4]"));
        Thread.sleep(2000);

        TreeMap<String,Long> map = new TreeMap<>();
        for(int i=0; i<allName.size() ;i++){
            Thread.sleep(2000);
            map.put(BrowserUtils.getText(allName.get(i)),Long.valueOf(BrowserUtils.getText(allPhoneNumber.get(i)).replace("-","")));



        }
        System.out.println("print out" +map);
        System.out.println();
        driver.quit();



    }
}
