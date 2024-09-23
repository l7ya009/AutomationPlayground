package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App
{
    public static void main( String[] args )
    {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();
        String header = driver.findElement(By.cssSelector("h4.subheader")).getText();
        System.out.println(header);
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();
        driver.findElement(By.cssSelector("div.row")).click();

//        driver.findElement()
//        driver.quit();
    }
}
