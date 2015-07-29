package com.jianfeng.algorithm.jiuzhang;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Chapter_2 {

	public static void main(String[] args) throws Exception {
		Chapter_2 st = new Chapter_2();
		// st.testLongestCommonSubstring();
//		st.testBinarySearch();
//		st.testSearchInsert();
//		st.testSearchMatrix();
//		st.testSearchMatrix2();
//		st.testFindPeak();
//		st.testSearch();
//		st.testRemoveDuplicates();
//		st.testRemoveDuplicates2();
//		st.testlongestConsecutive();
//		st.testpartitionArray();
//		st.test2sum();
//		st.testsingleNumberIII();
//		st.testfirstMissingPositive();
//		st.testthreeSumClosest();
//		st.testfourSum();
//		st.testbinarySearch();
//		st.testwoodCut();
//		st.testfindMin();
//		st.testtrailingZeros();
//		st.testupdateBits();
//		for(int i=0; i< 32; i++){
//			System.out.print((-1 >> i) & 1);
//		}
//		st.testnumTrees();
//		st.testlargestNumber();
//		st.testDeleteDigits();
	}
	
	public void testlargestNumber(){
		System.out.println(largestNumber(new int[]{1, 20, 23, 4, 8}));
		System.out.println(largestNumber(new int[]{1, 111, 11, 1, 1}));
		System.out.println(largestNumber(new int[]{1, 20, 2, 213, 214, 5, 55}));
	}
	
	public void testnumTrees(){
		System.out.println(numTrees(3));
//		System.out.println(numTrees(4));
//		System.out.println(numTrees(5));
		System.out.println(numTrees(6));
		System.out.println(numTrees(7));
	}
	
	public void testupdateBits(){
		System.out.println(updateBits(-123,45,21,26));
	}
	
	public void testtrailingZeros(){
		System.out.println(trailingZeros(5555550000000L));
	}
	
	public void testfindMin(){
		System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
		System.out.println(findMin(new int[]{0,1,2,4,5,6,7}));
		System.out.println(findMin(new int[]{7,6,5,4,3,2,1,0}));
	}
	
	public void testwoodCut(){
		System.out.println(woodCut(new int[]{232, 124, 456}, 7));
	}
	
	public void testbinarySearch(){
		System.out.println(binarySearch(new int[]{1, 2, 3, 3, 4, 5, 10}, 3));
	}
	
	public void testfourSum(){
		for(ArrayList<Integer> item : fourSum(new int[]{1,0,-1,-1,-1,-1,0,1,1,1,2}, 2)){
			for(int im : item){
				System.out.print(im + " ");
			}
			System.out.println();
		}
	}
	
	public void testthreeSumClosest(){
		System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
	}
	
	public void testfirstMissingPositive(){
		System.out.println(firstMissingPositive(new int[]{8,9,15}));
	}
	
	public void testsingleNumberIII(){
		System.out.println(singleNumberIII(new int[]{1,2,2,3,4,4,5,3}));
	}
	
	public void test2sum(){
//		for(int item : twoSum(new int[]{1, 3, 7, 9, 15, 6}, 9))
//			System.out.print(item + " ");
		for(int item : twoSumII(new int[]{1, 3, 7, 9, 15, 6}, 9))
			System.out.print(item + " ");
	}
	
	public void testpartitionArray(){
		System.out.println(partitionArray(new int[]{7,7,9,8,6,6,8,7,9,8,6,6}, 10));
	}
	
	public void testlongestConsecutive(){
		System.out.println(longestConsecutive(new int[]{1,1,1,2,2,2,2,3,3,4,4}));
	}
	
	public void testRemoveDuplicates(){
		System.out.println(removeDuplicates(new int[]{1,1,1,2,2,2,2,3,3,4,4}));
		System.out.println(removeDuplicates(new int[]{}));
		System.out.println(removeDuplicates(new int[]{1}));
		System.out.println(removeDuplicates(new int[]{1,2,3,4}));
	}
	
	public void testRemoveDuplicates2(){
		System.out.println(removeDuplicates2(new int[]{1,1,1,2,2,2,2,3,3,4,4}));
		System.out.println(removeDuplicates2(new int[]{}));
		System.out.println(removeDuplicates2(new int[]{1}));
		System.out.println(removeDuplicates2(new int[]{1,2,3,4}));
	}
	
	public void testSearch(){
		System.out.println(search(new int[]{4, 5, 1, 2, 3}, 3));
		System.out.println(search(new int[]{4, 5, 1, 2, 3}, 0));
		System.out.println(search(new int[]{4, 5}, 0));
		System.out.println(search(new int[]{4, 0}, 0));
		System.out.println(search(new int[]{1, 5, 7, 8, 9, 10}, 10));
	}
	
	public void testFindPeak(){
		System.out.println(findPeak(new int[]{1, 2, 1, 3, 4, 5, 7, 6}));
		System.out.println(findPeak(new int[]{1, 2, 1}));
		System.out.println(findPeak(new int[]{1, 2, 3, 4, 6, 5, 7, 6}));
	}
	
	public void testSearchMatrix2(){
		System.out.println(searchMatrix2(new int[][]{{1, 3, 5, 7}, {2, 4, 7, 8}, {3, 5, 9, 10}}, 3));
		System.out.println(searchMatrix2(new int[][]{}, 3));
	}
	
	public void testSearchMatrix(){
		System.out.println(searchMatrix(new int[][]{{1, 2, 5, 7},{10, 11, 16, 20}, {23, 30, 34, 50}}, 3));
		System.out.println(searchMatrix(new int[][]{}, 3));
		System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 7));
	}
	
	public void testSearchInsert(){
		System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
		System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
		System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
		System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
		System.out.println(searchInsert(new int[]{1,2,3,4,5,9}, 0));
	}

	public void testLongestCommonSubstring() {
		System.out.println(longestCommonPrefix(new String[] { "ABCDEFG",
				"ABCEFG", "ABCEFA", "ACKDJHS" }));
	}

	public void testBinarySearch() {
		ArrayList<Integer> rs = new ArrayList<Integer>();
		rs.add(6);
		rs.add(6);
		rs.add(7);
		rs.add(7);
		rs.add(7);
		rs.add(7);
		rs.add(7);
		rs.add(7);
		rs.add(8);
		rs.add(9);
		for (int item : binarySearch(rs, 7))
			System.out.println(item);
	}
	
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
    	if(num == null || num.length == 0)
    		return null;
    	StringBuilder rst = new StringBuilder();
    	for(int i=0; i< num.length; i++){
    		for(int j=0; j< num.length -i - 1; j++){
    			if(compareTwoIntegers(num[j], num[j+1]) > 0){
    				int tmp = num[j];
    				num[j] = num[j+1];
    				num[j+1] = tmp;
    			}
    		}
    		rst.append(num[num.length -1 -i]);
    	}
    	return rst.toString();
    }
    
    class NumbersComparator implements Comparator<String>{

		public int compare(String o1, String o2) {
			return (o1+ o2).compareTo(o2+o1);
		}
    	
    }
    
    private int compareTwoIntegers(int first, int second){
    	String f_str = String.valueOf(first);
    	String s_str = String.valueOf(second);
    	if(f_str.length() == s_str.length()){
    		return first - second;
    	}else{
    		int i=0;
    		while(i < f_str.length() && i < s_str.length() && f_str.charAt(i) == s_str.charAt(i)) i++;
    		if(i == f_str.length()){
    			return Integer.valueOf(s_str.charAt(0)) - Integer.valueOf(s_str.charAt(i));
    		}
    		if(i == s_str.length())
    			return Integer.valueOf(f_str.charAt(i)) - Integer.valueOf(f_str.charAt(0));
    		return Integer.valueOf(f_str.charAt(i)) - Integer.valueOf(s_str.charAt(i));
    	}
    }
	
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
    	int[] cache = new int[n+1];
    	cache[0] = 1;
    	cache[1] = 1;
    	cache[2] = 2;
    	for(int i=3; i< n+1; i++){
    		int tmp = i-1;
    		while(tmp >=0){
    			cache[i] += cache[tmp]*cache[i-tmp-1];
    			tmp--;
    		}
    	}
    	return cache[n];
    }
	
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
    	System.out.println("Pre n : " + Integer.toBinaryString(n));
    	System.out.println("Pre m : " + Integer.toBinaryString(m));
        int tmp = ~(((1 << j+1) - 1) - ((1 << i) -1));
        System.out.println("Tmp " + Integer.toBinaryString(tmp));
        n = n & tmp;
        System.out.println("After n : " + Integer.toBinaryString(n));
        m = m << i;
        System.out.println("After m : " + Integer.toBinaryString(m));
        return m | n;
    }
    
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     * Ex : 11! = 39916800, so the out should be 2
     */
    public long trailingZeros(long n) {
    	long count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
	
    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
		Given [4, 5, 6, 7, 0, 1, 2] return 0
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if(null == num || num.length == 0)
        	return -1;
        int left = 0;
        int right = num.length - 1;
        while(left + 1 < right){
        	int mid = left + (right - left)/2;
        	if(num[0] < num[num.length -1]){
        		right = mid;
        	}else{
        		if(num[mid] >= num[left] && num[mid] > num[right]){
            		left = mid;
            	}else{
            		if(num[mid] > num[right])
            			left = mid;
            		else
            			right = mid;
            	}
        	}
        }
        if(num[left] > num[right])
        	return num[right];
        else
        	return num[left];
    }
	
    /** 
     * Given n pieces of wood with length L[i] (integer array). 
     * Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
     * What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
     * For L=[232, 124, 456], k=7, return 114.
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
    	if(k <=0 || null == L || L.length == 0)
    		return 0;
    	int max = L[0];
    	for(int item : L){
    		if(item > max)
    			max = item;
    	}
    	int left = 1;
    	int right = max;
    	while(left + 1 < right){
    		int mid = left + (right - left)/2;
    		int i=0,nums = 0;
    		while(i < L.length) {
    			nums+=L[i]/mid;
    			i++;
    		}
    		if(nums >= k){
    			left = mid;
    		}else{
    			right = mid;
    		}
    	}
    	int i =0, lnums =0,rnums =0;
    	while(i < L.length) {
			lnums+=L[i]/left;
			rnums += L[i]/right;
			i++;
		}
    	if(rnums == k){
    		return right; 
    	}
    	if(lnums == k)
    		return left;
    	return 0;
    }
	
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
    	if(nums == null || nums.length == 0)
    		return -1;
    	int left = 0;
    	int right = nums.length -1;
    	while(left + 1 < right){
    		int mid = left + (right - left)/2;
    		if(nums[mid] >= target){
    			right = mid;
    		}else{
    			left = mid;
    		}
    	}
    	if(nums[left] == target)
    		return left;
    	if(nums[right] == target)
    		return right;
    	return -1;
    }
	
	 /**
     * @param A : An integer array
     * @return : Two integers
     * 0^a=a
     */
    public List<Integer> singleNumberIII(int[] A) {
    	if(A == null || A.length == 0)
    		return null;
    	List<Integer> rst = new ArrayList<Integer>();
    	int sum = 0;
    	for(int item : A){
    		sum = sum^item;
    	}
    	int interval = 0;
    	for(int i =0;i<32;i++){
    		if(1 == (sum >> i & 1))
    			interval = i;
    	}
    	int first = 0, second = 0;
    	for(int item : A){
    		if((item >> interval & 1)==0)
    			first = first ^ item;
    		else
    			second = second ^ item;
    	}
    	rst.add(first);
    	rst.add(second);
    	return rst;
    }
    
	
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        if(A == null || A.length == 0)
        	return -1;
        int result =0;
        int[] bits = new int[32];
        for(int i =0;i < 32; i++){
        	for(int j=0; j< A.length; j++){
        		bits[i] += A[j] >> i & 1;
        		bits[i] %= 3;
        	}
        	result |= (bits[i] << i);
        }
        return result;
    }
	
	 /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length < 3) {
			return rst;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}

			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
				if (sum == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					rst.add(tmp);
					left++;
					right--;
					while (left < right && num[left] == num[left - 1]) { // to skip duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]) { // to skip duplicates
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return rst;
    }
    
	/*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int[] result = new int[]{};
        for(int i =0; i< numbers.length; i++){
        	if(numbers[i] >= target)
        		continue;
        	index1=i;
        	for(int j = i+ 1;j< numbers.length;j++){
        		if(numbers[j] == target- numbers[i]){
        			result = new int[]{index1 + 1, j+1};
        			return result;
        		}
        			
        	}
        }
        return result;
    }
    
    public int[] twoSumII(int[] numbers, int target) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i=0; i< numbers.length; i++){
        	if(cache.containsKey(target - numbers[i])){
        		int left = cache.get(target - numbers[i]) + 1;
        		result[0] = Math.min(left, i + 1);
        		result[1] = Math.max(left, i + 1);
        		break;
        	}
        	cache.put(numbers[i], i);
        }
        return result;
    }
    
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
    	if(null == numbers || numbers.length == 0)
    		return null;
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(numbers);
    	for(int i=0; i< numbers.length - 3; i++){
    		if(i!=0 && numbers[i] == numbers[i-1])
    			continue;
    		for(int j = i+1; j< numbers.length -2; j++){
    			if(j!=i+1 && numbers[j] == numbers[j-1])
        			continue;
    			int mid = j+1;
    			int right = numbers.length -1;
    			while(mid < right){
    				int sum = numbers[i] + numbers[j] + numbers[mid] + numbers[right];
        			if(sum == target){
        				ArrayList<Integer> tmp = new ArrayList<Integer>();
        				tmp.add(numbers[i]);
        				tmp.add(numbers[j]);
        				tmp.add(numbers[mid]);
        				tmp.add(numbers[right]);
        				rst.add(tmp);
        				mid++;
        				right--;
        				while (mid < right && numbers[mid] == numbers[mid - 1]) { // to skip duplicates
    						mid++;
    					}
    					while (mid < right && numbers[right] == numbers[right + 1]) { // to skip duplicates
    						right--;
    					}
        			}else if(sum > target){
        				right--;
        			}else{
        				mid++;
        			}
    			}
    		}
    	}
    	return rst;
    }
	
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
    	if(numbers == null || numbers.length < 3)
    		return 0;
    	Arrays.sort(numbers);
    	int dis = Integer.MAX_VALUE;
    	for(int i=0; i < numbers.length -2; i++){
    		int left = i+1;
    		int right = numbers.length -1;
    		while(left < right){
    			int sum = numbers[i] + numbers[left] + numbers[right];
    			if(Math.abs(sum - target) < Math.abs(dis - target))
    				dis = sum;
    			if(sum < target){
    				left++;
    			}else if(sum > target){
    				right --;
    			}else{
    				return target;
    			}
    		}
    	}
    	return dis;
    }
    
	/**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
    	if(A == null || A.size() == 0)
    		return B;
    	if(B == null || B.size() == 0)
    			return A;
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int i=0,j=0;
    	for(; i< A.size()&&j<B.size();){
    		if(A.get(i) < B.get(j)){
    			result.add(A.get(i));
    			i++;
    		}else{
    			result.add(B.get(j));
    			j++;
    		}
    	}
    	if(i<A.size()){
    		result.addAll(A.subList(i, A.size()));
    	}else{
    		result.addAll(B.subList(j, B.size()));
    	}
    	return result;
    }
    
	public int partitionArray(int[] nums, int k) {
    	if(nums == null || nums.length == 0)
    		return 0;
    	int partitionNumber = getPartitionNumber(nums, k);
    	System.out.println(partitionNumber);
    	int left =0,right = nums.length-1;
    	while(left <= right){
    		if(nums[left] < partitionNumber){
    			left++;
    		}else{
    			int tmp = nums[right];
    			nums[right] = nums[left];
    			nums[left] = tmp;
    			right --;
    		}
    	}
    	return left;
    }
	
	/**    
     * @param A: an array of integers
     * @return: an integer
     */
	public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
                int tmp = A[A[i]-1];
                if (tmp == A[i]) {
                    break;
                }
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }
        for (int i = 0; i < A.length; i ++) {
                if (A[i] != i + 1) {
                    return i + 1;
                }
        }
        return A.length + 1;
    }
	
    public int getPartitionNumber(int[] nums, int k){
    	if(nums == null || nums.length == 0)
    		return 0;
    	int bigger = nums[0];
    	for(int item : nums){
    		if(item == k)
    			return k;
    		else if(item > k){
    			if(item < bigger)
    				bigger = item;
    		}
    	}
    	if(bigger < k)
    		return k;
    	return bigger;
    }

	public int longestCommonSubstring(String A, String B) {
		if (null == A || null == B)
			return 0;
		if (A.equals("") || B.equals(""))
			return 0;
		char[] A_arr = A.toCharArray();
		char[] B_arr = B.toCharArray();
		int longestlen = 0;
		for (int i = 0; i < A_arr.length; i++) {
			int curr_longestlen = 0;
			int k = i;
			for (int j = 0; j < B_arr.length && k < A_arr.length; j++) {
				if (A_arr[k] == B_arr[j]) {
					k++;
					curr_longestlen++;
				} else {
					if (curr_longestlen != 0) {
						k = i;
						j--;
						if (curr_longestlen > longestlen)
							longestlen = curr_longestlen;
						curr_longestlen = 0;
					}
				}
			}
			if (curr_longestlen > longestlen)
				longestlen = curr_longestlen;
		}
		return longestlen;
	}

	public String longestCommonPrefix(String[] strs) {
		if (null == strs || strs.length == 0)
			return "";
		int min = strs[0].length();
		int max = strs[0].length();
		for (String item : strs) {
			if (item.length() < min) {
				min = item.length();
			} else {
				max = item.length();
			}
		}
		if (min == 0 || max == 0)
			return "";
		int max_index = 0;
		outloop: for (int i = 0; i < min; i++, max_index++) {
			char flag = strs[0].charAt(i);
			for (int j = 0; j < strs.length; j++) {
				if (flag != strs[j].charAt(i))
					break outloop;
			}
		}
		if (max_index == 0)
			return "";
		else
			return strs[0].substring(0, max_index);
	}

	public void validateFileConstruct() {
		File temp = new File("temp.log");
		File persons = new File("persons.txt");
		if (persons.exists())
			persons.delete();
		System.out.println(temp.exists());
	}

	public void simpleDateFormat() throws Exception {
		Date datebefore = new Date(1402335947400L);
		Date dateafter = new Date(1402335947900L);
		Date datemiddle = new Date(1402335947800L);
		System.out.println(datemiddle.after(datebefore));
		System.out.println(dateafter.after(datemiddle));
	}

	public void daysbeforecurrentdate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		System.out.println("Date = " + cal.getTime());
	}

	public void printstringtofile() {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File(
					"textfile/persons.txt"), true /* append = true */));
			pw.append("it works!");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void useByteArrayOutputStream() throws IOException {

		byte[] bs = { 65, 66, 67, 68, 69 };
		ByteArrayOutputStream baos = null;

		try {

			// create new ByteArrayOutputStream
			baos = new ByteArrayOutputStream();

			// write byte array to the output stream
			baos.write(bs);

			// for each byte in the buffer
			for (byte b : baos.toByteArray()) {
				// write byte in to output stream
				baos.write(b);

				// print every byte
				System.out.println(b);
			}
		} catch (Exception e) {

			// if I/O error occurs
			e.printStackTrace();
		} finally {
			System.out.print(baos.toString());
			if (baos != null)
				baos.close();
		}
	}

	public int lengthOfLastWord(String s) {
		if (s.length() == 0 || s == null)
			return 0;
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				if (s.charAt(i) >= 'a' && s.charAt(i) >= 'z'
						|| s.charAt(i) >= 'A' && s.charAt(i) >= 'Z')
					count++;
			} else
				return count;
		}
		return count;
	}

	public ArrayList<Integer> binarySearch(ArrayList<Integer> A, int target) {
		ArrayList<Integer> rs = new ArrayList<Integer>();
		if (null == A || A.size() == 0) {
			rs.add(-1);
			rs.add(-1);
			return rs;
		}
		int min = 0;
		int max = A.size() - 1;
		int target_index = -1;
		int last = -1;
		int first = -1;
		while (min <= max) {
			int mid = (max - min) / 2 + min;
			if (target == A.get(mid)) {
				target_index = mid;
				break;
			} else if (target > A.get(mid)) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		if (-1 == target_index) {
			rs.add(-1);
			rs.add(-1);
			return rs;
		} else {
			int index = target_index;
			while (index >= 0 && A.get(index) == A.get(target_index))
				index--;
			first = index + 1;
			index = target_index;
			while (index < A.size() && A.get(index) == A.get(target_index))
				index++;
			last = index - 1;
			rs.add(first);
			rs.add(last);
			return rs;
		}
	}

	public int searchInsert(int[] A, int target) {
		if(null == A || A.length == 0)
			return 0;
		int min = 0;
		int max = A.length - 1;
		while(min < max){
			int mid = (max -min)/2 + min;
			if(A[mid] == target)
				return mid;
			else if(A[mid] > target)
				max = mid - 1;
			else
				min = mid + 1;
		}
		if(min == max){
			if(A[min] == target){
				return min + 1;
			}else if(A[min] > target)
				return min;
			else
				return min + 1;
		}else{
			return min;
		}
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(null == matrix || matrix.length == 0)
			return false;
		int start = 0;
		int end = matrix.length - 1;
		while(start < end){
			int mid = (end - start)/2 + start;
			if(matrix[mid][0] == target)
				return true;
			else if(matrix[mid][0] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		int col;
		if(start == end){
			if(matrix[start][0] == target)
				return true;
			else if(matrix[start][0] > target){
				col = start - 1;
			}else
				col = start;
		}else{
			col = start -1;
		}
		if(col < 0)
			return false;
		start = 0;
		end = matrix[col].length - 1;
		System.out.println("start " + start + " end " + end);
		while(start < end){
			int mid = (end - start)/2 + start;
			if(matrix[col][mid] == target)
				return true;
			else if(matrix[col][mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		System.out.println("start " + start + " end " + end);
		if(start == end){
			if(matrix[col][start] == target)
				return true;
		}
		return false;
	}
	
	public int searchMatrix2(int[][] matrix, int target) {
		if(null == matrix || matrix.length == 0)
			return 0;
		int nums = 0;
		int j = 0;
		int i = matrix.length - 1;
		while(i>=0 && j<matrix[0].length){
			int start = 0;
			int end = i;
			while(start < end){
				int mid = (end -start)/2 + start;
				if(matrix[mid][j] == target){
					nums++;
					break;
				}else if(matrix[mid][j] > target)
					end = mid -1;
				else
					start = mid + 1;
			}
			if(start < end){
				i = (end -start)/2 + start -1;
				j++;
			}else if(start == end){
				if(matrix[start][j] == target){
					nums++;
					j++;
					i = start - 1;
				}else if(matrix[start][j] > target){
					i = start -1;
				}else{
					j++;
				}
			}else{
				i = start - 1;
			}
		}
		return nums;
	}
	
	public int findPeak(int[] A) {
		if(A.length < 3)
			return -1;
		for(int i = 1; i <= A.length -1;){
			if(A[i] > A[i-1] && A[i] > A[i+1])
				return i;
			if(A[i] > A[i + 1])
				i += 2;
			else
				i++;
		}
		return -1;
	}
	
	public int search(int[] A, int target) {
		if(A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		while(start <= end){
			int mid = (start + end)/2;
			if(A[mid] == target)
				return mid;
			else if(A[start] > A[mid]){
				if(A[start] < target && target < A[mid])
					end = mid - 1;
				else
					start = mid + 1;
			}else{
				if(A[mid] < target && target < A[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}
	
	public int removeDuplicates(int[] nums) {
		if(nums.length == 0)
			return 0;
		int flag = 0;
		for(int i = 0;i < nums.length; i++){
			if(nums[flag] != nums[i]){
				flag++;
				nums[flag] = nums[i];
			}
		}
		return flag+1;
	}
	
	public int removeDuplicates2(int[] nums) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1)
			return 1;
		int flag = 0;
		int k =1;
		for(int i = 1;i < nums.length; i++){
			if(nums[flag] != nums[i]){
				flag++;
				nums[flag] = nums[i];
				k = 1;
			}else{
				if(k < 2){
					flag++;
					nums[flag] = nums[i];
					k++;
				}
			}
		}
		return flag + 1;
	}
	
	public int longestConsecutive(int[] num) {
		if(num.length == 0)
			return 0;
		Map<Integer, Integer> items = new HashMap<Integer, Integer>();
		for(int i : num)
			items.put(i, 0);
		int longesth = 0;
		for(int i : num){
			if(items.get(i) == 1)
				continue;
			items.put(i, 1);
			int current_len = 1;
			int k = i;
			while(items.containsKey(k + 1)){
				items.put(k+1, 1);
				k++;
				current_len++;
			}
			k = i;
			while(items.containsKey(k - 1)){
				items.put(k-1, 1);
				k--;
				current_len++;
			}
			if(longesth < current_len)
				longesth = current_len;
		}
		return longesth;
	}
	
	public int longestCommonSubsequence(String A, String B) {
		return 0;
	}
	
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
    	if(A == null || A.size() == 0)
            return null;
    	Long result = 1L;
    	ArrayList<Long> list = new ArrayList<Long>();
    	int flag = 0;
    	for(int item : A){
    		if(item == 0)
    			flag++;
    		else
    			result = result * item;
    		if(flag == 2)
    			break;
    	}
    	if(flag == 2){
    		for(int i =0; i< A.size(); i++)
    			list.add(0L);
    	}else{
    		for(int i =0; i< A.size(); i++){
    			if(A.get(i) == 0)
    				list.add(result);
    			else
    				list.add(result/A.get(i));
    		}
    	}
    	return list;
    }
    
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
      
      public class TreeNode {
  		public int val;
  		public TreeNode left, right;

  		public TreeNode(int val) {
  			this.val = val;
  			this.left = this.right = null;
  		}
  	}
}
