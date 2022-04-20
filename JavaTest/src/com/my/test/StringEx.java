package com.my.test;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author jhkim
 * String(문자열 관련 테스트)
 * Solution1 : 문자열에서 문자 갯수 찾기
 * Solution2 : 대소문자 변환 
 * Solution3 : 문장속 단어 (IndexOf(), substring())
 * Solution4 : 단어 뒤집기 (StringBuilder(x).reverse())
 * Solution5 : 특정 문자 뒤집기(toCharArray())
 *
 */
public class StringEx {
	
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
	
	public String solution3(String str) {
		String answer = "";
		int m = Integer.MIN_VALUE, pos;
		//Case1. Split 
		String[] s = str.split(" ");
		for(String x : s) {
			int len = x.length();
			if(len > m) {
				m = len;
				answer = x;
			}
		}
		
		/*//Case2 index of
		while((pos = str.indexOf(' ')) != -1) {
			String tmp = str.substring(0, pos);
			int len = tmp.length();
			if(len > m) {
				m = len;
				answer = tmp;
			}
			str = str.substring(pos+1);
		}
		if(str.length() > m) answer = str;
		
		*/
		
		return answer;
	}
	
	public ArrayList<String> solution4(Integer n ,String[] str) {
		ArrayList<String>  answer =  new ArrayList<String>();
		for(String x: str) {
			//Case1
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
			
			//Case2
			/*
			char[] s = x.toCharArray();
			int lt = 0, rt = x.length()-1;
			while(lt<rt) {
				char temp = s[lt];
				s[lt] = s[rt];
				s[rt] = temp;
				lt++;
				rt++;
				
			}
			String.valueOf(s);*/
		}
		return answer;
	}
	
	public String solution5(String str){
		String answer ="";
		char[] s = str.toCharArray();
		int lt=0, rt = str.length()-1;
		while(lt <rt) {
			if(!Character.isAlphabetic(s[lt])) lt++;
			else if(!Character.isAlphabetic(s[rt])) rt--;
			else {
				char tmp = s[lt];
				s[lt] = s[rt];
				s[rt] = tmp;
				lt++;
				rt--;
			}
		}
		answer = String.valueOf(s);
		return answer;
	}

	public static void main(String[] args) {
		StringEx T = new StringEx();
		
		/*[Solution1]
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		System.out.print(T.Solution1(str, c));
		*/
		
		/*//Solution2.
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution2(str));
		*/
		
		//Solution3
		/*
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution3(str));
		*/
		
		//Solution4
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String[] str = new String[n];
		for (int i=0; i <n ; i++) {
			str[i] = kb.next();
		}
		for (String x : T.solution4(n,str)) {
			System.out.println(x);
		}
		*/
		//Solution5
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution5(str));
		
	}

}
