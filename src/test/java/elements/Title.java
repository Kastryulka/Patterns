package elements;

import org.openqa.selenium.WebElement;

public class Title extends BaseElement {
    public Title(WebElement webElement){super(webElement);}

    public String getTitleText(){
        return webElement.getText();
    }
}
