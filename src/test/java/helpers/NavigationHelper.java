package helpers;

import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private static WebDriver navigation;

    public static void init(WebDriver driver) {
        navigation = driver;
    }

    public static void navigateTo(String URL) {
        navigation.navigate().to(URL);
    }
}
