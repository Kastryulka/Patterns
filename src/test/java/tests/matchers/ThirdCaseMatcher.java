package tests.matchers;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import static org.apache.commons.lang3.StringUtils.contains;

public class ThirdCaseMatcher {
    BasePage page;
    String vendorName = "ASUS";
    String ramSize = "32";

    public ThirdCaseMatcher(BasePage page){
        this.page = page;
    }

    //Проверить, что заголовок страницы соответствует ожидаемому
    public void newWindowTitleIsCorrect(String newWindowTitle,String firstLaptopText){
        Assertions.assertTrue(contains(newWindowTitle,firstLaptopText),"заголовок новой страницы не соответствует ожидаемому");
    }
    //Проверить, что в блоке Характеристики заголовок содержит ASUS
    public void characteristicsTitleIsCorrect(WebElement characteristicsTitle){
        Assertions.assertTrue(contains(characteristicsTitle.getText().toUpperCase(),vendorName),"заголовок некорректный: не " + vendorName);
    }
    //Проверить, что в блоке Характеристики значение Объем оперативной памяти равно 32 ГБ
    public void characteristicsRamIsCorrect(WebElement characteristicsRam){
        Assertions.assertTrue(contains(characteristicsRam.getText().toUpperCase(),ramSize), "ОЗУ в характеристиках некорректный: не " + ramSize);
    }
}
