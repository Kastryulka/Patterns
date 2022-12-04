package tests.firstCase;

import elements.Link;
import org.junit.jupiter.api.Test;
import pages.HouseholdAppliancesPage;
import pages.KitchenAppliancesPage;
import steps.HouseholdAppliancesPageSteps;
import steps.StartPageSteps;
import tests.BaseTest;
import tests.matchers.FirstCaseMatcher;

import java.util.List;

public class FirstCaseTest extends BaseTest{
    @Test
    public void firstStepTest(){
        outputDir = "temp\\\\FirstCase_firstStepTest\\\\";
        listener.setOutputDir(outputDir);

        HouseholdAppliancesPage householdAppliancesPage = FirstStep();

        FirstCaseMatcher firstCaseMatcher = new FirstCaseMatcher(householdAppliancesPage);
        firstCaseMatcher.householdAppliancesTextIsDisplayed(householdAppliancesPage.subcategoryPageTitle().getWebElement());
        logger.info("Надпись \"Бытовая техника\" в заголовке отображена");
    }
    @Test
    public void secondStepTest(){
        outputDir = "temp\\\\FirstCase-secondStepTest\\\\";
        listener.setOutputDir(outputDir);

        KitchenAppliancesPage kitchenAppliancesPage = SecondStep();

        FirstCaseMatcher firstCaseMatcher = new FirstCaseMatcher(kitchenAppliancesPage);
        firstCaseMatcher.kitchenAppliancesTextIsDisplayed(kitchenAppliancesPage.subcategoryPageTitle().getWebElement());
        logger.info("Надпись \"Техника для кухни\" в заголовке отображена");
    }
    @Test
    public void thirdStepTest(){
        outputDir = "temp\\\\FirstCase-thirdStepTest\\\\";
        listener.setOutputDir(outputDir);

        KitchenAppliancesPage kitchenAppliancesPage = ThirdStep();
        //... проверить, что отображается ссылка Собрать свою кухню,...

        FirstCaseMatcher firstCaseMatcher = new FirstCaseMatcher(kitchenAppliancesPage);
        firstCaseMatcher.confLinkDisplayed(kitchenAppliancesPage.configurationButton().getWebElement());
        logger.info("Ссылка \"Собрать свою кухню\" отображена");

    }

    /////!!!!!!!!!!!!!!!!!
    @Test
    public void thirdStepTestaaaaaaaa(){
        outputDir = "temp\\\\FirstCase-thirdAAAAAAAAAAAAAAAAAAAAAStepTest\\\\";
        listener.setOutputDir(outputDir);

        KitchenAppliancesPage kitchenAppliancesPage = ThirdStep();
        //... вывести в логи названия категорий, ...
        List<Link> subcategories= kitchenAppliancesPage.subcategories();
        for(Link elem : subcategories){
            logger.info("-" + elem.getText());
        }

        //...проверить, что категорий больше пяти
        FirstCaseMatcher firstCaseMatcher = new FirstCaseMatcher(kitchenAppliancesPage);
        firstCaseMatcher.subcategoriesCountIsCorrect(subcategories);
        logger.info("Категорий больше пяти");
    }

    protected HouseholdAppliancesPage FirstStep(){
        StartPageSteps startPage = new StartPageSteps(driver);
        listener.getScreenshotFull(driver,outputDir,"Начальная страница DNS");
        startPage.scrollToTop();
        //Перейти по ссылке Бытовая техника, проверить, что отображается текст
        startPage.goToHouseholdAppliancesPage();
        HouseholdAppliancesPage householdAppliancesPage = new HouseholdAppliancesPage(driver);
        logger.info("Перешли в раздел Бытовая техника");
        listener.getScreenshotFull(driver,outputDir,"Страница Бытовая техника");
        return householdAppliancesPage;
    }
    protected KitchenAppliancesPage SecondStep(){
        StartPageSteps startSteps = new StartPageSteps(driver);
        startSteps.goToHouseholdAppliancesPage();
        //Перейти по ссылке Техника для кухни, проверить, что отображается текст,...
        HouseholdAppliancesPageSteps householdAppliancesSteps = new HouseholdAppliancesPageSteps(driver);
        householdAppliancesSteps.goToKitchenAppliances();
        KitchenAppliancesPage kitchenAppliancesPage = new KitchenAppliancesPage(driver);
        logger.info("Перешли в раздел Техника для кухни");
        listener.getScreenshotFull(driver,outputDir,"Страница Техника для кухни");
        return kitchenAppliancesPage;
    }
    protected KitchenAppliancesPage ThirdStep(){
        StartPageSteps startSteps = new StartPageSteps(driver);
        startSteps.goToHouseholdAppliancesPage();
        HouseholdAppliancesPageSteps householdAppliancesSteps = new HouseholdAppliancesPageSteps(driver);
        householdAppliancesSteps.goToKitchenAppliances();
        KitchenAppliancesPage kitchenAppliancesPage = new KitchenAppliancesPage(driver);
        return kitchenAppliancesPage;
    }
}
