package io.github.ink_song.tools.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

  @Test
  void sortAndDropLowest() {
    int[] set1 = {4,10,9,-30};
    int[] set3 = {1,2,3,4};

    int[] s1result = ArrayUtils.sortAndDropLowest(set1);
    assertEquals(4, s1result[0]);
    assertEquals(10, s1result[2]);
    assertTrue(s1result[0] > set1[0]);
    assertTrue(set1.length > s1result.length);

    int[] s3result = ArrayUtils.sortAndDropLowest(set3);
    assertEquals(2, s3result[0]);
  }
}