import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

  /**
   * Created by aze on 2017.04.04..
   */
  class ExtensionTest {

    Extension extension = new Extension();

    @Test
    void testAdd_2and3is5() {
      assertEquals(5, extension.add(2, 3));
    }


    @Test
    void testAdd_1and4is5() {
      assertEquals(5, extension.add(1, 4));
    }

    @Test
    void testAdd_0and4is4() {
      assertEquals(4, extension.add(0, 4));
    }

    @Test
    void testMaxOfThree_first() {
      assertEquals(5, extension.maxOfThree(5, 4, 3));
    }

    @Test
    void testMaxOfThree_third() {
      assertEquals(5, extension.maxOfThree(3, 4, 5));
    }

    @Test
    void testMaxOfThree_second() {
      assertEquals(10, extension.maxOfThree(1, 10, 8));
    }

    @Test
    void testMaxOfThree_allSame() {
      assertEquals(10, extension.maxOfThree(10, 10, 10));
    }

    @Test
    void testMedian_four() {
      assertEquals(5, extension.median(Arrays.asList(7,5,3,5)));
    }

    @Test
    void testMedian_five() {
      assertEquals(3, extension.median(Arrays.asList(1,2,3,4,5)));
    }

    @Test
    void testMedian_fiveNotOrdered() {
      assertEquals(5, extension.median(Arrays.asList(1,5,1,6,7)));
    }

    @Test
    void testIsVowel_a() {
      assertTrue(extension.isVowel('a'));
    }

    @Test
    void testIsVowel_u() {
      assertTrue(extension.isVowel('u'));
    }

    @Test
    void testIsVowel_1() {
      assertFalse(extension.isVowel('1'));
    }

    @Test
    void testTranslate_bemutatkozik() {
      assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
    }

    @Test
    void testTranslate_lagopus() {
      assertEquals("lavagovopuvus", extension.translate("lagopus"));
    }
  }
