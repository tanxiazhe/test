package com.test;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
	public List<Integer> addToArrayForm(int[] num, int k) {
		List<Integer> ans = new LinkedList<Integer>();
		int ca=0, t=0,m=num.length-1,sum;
		while(k!=0&& m>=0){
			t = k%10;
			sum = num[m]+t+ca;
			ans.addFirst(sum%10);
			ca = sum/10;
			m--;
			k = k/10;
		}

		while(m>=0){
			sum = num[m]+ca;
			ans.addFirst(sum%10);
			ca = sum/10;
			m--;
		}
		while(k!=0){
			t = k%10;
			sum = t+ca;
			ans.addFirst(sum%10);
			ca = sum/10;
			k = k/10;
		}
		if(ca>0){
			ans.addFirst(ca);
		}

		return ans;
	}
}
