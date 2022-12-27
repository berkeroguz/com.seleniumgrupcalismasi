package day01_BerkerPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_OrnekTest {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }
    @Test
    public void test01(){
        WebElement homePage = driver.findElement(By.xpath("//div[@class='carousel-inner']"));
        Assert.assertTrue("HomePage invisible", homePage.isDisplayed());

    }

    @Test
    public void test02(){
        driver.findElement(By.xpath("//i[@class='fa fa-envelope']")).click();
        Assert.assertTrue("GET TOUCH Görüntülenemedi. ",driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).isDisplayed());
    }

    @Test
    public void test03() throws InterruptedException {

        // form submit testi
        WebElement nameBox = driver.findElement(By.xpath("//div/input[@name='name']"));
        nameBox.sendKeys("Ahmet");
        WebElement mailBox= driver.findElement(By.xpath("//div/input[@name='email']"));
        mailBox.sendKeys("ahmet@gmail.com");
        WebElement subjectBox= driver.findElement(By.xpath("//div/input[@name='subject']"));
        subjectBox.sendKeys("QA Tester");
        WebElement messageBox= driver.findElement(By.xpath("//div/textarea[@name='message']"));
        messageBox.sendKeys("Selenium öğreniyoruz Java'dan daha zevkli Ahmet hoca duymasın");

        WebElement fileBox= driver.findElement(By.xpath("//div/input[@name='upload_file']"));
        fileBox.sendKeys("C:\\Users\\Oguz\\Desktop\\ornek.txt");
        Thread.sleep(2000);

        //Submit
        driver.findElement(By.xpath("//div/input[@name='submit']")).click();
        //Cookiee'nin close butonuna tıklattık.

        //Website üzerinde açılan messagebox'lar alert class'ından yardım alınarak locate edilir ve içerisindeki methodlar aracılığı ile kullanılır.
        Alert alert = driver.switchTo().alert();
        alert.accept();


        Thread.sleep(1000);


        Assert.assertTrue("Onaylama yazısı görüntülenemedi. ",
                driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed());


        driver.findElement(By.xpath("//span/i")).click();
        Assert.assertTrue("GET TOUCH Görüntülenemedi. ",driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).isDisplayed());

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
