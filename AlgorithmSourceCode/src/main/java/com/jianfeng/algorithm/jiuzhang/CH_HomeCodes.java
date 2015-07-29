package com.jianfeng.algorithm.jiuzhang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * Hello world!
 **/

public class CH_HomeCodes {
	public static void main(String[] args) {
		CH_HomeCodes testcases = new CH_HomeCodes();
		// testcases.testMaxTree();
		// testcases.testBinaryOperator();
		// testcases.testSingleNumber();
		// testcases.testSingleNumberII();
		// testcases.testpartitionArray();
		// testcases.swap(-1, 45);
		// System.out.println(testcases.computerAverage(4, 7));
		// testcases.testSqrt();
		// testcases.testbitSapRequired();
		// testcases.testRehashing();
		// testcases.testupdateBits();
		// testcases.javaBitShift();
		// testcases.testbinaryRepresentation();
		// testcases.testcanJump();
		// testcases.testnextPermutation();
		// testcases.testsortedListToBST();
		// testcases.testConstructBST();
		// testcases.testCombination();
		// testcases.testCombinationsSum();
		// testcases.testcombinationSumIII();
		// testcases.testpermute();
		// testcases.testCloneGraph();
		// testcases.testmaxProduct();
		// testcases.testbackPack();
		// testcases.testMinAdjustmentCost();
		// testcases.testmaxProductII();
		// testcases.testlongestIncreasingSubsequence();
		// testcases.testcompareStrings();
		// testcases.teststrStr();
		// testcases.testanagrams();
		// testcases.testlongestCommonSubstring();
		// testcases.testDeleteDigits();//
//		testcases.removeDuplicates();
//		testcases.testcopyRandomNodes();
//		testcases.testSerialize();
//		testcases.testPartition();
//		testcases.testreplaceBlank();
//		testcases.testdeleteNode();
//		testcases.testverifySequenceOfBST();
//		testcases.testfindPath();
//		testcases.testquickSort();
//		testcases.testpriorityqueue();
//		testcases.testprintKthSmallNumbers();
//		testcases.testgetNumbersOfK();
//		testcases.testprintNNumbers();
//		CH_LinkedList[] ct = new CH_LinkedList[90];
//		System.out.println();
		testcases.testatoi();
		System.out.println(Integer.valueOf("52lintcode"));
	}
	
	public void testatoi(){
//		System.out.println(atoi(""));
//		System.out.println(atoi("-3re5"));
//		System.out.println(atoi("3er"));
//		System.out.println(atoi("345"));
		System.out.println(atoi("-3.24"));
	}
	
	/**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
    	if(str == null || str.length() == 0)
    		return 0;
    	
    	int start = str.length() -1;
    	int end = 0;
    	if(str.charAt(0) == '-')
    		end++;
    	int point_count = -1;
    	for(int i= str.length() -1; i>=end; i--){
    		if(str.charAt(i) == '.'){
    			if(point_count == -1)
    				point_count = i;
    			else
    				return 0;
    		}else if(str.charAt(i) < '0' || str.charAt(i) > '9'){
    			return 0;
    		}
    	}
    	if(point_count == 0 || point_count == str.length() -1)
    		return 0;
    	if(point_count != -1)
    		start = --point_count;
    	long sum = 0;
    	if(start - end + 1 > 10)
    		return 0;
    	int base = 1;
    	while(start >= end){
    		sum += (str.charAt(start) - '0') * base;
    		base *= 10;
    		start--;
    	}
    	if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
    		return 0;
    	if(str.charAt(0) == '-')
    		return 0 - (int)sum;
    	return (int)sum;
    }
    
    
	public int getNPermutation(int n){
		int product = 1;
		for(int i=1; i <= n; i++){
			product *= 6;
		}
		return product;
	}
	
	public void testprintNNumbers(){
		printNNumbers(5);
	}
	
	private static int sum = 0;
	
	private static int n = 1;
	
	public int getSum(){
		return sum;
	}
	
	public CH_HomeCodes(){sum += n;n++;}
	public void printNNumbers(int n){
		if(n <=0)
			return;
		int count = (int) Math.pow(6, n);
		int allcount = 0;
		for(int i=n; i <= 6*n; i++){
			this.count = 0;
			getCountOfNumbers(n, i);
			allcount += this.count;
			System.out.println("Sum : " + i + " 概率 : " + String.valueOf((this.count*1.0)/count));
		}
		System.out.println("count : " + count);
		System.out.println("totalAcount : " + allcount);
	}
	
	private int count = 0;
	public void getCountOfNumbers(int n, int k){
		if(n == 1){
			if(k <=6)
				count++;
			return;
		}
		for(int i=1; i<= k-n+1 && i <= 6;i++){
			getCountOfNumbers(n-1, k-i);
		}
	}
	
	public void testgetNumbersOfK(){
		System.out.println(getNumbersOfK(new int[]{1,1,2,2,2,2,2,3}, 2));
		System.out.println(getNumbersOfK(new int[]{1,1,2,2,2,2,2,3}, 1));
		System.out.println(getNumbersOfK(new int[]{1,1,2,2,2,2,2,3}, 3));
		System.out.println(getNumbersOfK(new int[]{3}, 3));
		System.out.println(getNumbersOfK(new int[]{3,3}, 3));
	}
	
	public int getNumbersOfK(int[] nums, int k){
		if(nums == null || nums.length == 0)
			return 0;
		int first = getFirstKRecursively(nums, 0, nums.length -1, k);
		if(first == -1)
			return -1;
		int last = getLastKRecursively(nums, 0, nums.length -1, k);
		return last - first + 1;
	}
	
	public int getFirstK(int[] nums, int k){
		int start = 0;
		int end = nums.length -1;
		while(start + 1 < end){
			int middle = start + (end - start)/2;
			if(nums[middle] == k){
				if(middle == 0 || nums[middle -1] != k)
					return middle;
				else
					end = middle;
			}else if(nums[middle] > k){
				end = middle;
			}else{
				start = middle;
			}
		}
		if(nums[start] == k){
			return start;
		}
		
		if(nums[end] == k){
			return end;
		}
		return -1;
	}
	
	public int getFirstKRecursively(int[] nums, int start, int end, int k){
		if(start > end)
			return -1;
		int middle = start + (end - start)/2;
		if(nums[middle] == k){
			if(middle == 0 || nums[middle -1] != k)
				return middle;
			else
				end = middle -1;
		}else if(nums[middle] > k){
			end = middle - 1;
		}else{
			start = middle + 1;
		}
		return getFirstKRecursively(nums, start, end, k);
	}
	
	public int getLastKRecursively(int[] nums, int start, int end, int k){
		if(start > end)
			return -1;
		int middle = start + (end - start)/2;
		if(nums[middle] == k){
			if(middle == nums.length -1 || nums[middle + 1] != k)
				return middle;
			else
				start = middle + 1;
		}else if(nums[middle] > k){
			end = middle - 1;
		}else{
			start = middle + 1;
		}
		return getLastKRecursively(nums, start, end, k);
	}
	
	public int getLastK(int[] nums, int k){
		int start = 0;
		int end = nums.length -1;
		while(start + 1 < end){
			int middle = start + (end - start)/2;
			if(nums[middle] == k){
				if(middle == nums.length -1 || nums[middle + 1] != k)
					return middle;
				else
					start = middle;
			}else if(nums[middle] > k){
				end = middle;
			}else{
				start = middle;
			}
		}
		if(nums[end] == k){
			return end;
		}
		if(nums[start] == k){
			return start;
		}
		return -1;
	}
	
	public void testprintKthSmallNumbers(){
		printKthSmallNumbers(new int[]{2,6,21,3,9,10,5,26}, 4);
	}
	
	public void printKthSmallNumbers(int[] numbers, int k){
		if(numbers == null || numbers.length == 0 || k<=0 || k>numbers.length)
			return;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){

			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
		int i = 0;
		for(;i<k;i++){
			queue.offer(numbers[i]);
		}
		for(;i<numbers.length;i++){
			if(numbers[i] < queue.peek()){
				queue.poll();
				queue.offer(numbers[i]);
			}
		}
		Iterator<Integer> iterator = queue.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
	}
	
	public void testpriorityqueue(){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(1, new Comparator<Integer>(){

			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
		queue.add(3);
		queue.add(7);
		queue.add(1);
		queue.add(8);
		System.out.println(queue.size());
	}
	
	public void testfindPath(){
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(12);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(7);
		a.right = c;
		b.left = d;
		b.right = e;
		a.left = b;
		for(List<Integer> item : findPath(a, 22)){
			for(int tmp : item){
				System.out.print(" " + tmp);
			}
			System.out.println();
		}
	}
	
	public void testquickSort(){
		int[] arr = new int[]{4,8,1,3,9};
		quickSort(arr);
		for(int item : arr)
			System.out.print(" " + item);
	}
	
	public void quickSort(int[] numbers){
		if(numbers == null || numbers.length == 0)
			return;
		quickSort(numbers, 0, numbers.length-1);
	}
	
	public void quickSort(int[] numbers, int left, int right){
		if(left >= right)
			return;
		int partition = partition(numbers, left, right);
		quickSort(numbers, left, partition -1);
		quickSort(numbers, partition + 1, right);
	}
	
	public int partition(int[] numbers, int start, int end){
		int pivot = numbers[end];
//		int leftCursor = start - 1;
//		int rightCursor = end;
//		while(leftCursor < rightCursor){
//			while(numbers[++leftCursor] < pivot);
//			while(rightCursor > 0 && numbers[--rightCursor] > pivot);
//			if(leftCursor >= rightCursor)
//				break;
//			else{
//				swap(numbers, leftCursor, rightCursor);
//			}
//		}
//		swap(numbers, leftCursor, end);
//		return leftCursor;
		int small = start -1;
		int leftCursor = start;
		for(;leftCursor < end;leftCursor++){
			if(numbers[leftCursor] < pivot){
				++small;
				swap(numbers, small, leftCursor);
			}
		}
		++small;
		swap(numbers, small, end);
		return small;
	}
	
	public void swap(int[] numbers, int left, int right){
		int tmp = numbers[left];
		numbers[left] = numbers[right];
		numbers[right] = tmp;
	}
	
	public void testverifySequenceOfBST(){
		System.out.println(verifySequenceOfBST(new int[]{5,7,6,9,11,10,8}));
		System.out.println(verifySequenceOfBST(new int[]{7,4,6,5}));
		System.out.println(verifySequenceOfBST(new int[]{5}));
		System.out.println(verifySequenceOfBST(new int[]{6,5}));
		System.out.println(verifySequenceOfBST(new int[]{4,5}));
	}
	
	public List<List<Integer>> findPath(TreeNode root, int expectedSum){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		findPath(root, result, path, expectedSum);
		return result;
	}
	
	public void findPath(TreeNode root, List<List<Integer>> result, List<Integer> path, int expectedSum){
		if(root == null)
			return;
		path.add(root.val);
		boolean isLeaf = root.left == null && root.right == null;
		expectedSum -= root.val;
		if(expectedSum == 0 && isLeaf){
			result.add(new ArrayList<Integer>(path));
		}
		if(expectedSum > 0){
			findPath(root.left, result, path, expectedSum);
			findPath(root.right, result, path, expectedSum);
		}
		path.remove(path.size()-1);
		expectedSum += root.val;
	}
	
	public boolean verifySequenceOfBST(int[] numbers){
		if(numbers == null || numbers.length == 0)
			return false;
		return verifySequenceOfBST(numbers, 0, numbers.length - 1);
	}
	
	public boolean verifySequenceOfBST(int[] numbers, int start, int end){
		if(start == end)
			return true;
		int root = numbers[end];
		int i =start;
		for(; i < end; i++){
			if(numbers[i] > root)
				break;
		}
		int j=i;
		for(; j < end; j++){
			if(numbers[j] < root)
				return false;
		}
		boolean left_result = true;
		if(i != start){
			left_result = verifySequenceOfBST(numbers, start, i-1);
		}
		boolean right_result = true;
		if(i < end){
			right_result = verifySequenceOfBST(numbers, i, end -1);
		}
		return left_result && right_result;
	}
	
	public void testdeleteNode(){
		// -14->-13->-12->-12->-11->-11->-11->-11->-11->-10->-10
				ListNode b = new ListNode(1);
				ListNode c = new ListNode(2);
				ListNode d = new ListNode(3);
				ListNode e = new ListNode(4);
				d.next = e;
				c.next = d;
				b.next = c;
				deleteNode(b);
	}
	
	public void deleteNode(ListNode node) {
        if(node == null)
            return;
        ListNode fast = node.next;
        while(fast != null && fast.next != null){
            node = node.next;
            fast = fast.next.next;
        }
        node.next = node.next.next;
    }
	
	public void testreplaceBlank(){
		System.out.println(replaceBlank(new char[]{'h', 'e', 'l', 'l','o', ' ', ' ', 'w', 'o', 'r', 'l', 'd', 't','t','t','t'},12));
	}
	
	public int replaceBlank(char[] string, int length) {
        if(string == null || length == 0)
            return 0;
        int space_count = 0;
        for(char item : string){
            if(item == ' ')
                space_count++;
        }
        int new_length = length + 2*space_count;
        if(new_length == length)
            return length;
        int i = length -1,j=new_length -1;
        while(space_count > 0){
            if(string[i] != ' '){
                string[j--] = string[i--];
            }else{
                string[j] = '0';
                string[--j] = '2';
                string[--j] = '%';
                j--;
                i--;
                space_count--;
            }
        }
        return new_length;
    }
	
	public void testSerialize(){
//		TreeNode root = new TreeNode(1);
//		TreeNode left = new TreeNode(2);
//		TreeNode right = new TreeNode(3);
//		root.right = right;
//		root.left = left;
//		System.out.println(serialize(root));
//		System.out.println(serialize(deserialize("123##45")));
	}
	
	public void testPartition(){
		System.out.println(partition("ab"));
	}
	
	public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if(s == null || s.length() == 0)
            return rst;
        List<String> path = new ArrayList<String>();
        if(isPalindrome(s)){
            List<String> item = new ArrayList<String>();
            item.add(s);
            rst.add(item);
        }
        partition(rst, path, s);
        return rst;
    }
    
    public void partition(List<List<String>> rst, List<String> path, String s){
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s.substring(0, i+1))){
            	if(path.size() == 0)
            		path.add(s.substring(0, i+1));
            	else{
            		path.set(path.size() -1, path.get(path.size() -1) + s.substring(i, i+ 1));
            	}
                if(i+1 >= s.length())
                    rst.add(path);
                else
                	partition(rst, path, s.substring(i+1, s.length()));
                path.set(path.size() -1, path.get(path.size() -1).substring(0, path.get(path.size() -1).length() -1));
            }
        }
    }
    
    public boolean isPalindrome(String s){
        if(s == null)
            return true;
        int start = 0;
        int end = s.length() -1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
	
	public String serialize(TreeNode root) {
        if(root == null)
            return null;
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int current_count = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            int next_count = 0;
            while(current_count > 0){
                TreeNode head = queue.poll();
                sb.append(head.val);
                if(head.left != null || head.right != null){
                    if(head.left == null){
                        sb.append("#");
                    }else{
                        queue.offer(head.left);
                        next_count++;
                    }
                    if(head.right == null){
                        sb.append("#");
                    }else{
                        queue.offer(head.right);
                        next_count++;
                    }
                }
                current_count--;
            }
            current_count = next_count;
        }
        String result = sb.toString();
        int index = result.length()-1;
        for(; index >= 0;index--){
            if(result.charAt(index) != '#')
                break;
        }
        return result.substring(0, index + 1);
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if(data == null || data.equals(""))
            return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int current_count = 1;
        TreeNode root = new TreeNode(Integer.valueOf(data.substring(0, 1)));
        queue.offer(root);
        int index = 1;
        while(!queue.isEmpty() && index < data.length() -1){
            int next_count = 0;
            while(current_count > 0){
                TreeNode head = queue.poll();
                if(data.charAt(index) != '#'){
                    head.left = new TreeNode(Integer.valueOf(data.substring(index, index+1)));
                    queue.offer(head.left);
                    next_count++;
                }
                if(data.charAt(++index) != '#'){
                    head.right = new TreeNode(Integer.valueOf(data.substring(index, index+1)));
                    queue.offer(head.right);
                    next_count++;
                }
                index++;
                current_count--;
            }
            current_count = next_count;
        }
        return root;
    }

	public void testcopyRandomNodes() {
		RandomListNode node = new RandomListNode(-1);
		node.random = node;
		copyRandomList(node);
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode pointer = head;
		// copy next
		while (pointer != null) {
			RandomListNode tmp = pointer.next;
			RandomListNode item = new RandomListNode(pointer.label);
			pointer.next = item;
			item.next = tmp;
			pointer = pointer.next.next;
		}
		pointer = head;
		// copy random
		while (pointer != null) {
			if (pointer.random != null)
				pointer.next.random = pointer.random.next;
			pointer = pointer.next.next;
		}
		RandomListNode new_head = head.next;
		while (head != null) {
			RandomListNode tmp = head.next;
			head.next = tmp.next;
			head = tmp;
			if (tmp.next != null) {
				tmp.next = tmp.next.next;
			}

		}
		return new_head;
	}

	public class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public void removeDuplicates() {
		// -14->-13->-12->-12->-11->-11->-11->-11->-11->-10->-10
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(3);
		// ListNode f = new ListNode(-11);
		// ListNode g = new ListNode(-11);
		// ListNode h = new ListNode(-11);
		// ListNode i = new ListNode(-11);
		// ListNode j = new ListNode(-10);
		// ListNode k = new ListNode(-10);
		// j.next = k;
		// i.next = j;
		// h.next = i;
		// g.next = h;
		// f.next = g;
		// e.next = f;
		d.next = e;
		c.next = d;
		b.next = c;
		a.next = b;
		ListNode head = deleteDuplicates(a);
		System.out.println(head.val);
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode dumy = new ListNode(0);
		dumy.next = head;
		head = dumy;
		ListNode right = dumy.next.next;
		while (right != null) {
			if (head.next.val != right.val) {
				head = head.next;
			} else {
				while (right != null && right.next != null
						&& right.next.val == right.val) {
					right = right.next;
				}
				head.next = right.next;
			}
			if (right != null)
				right = right.next;
		}
		return dumy.next;
	}

	public void testDeleteDigits() {
		System.out.println(DeleteDigits("178542", 4));
	}

	public void reverseArrayList(ArrayList<Integer> nums, int start, int end) {
		while (start != end) {
			int tmp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, tmp);
			start++;
			end--;
		}
	}

	public void testlongestCommonSubstring() {
		System.out.println(longestCommonSubstring("ABCD", "CBCE"));
	}

	public int longestCommonSubstring(String A, String B) {
		if (A == null || B == null || A.length() == 0 || B.length() == 0)
			return 0;
		int max = 0;
		for (int i = 0; i < A.length(); i++) {
			int curr_max = 0;
			int k = i;
			for (int j = 0; j < B.length() && k < A.length();) {
				if (A.charAt(k) == B.charAt(j)) {
					curr_max++;
					k++;
					j++;
				} else {
					k = i;
					j = j - curr_max + 1;
					max = Math.max(curr_max, max);
					curr_max = 0;
				}
			}
		}
		return max;
	}

	public void testanagrams() {
		for (String item : anagrams(new String[] { "", "" })) {
			System.out.print(item + ",");
		}
	}

	public void teststrStr() {
		System.out.println(strStr("source", "target"));
		System.out.println(strStr("abcdabcdefg", "bcd"));
	}

	public void testcompareStrings() {
		System.out.println(compareStrings("ABCDEFG", "ACC"));
	}

	public void testlongestIncreasingSubsequence() {
		System.out.println(longestIncreasingSubsequence(new int[] { 88, 4, 24,
				82, 86, 1, 56, 74, 71, 9, 8, 18, 26, 53, 77, 87, 60, 27, 69,
				17, 76, 23, 67, 14, 98, 13, 10, 83, 20, 43, 39, 29, 92, 31, 0,
				30, 90, 70, 37, 59 }));
	}

	public void testmaxProductII() {
		System.out.println(maxProductII(new int[] { 2, -2, 3 }));
	}

	public void testMinAdjustmentCost() {
		ArrayList<Integer> td = new ArrayList<Integer>();
		td.add(1);
		td.add(4);
		td.add(2);
		td.add(3);
		System.out.println(MinAdjustmentCost(td, 1));
	}

	public void testbackPack() {
		System.out.println(backPack(10, new int[] { 2, 3, 8, 5 }));
	}

	public void testmaxProduct() {
		System.out.println(maxProduct(new int[] { -1, -99 }));
	}

	public void testCloneGraph() {
		UndirectedGraphNode f = new UndirectedGraphNode(0);
		UndirectedGraphNode s = new UndirectedGraphNode(0);
		UndirectedGraphNode t = new UndirectedGraphNode(0);
		f.neighbors.add(s);
		f.neighbors.add(t);
		s.neighbors.add(t);
		t.neighbors.add(t);
		UndirectedGraphNode rst = cloneGraph(f);
		System.out.println(rst.label);
	}

	public void testpermute() {
		ArrayList<Integer> td = new ArrayList<Integer>();
		td.add(5);
		td.add(4);
		td.add(3);
		td.add(2);
		td.add(1);
		printNestedListII(permute(td));
	}

	public void testcombinationSumIII() {
		printNestedList(combinationSumIII(new int[] { 2, 3, 6, 7 }, 7));
		printNestedList(combinationSumIII(new int[] { 10, 1, 6, 7, 2, 1, 5 }, 8));
	}

	public void testCombination() {
		for (List<Integer> curr : combine(4, 2)) {
			for (int item : curr) {
				System.out.print(item + ",");
			}
			System.out.println();
		}
	}

	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<String>();
		if (strs == null || strs.length < 2)
			return result;
		for (int i = 0; i < strs.length - 1;) {
			int j = i + 1;
			result.add(strs[i]);
			int count = j;
			for (; j < strs.length; j++) {
				if (anagram(strs[i], strs[j])) {
					result.add(strs[j]);
					String tmp = strs[count];
					strs[count] = strs[j];
					strs[j] = tmp;
					count++;
				}
			}
			if (count == i + 1) {
				result.remove(result.size() - 1);
				i++;
			} else {
				i = count;
			}
		}
		return result;
	}

	public boolean anagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (!t.contains(String.valueOf(s.charAt(i))))
				return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (!s.contains(String.valueOf(t.charAt(i))))
				return false;
		}
		return true;
	}

	/**
	 * Returns a index to the first occurrence of target in source, or -1 if
	 * target is not part of source.
	 * 
	 * @param source
	 *            string to be scanned.
	 * @param target
	 *            string containing the sequence of characters to match.
	 */
	public int strStr(String source, String target) {
		if (null == source || target == null
				|| source.length() < target.length())
			return -1;
		for (int i = 0; i < source.length(); i++) {
			if (source.length() - i < target.length())
				return -1;
			if (source.charAt(i) != target.charAt(0)) {
				continue;
			} else {
				int k = i + 1, j = 1;
				for (; k < source.length() && j < target.length(); j++, k++) {
					if (source.charAt(k) != target.charAt(j))
						break;
				}
				if (j >= target.length())
					return i;
			}
		}
		return -1;
	}

	public boolean compareStrings(String A, String B) {
		if (null == A || null == B || A.length() < B.length())
			return false;
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		for (int i = 0; i < A.length(); i++) {
			if (count.containsKey(A.charAt(i)))
				count.put(A.charAt(i), count.get(A.charAt(i)) + 1);
			else
				count.put(A.charAt(i), 1);
		}
		for (int i = 0; i < B.length(); i++) {
			if (count.containsKey(B.charAt(i))) {
				if (count.get(B.charAt(i)) <= 0)
					return false;
				else
					count.put(B.charAt(i), count.get(B.charAt(i)) - 1);
			} else
				return false;
		}
		return true;
	}

	private void printNestedList(List<List<Integer>> rst) {
		if (rst != null) {
			for (List<Integer> curr : rst) {
				for (int item : curr) {
					System.out.print(item + ",");
				}
				System.out.println();
			}
		}
	}

	private void printNestedListII(List<ArrayList<Integer>> rst) {
		if (rst != null) {
			for (List<Integer> curr : rst) {
				for (int item : curr) {
					System.out.print(item + ",");
				}
				System.out.println();
			}
		}
	}

	public void testConstructBST() {
		System.out.println(buildTree(new int[] { 1, 2, 3 },
				new int[] { 3, 2, 1 }));
	}

	public void testsortedListToBST() {
		ListNode s1 = new ListNode(4);
		ListNode s2 = new ListNode(21);
		ListNode s3 = new ListNode(25);
		ListNode s4 = new ListNode(25);
		ListNode s5 = new ListNode(31);
		s4.next = s5;
		s3.next = s4;
		s2.next = s3;
		s1.next = s2;
		TreeNode root = sortedListToBST(s1);
		System.out.println(root.val);
	}

	public void testnextPermutation() {
		for (int item : nextPermutation(new int[] { 1, 3, 4, 2 })) {
			System.out.print(item + " ");
		}
		System.out.println();
		for (int item : nextPermutation(new int[] { 2, 3, 4, 2 })) {
			System.out.print(item + " ");
		}
		System.out.println();
		for (int item : nextPermutation(new int[] { 4, 3, 2, 1 })) {
			System.out.print(item + " ");
		}
	}

	public void testcanJump() {
		System.out.println(canJump(new int[] { 0, 8, 2, 0, 9 }));
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
	}

	public int maxProductII(int[] nums) {
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];

		min[0] = max[0] = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			min[i] = max[i] = nums[i];
			if (nums[i] > 0) {
				max[i] = Math.max(max[i], max[i - 1] * nums[i]);
				min[i] = Math.min(min[i], min[i - 1] * nums[i]);
			} else if (nums[i] < 0) {
				max[i] = Math.max(max[i], min[i - 1] * nums[i]);
				min[i] = Math.min(min[i], max[i - 1] * nums[i]);
			}

			result = Math.max(result, max[i]);
		}

		return result;
	}

	/**
	 * @param nums
	 *            : The integer array
	 * @return: The length of LIS (longest increasing subsequence)
	 */
	public int longestIncreasingSubsequence(int[] nums) {
		if (null == nums || nums.length == 0)
			return 0;
		int[] max_arr = new int[nums.length];
		int o_max = 0;
		for (int i = 0; i < nums.length; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i]) {
					max = Math.max(max, max_arr[j] + 1);
				}
			}
			max_arr[i] = max;
			o_max = Math.max(max, o_max);
		}
		return o_max;
	}

	/**
	 * @param nums
	 *            : A list of integers
	 * @return: An integer indicate the value of maximum difference between two
	 *          Subarrays
	 */
	public int maxDiffSubArrays(ArrayList<Integer> nums) {
		return 0;
	}

	public int backPack(int m, int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int[][] capacity = new int[m + 1][A.length + 1];
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < A.length + 1; j++) {
				if (i >= A[j - 1])
					capacity[i][j] = Math.max(capacity[i][j - 1], capacity[i
							- A[j - 1]][j - 1]
							+ A[j - 1]);
				else
					capacity[i][j] = capacity[i - 1][j];
			}
		}
		return capacity[m][A.length];
	}

	/**
	 * @param A
	 *            : An integer array.
	 * @param target
	 *            : An integer.
	 */
	public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
		if (target <= 0 || A == null || A.size() == 0)
			return 0;
		int[] arr = new int[A.size()];
		int[] new_arry = new int[A.size()];
		new_arry[0] = A.get(0);
		for (int i = 1; i < A.size() - 1; i++) {
			if (Math.abs(new_arry[i - 1] - A.get(i)) > target) {
				int post_cost = Math.abs(A.get(i + 1) - A.get(i)) - target;
				int pre_cost = Math.abs(new_arry[i - 1] - A.get(i)) - target;
				int cost = Math.min(pre_cost, post_cost);
				if (A.get(i) >= A.get(i + 1)) {
					new_arry[i] = A.get(i) - cost;
				} else {
					new_arry[i] = cost + A.get(i + 1);
				}
				arr[i] = pre_cost + arr[i - 1];
			} else {
				new_arry[i] = A.get(i);
				arr[i] = arr[i - 1];
			}
		}
		return arr[A.size() - 2];
	}

	/**
	 * @param nums
	 *            : an array of integers
	 * @return: an integer
	 */
	public int maxProduct(int[] nums) {
		if (null == nums || nums.length == 0)
			return 0;
		int sum = 1, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				sum *= nums[i];
				max = Math.max(max, sum);
				sum = Math.max(sum, 1);
			} else {
				int j = i + 1, tmp = 1;
				while (j < nums.length && nums[j] != 0) {
					tmp *= nums[j];
					j++;
				}
				if (tmp > 0) {
					int k = nums.length - 1;
					if (j < nums.length)
						k = j - 1;
					while (k >= i + 1 && tmp > 0) {
						tmp /= nums[k];
						k--;
					}
				}
				sum = sum * nums[i] * tmp;
				max = Math.max(max, sum);
				sum = 1;
			}
		}
		return max;
	}

	private int isadjcentWord(String left, String right) {
		int number = 0;
		int index = -1;
		for (int i = 0; i < left.length(); i++) {
			if (left.charAt(i) != right.charAt(i)) {
				number++;
				index = i;
			}
		}
		if (number >= 2)
			return -1;
		else
			return index;
	}

	/**
	 * @param node
	 *            : A undirected graph node
	 * @return: A undirected graph node
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		HashMap<UndirectedGraphNode, UndirectedGraphNode> cache = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		createNode(cache, node);
		createNodeEdge(cache, node);
		return cache.get(node);
	}

	private void createNode(
			HashMap<UndirectedGraphNode, UndirectedGraphNode> cache,
			UndirectedGraphNode node) {
		if (!cache.containsKey(node)) {
			cache.put(node, new UndirectedGraphNode(node.label));
		} else {
			return;
		}
		for (UndirectedGraphNode neighbor : node.neighbors) {
			if (neighbor == node)
				break;
			createNode(cache, neighbor);
		}
	}

	private void createNodeEdge(
			HashMap<UndirectedGraphNode, UndirectedGraphNode> cache,
			UndirectedGraphNode node) {
		if (null != cache.get(node)) {
			UndirectedGraphNode parent = cache.get(node);
			for (UndirectedGraphNode neighbor : node.neighbors) {
				if (neighbor == node) {
					if (parent.neighbors.size() == 0)
						parent.neighbors.add(cache.get(neighbor));
					break;
				}
				parent.neighbors.add(cache.get(neighbor));
				createNodeEdge(cache, neighbor);
			}
			cache.put(node, null);
		}
	}

	/**
	 * Definition for undirected graph.
	 **/
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	/**
	 * @param nums
	 *            : A list of integers.
	 * @return: A list of permutations.
	 */
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0)
			return rst;
		Collections.sort(nums);
		while (true) {
			rst.add(new ArrayList<Integer>(nums));
			int i = nums.size() - 1;
			while (i > 0 && nums.get(i - 1) >= nums.get(i))
				i--;
			if (i == 0) {
				break;
			}
			int j = nums.size() - 1;
			while (j > i && nums.get(j) <= nums.get(i - 1))
				j--;
			int tmp = nums.get(i - 1);
			nums.set(i - 1, nums.get(j));
			nums.set(j, tmp);
			reverseList(nums, i, nums.size() - 1);
		}
		return rst;
	}

	private void reverseList(ArrayList<Integer> nums, int start, int end) {
		while (start < end) {
			int tmp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, tmp);
			start++;
			end--;
		}
	}

	/**
	 * @param candidates
	 *            : A list of integers
	 * @param target
	 *            :An integer
	 * @return: A list of lists of integers
	 */
	public List<List<Integer>> combinationSumII(int[] candidates, int target) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (candidates == null)
			return rst;
		List<Integer> path = new ArrayList<Integer>();
		Arrays.sort(candidates);
		helpers(candidates, rst, target, path, 0);
		return rst;
	}

	public List<List<Integer>> combinationSumIII(int[] candidates, int target) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (candidates == null)
			return rst;
		Arrays.sort(candidates);
		List<Integer> path = new ArrayList<Integer>();
		helpers(candidates, rst, target, path, 0);
		return rst;
	}

	private void helpers(int[] candidates, List<List<Integer>> rst, int target,
			List<Integer> path, int index) {
		if (target == 0) {
			rst.add(new ArrayList<Integer>(path));
			return;
		}
		int prev = -1;
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] > target)
				break;
			if (prev != -1 && prev == candidates[i])
				continue;
			path.add(candidates[i]);
			helpers(candidates, rst, target - candidates[i], path, i);
			// below will not contains duplicates.
			// helpers(candidates, rst, target - candidates[i], path, i+1);
			path.remove(path.size() - 1);
			prev = candidates[i];
		}
	}

	private void helps(HashMap<Integer, List<List<Integer>>> solutions,
			int[] candidates, int target) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (target == 1) {
			return;
		} else {
			helps(solutions, candidates, target - 1);
			int left = 1, right = target - 1;
			while (left <= right) {
				if (solutions.containsKey(left) && solutions.containsKey(right)) {
					combineTowList(rst, solutions.get(left),
							solutions.get(right));
				}
				left++;
				right--;
			}
			for (int i = 0; i < candidates.length; i++) {
				if (candidates[i] == target) {
					List<Integer> curr = new ArrayList<Integer>();
					curr.add(target);
					rst.add(curr);
				}
			}
			if (rst.size() != 0)
				solutions.put(target, rst);
		}
	}

	private void combineTowList(List<List<Integer>> rst,
			List<List<Integer>> l1, List<List<Integer>> l2) {
		for (List<Integer> tmp1 : l1) {
			for (List<Integer> tmp2 : l2) {
				List<Integer> curr = new ArrayList<Integer>();
				curr.addAll(tmp1);
				curr.addAll(tmp2);
				Collections.sort(curr);
				if (!isExist(rst, curr))
					rst.add(curr);
			}
		}
	}

	private boolean isExist(List<List<Integer>> rst, List<Integer> curr) {
		if (rst == null || curr == null)
			return false;
		for (List<Integer> tmp : rst) {
			if (comparetEqualTwoList(tmp, curr)) {
				return true;
			}
		}
		return false;
	}

	private boolean comparetEqualTwoList(List<Integer> first,
			List<Integer> second) {
		if (first == null && second == null)
			return true;
		if ((first == null && second != null) || first != null
				&& second == null)
			return false;
		if (first.size() != second.size())
			return false;
		for (int i = 0; i < first.size(); i++) {
			if (first.get(i) != second.get(i))
				return false;
		}
		return true;
	}

	/**
	 * @param n
	 *            : Given the range of numbers
	 * @param k
	 *            : Given the numbers of combinations
	 * @return: All the combinations of k numbers out of 1..n
	 */
	public List<List<Integer>> combine(int n, int k) {
		ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (k > n || n == 0)
			return rst;

		if (k == 1) {
			int i = 1;
			while (i <= n) {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i);
				rst.add(tmp);
				i++;
			}
			return rst;
		} else {
			List<List<Integer>> rst_k_1 = combine(n, k - 1);
			for (int i = 0; i < rst_k_1.size(); i++) {
				List<Integer> curr = rst_k_1.get(i);
				int last_item = curr.get(curr.size() - 1);
				if (last_item == n)
					continue;
				else {
					while (last_item < n) {
						List<Integer> new_entry = new ArrayList<Integer>();
						new_entry.addAll(curr);
						last_item++;
						new_entry.add(last_item);
						rst.add(new_entry);
					}
				}
			}
		}
		return rst;
	}

	/**
	 * @param root
	 *            : The root of the binary search tree.
	 * @param value
	 *            : Remove the node with given value.
	 * @return: The root of the binary search tree after removal.
	 */
	public TreeNode removeNode(TreeNode root, int value) {
		if (root == null)
			return root;
		if (root.val == value) {
			TreeNode right_min = getMinNodeParentOfBST(root.right);
			if (right_min == null) {
				root = root.left;
			} else {
				if (right_min.left == null) {
					right_min.left = root.left;
					root = right_min;
				} else {
					right_min.left.left = root.left;
					right_min.left.right = root.right;
					right_min.left = null;
				}
			}
		} else {
			TreeNode parent = getParentNode(root, value);
			if (parent == null)
				return root;
			if (parent.left != null && parent.left.val == value) {
				TreeNode replace_p = getMinNodeParentOfBST(parent.left.right);
				if (replace_p == null) {
					parent.left = parent.left.left;
				} else if (replace_p.val == parent.left.val) {
					replace_p.left = parent.left.left;
					parent.left = replace_p;
				} else {
					TreeNode tmp = replace_p.left.right;
					replace_p.left.left = parent.left.left;
					replace_p.left.right = parent.left.right;
					parent.left = replace_p.left;
					replace_p.left = tmp;
				}
			}
			if (parent.right != null && parent.right.val == value) {
				TreeNode replace_p = getMinNodeParentOfBST(parent.right.right);
				if (replace_p == null) {
					parent.right = parent.right.left;
				} else if (replace_p.val == parent.left.val) {
					replace_p.left = parent.right.left;
					parent.right = replace_p;
				} else {
					replace_p.left.left = parent.right.left;
					parent.right = replace_p.left;
					replace_p.left = null;
				}
			}

		}
		return root;
	}

	public TreeNode getParentNode(TreeNode root, int value) {
		if (root == null || root.val == value)
			return root;
		if ((root.left != null && root.left.val == value)
				|| (root.right != null && root.right.val == value))
			return root;

		if (root.val < value) {
			return getParentNode(root.right, value);
		} else {
			return getParentNode(root.left, value);
		}
	}

	public TreeNode getMinNodeParentOfBST(TreeNode root) {
		if (root == null || root.left == null || root.left.left == null)
			return root;
		return getMinNodeParentOfBST(root.left);
	}

	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: An integer.
	 */
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: Level order a list of lists of integer
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return null;
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (queue.size() != 0) {
			ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
			ArrayList<Integer> current_level = new ArrayList<Integer>();
			while (queue.size() != 0) {
				tmp.add(queue.poll());
			}
			for (TreeNode node : tmp) {
				current_level.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
		return rst;
	}

	/**
	 * @param head
	 *            : The first node of linked list.
	 * @return: a tree node
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		int length = getLength(head);
		int left = 1;
		int right = length;
		if (left + 1 >= right) {
			TreeNode root = new TreeNode(head.val);
			if (head.next != null) {
				TreeNode right_r = new TreeNode(head.next.val);
				root.right = right_r;
			}
			return root;
		}
		int mid = left + (right - left) / 2;
		ListNode NthNode = getNthNode(head, mid - 2);
		TreeNode root = new TreeNode(NthNode.next.val);
		ListNode tmp = NthNode.next;
		NthNode.next = null;
		if (left < right)
			root.left = sortedListToBST(head);
		root.right = sortedListToBST(tmp.next);
		return root;
	}

	private ListNode getNthNode(ListNode head, int n) {
		int i = 0;
		while (head != null && i++ < n) {
			head = head.next;
		}
		return head;
	}

	private int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	/**
	 * @param preorder
	 *            : A list of integers that preorder traversal of a tree
	 * @param inorder
	 *            : A list of integers that inorder traversal of a tree
	 * @return : Root of a tree
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length || preorder.length == 0)
			return null;
		return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	private TreeNode buildSubTree(int[] preorder, int pf, int pl,
			int[] inorder, int of, int ol) {
		TreeNode root = new TreeNode(preorder[pf]);
		if (pf == pl) {
			return root;
		}
		int i = of;
		while (preorder[pf] != inorder[i])
			i++;
		if (i != of)
			root.left = buildSubTree(preorder, pf + 1, pf + i - of, inorder,
					of, i - 1);
		if (i != ol)
			root.right = buildSubTree(preorder, pf + i - of + 1, pl, inorder,
					i + 1, ol);
		return root;
	}

	/**
	 * @param nums
	 *            : an array of integers
	 * @return: return nothing (void), do not return anything, modify nums
	 *          in-place instead
	 */
	public int[] nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)
			return nums;
		int i = nums.length - 1;
		while (i > 0 && nums[i] < nums[i - 1])
			i--;
		if (i == 0) {
			Arrays.sort(nums);
			return nums;
		}
		int j = nums.length - 1;
		while (j >= i && nums[j] < nums[i - 1])
			j--;
		int tmp = nums[j];
		nums[j] = nums[i - 1];
		nums[i - 1] = tmp;
		Arrays.sort(nums, i, nums.length);
		return nums;
	}

	/**
	 * @param A
	 *            : A list of integers
	 * @return: The boolean answer
	 */
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0)
			return false;
		boolean[] cache = new boolean[A.length];
		for (int i = A.length - 1; i >= 0; i--) {
			cache[i] = calidateJump(i, A[i], cache);
		}
		return cache[0];
	}

	private boolean calidateJump(int start, int steps, boolean[] cache) {
		if (steps == 0)
			return false;
		for (int i = 1; i <= steps; i++) {
			if (((start + i) >= cache.length) || (cache[start + i] == true))
				return true;
		}
		return false;
	}

	public void testbinaryRepresentation() {
		System.out.println(binaryRepresentation("2.0"));
	}

	public void testupdateBits() {
		System.out.println(updateBits(1024, 21, 2, 6));
	}

	public void javaBitShift() {
		// System.out.println(Integer.toBinaryString(-789) +
		// " After left by 1 \n" + Integer.toBinaryString(-789 << 1));
		// System.out.println(Integer.toBinaryString(-789) +
		// " After right by 1 \n" + Integer.toBinaryString(-789 >> 1));
		// System.out.println(Integer.toBinaryString(-789) +
		// " After logical right by 1 \n" + Integer.toBinaryString(-789 >>> 3));
		// // System.out.println(Integer.toBinaryString(0 - (1 << 31)));
		// System.out.println(Integer.toBinaryString(1 >> 30));
		// System.out.println(Integer.toBinaryString(1 >> 31));
		// System.out.println(Integer.toBinaryString(1 >> 32));
		// System.out.println(Integer.toBinaryString(-23));
		// System.out.println(Integer.toBinaryString(-23 << 30));
		// System.out.println(Integer.toBinaryString(-23 << 31));
		// System.out.println(Integer.toBinaryString(-23 << 32));
		// System.out.println(Integer.toBinaryString(-23 << 33));
		// System.out.println(Integer.toBinaryString(-23 >>> 64));
		System.out.println(1 << 31);
		System.out.println(Integer.toBinaryString(-2147483648 + 1));
		System.out.println(Integer.toBinaryString(~((1 << 31) - (1 << 1))));
	}

	public int majorityNumber(ArrayList<Integer> nums, int k) {
		int[] candiates = new int[k];
		int[] counts = new int[k];
		for (int i = 0; i < nums.size(); i++) {
			int j = 0;
			for (; j < k; j++) {
				if (candiates[j] == nums.get(i)) {
					counts[j]++;
					break;
				} else if (candiates[j] == 0) {
					candiates[j] = nums.get(i);
					counts[j]++;
					break;
				}
			}
			if (j == k) {
				for (j = 0; j < k; j++) {
					counts[j]--;
				}
			}
		}
		int t = 0;
		while (t < k) {
			counts[t] = 0;
			t++;
		}
		for (int item : nums) {
			for (int i = 0; i < k; i++) {
				if (item == candiates[i])
					counts[i]++;
			}
		}
		int count_f = 0, v_f = 0;
		for (int i = 0; i < k; i++) {
			if (counts[i] > count_f)
				count_f = counts[i];
			v_f = candiates[i];
		}
		return v_f;
	}

	/**
	 * @param n
	 *            : Given a decimal number that is passed in as a string
	 * @return: A string
	 */
	public String binaryRepresentation(String n) {
		if (n == null || n.equals(""))
			return "ERROR";
		if (n.indexOf(".") == -1)
			return parseInteger(n);
		String[] params = n.split("\\.");
		String flt = parseFloat(params[1]);
		if (flt == "ERROR") {
			return flt;
		}
		if (flt.equals("0") || flt.equals("")) {
			return parseInteger(params[0]);
		}
		return parseInteger(params[0]) + "." + flt;
	}

	private String parseInteger(String num) {
		int n = Integer.parseInt(num);
		if (num.equals("") || num.equals("0"))
			return "0";
		String buffer = "";
		while (n > 0) {
			buffer = n % 2 + buffer;
			n = n / 2;
		}
		return buffer;
	}

	private String parseFloat(String fnum) {
		Double fl = Double.parseDouble("0." + fnum);
		String buffer = "";
		HashSet<Double> set = new HashSet<Double>();
		while (fl != 0.0) {
			if (buffer.length() > 32 || set.contains(fl))
				return "ERROR";
			set.add(fl);
			fl = 2 * fl;
			if (fl >= 1) {
				buffer += "1";
				fl -= 1;
			} else {
				buffer += "0";
			}
		}
		return buffer;
	}

	public void testRehashing() {
		ListNode ft = new ListNode(29);
		ListNode st = new ListNode(5);
		ft.next = st;
		ListNode[] nums = new ListNode[3];
		nums[2] = ft;
		rehashing(nums);
	}

	/**
	 * (<<)left shift bit will fill blank position with 0 no matter if it is
	 * negative number. So it may affect the signed number's sign position.
	 * (>>)right shift bit will fill blank position with number depends on its
	 * sign position. (>>>) logical right shift will fill with 0;
	 * a<<0,32,64,......32*n = a if shit number is bigger than 31, shift number
	 * should be N%31;
	 * 
	 * @param n
	 * @param m
	 * @param i
	 * @param j
	 * @return
	 */
	public int updateBits(int n, int m, int i, int j) {
		int mask;
		System.out.println("Pre N : " + Integer.toBinaryString(n));
		System.out.println("Pre M : " + Integer.toBinaryString(m));
		if (j < 31)
			mask = ~((1 << j + 1) - (1 << i));
		else
			mask = (1 << i) - 1;
		System.out.println("Mask : " + Integer.toBinaryString(mask));
		n = n & mask;
		System.out.println("N : " + Integer.toBinaryString(n));
		m = m << i;
		System.out.println("M : " + Integer.toBinaryString(m));
		return m | n;
	}

	/**
	 * @param hashTable
	 *            : A list of The first node of linked list
	 * @return: A list of The first node of linked list which have twice size
	 */
	public ListNode[] rehashing(ListNode[] hashTable) {
		if (hashTable == null)
			return null;
		int capacity = hashTable.length * 2;
		ListNode[] rst = new ListNode[capacity];
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] == null)
				continue;
			while (hashTable[i] != null) {
				ListNode item = hashTable[i];
				int index = hashcode(item.val, capacity);
				ListNode le = rst[index];
				if (le == null) {
					rst[index] = item;
				} else {
					while (le.next != null)
						le = le.next;
					le.next = item;
				}
				hashTable[i] = item.next;
				item.next = null;
			}
		}
		return rst;
	}

	int hashcode(int key, int capacity) {
		return key % capacity;
	}

	public void testbitSapRequired() {
		System.out.println(bitSwapRequired(31, 14));
	}

	/**
	 * @param a
	 *            , b: Two integer return: An integer
	 */
	public int bitSwapRequired(int a, int b) {
		int rs = a ^ b;
		int rst = 0;
		for (int i = 0; i < 32; i++) {
			if (1 == (rs >> i & 1))
				rst++;
		}
		return rst;
	}

	public void testSqrt() {
		System.out.println(sqrt(2147483647));
	}

	public void testpartitionArray() {
		System.out.println(partitionArray(new int[] { 3, 2, 2, 1 }, 2));
	}

	public int sqrt(int x) {
		if (x == 0)
			return x;
		long left = 1;
		long right = x;
		while (left + 1 < right) {
			long mid = (right + left) / 2;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid > x) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return (int) left;
	}

	public void swap(int left, int right) {
		System.out.println("pre-swp : left = " + left + " right = " + right);
		left = left ^ right;
		right = left ^ right;
		left = left ^ right;
		System.out.println("after-swp : left = " + left + " right = " + right);
	}

	/**
	 * shift right 1 position is equal to divide by 2.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public int computerAverage(int left, int right) {
		return (left + right) >> 1;
	}

	/**
	 * @param nums
	 *            : The integer array you should partition
	 * @param k
	 *            : As description return: The index after partition
	 */
	public int partitionArray(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		int partitionNumber = getPartitionNumber(nums, k);
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			if (nums[left] < partitionNumber) {
				left++;
			} else {
				int tmp = nums[right];
				nums[right] = nums[left];
				nums[left] = tmp;
				right--;
			}
		}
		return left;
	}

	public int getPartitionNumber(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		int bigger = nums[0];
		for (int item : nums) {
			if (item == k)
				return k;
			else if (item > k) {
				if (item < bigger)
					bigger = item;
			}
		}
		return bigger;
	}

	public void testSingleNumberII() {
		System.out.println(singleNumberII(new int[] { 1, 1, 2, 3, 3, 3, 2, 2,
				4, 1 }));
		System.out.println(singleNumberII(new int[] { 6, 1, 1, 1, 2, 2, 2, 4,
				5, 6, 4, 5, 4, 5, 6 }));
	}

	public void testSingleNumber() {
		System.out.println(singleNumber(new int[] { 1, 2, 2, 1, 3, 4, 3 }));
	}

	public int singleNumberII(int[] A) {
		int result = 0;
		int[] bits = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				bits[i] += A[j] >> i & 1;
				bits[i] %= 3;
			}

			result |= (bits[i] << i);
		}
		return result;
	}

	public int singleNumber(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int n = A[0];
		for (int i = 1; i < A.length; i++) {
			n = n ^ A[i];
			System.out.println(n);
		}

		return n;
	}

	public void testBinaryOperator() {
		System.out.println(60 & 13);
		System.out.println(13 & 60);
		System.out.println(60 | 13);
		System.out.println(60 ^ 13);
		System.out.println(~13);
		System.out.println(13 << 2);
		System.out.println(13 >> 2);
		System.out.println(13 >>> 2);
	}

	public void testMaxTree() {
		System.out.println(maxTree(new int[] { 2, 5, 6, 0, 3, 1 }));
	}

	public TreeNode maxTree(int[] A) {
		if (null == A || A.length == 0)
			return null;
		Stack<TreeNode> cache = new Stack<TreeNode>();
		for (int i = 0; i <= A.length; i++) {
			TreeNode newnode = null;
			if (i == A.length) {
				newnode = new TreeNode(Integer.MAX_VALUE);
			} else {
				newnode = new TreeNode(A[i]);
			}
			if (!cache.empty() == true && A[i] > cache.peek().val) {
				while (cache.empty() == false && A[i] > cache.peek().val) {
					TreeNode right_node = cache.pop();
					TreeNode left = null;
					if (cache.empty() == false)
						left = cache.pop();
					if (left != null && left.val < A[i]) {
						left.right = right_node;
						cache.push(left);
					} else {
						if (null != left)
							cache.push(left);
						newnode.left = right_node;
						break;
					}
				}
			}
			cache.push(newnode);
		}
		return cache.peek().left;
	}

	public String DeleteDigits(String A, int k) {
		if (k <= 0 || A == null || A.length() == 0 || k > A.length())
			return A;
		String result = A;
		while (k > 0) {
			result = removeOneBit(result);
			k--;
		}
		return result;
	}

	public String removeOneBit(String A) {
		int i = 0;
		for (; i < A.length() - 1; i++) {
			if (A.charAt(i) > A.charAt(i + 1)) {
				break;
			}
		}
		if (i >= A.length() - 1)
			return A.substring(0, A.length() - 1);
		else
			return A.substring(0, i) + A.substring(i + 1, A.length());
	}

	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
		public int compare(ListNode left, ListNode right) {
			if (left == null) {
				return 1;
			} else if (right == null) {
				return -1;
			}
			return left.val - right.val;
		}
	};

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),
				ListNodeComparator);
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				heap.add(lists.get(i));
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!heap.isEmpty()) {
			ListNode head = heap.poll();
			tail.next = head;
			tail = head;
			if (head.next != null) {
				heap.add(head.next);
			}
		}
		return dummy.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	// Definition of TreeNode:
	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	// Definition for Directed graph.
	class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;

		DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<DirectedGraphNode>();
		}
	};

}
