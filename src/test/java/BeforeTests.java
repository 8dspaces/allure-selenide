import com.codeborne.selenide.WebDriverRunner;
import config.Values;

import listeners.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.logevents.SelenideLogger;

import java.io.File;


public class BeforeTests {


    @BeforeClass
    public static void setupClass() {

        String cwd = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", cwd + File.separator + "chromedriver");

        //Doesn't matter chrome or Chrome as this is case insensitive.
        System.setProperty("selenide.browser", "Chrome");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }


    @AfterClass
    public void tearDown() {

        WebDriverRunner.getWebDriver().close();
        //getWebDriver().quit();
    }

}
