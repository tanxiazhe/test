package com.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.Semaphore;

/**
 * 1+2*3*4
 */

public class CalculationTest {
	public ArrayList<Integer> arrayList = new ArrayList<>(16);

	public static void main(String[] args) {
		String input ="1+2*3*4";
		System.out.println(cal(input));
	}
	public void printThread(){
		Thread a = new Thread(()->{

		});
		a.run();

	}
	public static int calWithStack(String input){
		int ans =0;
		Deque<Character> numStack = new ArrayDeque<>(16);
		int i=0;
		while(i< input.length()){
			int i1 = i;
			char cur = input.charAt(i);
			if(cur >=0 && cur <=9 ){
				numStack.push(cur);
			}
			else if(cur == '+' || cur =='-'){
				numStack.push(cur);
			}else{
				char lastOp = numStack.pop();
				if(cur =='*'){
					int temp = (lastOp-'0') * (cur-'0');
					numStack.push((char) (temp-'0'));
				}else {
					int temp = (lastOp-'0') / (cur-'0');
					numStack.push((char) (temp-'0'));
				}
			}
			i++;
		}



		return ans;
	}



	public static int cal(String input){
		int sum = 0;
		if(input.isEmpty() || input.trim().isEmpty()){
			return sum;
		}
		char lastOp= '+' ;
		int lastNum =0;
		for(int i=0; i<= input.length()-1; i++){
			char charAt = input.charAt(i);
			if(charAt -'0' >=0 && charAt-'9' <=0){
				if(lastOp == '+' || lastOp =='-') {
					lastNum = charAt;
				}
				 if(lastOp == '*'){
					lastNum *= charAt;

				}
				 if(lastOp == '/'){
					lastNum /=charAt;
				}
			}else{
				lastOp = charAt;
				if(lastOp =='+'){
					sum+=lastNum;
					lastNum = 0;
				}else if(lastOp =='-'){
					sum-=lastNum;
					lastNum =0;
				}
			}

		}


		return sum;
	}

}


