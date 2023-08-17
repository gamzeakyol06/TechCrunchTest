package Component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    By latestnews = By.xpath("//*[@id=\"tc-main-content\"]/div[3]/div/div/div/article");
    public WebElement LatestNews()  {return driver.findElement(latestnews);}


    By newstitle = By.xpath("//h1[@class='article__title']");
    public WebElement NewsTitle()  {return driver.findElement(newstitle);}

    public List<WebElement> LatestNewsList(){
        List<WebElement> latestnews = driver.findElements(By.xpath("//*[@id=\"tc-main-content\"]/div[3]/div/div/div/article"));
        return latestnews;
    }

    public List<WebElement> Span_Value(){
        List<WebElement> spans = driver.findElements(By.xpath("//span[@class='river-byline__authors']"));
        return spans;
    }

    public List<WebElement> Figure_Value(){
        List<WebElement> figures = driver.findElements(By.xpath("//figure[@class='post-block__media']"));
        return figures;
    }
    public List<WebElement> Links(){
        List<WebElement> links = driver.findElements(By.tagName("a"));
        return links;
    }

}
