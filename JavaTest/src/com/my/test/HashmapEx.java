package com.my.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashmapEx {

	public static void main(String[] args) {
		/*
		 * [Hashmap 프린트 하기 ]
		 * 	--> for(char key : map.keySet()) {
				System.out.println(key + " " + map.get(key));}
		 * 
		 * [key가 존재하는지 확인하기]
		 *   --> map.containsKey('A')
		 *   
		 * [key의 갯수]
		 * --> map.size()
		 * 
		 * [key를 삭제하기]
		 * --> map.remove('A)';
		 *   
		 *  Solution1 : COUNT하기 map.put(key,value),  map.getOrDefault(key, 0)+1;
		 *  Solution2 : 아나그램 map.put(x, map.get(x)-1);
		 *  Solution3 : 매출액 종류
		 */
		HashmapEx T = new HashmapEx();
		
		//Solution1
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String str = kb.next();
		System.out.println(T.solution1(n,str));
		*/
		
		//Soution2
		/*
		Scanner kb = new Scanner(System.in);
		String a = kb.next();
		String b = kb.next();
		System.out.println(T.solution2(a,b));
		*/
		
		//Solution3
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		for(int x: T.solution3(n,k,arr)) System.out.println(x + " ");
		*/
	}


	public char solution1(int n, String str) {
		char answer = ' ';
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char x : str.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		int max = Integer.MIN_VALUE;
		
		for(char key : map.keySet()) {
			//System.out.println(key + " " + map.get(key));
			if(map.get(key) > max)
			{
				max = map.get(key);
				answer = key;
			}
		}
		return answer;
	}
	

	private String solution2(String s1, String s2) {
		String answer = "YES";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char x : s1.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		
		for (char x : s2.toCharArray()) {
			if(!map.containsKey(x) ||map.get(x) == 0) return "NO";
			else map.put(x, map.get(x)-1);
		}
		
		return answer;
	}


	private ArrayList<Integer> solution3(int n, int k, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		HashMap<Integer, Integer> HM = new HashMap<Integer, Integer>();
		for(int i=0; i<k-1;i++) {
			HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
		}
		int lt=0;
		for(int rt =k-1; rt<n ; rt++) {
			HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
			answer.add(HM.size());
			HM.put(arr[lt], HM.get(lt)-1);
			if(HM.get(arr[lt]) ==0) HM.remove(arr[lt]);
			lt++;
		}
		return answer;
	}

}
