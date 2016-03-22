package com.jianfeng.algorithm.jiuzhang;

public class BTNode {
	BTNode left, right;
	int val;
	
	public BTNode(int val){
		this.val = val;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
	
}
