package pages;

import elements.Button;
import elements.Link;
import elements.Title;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//страница Бытовая техника
public class HouseholdAppliancesPage extends BasePage{
    private Logger logger = LogManager.getLogger(StartPage.class);
    @FindBy(xpath="//*[contains(@class,'city-select__text')]")
    private WebElement selectedCity;
    @FindBy(xpath="//*[@class='subcategory__page-title']")
    private WebElement subcategoryPageTitle;
    @FindBy(xpath = "//*[text()='Техника для кухни']//ancestor::a[contains(@class ,'ui-link')]")
    private WebElement kitchenAppliances;

    public HouseholdAppliancesPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    public Button selectedCity() {
        return new Button(selectedCity);
    }
    public Title subcategoryPageTitle(){
        return new Title(subcategoryPageTitle);
    }
    public Link kitchenAppliances(){
        return new Link(kitchenAppliances);
    }
}
