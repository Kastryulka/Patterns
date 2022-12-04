package pages;

import helpers.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    // Драйвер браузера
    protected static WebDriver driver;
    // Конструктор базового класса
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        ActionHelper.init(driver);
        WindowHelper.init(driver);
        WaitHelper.init(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        JavaScriptHelper.init(driver);
    }
    // Получение заголовка текущей страницы
    public String getPageTitle() {
        String title = driver.getTitle();
        //logger.info("Заголовок страницы: " + title);
        return title;
    }
}
