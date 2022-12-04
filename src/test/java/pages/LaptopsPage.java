package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//страница Ноутбуки
public class LaptopsPage extends BasePage {
    public LaptopsPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }
}
