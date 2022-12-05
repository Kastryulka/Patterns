package tests.matchers;

import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import steps.StartPageSteps;

import java.util.ArrayList;
import java.util.List;

public class SecondCaseMatcher {
    StartPageSteps startPageSteps;
    //ожидаемые результаты
    ArrayList<String> testRefs = new ArrayList<String>();
    int productsCountExpected = 100;
    int popupCookingCountExpected = 5;

    //public SecondCaseMatcher(StartPageSteps startPageSteps){
    public SecondCaseMatcher(){
        //this.startPageSteps = startPageSteps;
        testRefs.add("Техника для кухни");
        testRefs.add("Техника для дома");
        testRefs.add("Встраиваемая техника");
    }

    //проверить, что отображаются ссылки, если навестись на Бытовая техника
    public void sublistAppliancesIsCorrect(List<Link> sublistAppliances){
        Assertions.assertEquals(testRefs.size(), sublistAppliances.size(), "количество ссылок не соответствует ожидаемому");
        for(Link elem : sublistAppliances){
            Assertions.assertTrue(testRefs.contains(elem.getText()), "элемент отсутствует среди ссылок");
            Assertions.assertTrue(elem.getWebElement().isDisplayed(), "не отображается элемент в разделе Бытовая техника");
        }}
    //... проверить, что ссылок больше пяти
    public void popupCookingCountIsCorrect(List<Link> popupCooking){
        Assertions.assertTrue(popupCooking.size()>popupCookingCountExpected, "Плиты и печи меньше " + popupCookingCountExpected);
    }
    //... проверить, что в заголовке количество товаров больше ста
    public void productsCountIsCorrect(int value){
        Assertions.assertTrue(value>productsCountExpected, "товаров меньше " + productsCountExpected);
    }
}
