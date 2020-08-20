import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Scanner;

public class SeleniumDeneme {

    /** Giriş Sayfası **/
    public static String usernameXpath = "//input[@id='username']";
    public static String passwordXpath = "//input[@id='password']";
    public static String girisButonuXpath = "//button[@class='btn btn-primary btn-lg btn-block']";


    /** Profil Sayfası **/
    public static String dahaFazlaGosterXpath = "//a[@class='load-more-entries']";
    public static String profil_profilinToplamEntrySayisi = "//li[@id='entry-count-total']";
    public static String profilSayfasindakiEntriler = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/div[@id='profile-stats-section-content']/div[@id='topic']/div";
    public static String profileStatsContainer =      "//body[@class='light-theme theme-disabled']/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/div[@id='profile-stats-section-content']";

    /** Profil İstatistikleri **/
    /*
    public static String profilStatsEntriler = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[1]";
    public static String profilStatsFavoriler = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[2]";
    public static String profilStatsGorseller = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[3]";
    public static String profilStatsIstatistikler = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]";


    public static String profilStatsIstatistiklerEnCokFavlananlar         = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]/ul/li[1]";
    public static String profilStatsIstatistiklerSonOylananlar            = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]/ul/li[2]";
    public static String profilStatsIstatistiklerBuHaftaDikkatCekenleri   = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]/ul/li[3]";
    public static String profilStatsIstatistiklerElEmegiGozNuru           = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]/ul/li[4]";
    public static String profilStatsIstatistiklerEnBegenilenleri          = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]/ul/li[5]";
    public static String profilStatsIstatistiklerFavoriYazarlari          = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]/ul/li[6]";
    public static String profilStatsIstatistiklerKatkidaBulunduguKanallar = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]/ul/li[7]";
    public static String profilStatsIstatistiklerUkteleri                 = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]/ul/li[8]";
    public static String profilStatsIstatistiklerSorunsallari             = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]/ul/li[9]";
    public static String profilStatsIstatistiklerSorunsalYanitlari        = "//body/div[@id='container']/div[@id='main']/div[@id='content']/section[@id='content-body']/div[@id='profile-stats-sections']/ul[@id='profile-stats-section-nav']/li[4]/ul/li[10]";
     */

    /** Entri İşlemleri **/
    public static String entryDropdownMenuXpath;
    public static String entrySilButonuXpath = "//ul[@class='dropdown-menu right toggles-menu open']//a[contains(text(),'sil')]";
    public static String entrySilKesinMiXpath = "//button[contains(text(),'kesin')]";


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();



        driver.get("https://eksisozluk.com/giris");
        WebElement username = driver.findElement(By.xpath(usernameXpath));
        username.sendKeys("your-username");
        WebElement password = driver.findElement(By.xpath(passwordXpath));
        password.sendKeys("your-password");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //After you signed in, and went to your profile page, then press enter in the commandline so that program
        //can keep executing
        Scanner scanner = new Scanner(System.in);
        scanner.next();


        //Before the code execution reaches here, you have to be in your profile page
        int a = 1;
        int entrySayac = 1;
        int kacinciTopic = 0;
        driver.manage().window().maximize();
        Thread.sleep(10000);
        while(a >=1) {

            Thread.sleep(2000);
            if(a%10 == 1) {
                entrySayac = 1;
                System.out.println("Sayac guncellendi: sayac -> "+ entrySayac + " a->"+a + " kacincTopic->"+kacinciTopic);
            }

            kacinciTopic = a/10;
            if(a%10 != 0) {
                kacinciTopic++;
            }

            System.out.println("kacinciTopicAfterIf-> " + kacinciTopic);
            String dropdownMenu = profileStatsContainer + "/div["+kacinciTopic+"]//div["+entrySayac+"]//ul[1]//li[1]//footer[1]//div[2]//div[1]/a[1]";
            System.out.println("ddMenu: " + dropdownMenu);
            WebElement dropdownElement = driver.findElement(By.xpath(dropdownMenu));

            Actions action = new Actions(driver);
            action.moveToElement(dropdownElement).click().perform();

            Thread.sleep(100);
            WebElement buton = driver.findElement(By.xpath(entrySilButonuXpath));
            buton.click();


            WebElement kesinMi = driver.findElement(By.xpath(entrySilKesinMiXpath));
            kesinMi.click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a++;
            entrySayac++;
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }






        driver.close();
        driver.quit();
    }
}
