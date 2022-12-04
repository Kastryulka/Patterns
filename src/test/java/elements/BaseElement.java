package elements;

import org.openqa.selenium.WebElement;

public class BaseElement {
    protected WebElement webElement;
    // Конструктор класса
    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }
    public WebElement getWebElement() {
        return webElement;
    }
}
