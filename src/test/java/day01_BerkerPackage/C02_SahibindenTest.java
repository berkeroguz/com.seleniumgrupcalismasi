package day01_BerkerPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.sql.Driver;
import java.time.Duration;

public class C02_SahibindenTest {
    /*
            1- Kullanıcı ve şifre ile giriş yapılsın
            2- Sahibinden logo'suna tıklayıp anasayfaya gitisn
            3- "Anasayfa vitrini" yazısının görüntülendiğini test edin
            4- Soldaki kategorilerden Otomobil'e tıklayalım
            5- BMW seçelimk
            6- BMW - 7 serisini seçelim
            7- BMW - 730d xDrive Long seçelim
            8- Renk filteresine tıklayıp rengi gri olarak seçelim
            9- Ara butonuna tıklayalım.
            10- Çıkan ilanlardan fiyatı ucuz olan ilana tıklayalım.

     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.edgedriver().setup();
        driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.sahibinden.com");
    }

    @Test
    public void test01(){
        //kullanıcı girişi

        driver.findElement(By.xpath("//div/ul/li/a[@id='secure-login']")).click();
        driver.findElement(By.xpath("//input[@id='loginSelectionPageEmail']")).sendKeys("denemeogz123@gmail.com");
        driver.findElement(By.xpath("//button[@id='signInWithEmail']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Wisequarter10");
        driver.findElement(By.xpath("//button[@id='userLoginSubmitButton']")).click();

    }

    @Test
    public void test02(){
        String expectedWord ="Anasayfa Vitrini";
        String actualWord = driver.findElement(By.xpath("(//h3)[1]")).getText();
        driver.findElement(By.xpath("//div/p/a[@class='sahibinden-logo ng-isolate-scope']")).click();
        Assert.assertTrue("Anasayfa Vitrini yazısı içermiyor. ", actualWord.contains(expectedWord));

        System.out.println("Yasir deneme");

        System.out.println("Deneme");

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
