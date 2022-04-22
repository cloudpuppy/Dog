package com.my.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayEx {
	/**
	 * Solution1 : 큰수 출력하기. 
	 * Solution2 : 보이는 학생 
	 * Solution3 : 가위바위보 
	 * Solution4 : 피보나치수열
	 * Solution5 : 소소의 개수 (에라토스테네스 체)
	 * Solution6 : 뒤집은 소수 
	 * Solution7 : 점수 계
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayEx T = new ArrayEx();
		
		//Solution1
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution1(n,arr)) {
			System.out.print(x + " ");
		}
		*/
		
		//Solution2 
	/*	Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution2(n, arr));
		*/
		
		//Solution3
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i=0; i < a.length; i++) {
			a[i] = kb.nextInt();
		}
		for(int i=0; i < a.length; i++) {
			b[i] = kb.nextInt();
		}
		for(char x : T.solution3(n, a, b).toCharArray()) System.out.println(x);
		*/
		
		//Solution4
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		for(int x : T.solution4(n)) System.out.print(x + " ");
		*/
		
		//Solution5
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		System.out.println(T.solution5(n));
		*/
		
		//Solution6
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution6(n,arr)) {
			System.out.print(x + " ");
		}
		
		
	}


	private ArrayList<Integer> solution1(int n, int[] arr) {
		 ArrayList<Integer> answer = new ArrayList<>();
		 answer.add(arr[0]);
		 for(int i=1 ; i <n; i++) {
			 if(arr[i] > arr[i-1]) answer.add(arr[i]);
		 }
		return answer;
	}
	
	private int solution2(int n, int[] arr) {
		int answer = 1;
		int max = arr[0];
		for(int i =1 ; i<n; i++) {
			if(arr[i] > max) answer++;
		}
		return answer;
	}
	
	private String solution3(int n, int[] a, int[] b) {
		String answer = "";
		for(int i =0 ; i<n; i++) {
			if(a[i] == b[i]) answer += "D";
			else if(a[i]==1 && b[i]==3) answer += "A";
			else if(a[i]==2 && b[i]==1) answer += "A";
			else if(a[i]==3 && b[i]==2) answer += "A";
			else answer += "B";
		}
		return answer;
	}
	
	private int[] solution4(int n) {
		int[] answer = new int[n];
		answer[0] = 1;
		answer [1] = 1;
		for(int i=2 ; i<n ; i++) {
			answer[i] = answer[i-2] + answer[i-1];
		}
		return answer;
	}
	
	private int solution5(int n) {
		int answer =0;
		int[] ch = new int[n+1];
		for(int i=2; i<=n; i++){
			if(ch[i]==0){
				answer++;
				for(int j=i; j<=n; j=j+i) ch[j]=1;
			}
		}
		return answer;
	}
	
	private ArrayList<Integer> solution6(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0; i<n; i++){
			int tmp=arr[i];
			int res=0;
			while(tmp>0){
				int t=tmp%10;
				res=res*10+t;
				tmp=tmp/10;
			}
			if(isPrime(res)) answer.add(res);
		}
		return answer;
	}
	
	public boolean isPrime(int num) {
		if(num==1) return false;
		for(int i=2; i<num; i++){
			if(num%i==0) return false;
		}
		return true;

	}

}
