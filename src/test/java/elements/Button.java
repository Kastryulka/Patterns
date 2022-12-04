package elements;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement{
    public Button(WebElement webElement){super(webElement);}

    public void click() {
        // Ожидание кликабельности кнопки
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
