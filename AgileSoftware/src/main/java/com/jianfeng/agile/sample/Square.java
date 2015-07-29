package com.jianfeng.agile.sample;

public class Square extends Rectangle{
	public void setHeight(double height) {
		super.setHeight(height);
		super.setWidth(height);
	}

	public void setWidth(double width) {
		super.setHeight(width);
		super.setWidth(width);
	}
}
