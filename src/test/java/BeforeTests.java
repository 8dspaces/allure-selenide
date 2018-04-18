import config.Values;

import listeners.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.logevents.SelenideLogger;


public class BeforeTests {


    @BeforeClass
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/qimick/Documents/SourceSmart/@java/TestNG-Allure-Selenide/chromedriver");
        //Doesn't matter chrome or Chrome as this is case insensitive.
        System.setProperty("selenide.browser", "Chrome");

        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }


    @AfterClass
    public void tearDown() {
        getWebDriver().quit();
    }

}
