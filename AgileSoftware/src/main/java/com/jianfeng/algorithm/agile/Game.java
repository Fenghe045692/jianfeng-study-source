package com.jianfeng.algorithm.agile;

public class Game {
	private int currentFrame = 0;
	private boolean firstThrowInFrame = true;
	private Sorcer sorcer = new Sorcer();
	
	public void add(int pins) {
		sorcer.addThrow(pins);
		adjustCurrentFrame(pins);
	}
	
	public void adjustCurrentFrame(int pins){
		if(lastBallInFrame(pins)){
			advanceFame();
			firstThrowInFrame = true;
		}else{
			firstThrowInFrame = false;
		}
	}
	
	public boolean lastBallInFrame(int pins){
		return (strike(pins) || !firstThrowInFrame);
	}
	
	public int getCurrentFrame(){
		return currentFrame;
	}
	
	public boolean strike(int pins){
		return firstThrowInFrame && pins == 10;
	}
	
	public int score() {
		return sorcer.scoreForFrame(currentFrame);
	}
	
	public boolean adjustFrameForStrike(int pins){
		if(pins == 10){
			advanceFame();
			return true;
		}
		return false;
	}
	
	public int scoreForFrame(int frame){
		return sorcer.scoreForFrame(frame);
	}
	
	private void advanceFame(){
		currentFrame = Math.min(10, currentFrame + 1);
	}

}
