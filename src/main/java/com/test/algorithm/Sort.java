package com.test.algorithm;

public class Sort {
  public static void main(String[] args) {
    int[] A = {-5,-4,1,2,5,0,7,-5};


    for (int i = 0; i < A.length; i++) {
      System.out.print("  " + A[i] + " ");
    }
    int B[] = quickSort(A, 0, A.length - 1);
    System.out.println();
    for (int i = 0; i < B.length; i++) {
      System.out.print("  " + B[i] + " ");
    }
  }

  public static int[] quickSort(int[] A, int start, int end) {
    if (start < end) {
      int mid = quickSort1(A, start, end);
      quickSort(A, start, mid - 1);
      quickSort(A, mid + 1, end);
    }

    return A;
  }

  public static int quickSort1(int[] A, int start, int end) {
    int piv = A[start];
      while(start < end){

        if(A[end] < piv ) {
          A[start] = A[end];
          start++;
        }
        else{
          end--;
        }
        if(A[start] > piv){
          A[end]= A[start];
          end--;
        }
        else{
          start++;
        }
      }

    A[start] = piv;
    return start;
  }

  public int[] sortArrayByParityII(int[] A) {
    int left = 0, right;
    for(int i=0; i<  A.length-1 ; i++){
      if(i%2 == 0 && A[i]%2 != 0){
        right = i+1;
        while(right < A.length-1){
          if(right %2 !=0 && A[right] %2 ==0){
            int temp = A[i];
            A[i] = A[right];
            A[right] = temp;
            break;
          }else{
            right+=2;
          }
        }

      }
      if(i%2 != 0 && A[i]%2 == 0){
        right = i+1;
        while(right < A.length-1){
          if(right %2 ==0 && A[right] %2 !=0){
            int temp = A[i];
            A[i] = A[right];
            A[right] = temp;
            break;
          }else{
            right+=2;
          }
        }

      }

    }
    return A;
  }
}
