
import listeners.AllureOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;


//import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import pages.GooglePage;
import pages.SearchResultsPage;




@Listeners(AllureOnFailListener.class)
@Title("Test")
public class GoogleTest extends BeforeTests{


  @Test
  public void userCanSearch() {
    GooglePage page = open("http://www.baidu.com/", GooglePage.class);
    SearchResultsPage results = page.searchFor("selenide");
    //results.getResults().shouldHave(sizeGreaterThan(1));
    results.getResult(0).shouldHave(text("selenide"));
  }

}
