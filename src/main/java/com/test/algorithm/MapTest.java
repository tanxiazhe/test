package com.test.algorithm;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		Map<Character, List<String>> input = new HashMap<>();
		input.put('2', Arrays.asList("a","b","c"));
		input.put('3',Arrays.asList("d","e","f"));
		input.put('4',Arrays.asList("g","h","i"));
		input.put('5',Arrays.asList("j","k","l"));
		input.put('6',Arrays.asList("m","n","o"));
		input.put('7',Arrays.asList("p","q","r","s"));
		input.put('8',Arrays.asList("t","u","v"));
		input.put('9',Arrays.asList("w","x","y","z"));

		String digits ="23";
		List<List<String>> in = new ArrayList<>();
		for(int i=0; i<digits.length();i++){
			in.add(input.get(digits.charAt(i)));
		}
		List<String> strings = in.get(0);
		System.out.println(strings.get(0));
		System.out.println(strings.get(0));
	}
}
