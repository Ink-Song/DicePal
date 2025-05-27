package io.github.ink_song.tools.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {

  @Test
  void sum() {
    int[] set1 = {1,1,1,1};
    int[] set2 = {2,2,2,2};

    int result1 = MathUtil.sum(set1);
    assertEquals(4, result1);
    int result2 = MathUtil.sum(set2);
    assertEquals(8, result2);
  }
}