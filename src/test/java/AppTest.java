import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void AddNewWord() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    assertThat(pageSource()).contains("Add");
  }

  @Test
  public void AddWordInputFormNavigatesCorrectly() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Apple");
    submit(".btn");
    assertThat(pageSource()).contains("Success");
  }

  @Test
  public void testWordSavesAndDisplaysInList() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Apple");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Apple");
  }

  @Test
  public void testWordDefinitionSaves() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Apple");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Add New Word"));
    fill("#name").with("Pear");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Apple");
    assertThat(pageSource()).contains("Pear");
  }
}
