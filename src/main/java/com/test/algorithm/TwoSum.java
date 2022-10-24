package com.test.algorithm;

class TwoSum {
  public static int[] twoSum(int[] numbers, int target) {
    int i, h;
    int[] returnSizes = new int[2];
    for (i = 0; i < numbers.length; i++) {
      // if (numbers[i] >= target)
      // return null;
      returnSizes[0] = i + 1;
      h = numbers.length - 1;

      System.out.println(" returnSizes[0] " + returnSizes[0] + " h " + h + " num[i] " + numbers[i]);
      for (int j = i + 1; j < h + 1; j++) {
        if (numbers[j] + numbers[i] == target) {
          returnSizes[1] = j + 1;
          return returnSizes;
        }
        if (numbers[h] + numbers[i] == target) {
          returnSizes[1] = h + 1;
          return returnSizes;
        }

        if (numbers[(j + h) / 2] + numbers[i] == target) {
          returnSizes[1] = (j + h) / 2 + 1;
          return returnSizes;
        }
        if (numbers[(j + h) / 2] + numbers[i] == target) {
          h = (j + h) / 2 - 1;
        }
        if (numbers[(j + h) / 2] + numbers[i] == target) {
          j = (j + h) / 2;
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] num =
        {12, 13, 23, 28, 43, 44, 59, 60, 61, 68, 70, 86, 88, 92, 124, 125, 136, 168, 173, 173, 180,
            199, 212, 221, 227, 230, 277, 282, 306, 314, 316, 321, 325, 328, 336, 337, 363, 365,
            368, 370, 370, 371, 375, 384, 387, 394, 400, 404, 414, 422, 422, 427, 430, 435, 457,
            493, 506, 527, 531, 538, 541, 546, 568, 583, 585, 587, 650, 652, 677, 691, 730, 737,
            740, 751, 755, 764, 778, 783, 785, 789, 794, 803, 809, 815, 847, 858, 863, 863, 874,
            887, 896, 916, 920, 926, 927, 930, 933, 957, 981, 997};
    int[] b = twoSum(num, 542);
    for (int i = 0; i < 2; i++) {
      System.out.println(b[i]);
    }
  }
}