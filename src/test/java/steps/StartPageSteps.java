package steps;

import elements.Link;
import helpers.ActionHelper;
import helpers.WaitHelper;
import helpers.WindowHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import pages.StartPage;

import java.util.List;

public class StartPageSteps {
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);
    private StartPage startPage;

    // Конструктор
    public StartPageSteps(WebDriver driver) {
        startPage = new StartPage(driver);
        // Открыть сайт https://www.dns-shop.ru/
        startPage.openPage();
        logger.info("Открыта страница DNS - " + "https://www.dns-shop.ru/");
        logger.info("Заголовок страницы - " + startPage.getPageTitle());
        logger.info("Текущий URL - " + startPage.getURL());
        logger.info(String.format("Ширина окна: %d", WindowHelper.getWindowSize().getWidth()));
        logger.info(String.format("Высота окна: %d", WindowHelper.getWindowSize().getHeight()));
    }

    public List<Link> getSublistAppliances(){
        return startPage.subcategories();
    }
    public List<Link> getSublistCooking(){
        return startPage.popupCooking();
    }
    //если появляется окно выбора города (может скрывать Бытовую технику), нажимаем на кнопку согласия
    public void confirmCity(){
        try{
            WebElement body = startPage.blockBody().getWebElement();
            startPage.confirmCity().click();
            logger.info("Согласились с выбором города");
            //WaitHelper.stalenessOfElement(body);
            //logger.info("Страница обновлена");
            //listener.getScreenshotFull(driver,outputDir,"Обновленная начальная страница");
            ActionHelper.scrollToElement(startPage.selectedCity().getWebElement());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void goToHouseholdAppliancesPage(){
        try{
            startPage.householdAppliances().click();
        }
        catch (ElementClickInterceptedException e){
            confirmCity();
            startPage.householdAppliances().click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void goToLaptopsPage(){
        try{
            startPage.laptops().click();
        }
        catch (ElementClickInterceptedException e){
            confirmCity();
            startPage.laptops().click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void focusOnHouseholdAppliances(){
        try{
            startPage.householdAppliances().focusOnLink();
        }
        catch (ElementNotInteractableException e){
            confirmCity();
            startPage.householdAppliances().focusOnLink();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void focusOnCooking(){
        try{
            startPage.cooking().focusOnLink();
        }
        catch (ElementNotInteractableException e){
            confirmCity();
            startPage.cooking().focusOnLink();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void focusOnComputersPeripherals(){
        try{
            startPage.computersPeripherals().focusOnLink();
        }
        catch (ElementNotInteractableException e){
            confirmCity();
            startPage.computersPeripherals().focusOnLink();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void focusAndClickCooking(){
        focusOnCooking();
        startPage.cooking().click();
    }
    public void scrollToTop(){
        ActionHelper.scrollToElement(startPage.selectedCity().getWebElement());
    }
}
