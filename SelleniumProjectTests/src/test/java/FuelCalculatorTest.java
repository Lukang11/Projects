import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FuelCalculatorTest {
    private static WebDriver webDriver;
    @BeforeClass
    public static void startUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.calculator.net/fuel-cost-calculator.html");
        webDriver.manage().window().maximize();
    }
    @Test
    public void setCalculationParamsAndCalculateFuel(){
        webDriver.findElement(By.name("tripdistance")).clear();
        webDriver.findElement(By.name("tripdistance")).sendKeys("412");

        webDriver.findElement(By.name("fuelefficiency")).clear();
        webDriver.findElement(By.name("fuelefficiency")).sendKeys("5.5");

        webDriver.findElement(By.name("gasprice")).clear();
        webDriver.findElement(By.name("gasprice")).sendKeys("1.8");
        webDriver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String requiredFuel =  webDriver.findElement(By.xpath("//font[b=22.7]")).getText();
        String requiredCost = webDriver.findElement(By.xpath("//font[b=\"$40.79\"]")).getText();
        Assert.assertEquals("22.7",requiredFuel);
        Assert.assertEquals("$40.79",requiredCost);


    }
}
