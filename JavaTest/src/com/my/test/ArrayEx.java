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
	 * Solution7 : 점수 계산 
	 * Solution8 : 등수 구하기 
	 * Solution9 : 격자판 최대합 Math.max(answer, sum);
	 * Solution10 : 봉우리 
	 * Solution11 : 임시반장 정하기
	 * Solution12 : 멘토링 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayEx T = new ArrayEx();
		
		//Solution1
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution1(n,arr)) {
			System.out.print(x + " ");
		}
		
		
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
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution6(n,arr)) {
			System.out.print(x + " ");
		}
		*/
		
		//Solution7
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution7(n, arr));
		*/
		
		//Solution8
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution7(n,arr)) {
			System.out.print(x + " ");
		}
		*/
		
		//Solution9
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] arr = new int[n][n];
		for(int i =0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution9(n,arr));
		*/
		
		//Solution10
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] arr = new int[n][n];
		for(int i =0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution10(n,arr));
		*/
		
		//Solution11
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] arr = new int[n+1][6];
		for(int i =1; i<=n; i++) {
			for(int j=1; j<=5; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution11(n,arr));
		*/
		
		//Solution12
		/*
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[][] arr = new int[m][n];
		for(int i =0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution12(n,m,arr));
		*/
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
	
	private int solution7(int n, int[] arr) {
		int answer = 0, cnt = 0;
		for(int i =0 ; i < n ; i++) {
			if(arr[i] == 1) {
				cnt++;
				answer += cnt;
			}
			else cnt = 0;
		}
		
		return answer;
	}
	
	private int[] solution8(int n, int[] arr) {
		int[] answer = new int[n];
		for(int i=0; i<n; i++) {
			int cnt = 1;
			for(int j=0; j <n; j++) {
				if(arr[j] > arr[i]) cnt++;
			}
			answer[i] = cnt;
		}
		
		return answer;
	}
	

	private int solution9(int n, int[][] arr) {
		int answer = Integer.MIN_VALUE;
		int sum1, sum2;
		for(int i=0; i<n; i++) {
			sum1 = sum2 = 0;
			for(int j=0;j<n;j++) {
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		sum1 = sum2 = 0;
		for(int i=0; i<n; i++) {
			sum1 += arr[i][i];
			sum2 += arr[i][n-i-1];
		}
		answer = Math.max(answer, sum1);
		answer = Math.max(answer, sum2);
		return answer;
	}

	private int solution10(int n, int[][] arr) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int answer =0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				boolean flag = true;
				for(int k=0; k<4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx >=0 && nx < n && ny >=0 && ny <n && arr[nx][ny] >= arr[j][j]) {
						flag =false;
						break;
					}
				}
				if(flag) answer++;
			}
		}
		return answer;
	}
	
	private int solution11(int n, int[][] arr) {
		int answer =0, max = Integer.MIN_VALUE;
		for(int i =1 ; i <= n;i++) {
			int cnt = 0;
			for(int j=1; j <=n;j++) {
				for(int k=1; k<=5; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}
				}
			}
			if(cnt > max) {
				max = cnt;
				answer = i;
			}
		}
		return answer;
	}
	
	private int solution12(int n, int m, int[][] arr) {
		int answer = 0;
		for(int i=0; i<=n; i++) {
			for(int j=1; j <=n; j++) {
				int cnt=0;
				for(int k=0; k<m;k++) {
					int pi=0, pj=0;
					for(int s=0; s<n; s++) {
						if(arr[k][s] == i) pi = s;
						if(arr[k][s] == j) pj = s;
					}
					if(pi <pj) cnt++;
				}
				if(cnt == m) {
					answer++;
				}
			}
		}
		return answer;
	}

}
