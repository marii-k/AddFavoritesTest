package ru.avito;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSettings {

    public ChromeDriver driver;
    String favoriteBtn = "/html/body/div[1]/div/div[3]/div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[3]/div/div/div/div[1]/button";// кнопка добавить в избранное с страницы элемента
    String favorites = "/html/body/div[1]/div/div[1]/div/div/div[1]/a[1]/div"; //кнопка избранное
    String addFavorite = "//*[@id=\"app\"]/div/div[4]/div/div/favorite-items-list/div/div/div[1]/div[2]/div/div/div"; //добавленный элемент
    String elementBtn = "/html/body/div[1]/div/div[4]/div/div/favorite-items-list/div/div/div[1]/div[2]/div/div/div/div[2]/div[1]/div";// убрать из избранного
    String windowFavorite = "/html/body/div[2]/div[6]/div/div/div";//поп-ап "добавлено в избранное"

    @Before
    public void setUp() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземляра драйвера
        WebDriver driver = new ChromeDriver();
        //задержка на выполнение теста = 10 сек.
        new WebDriverWait(driver, Duration.ofSeconds(10));
        //получение ссылки на страницу объявления из файла настроек
        driver.get(ConfProperties.getProperty("website"));
    }
}

