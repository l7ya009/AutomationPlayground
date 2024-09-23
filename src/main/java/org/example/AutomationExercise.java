package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationExercise {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://automationexercise.com/login");
        driver.findElement(By.name("name")).sendKeys("Yehia");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("yehiaosama00090009@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
        driver.findElement(By.cssSelector("label.top")).click();
//        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345");
        driver.findElement(By.id("password")).sendKeys("12345");
//
//        driver.findElement(By.id("days")).findElement(By.xpath("//option[@value=\"15\"]")).click();

        WebElement daysDropdown = driver.findElement(By.id("days"));
        Select selectDays = new Select(daysDropdown);
        selectDays.selectByValue("15");

//        driver.findElement(By.xpath("//select[@data-qa=\"months\"]")).findElement(By.xpath("//*[@id=\"months\"]/option[5]")).click();
        WebElement monthsDropdown = driver.findElement(By.id("months"));
        Select selectMonths = new Select(monthsDropdown);
        selectMonths.selectByValue("4");

        WebElement yearsDropdown = driver.findElement(By.id("years"));
        Select selectYears = new Select(yearsDropdown);
        selectYears.selectByValue("1992");

//        driver.findElement(By.id("years")).findElement(By.xpath("//*[@id=\"years\"]/option[31]")).click();
        driver.findElement(By.id("first_name")).sendKeys("Yehia");
        driver.findElement(By.id("last_name")).sendKeys("Osama");
        driver.findElement(By.id("company")).sendKeys("Testing");
        driver.findElement(By.id("address1")).sendKeys("gamal abdelnaser");
        driver.findElement(By.id("address2")).sendKeys("miami");
//        driver.findElement(By.id("country"));

        WebElement dropdown = driver.findElement(By.id("country"));
        Select select = new Select(dropdown);
        select.selectByValue("United States");

        driver.findElement(By.id("state")).sendKeys("california");
        driver.findElement(By.id("city")).sendKeys("alexandria");
        driver.findElement(By.id("zipcode")).sendKeys("21543");
        driver.findElement(By.id("mobile_number")).sendKeys("01205944475");
//        driver.findElement(By.xpath("//button[@class=\"btn btn-default\"]")).click();
//        driver.close();

    }
}
