package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import elements.*;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

//начальная страница
public class StartPage extends BasePage {
    private Logger logger = LogManager.getLogger(StartPage.class);
    private final String URL = "https://www.dns-shop.ru/";

    // Кнопка "Всё верно" на всплывашке
    @FindBy(xpath = "//button[contains(@class,'v-confirm-city__btn')]")
    private WebElement confirmCity;
    @FindBy(xpath="//body[1]")
    private WebElement body;
    @FindBy(xpath="//*[contains(@class,'city-select__text')]")
    private WebElement selectedCity;
    @FindBy(xpath="//a[contains(@class ,'menu-desktop__root-title') and text()='Бытовая техника']")
    private WebElement householdAppliances;
    @FindBy(xpath="//a[contains(@class ,'menu-desktop__root-title') and text()='Бытовая техника']//ancestor::div[@class='menu-desktop__root']//div[contains(@class ,'menu-desktop__submenu_top')]/a")
    private List<WebElement> sublistAppliances;
    @FindBy(xpath="//a[@class='ui-link menu-desktop__second-level' and text()='Плиты и печи']")
    private WebElement linkCooking;
    @FindBy(xpath="//a[@class='ui-link menu-desktop__second-level' and text()='Плиты и печи']/span[@class='menu-desktop__popup']/a")
    private List<WebElement> popupCooking;
    @FindBy(xpath="//a[contains(@class,'menu-desktop__root-title') and contains(text(),'периферия')]")
    private WebElement computersPeripherals;
    @FindBy(xpath="//a[contains(@class,'menu-desktop__second-level') and contains(text(),'Ноутбуки')]")
    private WebElement laptops;

    public StartPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return this.URL;
    }
    // Открытие страницы
    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    // Кнопка "Всё верно" на всплывашке
    public Button confirmCity() {
        return new Button(confirmCity);
    }
    public Button selectedCity() {
        return new Button(selectedCity);
    }
    public Link householdAppliances() {
        return new Link(householdAppliances);
    }
    public Link cooking() {
        return new Link(linkCooking);
    }
    public List<Link> subcategories() {
        WaitHelper.visibilityOfManyElements(sublistAppliances);
        List<WebElement> elementsList = sublistAppliances;
        List<Link> linksList = new ArrayList<Link>();
        elementsList.forEach(webElement -> linksList.add(new Link(webElement)));
        return linksList;
    }
    public List<Link> popupCooking() {
        WaitHelper.visibilityOfManyElements(popupCooking);
        List<WebElement> elementsList = popupCooking;
        List<Link> linksList = new ArrayList<Link>();
        elementsList.forEach(webElement -> linksList.add(new Link(webElement)));
        return linksList;
    }
    public Block blockBody(){
        return new Block(body);
    }
}
