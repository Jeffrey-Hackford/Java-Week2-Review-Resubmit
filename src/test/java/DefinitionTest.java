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

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("a test definition");
    Definition secondDefinition = new Definition("another test definition");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void clear_emptiesAllInstancesFromArrayList_0() {
    Definition myDefinition = new Definition("a test definition");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_definitionsInstantiateWithAnIncreasingIDNumber_1() {
    Definition.clear();
    Definition myDefinition = new Definition("a test definition");
    assertEquals(1, myDefinition.getId());
  }


}
