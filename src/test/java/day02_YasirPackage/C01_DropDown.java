package day02_YasirPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(5000);
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdownIndex = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdownIndex);
        select.selectByIndex(1);

        WebElement seciliIndex = select.getFirstSelectedOption();
        String seciliIndexStr = seciliIndex.getText();
        System.out.println(seciliIndexStr);
        Thread.sleep(5000);

    }

    @Test
    public void test02() throws InterruptedException {
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            WebElement dropdownValue = driver.findElement(By.xpath("//select[@id='dropdown']"));
            Select select= new Select(dropdownValue);

            select.selectByValue("2");

            WebElement seciliValue = select.getFirstSelectedOption();
            String seciliValueStr = seciliValue.getText();
            System.out.println(seciliValueStr);
            Thread.sleep(3000);

    }

    @Test
    public void test03() throws InterruptedException {
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve
        //yazdırın
        WebElement dropdownisibleText = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select= new Select(dropdownisibleText);

        select.selectByVisibleText("Option 1");
        WebElement seciliselect = select.getFirstSelectedOption();
        String seciliselectStr = seciliselect.getText();
        System.out.println(seciliselectStr);
        Thread.sleep(3000);
    }

    @Test
    public void test04(){
        //4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement>dropDownList = driver.findElements(By.xpath("//select[@id='dropdown']/option"));


        for (WebElement each:dropDownList
             ) {
            System.out.println(each.getText());
        }

    }

    @Test
    public void test05(){
        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
        //degilse False yazdırın.

     List<WebElement> dropDownSize = driver.findElements(By.xpath("//select[@id='dropdown']/option"));

        int expected =3;
        int actual = dropDownSize.size();
        Assert.assertEquals(actual,expected);

    }


}
