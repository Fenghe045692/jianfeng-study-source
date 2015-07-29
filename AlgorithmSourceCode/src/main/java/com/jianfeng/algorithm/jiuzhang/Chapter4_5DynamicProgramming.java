package com.jianfeng.algorithm.jiuzhang;

import java.util.ArrayList;

public class Chapter4_5DynamicProgramming {
	
	public static void main(String[] args){
		Chapter4_5DynamicProgramming dy = new Chapter4_5DynamicProgramming();
//		dy.testFibonacci();
		//dy.testKnapsackWithDPitemsRec();
//		dy.testlonggestCommonSubsequence();
//		dy.testKnapsackWithDPitemsRec();
		dy.testminDistance();
	}
	
	public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
		KSUMResultType[][] memorization = new KSUMResultType[A.length + 1][k + 1];
		for(int i=0; i< A.length + 1; i++)
			memorization[i][0] = new KSUMResultType();
		for(int i=0; i< k; i++)
			memorization[0][k] = new KSUMResultType();
		for(int i =1; i < A.length + 1; i++){
			for(int j =1; j< k; j++){
			}
		}
		return memorization[A.length][k].solutions;
	}
	
	public KSUMResultType addItemIntoLists(KSUMResultType list, Integer item){
		if(null == list)
			return list;
		if(list.solutions == null){
			
		}
		return null;
	}
	public void testminDistance(){
		System.out.println(minDistance("ABCD", "DCBA"));
		System.out.println(minDistance("mart", "karma"));
		System.out.println(minDistance("mart", "k"));
	}
	
	public int minDistance(String word1, String word2) {
		if(word1 == null || word2 == null || word1.equals("") || word2.equals(""))
			return 0;
		int m = word1.length();
		int n = word2.length();
        int[][] memorization = new int[m + 1][n + 1];
        for(int i=0; i< m + 1; i++){
        	memorization[i][0] = i;
        }
        for(int i=0; i< n + 1; i++){
        	memorization[0][i] = i;
        }
        for(int i=1; i< m + 1; i++){
            for(int j =1; j< n + 1; j++){
            	if(word1.charAt(i -1) == word2.charAt(j -1)){
            		memorization[i][j] = memorization[i-1][j-1]; 
            	}else{
            		memorization[i][j] = Math.min(memorization[i -1][j -1], Math.min(memorization[i -1][j], memorization[i][j -1])) + 1;
            	}
            }
        }
        return memorization[word1.length()][word2.length()];
    }
	
	public void testlonggestCommonSubsequence(){
		System.out.println(longgestCommonSubsequence("ABCDFEGKDLD", "DACBFWAEGDK"));
		System.out.println(longgestCommonSubsequenceDy("ABCDFEGKDLD", "DACBFWAEGDK"));
	}
	
	public int longgestCommonSubsequence(String A, String B){
		if(A == null || A.equals("") || B == null || B.equals(""))
			return 0;
		if(A.charAt(A.length() -1) == B.charAt(B.length() - 1)){
			return longgestCommonSubsequence(A.substring(0, A.length() - 1), B.substring(0, B.length() - 1)) + 1;
		}else{
			return Math.max(longgestCommonSubsequence(A, B.substring(0, B.length() - 1)),  longgestCommonSubsequence(A.substring(0, A.length() - 1), B));
		}
	}
	
	public int longgestCommonSubsequenceDy(String A, String B){
		if(A == null || A.equals("") || B == null || B.equals(""))
			return 0;
		int[][] memoization = new int[A.length() + 2][B.length() + 2];
		for(int i=0; i< A.length(); i++){
			for(int j=0; j < B.length();j++){
				memoization[i+1][j+1] = Math.max(memoization[i+1][j], memoization[i][j+1]);
				if(A.charAt(i) == B.charAt(j))
					memoization[i+1][j+1] = memoization[i][j] + 1;
			}
		}
		return memoization[A.length()][B.length()];
	}
	
	public void testKnapsackWithDPitemsRec(){
		Item[] items = new Item[]{new Item(4, 8), new Item(3, 5)};
		System.out.println(KnapsackWithDPitemsRec(9, items));
		System.out.println(KnapsackWithDPitemsRec(10, items));
		System.out.println(KnapsackWithDPitemsDy(9, items));
		System.out.println(KnapsackWithDPitemsDy(10, items));
		int[] cps_1 = new int[10];
		for(int i=0;i < cps_1.length; i++)
			cps_1[i] = -1;
		int[] cps_2 = new int[11];
		for(int i=0;i < cps_2.length; i++)
			cps_2[i] = -1;
		System.out.println(KnapsackWithDPitemsRecM(9, items, cps_1));
		System.out.println(KnapsackWithDPitemsRecM(10, items, cps_2));
		
		System.out.println(KnapsackWithOutDPitemsRec(9, items.length, items));
		System.out.println(KnapsackWithOutDPitemsRec(10, items.length, items));
		
		System.out.println(KnapsackWithOutDPitemsRecDY(9, items.length, items));
		System.out.println(KnapsackWithOutDPitemsRecDY(10, items.length, items));
		
	}
	
	public int KnapsackWithDPitemsRec(int capacity, Item[] items){
		if(capacity <= 0 || items.length == 0)
			return 0;
		int type_numbers = items.length;
		int max_value = 0;
		for(int i=0; i < type_numbers; i++){
			if(capacity >= items[i].size){
				max_value = Math.max(max_value, KnapsackWithDPitemsRec(capacity - items[i].size, items) + items[i].value);
			}
		}
		return max_value;
	}
	
	public int KnapsackWithOutDPitemsRec(int capacity, int numbersoftype, Item[] items){
		if(capacity <= 0 || numbersoftype == 0)
			return 0;
		int currentitem = numbersoftype - 1;
		int value_current_picked = 0;
		if(capacity > items[currentitem].size){
			value_current_picked = KnapsackWithOutDPitemsRec(capacity - items[currentitem].size, numbersoftype -1, items) + items[currentitem].value; 
		}
		
		return Math.max(value_current_picked, KnapsackWithOutDPitemsRec(capacity, numbersoftype -1, items));
	}
	
	public int KnapsackWithOutDPitemsRecDY(int capacity, int numbersoftype, Item[] items){
		int[][] memorization = new int[numbersoftype][capacity + 1];
		for (int s = 0; s <= capacity; s++)
		{
			if (s < items[0].size)
				memorization[0][s] = 0;
			else
				memorization[0][s] = items[0].value;
		}
		for(int i=1; i< numbersoftype; i++){
			for(int j=0; j<= capacity; j++){
				int pre_value =0;
				if(j >= items[i].size){
					pre_value = memorization[i-1][j-items[i].size] + items[i].value;
				}
				memorization[i][j] = Math.max(memorization[i-1][j], pre_value);
			}
		}
		return memorization[numbersoftype-1][capacity];
	}
	
	public int KnapsackWithDPitemsRecM(int capacity, Item[] items, int[] capacities){
		if(capacity <= 0 || items.length <= 0)
			return 0;
		if(-1 != capacities[capacity])
			return capacities[capacity];
		int type_numbers = items.length;
		int max_value = 0;
		for(int i=0; i < type_numbers; i++){
			if(capacity >= items[i].size){
				max_value = Math.max(max_value, KnapsackWithDPitemsRec(capacity - items[i].size, items) + items[i].value);
			}
		}
		capacities[capacity] = max_value;
		return max_value;
	}
	
	public int KnapsackWithDPitemsDy(int capacity, Item[] items){
		if(capacity <= 0 || items.length == 0)
			return 0;
		int[] capacities = new int[capacity + 1];
		for(int i = 1; i < capacity + 1; i++){
			int max_value = 0;
			for(int k=0; k < items.length; k++){
				if(i >= items[k].size){
					max_value = Math.max(max_value, capacities[i - items[k].size] + items[k].value);
				}
			}
			capacities[i] = max_value;
		}
		return capacities[capacity];
	}
	
	public void testFibonacci(){
		int[] mv = new int[11];
		int i =0;
		while(i < mv.length){
			mv[i] = -1;
			i++;
		}
		System.out.println(Fibonacci(10));
		System.out.println(FibonacciDy(10));
		System.out.println(FibonacciM(10, mv));
	}
	
	public int FibonacciM(int  n, int[] mv){
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		if(mv[n] != -1)
			return mv[n];
		int value = FibonacciM(n-1, mv) + FibonacciM(n-2, mv);
		mv[n] = value;
		return value;
	}
	
	public int Fibonacci(int  n){
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		return Fibonacci(n-1) + Fibonacci(n-2);
	}
	
	public int FibonacciDy(int  n){
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		int pre_value = 0;
		int next_value = 1;
		for(int i = 2; i <= n; i++){
			int tmp = next_value;
			next_value = pre_value + next_value;
			pre_value = tmp;
		}
		return next_value;
	}
	
	public class Item{
		public int size;
		public int value;
		
		public Item(int size, int value){
			this.size = size;
			this.value = value;
		}
	}
	
	public class KSUMResultType{
		public ArrayList<ArrayList<Integer>> solutions;
		
		public KSUMResultType(){
		}
	}
}
