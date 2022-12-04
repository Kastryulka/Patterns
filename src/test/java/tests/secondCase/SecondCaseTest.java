package tests.secondCase;

import elements.Link;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HouseholdAppliancesPage;
import pages.StartPage;
import steps.StartPageSteps;
import tests.BaseTest;
import tests.matchers.FirstCaseMatcher;
import tests.matchers.SecondCaseMatcher;

import java.util.List;

public class SecondCaseTest extends BaseTest {
    @Test
    public void firstStepTest(){
        outputDir = "temp\\\\SecondCase\\\\";
        listener.setOutputDir(outputDir);

        StartPageSteps startPage = FirstStep();

        SecondCaseMatcher secondCaseMatcher = new SecondCaseMatcher(startPage);
        secondCaseMatcher.sublistAppliancesIsCorrect(startPage.getSublistAppliances());
        listener.getScreenshotFull(driver,outputDir,"Элементы меню Бытовая техника");
        startPage.scrollToTop();
        logger.info("Необходимые ссылки отображаются");
    }
    @Test
    public void secondStepTest(){
        outputDir = "temp\\\\SecondCase\\\\";
        listener.setOutputDir(outputDir);

        //StartPageSteps startPage = SecondStep();
        StartPageSteps startPage = new StartPageSteps(driver); /////////!!!!!!!
        List<Link> sublistCooking = SecondStep();
        listener.getScreenshotFull(driver,outputDir,"Элементы меню Плиты и печи");

        //... проверить, что ссылок больше пяти
        SecondCaseMatcher secondCaseMatcher = new SecondCaseMatcher(startPage);
        secondCaseMatcher.popupCookingCountIsCorrect(sublistCooking);
        listener.getScreenshotFull(driver,outputDir,"Элементы меню Бытовая техника");
        startPage.scrollToTop();
        logger.info("Необходимые ссылки отображаются");
    }
    /*@Test
    public void dnsTest(){
        outputDir = "temp\\\\SecondCase\\\\";
        listener.setOutputDir(outputDir);
        SecondCaseMatcher secondCaseMatcher = new SecondCaseMatcher(new StartPage(driver));

        String cityXpath = "//*[contains(@class,'city-select__text')]";

        decoratedDriver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница DNS - " + "https://www.dns-shop.ru/");
        listener.getScreenshotFull(driver,outputDir,"Начальная страница DNS");
        actions.scrollToElement(driver.findElement(By.xpath(cityXpath))).perform();

        //если появляется окно выбора города (может скрывать Бытовую технику), нажимаем на кнопку согласия
        String xpathConfirmCityBtn = "//button[contains(@class,'v-confirm-city__btn')]";
        try{
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathConfirmCityBtn)))
                    .click();
            logger.info("Согласились с выбором города");
            WebElement body = driver.findElement(By.xpath(
                    "//body[1]"));
            wait.until(ExpectedConditions.stalenessOf(body));
            logger.info("Страница обновлена");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        ////первый шаг

        //////второй шаг

        //Навестись и перейти в плиты, ...
        actions
                .moveToElement(linkAppliances)
                .perform();
        WebElement stoves = wait.until(ExpectedConditions.elementToBeClickable(linkCooking));
        actions
                .moveToElement(stoves)
                .click()
                .perform();
        logger.info("Перешли в раздел Плиты");
        listener.getScreenshotFull(driver,outputDir,"Плиты");
        actions.scrollToElement(driver.findElement(By.xpath(cityXpath))).perform();
        //...перейти в электрические плиты...
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@class,'subcategory__item')]//span[text()='Плиты электрические']")))
                .click();
        logger.info("Перешли в раздел Плиты электрические");
        listener.getScreenshotFull(driver,outputDir,"Электрические плиты");
        //... проверить, что в заголовке количество товаров больше ста
        WebElement productsCount = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@class='products-count']")));
        int value = Integer.parseInt(productsCount.getText().replaceAll("[^0-9]", ""));
        logger.info("Количество товаров: " + value);
        secondCaseMatcher.productsCountIsCorrect(value);
    }*/

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
}
