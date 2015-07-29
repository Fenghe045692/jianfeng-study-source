package com.jianfeng.algorithm.jiuzhang;

public class Others {
	public static void main(String[] args) {
		Others os = new Others();
		os.testfindMissing();
	}

	public void testfindMissing() {
		System.out.println(findMissing(new int[] {}));
		System.out.println(findMissing(new int[] { 0 }));
		System.out.println(findMissing(new int[] { 3, 2, 1, 4 }));
		System.out.println(findMissing(new int[] { 3, 2, 1, 0 }));
	}

	/*
	 * Given an array contains N numbers of 0 .. N, find which number doesn't
	 * exist in the array. Given N = 3 and the array [0, 1, 3], return 2.
	 */
	/**
	 * @param nums
	 *            : an array of integers
	 * @return: an integer
	 */
	public int findMissing(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		for (int i = 0; i < nums.length;) {
			if (nums[i] < nums.length && nums[i] != i) {
				swap(nums, nums[i], i);
			} else {
				i++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i)
				return i;
		}
		return nums.length;
	}

	public void swap(int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
	
	 /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        return 0;
    }
	
	public boolean isSameLine(Point p1, Point p2, Point p3){
		if(p1 == null || p2 == null)
			return true;
		return false;
	}

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

}
