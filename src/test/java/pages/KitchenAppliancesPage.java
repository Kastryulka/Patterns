package pages;

import elements.Button;
import elements.Link;
import elements.Title;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

//страница Техника для кухни
public class KitchenAppliancesPage extends BasePage {
    @FindBy(xpath="//*[@class='subcategory__page-title']")
    private WebElement subcategoryPageTitle;
    @FindBy(xpath="//a[contains(@class ,'configurator-links-block__links-link')]")
    private WebElement configurationButton;
    @FindBy (xpath = "//*[@class='subcategory__title']")
    private List<WebElement> subcategories;

    public KitchenAppliancesPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    public Title subcategoryPageTitle(){
        return new Title(subcategoryPageTitle);
    }
    public Button configurationButton() {return new Button(configurationButton);}
    public List<Link> subcategories() {
        List<WebElement> elementsList = subcategories;
        List<Link> linksList = new ArrayList<Link>();
        elementsList.forEach(webElement -> linksList.add(new Link(webElement)));
        return linksList;
    }
}
