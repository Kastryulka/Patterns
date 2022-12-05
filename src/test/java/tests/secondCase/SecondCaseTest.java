package tests.secondCase;

import elements.Link;
import org.junit.jupiter.api.Test;
import steps.ElectricStovesPageSteps;
import steps.StartPageSteps;
import steps.StovesPageSteps;
import tests.BaseTest;
import tests.matchers.SecondCaseMatcher;

import java.util.List;

public class SecondCaseTest extends BaseTest {
    @Test
    public void firstStepTest(){
        outputDir = "temp\\\\SecondCase\\\\";
        listener.setOutputDir(outputDir);

        StartPageSteps startPage = FirstStep();

        //SecondCaseMatcher secondCaseMatcher = new SecondCaseMatcher(startPage);
        SecondCaseMatcher secondCaseMatcher = new SecondCaseMatcher();
        secondCaseMatcher.sublistAppliancesIsCorrect(startPage.getSublistAppliances());
        listener.getScreenshotFull(driver,outputDir,"Элементы меню Бытовая техника");
        logger.info("Необходимые ссылки отображаются");
    }
    @Test
    public void secondStepTest(){
        outputDir = "temp\\\\SecondCase\\\\";
        listener.setOutputDir(outputDir);

        //StartPageSteps startPage = SecondStep();
        //StartPageSteps startPage = new StartPageSteps(driver); /////////!!!!!!!
        List<Link> sublistCooking = SecondStep();
        listener.getScreenshotFull(driver,outputDir,"Элементы меню Плиты и печи");

        //... проверить, что ссылок больше пяти
        //SecondCaseMatcher secondCaseMatcher = new SecondCaseMatcher(startPage);
        SecondCaseMatcher secondCaseMatcher = new SecondCaseMatcher();
        secondCaseMatcher.popupCookingCountIsCorrect(sublistCooking);
        listener.getScreenshotFull(driver,outputDir,"Элементы меню Бытовая техника");
        logger.info("Необходимые ссылки отображаются");
    }
    @Test
    public void thirdStepTest(){
        outputDir = "temp\\\\SecondCase\\\\";
        listener.setOutputDir(outputDir);

        ElectricStovesPageSteps electricStovesPage = ThirdStep();
        int value = electricStovesPage.getProductsCount();
        logger.info("Количество товаров: " + value);

        //... проверить, что в заголовке количество товаров больше ста
        //SecondCaseMatcher secondCaseMatcher = new SecondCaseMatcher(electricStovesPage);
        SecondCaseMatcher secondCaseMatcher = new SecondCaseMatcher();
        secondCaseMatcher.productsCountIsCorrect(value);
    }


    protected StartPageSteps FirstStep(){
        StartPageSteps startPage = new StartPageSteps(driver);
        //startPage.confirmCity();
        listener.getScreenshotFull(driver,outputDir,"Начальная страница DNS");
        startPage.scrollToTop();
        //Навести курсор на ссылку Бытовая техника, проверить, что отображаются ссылки
        startPage.focusOnHouseholdAppliances();
        return startPage;
    }
    protected List<Link> SecondStep(){
        StartPageSteps startPage = new StartPageSteps(driver);
        //startPage.confirmCity();
        //Навестись на приготовление пищи... проверить количество ссылок в подменю
        startPage.focusOnHouseholdAppliances();
        startPage.focusOnCooking();
        logger.info("Открыто подменю Плиты и печи");
        logger.info("Количество элементов подменю: " + startPage.getSublistCooking().size());
        //startPage.scrollToTop();
        //return startPage;
        return startPage.getSublistCooking();
    }
    protected ElectricStovesPageSteps ThirdStep(){
        StartPageSteps startPage = new StartPageSteps(driver);
        //Навестись и перейти в плиты, ...
        startPage.focusOnHouseholdAppliances();
        startPage.focusAndClickCooking();
        logger.info("Перешли в раздел Плиты");
        listener.getScreenshotFull(driver,outputDir,"Плиты");
        startPage.scrollToTop();
        //...перейти в электрические плиты...
        StovesPageSteps stovesPageSteps = new StovesPageSteps(driver);
        stovesPageSteps.goToElectricStovesPage();
        logger.info("Перешли в раздел Плиты электрические");
        ElectricStovesPageSteps electricStovesPage = new ElectricStovesPageSteps(driver);
        listener.getScreenshotFull(driver,outputDir,"Электрические плиты");
        return electricStovesPage;
    }
}
