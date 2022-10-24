package com.test.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leeat");
		wordDict.add("leet");
		wordDict.add("code");
		Set<String> set = new HashSet<>(wordDict);
//		System.out.println(set);
		SetTest setTest = new SetTest();
		String s = "";
		System.out.println(s.isEmpty());
		//System.out.println(setTest.wordBreak("leetcode", wordDict));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		return wordBreak(s,set);
	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		if(wordDict.contains(s)) return true;
		System.out.println(s);
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i=1; i< s.length()+1; i++){
			String left = s.substring(0, i);
			String right = s.substring(i);
			System.out.println(i + ", left: "+left+ ", right: "+ right);
			if(wordDict.contains(left) && wordBreak(right,wordDict)){
				return true;
			}
		}

		return false;
	}
}
