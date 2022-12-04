package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {
    // Логгер
    private static Logger logger = LogManager.getLogger(ActionHelper.class);
    // Экшен
    protected static Actions actions;

    // Инициализация экшена
    public static void init(WebDriver driver) {
        actions = new Actions(driver);
    }

    // Перемещение курсора мыши на элемент
    public static void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }
    public static void scrollToElement(WebElement webElement){
        actions.scrollToElement(webElement).perform();
    }
    public static void clickToElement(WebElement webElement){
        actions.click(webElement).perform();
    }
    public static void moveAndClickToElement(WebElement webElement){
        moveToElement(webElement);
        clickToElement(webElement);
    }
}
