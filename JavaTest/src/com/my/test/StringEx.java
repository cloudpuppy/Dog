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
 * Solution6 : 중복문자 제거 (charAt(), indexOf())
 * Solution7:  회문문자열 StringBuilder(str).reverse(), str.equalsIgnoreCase()
 * Solution8 : 팰린드롬 (replaceAll)
 * Solution9 : 숫자추출 Character.isDigit(x)), Integer.parseInt()
 * Solution10 : 가장 짧은 문자 거리 
 * Solution11 : 문자열 압
 * Solution12 : 암호 (replace(), parseInt(string,2) 2진수 10진수
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
	
	public String solution6(String str){
		String answer ="";
		
		for(int i=0 ; i < str.length() ;i++) {
			if(str.indexOf(i) == i) {
				answer += str.charAt(i);
			}
		}
		return answer;
	}
	
	public String solution7(String str){
		String answer ="YES";
		//Case1
		/*
		str = str.toUpperCase();
		int len = str.length();
		for(int i=0; i< len/2; i++) {
			if(str.charAt(i) != str.charAt(len-i-1)) return("NO"); 
		}*/
		
		//Case2
		String tmp = new StringBuilder(str).reverse().toString();
		if(!str.equalsIgnoreCase(tmp)) return("NO");
		return answer;
	}
	
	public String solution8(String str){
		String answer ="NO";
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		String tmp = new StringBuilder(str).reverse().toString();
		if(tmp.equals(str)) answer = "YES";
		return answer;
	}
	
	public int solution9(String str){
		String answer ="";
		for(char x : str.toCharArray()) {
			//if(x >= 48 && x <57) answer = answer *10 + (x-48);
			if(Character.isDigit(x)) answer +=x;
		}
		return Integer.parseInt(answer);
	}

	public int[] solution10(String str, char target){
		int[] answer = new int[str.length()];
		int p = 1000;
		for(int i=0 ; i < str.length(); i++) {
			if(str.charAt(i) == target) {
				p = 0 ;
				answer[i] = p;
			}
			else {
				p++;
				answer[i] = p;
			}
		}
		
		p =1000;
		for(int i=str.length()-1; i >=0 ; i--) {
			if(str.charAt(i) == target) p = 0;
			else {
				p++;
				answer[i] = Math.min(answer[i], p);
			}
		}
		return answer;
	}
	
	public String solution11(String str) {
		String answer = "";
		str = str + " ";
		int cnt = 1;
		for(int i=0 ; i < str.length()-1 ; i++) {
			if(str.charAt(i) == str.charAt(i+1)) cnt++;
			else {
				answer += str.charAt(i);
				if(cnt >1) answer += String.valueOf(cnt);
				cnt =1;
			}
		}
		return answer;
	}

	public String solution12(int n, String str) {
		String answer = "";
		for(int i =0 ; i < n; i++) {
			String tmp = str.substring(0,7).replace('#','1').replace('*', '0');
			int num = Integer.parseInt(tmp,2);
			answer+=(char)num;
			str = str.substring(7);
		}
		
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
		/*
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution5(str));
		*/
		//Solution6
		/*
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution6(str));
		*/
		//Solution7
		/*
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution7(str));
		*/
		//Solution8
		/*
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution8(str));
		*/
		//Solution9
		/*
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution9(str));
		*/
		//Solution10
		/*
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		for(int x : T.solution10(str,c)) {
			System.out.print(x + " ");
		}
		*/
		//Solution11
		/*
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution11(str));
		*/
		//Solution12
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String str = kb.next();
		System.out.println(T.solution12(n,str));
		
	}

}
