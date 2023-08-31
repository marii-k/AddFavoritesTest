package ru.avito;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class FavoritesTest extends WebDriverSettings {


    @Test
    public void AddFavoritesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("website"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(favoriteBtn))).click(); //кликнуть на кнопку избранное


        Duration timeOut = Duration.ofSeconds(5);
        driver.manage().timeouts().implicitlyWait(timeOut);
        driver.findElement(By.xpath(windowFavorite));//поп-ап "добавлено в избранное"

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(favorites))); //переход на страницу избранного
        WebElement elementToClick = driver.findElement(By.xpath(favorites));
        elementToClick.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addFavorite)));//найти элемент на странице избранного
        WebElement elementBook = driver.findElement(By.xpath(addFavorite));

        driver.findElement(By.xpath(elementBtn)).click();//кликнуть "убрать из избранного"
        driver.navigate().refresh();//обновление страницы

        WebDriverWait waitForElementToDisappear = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitForElementToDisappear.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementBtn)));
        }
    @After
    public void tearDown() {
        driver.quit();
    }
}





