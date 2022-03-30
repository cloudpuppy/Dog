package com.my.test;

import java.util.Scanner;
/**
 * 
 * @author jhkim
 * String(문자열 관련 테스트)
 * Solution1 : 문자열에서 문자 갯수 찾기
 * Solution2 : 대소문자 변환 
 *
 */
public class Ex1 {
	
	public int Solution1(String str, char t) {
		int answer = 0;
		
		//대문자로 변경하기
		str = str.toUpperCase();
		t = Character.toUpperCase(t);	
		
		//Case1
		/*
		for(int i=0; i < str.length(); i++) {
			if(str.charAt(i) == t) {
				answer++;
			}
		}
		*/
		
		//Case2
		for(char x : str.toCharArray()) {
			if(x == t) answer++;
		}
		return answer;
	}
	
	public String solution2(String str) {
		String answer = "";
		for(char x : str.toCharArray()) {
			if(Character.isLowerCase(x)) answer+= Character.toUpperCase(x);
			else answer += Character.toLowerCase(x);
		}
		return answer;
	}

	public static void main(String[] args) {
		Ex1 T = new Ex1();
		
		/*[Solution1]
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		System.out.print(T.Solution1(str, c));
		*/
		
		//Solution2.
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution2(str));
		
	}

}
