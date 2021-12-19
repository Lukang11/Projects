import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class GovNewOrderCalc {
    private static WebDriver webDriver;
    @BeforeClass
    public static void startUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.podatki.gov.pl/polski-lad/kwota-wolna-polski-lad/kalkulator-wynagrodzen-polski-lad/");
        webDriver.manage().window().maximize();
    }
    @Test
    public void assertEmployeeSalaryInPkk() throws InterruptedException {
        webDriver.switchTo().frame(0);
        webDriver.findElement(By.xpath("//input[@name=\"salary\"]")).sendKeys("12000");
        webDriver.findElement(By.xpath("//input[@id=\"isppk1\"]")).click();

        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.textMatches(By.xpath("//h2//span[@id = \"cell_c30_n\"]"), Pattern.compile("\\d+\\d+\\d+\\d+,\\d+\\d")));



        String result = webDriver.findElement(By.xpath("//h2//span[@id = \"cell_c30_n\"]")).getText();
        System.out.println(result);

        Assert.assertEquals("7817,12 zł",result);
    }
    @Test
    public void assertEmployeeSalaryWithoutPkk() {
        GovNewOrderCalc.startUp();
        webDriver.switchTo().frame(0);
        webDriver.findElement(By.xpath("//input[@name=\"salary\"]")).sendKeys("10000");
        webDriver.findElement(By.xpath("//input[@id = \"workplace0\"]")).click();
        webDriver.findElement(By.xpath("//input[@id=\"isppk0\"]")).click();

        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.textMatches(By.xpath("//h2//span[@id = \"cell_c30_n\"]"), Pattern.compile("\\d+\\d+\\d+\\d+,\\d+\\d")));

        String result = webDriver.findElement(By.xpath("//h2//span[@id = \"cell_c30_n\"]")).getText();
        System.out.println(result);

        Assert.assertEquals("6953,92 zł",result);
    }
}
