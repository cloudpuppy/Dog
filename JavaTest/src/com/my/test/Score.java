package com.my.test;

public class Score {
	String test;
	String name;
	String seq;
	int testNum;
	int score1;
	int scroe2;
	int total;
	
	public Score(String test, String name, String seq, int testNum, int score1, int scroe2) {
		super();
		this.test = test;
		this.name = name;
		this.seq = seq;
		this.testNum = testNum;
		this.score1 = score1;
		this.scroe2 = scroe2;
		this.total = score1 + scroe2;
	}
	
	public static Score parseResult(String line) {
		String[] item = line.split("#");
		Score s   = new Score(item[0], item[1], item[2], 
				Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5]));
		return s;
		
	}	

}
