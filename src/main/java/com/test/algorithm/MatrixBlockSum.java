package com.test.algorithm;

class MatrixBlockSum {
  public int[][] matrixBlockSum(int[][] mat, int K) {
    int res[][] = new int[mat.length][mat[0].length];
    int helper[][] = matrixBlockSumHelper(mat);
    for(int i=0; i< mat.length; i++){
      for(int j=0; j< mat[0].length; j++){
        int sum = 0;
        int il = Math.max(i-K, 0);
        int ih = Math.min(i+K, mat.length-1);
        int jl = Math.max(j-K, 0);
        int jh = Math.min(j+K, mat[0].length-1);

        sum = helper[ih][jh];
        if(il >0) sum-= helper[il-1][jh];
        if(jl >0) sum-= helper[ih][jl-1];
        if(il>0 && jl>0) sum+= helper[il-1][jl-1];
        res[i][j] = sum;
      }
    }
    return res;
  }

  public int[][] matrixBlockSumHelper(int[][] mat) {
    int res[][] = new int[mat.length][mat[0].length];
    for(int i=0; i< mat.length; i++){
      int sum = 0;
      for(int j=0; j< mat[0].length; j++){
        System.out.println("0  mat[i][j]= "+ mat[i][j]+ " sum= "+  sum);
        sum += mat[i][j];
        System.out.println("1  mat[i][j]= "+ mat[i][j]+ " sum= "+  sum);
        if(i>0) sum+= res[i-1][j];
        res[i][j] = sum;
        System.out.println(res[i][j]);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    MatrixBlockSum mbs = new MatrixBlockSum();
    int [][] input  =new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    mbs.matrixBlockSumHelper(input);
  }
}