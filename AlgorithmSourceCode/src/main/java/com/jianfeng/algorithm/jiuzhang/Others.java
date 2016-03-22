package com.jianfeng.algorithm.jiuzhang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Others {
	public static void main(String[] args) {
		Others os = new Others();
//		os.testfindMissing();
//		os.testfindTopK();
//		os.testCollections();
//		os.testListIterator();
//		os.testKthPrime();
//		os.testPermuteUnique();
//		os.testMajorityNumber();
//		os.test();
//		os.testRangeModule();
//		os.testLinkedList();
//		os.testmaxSlidingWindow();
//		os.testcountOfSmallerNumber();
//		os.testFactorialRecursive();
		os.testbubblesort();
	}
	
	public void testbubblesort(){
		int[] arr = new int[]{7,6,10,2,3,42,8,2,1,6};
		printArray(arr);
		bubblesort(arr);
		printArray(arr);
	}
	
	public void  printArray(int[] arr){
		for(int item : arr){
			System.out.print(item + " ");
		}
		System.out.println();
	}
	
	public void bubblesort(int[] arr){
		if(arr == null || arr.length < 2)
			return;
		int n = arr.length - 1;
		for(int i = n; i > 0; i--){
			for(int j = 0; j < i; j++){
				int k = j+1;
				if(arr[k] < arr[j]){
					swap(arr, j, k);
				}
			}
		}
	}
	
	public void testFactorialRecursive(){
		System.out.println(FactorialRecursive(14));
		System.out.println(FactorialIterative(14));
	}
	
	public int FactorialRecursive(int n){
		if(n == 1 || n == 0)
			return n;
		return FactorialRecursive(n-1) + FactorialRecursive(n-2);
	}
	
	public int FactorialIterative(int n){
		if(n == 1 || n == 0)
			return n;
		int p1 = 0, p2 = 1;
		while(n > 1){
			int tmp = p2;
			p2 += p1;
			p1 = tmp;
			n--;
		}
		return p2;
	}
	
	public void testcountOfSmallerNumber(){
		for(int num : countOfSmallerNumber(new int[]{55,81,56,91,35,92,10,53,
				27,94,64,45,19,44,52,19,79,12,16,90,97,33,73,2,20,68,
				19,7,17,62,45,48,62,26,85,4,63,67,56,16}, new int[]{75})){
			System.out.print(" " + num);
		}
	}
	
    public class TreeNode{
        int start, end,count;
        TreeNode left, right;
        public TreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    } 
    
    public TreeNode buildTree(int[] A){
        if(A == null || A.length == 0)
            return null;
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int min = A[0];
        int max = A[0];
        for(int num : A){
            if(counter.containsKey(num)){
                counter.put(num, counter.get(num) + 1);
            }else{
                counter.put(num, 1);
            }
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return buildTree(counter, min, max);
    }
    
    public TreeNode buildTree(HashMap<Integer, Integer> counter, int start, int end){
        TreeNode root = new TreeNode(start, end);
        if(start == end){
            if(counter.containsKey(start)){
                root.count = counter.get(start);
            }
        }else{
            int mid = start + ((end - start) >> 1);
            root.left = buildTree(counter, start, mid);
            root.right = buildTree(counter, mid + 1, end);
            root.count = root.left.count + root.right.count;
        }
        return root;
    }
    
    public int query(TreeNode root, int num){
        if(root == null || num <= root.start)
            return 0;
        if(num > root.end)
            return root.count;
        int mid = root.start + ((root.end - root.start) >> 1);
        if(num <= mid){
            return query(root.left, num);
        }else{
            return root.left.count + 
                        query(root.right, num);
        }
    }
    
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if(queries == null || queries.length == 0)
            return rst;
        TreeNode root = buildTree(A);
        for(int num : queries){
            rst.add(query(root, num));
        }
        return rst;
    }
	
	public void testmaxSlidingWindow(){
		for(int num : maxSlidingWindow(new int[]{7,6,5,4,3,2,1}, 3)){
			System.out.print(" " + num);
		}
	}
	
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
    	ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int i = 0;

        
        for(int now : nums) {
            i++;
            
    		while((!deque.isEmpty() && now > deque.peekLast())) {
    			deque.pollLast();
    		} 
    		deque.offer(now);
    		if(i > k  && deque.peekFirst() == nums[i - k - 1])
    		         deque.pollFirst();
    		if(i >= k) {
    			ans.add(deque.peekFirst());
    		}
            
        }
        return ans;
    }
	
	public void testLinkedList(){
		LinkedList<String> list = new LinkedList<String>();
		list.push("a");
		list.push("b");
		System.out.println(list.pop());
	}
	
	public CharTreeNode convertTernaryExpressiontoBT(char[] values){
		if(values == null || values.length < 5)
			return null;
		CharTreeNode root = new CharTreeNode(values[0]);
		Stack<CharTreeNode> stack = new Stack<CharTreeNode>();
		CharTreeNode p = root;
		for(int i = 1; i < values.length; i++){
			if(values[i] == '?'){
				p.left = new CharTreeNode(values[i+1]);
				stack.add(p);
				p = p.left;
			}else if(values[i] == ':'){
				p = stack.pop();
				while(!stack.empty() && p.right != null){
					p = stack.pop();
				}
				p.right = new CharTreeNode(values[i+1]);
				stack.add(p);
				p = p.right;
			}else{
				throw new RuntimeException("Invalid ternary expression!");
			}
		}
		return root;
	}
	
	public void testRangeModule(){
		RangeModule re = new RangeModule();
		re.AddRange(10, 100);
		re.DeleteRange(25, 44);
		System.out.println(re.QueryRange(50, 60));
	}
	
	class RangeModule
	{
	    private ArrayList<Interval> intervals;
	    
	    public RangeModule(){
	        intervals = new ArrayList<Interval>();
	    }
	    
	    public void AddRange(int lower, int upper)
	    {
	        if(lower > upper)
	            return;
	        Interval newInterval = new Interval(lower, upper);
	        if(intervals.size() == 0){
	            intervals.add(newInterval);
	            return;
	        }
	        
	        ArrayList<Interval> result = new ArrayList<Interval>();
	        int insertPos = 0;
	        for(Interval interval : intervals){
	            if(interval.end < newInterval.start){
	                result.add(interval);
	                insertPos++;
	            }else if(interval.start > newInterval.end){
	                result.add(interval);
	            }else{
	                newInterval.start = Math.min(interval.start, newInterval.start);
	                newInterval.end = Math.max(interval.end, newInterval.end);
	            }
	        }
	        result.add(insertPos, newInterval);
	        intervals = result;
	    }

	    public boolean QueryRange(int lower, int upper)
	    {
	        if(intervals.size() == 0 || lower > upper)
	            return false;
	        for(Interval interval : intervals){
	            if(interval.end < lower){
	                continue;
	            }else if(interval.start <= lower && interval.end >= upper){
	                return true;
	            }
	        }
	        return false;
	    }

	    public void DeleteRange(int lower, int upper)
	    {
	        if(intervals.size() == 0 || lower > upper)
	            return;
	        ArrayList<Interval> result = new ArrayList<Interval>();
	        for(Interval interval : intervals){
	            if(interval.end < lower || interval.start > upper){
	                result.add(interval);
	            }else{
	                int curr_end = interval.end;
	                if(interval.start < lower){
	                    interval.end = lower -1;
	                    result.add(interval); 
	                }
	                if(curr_end > upper){
	                    Interval newItem = new Interval(upper+1, curr_end);
	                    result.add(newItem);
	                }
	            }
	        }
	        intervals = result;
	    }

	    public class Interval{
	        int start, end;
	        Interval(int start, int end){
	            this.start = start;
	            this.end = end;
	        }
	    }
	};
	
	public void test(){
		System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
	}
	
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if(word == null || word.length() == 0)
            return true;
        if(board == null || m*n < word.length())
            return false;
        int[][] visited = new int[m][n];
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                if(search(board, word, visited, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, String word, int[][] visited, int i, int j, int index){
        if(i < 0 || i > board.length -1 || 
        		j < 0 || j > board[0].length - 1 || 
        		board[i][j] != word.charAt(index) || 
        		visited[i][j] == 1)
            return false;
        if(index == word.length() -1)
            return true;
        board[i][j] = '#';
        boolean result = search(board, word, visited, i-1, j, index + 1) || 
                        search(board, word, visited, i+1, j, index + 1) || 
                        search(board, word, visited, i, j-1, index + 1) || 
                        search(board, word, visited, i, j+1, index + 1);
        board[i][j] = word.charAt(index);
        return result;
    }
	
	public void testMajorityNumber(){
		System.out.println(majorityNumber(Arrays.asList(1,1,1,1,2,2,3,3,4,4,4)));
	}
	
	public int majorityNumber(List<Integer> nums) {
	    int candidate1 =0, candidate2 =0;
	    int count1 = 0, count2 = 0;
	    for(int num : nums){
	        if(num == candidate1){
	            count1++;
	        }else if(num == candidate2){
	            count2++;
	        }else if(count1 == 0){
	            candidate1 = num;
	            count1 = 1;
	        }else if(count2 == 0){
	            candidate2 = num;
	            count2 = 1;
	        }else{
	            count1--;
	            count2--;
	        }
	    }
	    count1 = count2 = 0;
	    for(int num : nums){
	        if(num == candidate1){
	            count1++;
	        }else if(num == candidate2){
	            count2++;
	        }
	    }
	    
	    return count1 > count2 ? candidate1 : candidate2;
	}
	
	public void testPermuteUnique(){
//		for(ArrayList<Integer> list : permuteUnique(new int[]{3,3,0,3})){
//			for(int item : list){
//				System.out.print(" " + item);
//			}
//			System.out.println();
//		}
//		
		for(ArrayList<Integer> list : permuteUnique(new ArrayList<Integer>(Arrays.asList(3,3,0,3)))){
			for(int item : list){
				System.out.print(" " + item);
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0)
            return rst;
        ArrayList<Integer> list = new ArrayList<Integer>();	
        int[] visited = new int[nums.size()];
        Collections.sort(list);
        permute(rst, list, nums, visited);
        return rst;
    }
    
    public void permute(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, ArrayList<Integer> nums, int[] visited){
        if(list.size() == nums.size()){
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i =0; i < nums.size(); i++){
            if(visited[i] == 1 || (i!=0 && nums.get(i) == nums.get(i-1) && visited[i-1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(nums.get(i));
            permute(rst, list, nums, visited);
            list.remove(list.size() -1);
            visited[i] = 0;
        }
    }
	
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        
        Arrays.sort(num);
        helper(result, list, visited, num);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] visited, int[] num) {
        if(list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(num[i]);
            helper(result, list, visited, num);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }    
	
	public void permuteString(String s){
		permuteString("", s);
	}
	
	public void permuteString(String beginningString, String endingString) {
			if(endingString.length() <= 1){
				System.out.println(beginningString + endingString);
				return;
			}
			for(int i =0; i < endingString.length(); i++){
				String newString = endingString.substring(0, i) + endingString.substring(i + 1, endingString.length());
				permuteString(beginningString + endingString.charAt(i), newString);
			}
	}
	
	public void testKthPrime(){
		for(int i = 1; i <= 11; i++){
			System.out.println(kthPrimeNumber(i));
		}
	}
	
	public long kthPrimeNumber(int k) {
	    if(k <=0){
	        return -1;
	    }
	    long[] cache = new long[k+1];
	    cache[0] = 1;
	    int p3 = 0, p5 = 0, p7 = 0;
	    for(int m =1; m <=k ; m++){
	        long small = Math.min(Math.min(cache[p3] * 3, cache[p5] * 5), cache[p7] * 7);
	        cache[m] = small;
	        if (small / cache[p3] == 3) p3++;
	        if (small / cache[p5] == 5) p5++;
	        if (small / cache[p7] == 7) p7++;
	    }
	    return cache[k];
	}
	
	public class StringAddress{
		private String address;
		
		public StringAddress(String address){
			this.address = address;
		}
		
		public String toString(){
			return super.toString() + " " + address;
		}
		
		public void setAddress(String address){
			this.address = address;
		}
	}
	
	public void testBlockingQueue(){
		BlockingQueue be = new LinkedBlockingQueue();
	}
	
	public void testListIterator(){
		List<Integer> list = new LinkedList<Integer>(Arrays.asList(1,2,6,5,4,6,7,8,8,4,2,3,2,2,2,2,2,1,1,1,1));
		ListIterator<Integer> ltr = list.listIterator(7);
		while(ltr.hasNext()){
			System.out.println(ltr.next());
		}
	}
	
	public void testCollections(){
		List<StringAddress> list = new LinkedList<StringAddress>(Collections.nCopies(4, new StringAddress("Hello")));
		System.out.println(list);
		Collections.fill(list, new StringAddress("World"));
		System.out.println(list);
		StringAddress sa = list.get(0);
		sa.setAddress("HAHA!");
		System.out.println(list);
	}

	public void testfindMissing() {
		System.out.println(findMissing(new int[] {}));
		System.out.println(findMissing(new int[] { 0 }));
		System.out.println(findMissing(new int[] { 3, 2, 1, 4 }));
		System.out.println(findMissing(new int[] { 3, 2, 1, 0 }));
	}
	
	public void testfindTopK(){
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,6,5,4,6,7,8,8,4,2,3,2,2,2,2,2,1,1,1,1));
		for(int num : findTopK(list, 3)){
			System.out.print(" " + num);
		}
		System.out.println();
		for(int num : findTopK(list, 2)){
			System.out.print(" " + num);
		}
	}
	
	public <T> List<T> findTopK(List<T> inputData, int k) {
		List<T> result = new ArrayList<T>();
		Map<T, Integer> map = getFrequency(inputData);
		PriorityQueue<Map.Entry<T, Integer>> queue = new PriorityQueue<Map.Entry<T, Integer>>(k, new Comparator<Map.Entry<T, Integer>>(){
			public int compare(Map.Entry<T, Integer> e1, Map.Entry<T, Integer> e2){
				return e1.getValue() - e2.getValue();
			}
		});
		for(Map.Entry<T, Integer> entry : map.entrySet()){
			if(queue.size() >= k){
				if(entry.getValue() > queue.peek().getValue()){
					queue.poll();
					queue.offer(entry);
				}
			}else{
				queue.offer(entry);
			}
		}
		while(!queue.isEmpty()){
			result.add(queue.poll().getKey());
		}
		return result;
	}
	
	private <T> Map<T, Integer> getFrequency(List<T> inputData){
		Map<T, Integer> map = new HashMap<T, Integer>();
		for(T t : inputData){
			if(map.containsKey(t)){
				map.put(t, map.get(t) + 1);
			}else{
				map.put(t, 1);
			}
		}
		return map;
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
	
	public class CharTreeNode {
		public char val;
		public CharTreeNode left, right;

		public CharTreeNode(char val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

}
