package Test;

import Base.Base;
import Component.MainPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.Random;

public class TechCrunch_Test extends Base {

    @BeforeTest
    public void BeforeMethod() throws MalformedURLException, InterruptedException {
        super.beforemethod();
    }

    @Test
    public void OpenLink() throws InterruptedException {
        try {
            driver.get(MAIN_PAGE_URL);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("fail");
        }
    }

    @Test
    public void TheLatestNewsAuthorCheck() throws InterruptedException{
        try {
            driver.get(MAIN_PAGE_URL);
            MainPage mainpage = new MainPage(driver);
            System.out.println(mainpage.LatestNewsList().size());

            for (WebElement span : mainpage.Span_Value())
                {
                    String text_span = span.getText();
                    System.out.println(text_span);

                    if (span == null) {
                        Assert.fail("fail");
                    }
                    else{
                        System.out.println("This News has an Author");
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("fail");
        }
    }

    @Test
    public void TheLatestNewsImageCheck() throws InterruptedException{
        try {
            driver.get(MAIN_PAGE_URL);
            MainPage mainpage = new MainPage(driver);
            System.out.println(mainpage.LatestNewsList().size());

            for (WebElement figure: mainpage.Figure_Value())
            {
                Boolean figure_available = figure.isDisplayed();

                if (figure_available == false) {
                    Assert.fail("fail");
                }
                else{
                    System.out.println("This News has an Image");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("fail");
        }
    }

    @Test
    public void AnyNewsTitleCheck() throws InterruptedException {
        try {
            driver.get(MAIN_PAGE_URL);
            MainPage mainpage = new MainPage(driver);
            System.out.println(mainpage.LatestNewsList().size());

            // Randomly selected any news from Latests
            Random rand = new Random();
            System.out.println(rand.nextInt(mainpage.LatestNewsList().size()));
            Integer newsrand = rand.nextInt(mainpage.LatestNewsList().size());
            WebElement LatestNews = mainpage.LatestNewsList().get(newsrand);
            LatestNews.click();
            Thread.sleep(2000);
            String ExpectedPageTitle = driver.getTitle();
            System.out.println(ExpectedPageTitle);
            String ActualNewsTitle = (mainpage.NewsTitle().getText() + " | TechCrunch");
            System.out.println(ActualNewsTitle);

            Assert.assertEquals(ActualNewsTitle,ExpectedPageTitle);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("fail");
        }
    }

    @Test
    public void AnyNewsLinksCheck() throws InterruptedException{
        try {
            driver.get(MAIN_PAGE_URL);
            MainPage mainpage = new MainPage(driver);
            System.out.println(mainpage.LatestNewsList().size());

            // Randomly selected any news from Latests
            Random rand = new Random();
            System.out.println(rand.nextInt(mainpage.LatestNewsList().size()));
            Integer newsrand = rand.nextInt(mainpage.LatestNewsList().size());
            WebElement LatestNews = mainpage.LatestNewsList().get(newsrand);
            LatestNews.click();
            Thread.sleep(2000);

            for (WebElement link : mainpage.Links()) {
                String url = link.getAttribute("href");
                verifyLink(url);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("fail");
        }

    }

    @AfterTest
    public void aftermethod(){
        super.aftermethod();
    }
}
