package com.test.algorithm;

class Solution2 {
  public static void main(String[] args) {
    int[] A = {-5,-4,1,2,5};


    for (int i = 0; i < A.length; i++) {
      System.out.print("  " + A[i] + " ");
    }
    int B[] = sortedSquares(A);
    System.out.println(" A ");
    for (int i = 0; i < A.length; i++) {
      System.out.print("  " + A[i] + " ");
    }

    System.out.println();
    for (int i = 0; i < B.length; i++) {
      System.out.print("  " + B[i] + " ");
    }
  }

  public static int[] sortedSquares(int[] A) {
    for(int i=0; i< A.length; i++){
      A[i]= A[i]*A[i];
    }

    return quickSort(A,0,A.length-1);
  }
  public static int[] quickSort(int[] A, int start, int end){
    if(start < end){
      int mid = quickSort1(A,start, end);
      quickSort(A,start, mid-1);
      quickSort(A,mid+1, end);
    }

    return A;
  }

  public static int quickSort1(int[] A , int start, int end){
    int piv = A[start];

    while (start < end) {

      if (A[end] >= piv && start < end) {
        end--;
      }
      A[start] = A[end];

      if (A[start] <= piv && start < end) {
        start++;
      }
      A[end] = A[start];
    }
    A[start] = piv;

    return start;

  }
}
