package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    protected static WebDriver driver;
    public final static String MAIN_PAGE_URL = "https://techcrunch.com/";

        public void beforemethod () throws MalformedURLException, InterruptedException {

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-notifications");

            System.setProperty("webdriver.chrome.driver","src/main/driver/chromedriver-win32/chromedriver.exe");
            System.out.println(System.getProperty("webdriver.chrome.driver"));

            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
    }
        public void aftermethod(){
            driver.quit();
    }

    public void verifyLink(String url) throws IOException {
        try {
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
            }
        } catch (Exception e) {
            System.out.println(url + " - " + "is a broken link");
        }
    }
}
