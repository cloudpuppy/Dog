package com.my.test;

import java.util.Scanner;

public class Ex1 {
	
	//문자 갯수 찾기 
	public int Solution(String str, char t) {
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

	public static void main(String[] args) {
		Ex1 T = new Ex1();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		System.out.print(T.Solution(str, c));
	}

}
