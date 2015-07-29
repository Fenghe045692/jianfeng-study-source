package com.jianfeng.algorithm.jiuzhang;

import java.util.ArrayList;

public class Chapter_3 {
	public static void main(String[] args) {
		Chapter_3 c3 = new Chapter_3();
//		System.out.println(" Pre Order Travesal----");
//		c3.testpreorderTraversal();
//		System.out.println(" In Order Travesal----");
//		c3.testinorderTraversal();
//		System.out.println(" Post Order Travesal----");
//		c3.testpostorderTraversal();
//		c3.testmaxDepth();
//		c3.testisBalanced();
//		c3.testmaxPathSum();
//		c3.testquickSort();
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		return null;
	}
	
	public void testquickSort(){
		int[] arr = new int[]{1,3,5,7,3,0,12,5,9}; 
		quickSort(arr, 0, arr.length - 1);
		for(int item : arr){
			System.out.print(" " + item);
		}
		System.out.println();
	}
	
	public void testmaxPathSum(){
		System.out.println(maxPathSum(makeBalancedBT()[0]));
		System.out.println(maxPathSum(makeBalancedBT()[1]));
	}
	
	public void testisBalanced(){
		System.out.println(isBalanced(makeBalancedBT()[0]));
		System.out.println(isBalanced(makeBalancedBT()[1]));
	}
	
	public boolean isBalanced(TreeNode root) {
		if(null == root)
			return true;
		return getBMaximumLength(root) != -1;
	}
	
	public void testmaxDepth(){
		System.out.println(maxDepth(makeSampleTreeForMaximumDepthOfBT()));
		System.out.println(maxDepth(makeSampleTree()));
	}
	
	public int maxDepth(TreeNode root) {
        return getMaximumLength(root);
    }
	
	public int getMaximumLength(TreeNode root){
		if(root == null)
			return 0;
		int left = getMaximumLength(root.left);
		int right = getMaximumLength(root.right);
		return Math.max(left, right) + 1;
	}
	
	public int getBMaximumLength(TreeNode root){
		if(root == null)
			return 0;
		int left = getBMaximumLength(root.left);
		if(left == -1)
			return -1;
		int right = getBMaximumLength(root.right);
		if(right == -1)
			return -1;
		if((Math.max(left, right) - Math.min(left, right)) > 1)
				return -1;
		return Math.max(left, right) + 1;
	}
	
	public void testpreorderTraversal(){
		for(int item : preorderTraversal(makeSampleTree())){
			System.out.print(" " + item);
		}
		System.out.println();
	}
	
	public void testinorderTraversal(){
		for(int item : inorderTraversal(makeSampleTree())){
			System.out.print(" " + item);
		}
		System.out.println();
	}
	
	public void testpostorderTraversal(){
		for(int item : postorderTraversal(makeSampleTree())){
			System.out.print(" " + item);
		}
		System.out.println();
	}
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		if(root == null)
			return null;
		ArrayList<Integer> rs = new ArrayList<Integer>();
		preorderTravesal(root, rs);
		return rs;
	}
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		if(root == null)
			return null;
		ArrayList<Integer> rs = new ArrayList<Integer>();
		inorderTravesal(root, rs);
		return rs;
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		if(root == null)
			return null;
		ArrayList<Integer> rs = new ArrayList<Integer>();
		postorderTravesal(root, rs);
		return rs;
	}
	
	public void preorderTravesal(TreeNode root, ArrayList<Integer> rs){
		if(root != null){
			rs.add(root.val);
			preorderTravesal(root.left, rs);
			preorderTravesal(root.right, rs);
		}else
			return;
	}
	
	public void inorderTravesal(TreeNode root, ArrayList<Integer> rs){
		if(root != null){
			inorderTravesal(root.left, rs);
			rs.add(root.val);
			inorderTravesal(root.right, rs);
		}else
			return;
	}
	
	public void postorderTravesal(TreeNode root, ArrayList<Integer> rs){
		if(root != null){
			postorderTravesal(root.left, rs);
			postorderTravesal(root.right, rs);
			rs.add(root.val);
		}else
			return;
	}
	
	public int partition(int arr[], int left, int right)
	{
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right)/2];
		while(i <= j){
			while(arr[i] < pivot)
				i++;
			while(arr[j] > pivot)
				j--;
			if(i<=j){
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}
	
	public void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if(left < index -1)
			quickSort(arr, left, index -1);
		if(index < right)
			quickSort(arr, index, right);
	}
	
	
	public TreeNode makeSampleTree(){
		TreeNode root = new TreeNode(1);
		TreeNode right_1 = new TreeNode(2);
		TreeNode left_1 = new TreeNode(3);
		root.right = right_1;
		right_1.left = left_1;
		return root;
	}
	
	public TreeNode makeSampleTreeForMaximumDepthOfBT(){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode right_l = new TreeNode(4);
		TreeNode right_r = new TreeNode(5);
		right.left = right_l;
		right.right = right_r;
		root.left = left;
		root.right = right;
		return root;
	}
	
	public TreeNode[] makeBalancedBT(){
		TreeNode[] st = new TreeNode[2];
		//initial A
		TreeNode A = new TreeNode(3);
		TreeNode A1 = new TreeNode(9);
		TreeNode A2 = new TreeNode(20);
		TreeNode A3 = new TreeNode(15);
		TreeNode A4 = new TreeNode(7);
		A2.left = A3;
		A2.right = A4;
		A.right = A2;
		A.left = A1;
		st[0] = A;
		//initial B
		TreeNode B = new TreeNode(3);
		TreeNode B1 = new TreeNode(20);
		TreeNode B2 = new TreeNode(15);
		TreeNode B3 = new TreeNode(7);
		B1.left = B2;
		B1.right = B3;
		B.right = B1;
		st[1] = B;
		return st;
	}

	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	private class ResultType {
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}
