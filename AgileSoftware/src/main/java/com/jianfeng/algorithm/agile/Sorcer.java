package com.jianfeng.algorithm.agile;

public class Sorcer {
	private int[] itsThrows = new int[21];
	private int itsCurrentThrow = 0;

	private int ball;
	
	public void addThrow(int pins){
		itsThrows[itsCurrentThrow++] = pins;
	}
	
	public int scoreForFrame(int frame){
		ball = 0;
		int score = 0;
		for(int currentFrame = 0; currentFrame < frame; currentFrame++){
			if(strike()){
				score += 10 + nextTwoBallsForStrike();
				ball++;
			}else{
				score += handleSecondThrow();
			}
		}
		return score;
	}
	
	public boolean strike(){
		return itsThrows[ball] == 10;
	}
	
	public int nextTwoBallsForStrike(){
		return itsThrows[ball+1] + itsThrows[ball + 2];
	}
	
	public int handleSecondThrow(){
		int score = 0;
		if(sqare()){
			score += 10 + nextBallForSqare();
			ball += 2;
		}else{
			score += twoBallsInFrame();
			ball += 2;
		}
		return score;
	}
	
	public int twoBallsInFrame(){
		return itsThrows[ball] + itsThrows[ball + 1];
	}
	
	public boolean sqare(){
		return itsThrows[ball] + itsThrows[ball + 1] == 10;
	}
	
	public int nextBallForSqare(){
		return itsThrows[ball + 2];
	}
}
