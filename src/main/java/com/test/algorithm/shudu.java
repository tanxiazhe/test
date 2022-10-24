package com.test.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class shudu {
	public static void main(String[] args) {
		char [][] a = new char[][]{{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};

		for(int i=0; i<a.length; i++){
			System.out.println(Arrays.toString(a[i]));
		}
		System.out.println(isValidSudoku(a));
	}
	public static boolean isValidSudoku(char[][] board) {
		boolean rtn = true;
		rtn = rtn && getSub(board,0,0,9);

		for(int i=0; i<9; ){
			for(int j=0; j< 9;){
				rtn = rtn && getSub(board,i,j,3);
				j+=3;
			}

			i+=3;
		}
		return rtn;
	}

	static boolean  getSub(char[][] board, int m, int n , int size){
		System.out.println(size+", m="+m+", n=" +n);
		Set<Character> set = new HashSet<>();

		for(int i=m; i<m+size; i++){

			for(int j=n; j<n+size; j++){

				if(board[i][j] !='.'){
					if(set.contains(board[i][j])){
						System.out.println(size+"-column, i="+i+", j=" +j);
						return false;
					}else{
						System.out.print(size+"-, i="+i+", j=" +j+", "+ board[i][j]+", before size" + set.size());
						set.add(board[i][j]);

					}
				}
			}
			System.out.println(size+"-column after "+set);
			set.clear();

			for(int j=n; j<n+size; j++){
				if(board[j][i] !='.'){
					if(set.contains(board[j][i])){
						System.out.println(size+"-row, i="+i+", j=" +j);
						return false;
					}else{
						set.add(board[j][i]);
						System.out.println(size+"-row after "+set.size());
					}
				}
			}
			System.out.println(size+"-row after "+set);
			set.clear();
		}
		return true;
	}
}
