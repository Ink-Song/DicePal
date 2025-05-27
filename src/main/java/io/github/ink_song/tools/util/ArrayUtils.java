package io.github.ink_song.tools.util;

import java.util.Arrays;

public class ArrayUtils {

  public static int[] sortAndDropLowest(int[] input) {
    Arrays.sort(input);
    int[] output = new int[input.length - 1];
    System.arraycopy(input, 1, output, 0, input.length - 1);
    return output;
  }
}
