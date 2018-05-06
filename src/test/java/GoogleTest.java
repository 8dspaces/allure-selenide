
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;


//import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import pages.GooglePage;
import pages.SearchResultsPage;



//@Listeners(AllureOnFailListener.class)
@Title("Test")
@Feature("Search example Testing")
public class GoogleTest extends BeforeTests{


  @Story("baidu testing")
  @Test
  public void userCanSearch() {
    GooglePage page = open("http://www.baidu.com/", GooglePage.class);
    SearchResultsPage results = page.searchFor("selenide");
    //results.getResults().shouldHave(sizeGreaterThan(1));
    results.getResult(0).shouldHave(text("Selenide"));
  }

    @Story("use parameters")
    @Parameters({ "username", "password" })
    @Test
    public void useParameters(@Optional("mysql") String username, @Optional("mysql") String password) {

      System.out.println("output is - " + username);
      System.out.println("output is - " + password);


    }

}
