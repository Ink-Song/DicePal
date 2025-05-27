package io.github.ink_song.tools.util;

public class MathUtil {
  public static int sum(int[] ints) {
    int sum = 0;
    for (int num : ints){
      sum = sum + num;
    }
    return sum;
  }
}
