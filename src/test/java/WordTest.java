import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {
    Word.clear();
    Definition.clear();
  }

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word testWord = new Word("Apple");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getWord_categoryInstantiatesWithWord_Apple() {
    Word testWord = new Word("Apple");
    assertEquals("Apple", testWord.getWord());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("Apple");
    Word secondWord = new Word("Pear");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_emptiesAllWordsFromList_0() {
    Word testWord = new Word("Apple");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void getId_wordsInstantiateWithAnId_1() {
    Word testWord = new Word("Apple");
    assertEquals(1, testWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondWord() {
    Word firstWord = new Word("Apple");
    Word secondWord = new Word("Pear");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }
}
