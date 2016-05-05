import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("a test definition");
    assertEquals(true, myDefinition instanceof Definition);
  }
  @Test
  public void Definition_instantiatesWithDefinition_String() {
    Definition myDefinition = new Definition("a test definition");
    assertEquals("a test definition", myDefinition.getDefinition());
  }

}