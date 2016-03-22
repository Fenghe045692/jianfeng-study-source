package com.jianfeng.algorithm.jiuzhang;

//http://blog.csdn.net/u011095253/article/details/9158387
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Recusion {

	public static void main(String[] args) throws Exception {
		Recusion rn = new Recusion();
		// rn.testsubsets();
		// rn.testCloneGraph();
		// System.out.println(rn.replace("dog", 1, 'i'));
		// System.out.println(rn.climbStairs(4));
		// rn.testmaxSubArray();
		// rn.testmaxProduct();
		// rn.testmaxTwoSubArrays();
		// rn.testnumDistinct();
		// rn.testisInterleave();
		// rn.testwordBreak();
		// rn.testbackpack();
		// rn.testmaxDiffSubArrays();
		// rn.testkthPrimeNumber();
		// rn.testbuildTree();
		// rn.testminimumPath();
		// rn.testPartition();
		// rn.testsolveNQueensII();
		// rn.testSolutionII();
		// rn.testsort();
		// rn.testmaxProfit();
		// rn.testequal();
		// rn.testprint1ToNDigitsMaxNumber();
		// rn.testprint1ToNDigitsMaxNumberRecursively();
		// rn.testprintMatrix();
		// rn.testvalidateStackSequence();
		// rn.testStrPermutation();
		// rn.testmedian();
		// rn.testmergeSort();
		rn.testinversePair();
		LinkedBlockingQueue le = new LinkedBlockingQueue();
	}

	private class CTreeNode {
		char c;
		CTreeNode left;
		CTreeNode right;
		CTreeNode parent;

		public CTreeNode(char c) {
			this.c = c;
			left = null;
			right = null;
		}
	}

	public CTreeNode convertT(char[] values) {
		CTreeNode n = new CTreeNode(values[0]);
		for (int i = 1; i < values.length; i += 2) {
			if (values[i] == '?') {
				n.left = new CTreeNode(values[i + 1]);
				n = n.left;
			} else if (values[i] == ':') {
				n = n.parent;
				while (n.right != null && n.parent != null) {
					n = n.parent;
				}
				n.right = new CTreeNode(values[i + 1]);
				n = n.right;
			}
		}
		return n;
	}

	public CTreeNode toTree(String s) {
		if (s == null || s.length() == 0)
			return null;
		CTreeNode root = new CTreeNode(s.charAt(0));
		Stack<CTreeNode> stack = new Stack<CTreeNode>();
		stack.push(root);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '?') {
				CTreeNode node = stack.peek();
				node.left = new CTreeNode(s.charAt(i + 1));
				stack.push(node.left);
			} else if (s.charAt(i) == ':') {
				stack.pop();
				CTreeNode node = stack.pop();
				node.right = new CTreeNode(s.charAt(i + 1));
			}
		}
		return root;
	}

	public int numIslands(boolean[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int numbers = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited[i][j] && grid[i][j]) {
					numIslandsDFS(grid, visited, i, j);
					numbers++;
				}
			}
		}
		return numbers;
	}

	public void numIslandsDFS(boolean[][] grid, boolean[][] visited, int x,
			int y) {
		if (x < 0 || y < 0 || !grid[x][y] || visited[x][y])
			return;
		visited[x][y] = true;
		numIslandsDFS(grid, visited, x - 1, y);
		numIslandsDFS(grid, visited, x + 1, y);
		numIslandsDFS(grid, visited, x, y + 1);
		numIslandsDFS(grid, visited, x, y - 1);
	}

	public void testinversePair() {
		int[] nums = new int[] { 4, 2, 7, 9, 21, 0, 5 };
		System.out.println(inversePair(nums));
		for (int item : nums) {
			System.out.print(item + " ");
		}
		nums = new int[] { 4, 5 };
		System.out.println(inversePair(nums));
		nums = new int[] { 5, 3 };
		System.out.println(inversePair(nums));
		nums = new int[] { 5, 5 };
		System.out.println(inversePair(nums));
	}

	public int inversePair(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] tmp = new int[nums.length];
		return inversePairCor(nums, tmp, 0, nums.length - 1);
	}

	public int inversePairCor(int[] nums, int[] tmp, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int count = 0;
		int middle = start + (end - start) / 2;
		count += inversePairCor(nums, tmp, start, middle);
		count += inversePairCor(nums, tmp, middle + 1, end);
		return count + mergetSortedArrayII(nums, start, middle, end, tmp);

	}

	public void testmergeSort() {
		int[] nums = new int[] { 4, 2, 7, 9, 21, 0, 5 };
		mergeSort(nums);
		for (int item : nums) {
			System.out.print(item + " ");
		}
	}

	public void mergeSort(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int[] tmp = new int[nums.length];
		mergetSort(nums, 0, nums.length - 1, tmp);
	}

	public void mergetSort(int[] nums, int start, int end, int[] tmp) {
		if (start < end) {
			int middle = start + (end - start) / 2;
			mergetSort(nums, start, middle, tmp);
			mergetSort(nums, middle + 1, end, tmp);
			mergetSortedArray(nums, start, middle, end, tmp);
		}
	}

	public int mergetSortedArrayII(int[] nums, int start, int middle, int end,
			int[] tmp) {
		int i = middle, j = end;
		int k = end;
		int count = 0;
		while (i >= start && j >= middle + 1) {
			if (nums[i] <= nums[j]) {
				tmp[k--] = nums[j--];

			} else {
				count += j - middle;
				tmp[k--] = nums[i--];
			}
		}
		while (i >= start)
			tmp[k--] = nums[i--];
		while (j >= middle + 1)
			tmp[k--] = nums[j--];
		k = end;
		while (start <= end) {
			nums[end--] = tmp[k--];
		}
		return count;
	}

	public void mergetSortedArray(int[] nums, int start, int middle, int end,
			int[] tmp) {
		int i = start, j = middle + 1;
		int k = 0;
		while (i <= middle && j <= end) {
			if (nums[i] <= nums[j]) {
				tmp[k++] = nums[i++];
			} else {
				tmp[k++] = nums[j++];
			}
		}
		while (i <= middle)
			tmp[k++] = nums[i++];
		while (j <= end)
			tmp[k++] = nums[j++];
		k = 0;
		while (start <= end) {
			nums[start++] = tmp[k++];
		}
	}

	public void testmedian() {
		System.out.println(median(new int[] { 2, 5, 9, 4, 12, 6 }));
	}

	public int getMoreThanHalfNumber(int[] numbers) {
		return 0;
	}

	public void testStrPermutation() {
		permutation("dffeegghh");
	}

	/**
	 * @param nums
	 *            : A list of integers.
	 * @return: An integer denotes the middle number of the array.
	 */
	public int median(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length - 1;
		int middle = left + (right - left) / 2;
		while (true) {
			int partition = partition(nums, left, right);
			if (partition > middle) {
				right = partition - 1;
			} else if (partition < middle) {
				left = partition + 1;
			} else {
				break;
			}
		}
		return nums[middle];
	}

	public int partition(int[] nums, int left, int right) {
		int pivot = nums[right];
		int small = left - 1;
		for (int i = left; i < right; i++) {
			if (nums[i] < pivot) {
				++small;
				swap(nums, small, i);
			}
		}
		++small;
		swap(nums, small, right);
		return small;
	}

	public void permutation(String str) {
		if (str == null || str.length() == 0)
			return;
		char[] str_arr = str.toCharArray();
		Arrays.sort(str_arr);
		// permutation(str_arr, 0);
		// permutation(str_arr);
		permutation("", str);
	}

	private HashMap<String, String> cache = new HashMap<String, String>();

	public void permutation(char[] str, int start) {
		if (start == str.length - 1) {
			System.out.println("count " + count++ + ":" + String.valueOf(str));
			if (cache.containsKey(String.valueOf(str))) {
				System.out.println("duplicate_count " + duplicate_count++ + ":"
						+ String.valueOf(str));
			} else {
				cache.put(String.valueOf(str), null);
			}
		} else {
			for (int i = start; i < str.length;) {
				if (i != start && str[i] == str[start]) {
					i++;
					continue;
				}
				swap(str, start, i);
				permutation(str, start + 1);
				swap(str, start, i);
				while (i < str.length - 1 && str[i] == str[i + 1])
					i++;
				i++;
			}
		}
	}

	private int count = 0;
	private int duplicate_count = 0;

	public void permutation(char[] nums) {
		if (nums == null || nums.length == 0)
			return;
		Arrays.sort(nums);
		while (true) {
			if (cache.containsKey(String.valueOf(nums))) {
				System.out.println("Duplicate Entry : " + String.valueOf(nums));
			} else {
				cache.put(String.valueOf(nums), null);
				System.out.println("count " + count++ + ": "
						+ String.valueOf(nums));
			}
			int i = nums.length - 1;
			while (i > 0 && nums[i - 1] >= nums[i])
				i--;
			if (i == 0) {
				break;
			}
			int j = nums.length - 1;
			while (j > i && nums[j] <= nums[i - 1])
				j--;
			char tmp = nums[i - 1];
			nums[i - 1] = nums[j];
			nums[j] = tmp;
			reverseList(nums, i, nums.length - 1);
		}
	}

	public void reverseList(char[] nums, int start, int end) {
		while (start < end) {
			char tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}

	public void swap(char[] str, int left, int right) {
		char tmp = str[left];
		str[left] = str[right];
		str[right] = tmp;
	}

	private void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println("count " + count++ + ": " + prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
		}
	}

	public void testvalidateStackSequence() {
		System.out
				.println(validateStackSequence(new int[] { 1, 2, 3, 4, 5, 6 },
						new int[] { 6, 5, 4, 3, 2, 1 }));
		System.out
				.println(validateStackSequence(new int[] { 1, 2, 3, 4, 5, 6 },
						new int[] { 6, 5, 4, 3, 1, 2 }));
		System.out
				.println(validateStackSequence(new int[] { 1, 2, 3, 4, 5, 6 },
						new int[] { 6, 5, 7, 3, 1, 2 }));
		System.out
				.println(validateStackSequence(new int[] { 1, 2, 3, 4, 5, 6 },
						new int[] { 3, 2, 1, 4, 5, 6 }));
		System.out.println(validateStackSequence(new int[] { 3 },
				new int[] { 3 }));
	}

	public boolean validateStackSequence(int[] inStackSequence,
			int[] outStackSequence) {
		if (inStackSequence == null || outStackSequence == null
				|| inStackSequence.length != outStackSequence.length)
			return false;
		Stack<Integer> cache_stack = new Stack<Integer>();
		int start = 0;
		for (int i = 0; i < outStackSequence.length; i++) {
			if (cache_stack.isEmpty()
					|| cache_stack.peek() != outStackSequence[i]) {
				while (start < inStackSequence.length
						&& inStackSequence[start] != outStackSequence[i]) {
					cache_stack.push(inStackSequence[start]);
					start++;
				}
				if (start >= inStackSequence.length)
					return false;
				start++;
			} else {
				cache_stack.pop();
			}
		}
		return true;
	}

	public void testprintMatrix() {
		printMatrix(new int[][] { { 1, 2, 3, 4 }, { 6, 7, 8, 9 },
				{ 10, 11, 12, 13 }, { 14, 15, 16, 17 }, { 18, 19, 20, 21 } });
		System.out.println();
		printMatrix(new int[][] { { 1, 2, 3, 4 } });
		System.out.println();
		printMatrix(new int[][] { { 1 }, { 2 }, { 3 }, { 4 } });
	}

	public void printMatrix(int[][] numbers) {
		if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
			return;
		}
		int rows = numbers.length;
		int columns = numbers[0].length;
		int start = 0;
		while (rows > start * 2 && columns > start * 2) {
			printMatrixInCircle(numbers, start);
			start++;
		}
	}

	public void printMatrixInCircle(int[][] numbers, int start) {
		int endX = numbers.length - 1 - start;
		int endY = numbers[0].length - 1 - start;
		for (int i = start; i <= endY; i++) {
			System.out.print(" " + numbers[start][i]);
		}

		if (start < endX) {
			for (int i = start + 1; i <= endX; i++) {
				System.out.print(" " + numbers[i][endY]);
			}
		}
		if (start < endY && start < endX) {
			for (int i = endY - 1; i >= start; i--) {
				System.out.print(" " + numbers[endX][i]);
			}
		}
		if (start < endY && start < endX - 1) {
			for (int i = endX - 1; i > start; i--) {
				System.out.print(" " + numbers[i][start]);
			}
		}
	}

	public void testprint1ToNDigitsMaxNumberRecursively() {
		print1ToNDigitsMaxNumberRecursively(3);
	}

	public void print1ToNDigitsMaxNumberRecursively(int n) {
		if (n <= 0)
			return;
		char[] num_arr = new char[n];
		print1ToNDigitsMaxNumberRecursively(num_arr, 0);
	}

	public void print1ToNDigitsMaxNumberRecursively(char[] num_arr, int index) {
		if (index >= num_arr.length) {
			printCharNumer(num_arr);
			return;
		}
		for (int i = 0; i < 10; i++) {
			num_arr[index] = (char) (i + '0');
			print1ToNDigitsMaxNumberRecursively(num_arr, index + 1);
		}
	}

	public void testprint1ToNDigitsMaxNumber() {
		print1ToNDigitsMaxNumber(3);
	}

	public void print1ToNDigitsMaxNumber(int n) {
		if (n <= 0)
			return;
		char[] num_arr = new char[n + 1];
		initialize(num_arr);
		while (!increment(num_arr)) {
			printCharNumer(num_arr);
		}
	}

	public void printCharNumer(char[] num_arr) {
		boolean isBeginning = true;
		String result = "";
		for (int i = 0; i < num_arr.length; i++) {
			if (isBeginning && num_arr[i] != '0')
				isBeginning = false;
			if (!isBeginning)
				result += num_arr[i];
		}
		if (result.length() != 0)
			System.out.println(result);
	}

	public boolean increment(char[] num_arr) {
		boolean isOverFlow = false;
		int ntoken = 0;
		for (int i = num_arr.length - 1; i >= 0; i--) {
			int nSum = num_arr[i] - '0' + ntoken;
			if (i == num_arr.length - 1)
				nSum++;
			if (nSum >= 10) {
				if (i == 1) {
					isOverFlow = true;
				} else {
					num_arr[i] = '0';
					ntoken = 1;
				}
			} else {
				num_arr[i] = (char) (nSum + '0');
				break;
			}
		}
		return isOverFlow;
	}

	public void initialize(char[] num_arr) {
		for (int i = 0; i < num_arr.length; i++) {
			num_arr[i] = '0';
		}
	}

	public void testequal() {
		System.out.println(equal(0.0000002, 0.00000021));
	}

	public boolean equal(double num1, double num2) {
		if (Math.abs(num1 - num2) < 0.0000001)
			return true;
		return false;
	}

	public void sortColors(int[] a) {
		if (a == null || a.length == 0)
			return;
		int pl = 0;
		int pr = a.length - 1;
		int i = 0;
		while (i <= pr) {
			if (a[i] == 0) {
				swap(a, pl, i);
				pl++;
				i++;
			} else if (a[i] == 1) {
				i++;
			} else {
				swap(a, pr, i);
				pr--;
			}
		}

	}

	public void testmaxProfit() {
		System.out.println(maxProfit(new int[] { 2, 1, 2, 0, 1 }));
	}

	/**
	 * @param prices
	 *            : Given an integer array
	 * @return: Maximum profit
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int[] left_maxProfit = new int[prices.length];
		int[] right_maxProfit = new int[prices.length];
		int min = prices[0];
		int max_profit = 0;
		for (int i = 0; i < prices.length; i++) {
			min = prices[i] > min ? min : prices[i];
			max_profit = prices[i] - min > max_profit ? prices[i] - min
					: max_profit;
			left_maxProfit[i] = max_profit;
		}

		int max = prices[prices.length - 1];
		max_profit = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			max = prices[i] > max ? prices[i] : max;
			max_profit = max - prices[i] > max_profit ? max - prices[i]
					: max_profit;
			right_maxProfit[i] = max_profit;
		}
		max_profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			max_profit = Math.max(max_profit, left_maxProfit[i]
					+ right_maxProfit[i + 1]);
		}
		return max_profit;
	}

	public void testsort() {
		int[] numbers = new int[] { 3, 5, 6, 4, 2 };
		sort(numbers);
		for (int tmp : numbers) {
			System.out.print(tmp + " ");
		}
	}

	public void sort(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return;
		}
		quickSort(numbers, 0, numbers.length - 1);
	}

	public void quickSort(int[] numbers, int low, int high) {
		int pivot = numbers[low + (high - low) / 2];
		int i = low, j = high;
		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}

			while (numbers[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchange(numbers, i, j);
				i++;
				j--;
			}
		}
		if (low < j) {
			quickSort(numbers, low, j);
		}

		if (i < high) {
			quickSort(numbers, i, high);
		}
	}

	private void exchange(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	/**
	 * @param A
	 *            : An integer array.
	 * @param B
	 *            : An integer array.
	 * @return: a double whose format is *.5 or *
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
		return 0.0;
	}

	public void testSolutionII() {
		SolutionII solutionII = new SolutionII(2);
		solutionII.set(1, -1);
		solutionII.set(2, -2);
		System.out.println(solutionII.get(2));
		System.out.println(solutionII.get(1));
		solutionII.set(3, -3);
		solutionII.set(4, -4);
		System.out.println(solutionII.get(2));
	}

	/*
	 * Design and implement a data structure for Least Recently Used (LRU)
	 * cache. It should support the following operations: get and set.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key
	 * exists in the cache, otherwise return -1. set(key, value) - Set or insert
	 * the value if the key is not already present. When the cache reached its
	 * capacity, it should invalidate the least recently used item before
	 * inserting a new item.
	 */
	public class SolutionII {
		HashMap<Integer, Integer> items;
		int capacity;
		ArrayList<Integer> cache;

		// @param capacity, an integer
		public SolutionII(int capacity) {
			this.items = new HashMap<Integer, Integer>();
			this.cache = new ArrayList<Integer>();
			this.capacity = capacity;
		}

		// @return an integer
		public int get(int key) {
			if (items.containsKey(key)) {
				updateNewKey(cache, key);
				return items.get(key);
			}
			return -1;
		}

		// @param key, an integer
		// @param value, an integer
		// @return nothing
		public void set(int key, int value) {
			if (items.containsKey(key)) {
				items.put(key, value);
				updateNewKey(cache, key);
			} else {
				items.put(key, value);
				cache.add(0, key);
				if (cache.size() > capacity) {
					int removedKey = cache.remove(cache.size() - 1);
					items.remove(removedKey);
				}
			}
		}

		public void updateNewKey(ArrayList<Integer> cache, int key) {
			for (int i = 0; i < cache.size(); i++) {
				if (cache.get(i) == key) {
					cache.remove(i);
				}
			}
			cache.add(0, key);
		}
	}

	public TreeNode insertNode(TreeNode root, TreeNode node) {
		if (root == null)
			return node;
		insert(root, node);
		return root;
	}

	public void insert(TreeNode root, TreeNode node) {
		if (root.val < node.val) {
			if (root.right == null) {
				root.right = node;
			} else {
				insert(root.right, node);
			}
		} else {
			if (root.left == null) {
				root.left = node;
			} else {
				insert(root.left, node);
			}
		}
	}

	public void testsolveNQueensII() {
		System.out.println(solveNQueensII(5));
	}

	private int sum = 0;

	public int solveNQueensII(int n) {
		if (n <= 0)
			return 0;
		HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();
		drawChessBoard(history, 0, -1, n);
		return sum;
	}

	public void drawChessBoard(HashMap<Integer, Integer> c_history, int start,
			int lastColumn, int n) {
		if (start >= n)
			return;
		for (int i = 0; i < n; i++) {
			if (start == 0 || isValidItem(c_history, start, i, n)) {
				if (start == n - 1) {
					sum++;
				} else {
					c_history.put(i, start);
					drawChessBoard(c_history, start + 1, i, n);
				}
				c_history.remove(i);
			}
		}
	}

	public boolean isValidItem(HashMap<Integer, Integer> c_history, int i,
			int j, int n) {
		if (c_history.containsKey(j))
			return false;
		int m = i, k = j;
		while (m > 0 && k > 0) {
			m--;
			k--;
			if (c_history.containsKey(k) && c_history.get(k) == m)
				return false;
		}
		while (i > 0 && j < n - 1) {
			i--;
			j++;
			if (c_history.containsKey(j) && c_history.get(j) == i)
				return false;
		}
		return true;
	}

	public String getItem(int index, int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			if (i != index) {
				result += ".";
			} else {
				result += "Q";
			}
		}
		return result;
	}

	public void testPartition() {
		System.out.println(partition("ab"));
	}

	public List<List<String>> partition(String s) {
		List<List<String>> rst = new ArrayList<List<String>>();
		if (s == null || s.length() == 0)
			return rst;
		List<String> path = new ArrayList<String>();
		partition(rst, path, s);
		return rst;
	}

	public void partition(List<List<String>> rst, List<String> path, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s.substring(0, i + 1))) {
				path.add(s.substring(0, i + 1));
				if (i + 1 >= s.length())
					rst.add(new ArrayList<String>(path));
				else
					partition(rst, path, s.substring(i + 1, s.length()));
				path.remove(path.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String s) {
		if (s == null)
			return true;
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	public void testminimumPath() {
		System.out.println(minPathSum(new int[][] { { 1, 2 }, { 1, 1 } }));
	}

	public class Solutions {
		Stack<TreeNode> myStack;
		TreeNode current;

		Solutions(TreeNode root) {
			myStack = new Stack<TreeNode>();
			current = root;
		}

		/** @return whether we have a next smallest number */
		boolean hasNext() {
			return (current != null || !myStack.empty());
		}

		/** @return the next smallest number */
		int next() {
			while (current != null) {
				myStack.push(current);
				current = current.left;
			}
			current = myStack.peek();
			myStack.pop();
			int val = current.val;
			current = current.right;
			return val;
		}
	}

	/**
	 * @param grid
	 *            : a list of lists of integers.
	 * @return: An integer, minimizes the sum of all numbers along its path
	 */
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int[][] minSum = new int[grid.length][grid[0].length];
		minSum[0][0] = grid[0][0];
		for (int i = 1; i < grid.length; i++) {
			minSum[i][0] = minSum[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < grid[0].length; i++) {
			minSum[0][i] = minSum[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				minSum[i][j] = Math.min(minSum[i][j - 1], minSum[i - 1][j])
						+ grid[i][j];
			}
		}
		return minSum[grid.length - 1][grid[0].length - 1];
	}

	/**
	 * @param root
	 *            : The root of the binary search tree.
	 * @param A
	 *            and B: two nodes in a Binary.
	 * @return: Return the least common ancestor(LCA) of the two nodes.
	 */

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || A == null || B == null)
			return root;
		if (root == A || root == B)
			return root;
		if (isExist(root.left, A)) {
			if (isExist(root.left, B)) {
				return lowestCommonAncestor(root.left, A, B);
			}
		} else {
			if (isExist(root.right, B)) {
				return lowestCommonAncestor(root.right, A, B);
			}
		}
		return root;
	}

	public boolean isExist(TreeNode root, TreeNode node) {
		if (root == null)
			return false;
		if (root == node)
			return true;
		return isExist(root.left, node) || isExist(root.right, node);
	}

	public void testbuildTree() {
		buildTree(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 });
	}

	private int max_value = Integer.MIN_VALUE;
	private boolean first_value = true;

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (isValidBST(root.left)) {
			if (!first_value) {
				if (root.val <= max_value)
					return false;
			}
			max_value = root.val;
			first_value = false;
			return isValidBST(root.right);
		} else
			return false;
	}

	public boolean isBalanced(TreeNode root) {
		if (getBalancedDepth(root) != -1)
			return true;
		return false;
	}

	public int getBalancedDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = getBalancedDepth(root.left);
		int right = getBalancedDepth(root.right);
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null
				|| preorder.length != inorder.length || preorder.length == 0)
			return null;
		return buildTreeByIndex(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	public TreeNode buildTreeByIndex(int[] preorder, int p1, int p2,
			int[] inorder, int o1, int o2) {
		if (o1 == o2) {
			return new TreeNode(inorder[o1]);
		} else {
			int interval = o1;
			while (interval <= o2 && inorder[interval] != preorder[p1])
				interval++;
			if (interval == o1) {
				TreeNode root = new TreeNode(inorder[o1]);
				root.right = buildTreeByIndex(preorder, p1 + 1, p2, inorder,
						o1 + 1, o2);
				return root;
			} else if (interval == o2) {
				TreeNode root = new TreeNode(inorder[o2]);
				root.left = buildTreeByIndex(preorder, p1 + 1, p2, inorder, o1,
						o2 - 1);
				return root;
			} else {
				TreeNode root = new TreeNode(inorder[interval]);
				root.left = buildTreeByIndex(preorder, p1 + 1, interval - o1
						+ p1, inorder, o1, interval - 1);
				root.right = buildTreeByIndex(preorder, interval - o1 + p1 + 1,
						p2, inorder, interval + 1, o2);
				return root;
			}
		}
	}

	/*
	 * Given an integer array, find a subarray with sum closest to zero. Return
	 * the indexes of the first number and last number. Example Given [-3, 1, 1,
	 * -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
	 */
	/**
	 * @param nums
	 *            : A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 */
	public class Element implements Comparable<Element> {
		public int val;
		public int index;

		public Element(int val, int index) {
			this.val = val;
			this.index = index;
		}

		public int compareTo(Element element) {
			return this.val - element.val;
		}

	}

	public ArrayList<Integer> subarraySumClosest(int[] nums) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return rst;
		Element[] sums = new Element[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sums[i] = new Element(sum, i);
		}
		Arrays.sort(sums);
		int min = Integer.MAX_VALUE;
		int left = 0, right = 0;
		for (int i = 0; i < sums.length - 1; i++) {
			if (min > Math.abs(sums[i].val - sums[i + 1].val)) {
				left = Math.min(sums[i].index, sums[i + 1].index) + 1;
				right = Math.max(sums[i].index, sums[i + 1].index);
				min = Math.abs(sums[i].val - sums[i + 1].val);
			}
		}
		rst.add(left);
		rst.add(right);
		return rst;
	}

	public ArrayList<ArrayList<Integer>> subsetss(ArrayList<Integer> S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.size() == 0) {
			return result;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		result.add(path);
		addSubsets(S, path, 0, result);
		return result;
	}

	public void addSubsets(ArrayList<Integer> S, ArrayList<Integer> path,
			int index, ArrayList<ArrayList<Integer>> result) {
		for (; index < S.size(); index++) {
			ArrayList<Integer> new_item = new ArrayList<Integer>();
			for (int i = 0; i < path.size(); i++) {
				new_item.add(path.get(i));
			}
			new_item.add(S.get(index));
			result.add(new_item);
			path.add(S.get(index));
			addSubsets(S, path, index++, result);
			path.remove(path.size() - 1);
		}
	}

	public void testkthPrimeNumber() {
		// System.out.println(kthPrimeNumber(1));
		System.out.println(kthPrimeNumber(10));
		System.out.println(kthPrimeNumberII(10));
	}

	public void testmaxDiffSubArrays() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(-5);
		arr.add(3);
		arr.add(-4);
		arr.add(0);
		arr.add(0);
		arr.add(0);
		arr.add(-1);
		arr.add(20);
		arr.add(1);
		arr.add(1);
		arr.add(-1);
		arr.add(-1);
		arr.add(-1);
		arr.add(-1);
		arr.add(-1);
		System.out.println(maxDiffSubArrays(arr));
	}

	public void testbackpack() {
		System.out.println(backPack(10, new int[] { 3, 4, 8, 5 }));
	}

	public void testwordBreak() {
		Set<String> dict = new HashSet<String>();
		dict.add("lint");
		dict.add("code");
		System.out.println(wordBreak("lintcode", dict));
	}

	public void testisInterleave() {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(isInterleave("a", "", "a"));
		System.out
				.println(isInterleave("asdfjopufaaf;lasnopfodifa;djfal;sfjdsf",
						"adlkjfoqweijzdkj;ljfeowfjl;djfnd",
						"asdfjopufaaf;lasnopfodadlkjfoqweijzdkj;ljfeowfjl;djfneifa;djfal;sfjdsf"));
	}

	public void testnumDistinct() {
		System.out.println(numDistinct("rabbbit", "rabit"));
	}

	public void testmaxTwoSubArrays() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// arr.add(1);
		// arr.add(3);
		arr.add(5);
		// arr.add(2);
		arr.add(4);
		// arr.add(2);
		System.out.println(maxTwoSubArrays(arr));
	}

	public void testmaxProduct() {
		// System.out.println(maxProduct(new int[]{-1,-99}));
		// System.out.println(maxProduct(new int[]{1,-99}));
		// System.out.println(maxProduct(new int[]{-1, 99}));
		// System.out.println(maxProduct(new int[]{2,3,-2,4}));
		System.out.println(maxProduct(new int[] { -3, 0, 1, 2 }));
	}

	public void testmaxSubArray() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(-5);
		arr.add(3);
		arr.add(-4);
		arr.add(0);
		arr.add(-1);
		arr.add(20);
		arr.add(1);
		arr.add(-1);
		System.out.println(maxSubArray(arr));
	}

	public void testsubsets() {
		ArrayList<Integer> td = new ArrayList<Integer>();
		td.add(2);
		td.add(2);
		td.add(1);
		printNestedList(subsets(td));
	}

	private void printNestedList(ArrayList<ArrayList<Integer>> nums) {
		for (ArrayList<Integer> outer : nums) {
			for (int curr : outer) {
				System.out.print(" " + curr);
			}
			System.out.println();
		}
	}

	public void testCloneGraph() {
		UndirectedGraphNode f = new UndirectedGraphNode(0);
		UndirectedGraphNode s = new UndirectedGraphNode(1);
		UndirectedGraphNode t = new UndirectedGraphNode(2);
		f.neighbors.add(s);
		f.neighbors.add(t);
		s.neighbors.add(t);
		t.neighbors.add(t);
		UndirectedGraphNode cloneGraph = cloneGraph(f);
		System.out.println(cloneGraph.label);
	}

	/*
	 * Ugly number is a number that only have factors 3, 5 and 7.
	 * 
	 * Design an algorithm to find the Kth ugly number. The first 5 ugly numbers
	 * are 3, 5, 7, 9, 15 ...
	 */
	/**
	 * @param k
	 *            : The number k.
	 * @return: The kth prime number as description.
	 */
	public long kthPrimeNumber(int k) {
		long[] rs = new long[k + 1];
		if (k < 1)
			return k;
		long n3 = 3, n5 = 5, n7 = 7;
		int i3 = 0, i5 = 0, i7 = 0;
		for (int i = 1; i <= k; i++) {
			long t = Math.min(n3, Math.min(n5, n7));
			if (t == n3) {
				rs[i] = n3;
				n3 = rs[++i3] * 3;
			}
			if (t == n5) // 注意：不能使用else，避免重复
			{
				rs[i] = n5;
				n5 = rs[++i5] * 5;
			}
			if (t == n7) // 注意：不能使用else
			{
				rs[i] = n7;
				n7 = rs[++i7] * 7;
			}
		}
		return rs[rs.length - 1];
	}

	public long kthPrimeNumberII(int k) {
		if (k <= 0)
			return 0;
		long[] rs = new long[k + 1];
		rs[0] = 1;
		int index3 = 0;
		int index5 = 0;
		int index7 = 0;
		int next_count = 1;
		while (next_count <= k) {
			long min = Math.min(rs[index3] * 3,
					Math.min(rs[index5] * 5, rs[index7] * 7));
			rs[next_count] = min;
			while (rs[index3] * 3 <= rs[next_count])
				index3++;
			while (rs[index5] * 5 <= rs[next_count])
				index5++;
			while (rs[index7] * 7 <= rs[next_count])
				index7++;
			next_count++;
		}
		return rs[k];
	}

	/**
	 * @param nums
	 *            : A list of integers
	 * @return: An integer indicate the value of maximum difference between two
	 *          Subarrays
	 */
	public int maxDiffSubArrays(ArrayList<Integer> nums) {
		if (null == nums || nums.size() == 0)
			return 0;
		int[][] l_max = new int[nums.size()][2];
		int[][] r_max = new int[nums.size()][2];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int max_sum = 0, min_sum = 0;
		for (int i = 0; i < nums.size(); i++) {
			max_sum += nums.get(i);
			max = Math.max(max, max_sum);
			max_sum = Math.max(max_sum, 0);
			l_max[i][0] = max;
			min_sum += nums.get(i);
			min = Math.min(min, min_sum);
			min_sum = Math.min(min_sum, 0);
			l_max[i][1] = min;
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		max_sum = 0;
		min_sum = 0;
		for (int i = nums.size() - 1; i >= 0; i--) {
			max_sum += nums.get(i);
			max = Math.max(max, max_sum);
			max_sum = Math.max(max_sum, 0);
			r_max[i][0] = max;
			min_sum += nums.get(i);
			min = Math.min(min, min_sum);
			min_sum = Math.min(min_sum, 0);
			r_max[i][1] = min;
		}
		int total_max = nums.get(0);
		for (int i = 0; i < nums.size() - 1; i++) {
			int curr_max = Math.max(Math.abs(l_max[i][0] - r_max[i + 1][1]),
					Math.abs(l_max[i][1] - r_max[i + 1][0]));
			total_max = Math.max(total_max, curr_max);
		}
		return total_max;
	}

	/*
	 * Given n items with size Ai, an integer m denotes the size of a backpack.
	 * How full you can fill this backpack? Example If we have 4 items with size
	 * [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that
	 * the max size we can fill this backpack is 10. If the backpack size is 12.
	 * we can select [2, 3, 7] so that we can fulfill the backpack.
	 * 
	 * You function should return the max size we can fill in the given
	 * backpack.
	 */
	/**
	 * @param m
	 *            : An integer m denotes the size of a backpack
	 * @param A
	 *            : Given n items with size A[i]
	 * @return: The maximum size
	 */
	public int backPack(int m, int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int[][] capacity = new int[m + 1][A.length];
		for (int i = 0; i < m + 1; i++) {
			if (i >= A[0]) {
				capacity[i][0] = A[0];
			}
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < A.length; j++) {
				int pre_max = 0;
				if (i >= A[j]) {
					pre_max = Math.max(pre_max, capacity[i - A[j]][j - 1]
							+ A[j]);
				}
				capacity[i][j] = Math.max(pre_max, capacity[i][j - 1]);
			}
		}
		return capacity[m][A.length - 1];

	}

	/*
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * break into a space-separated sequence of one or more dictionary words.
	 * 
	 * Example Given s = "lintcode", dict = ["lint", "code"].
	 * 
	 * Return true because "lintcode" can be break as "lint code".
	 */

	/**
	 * @param s
	 *            : A string s
	 * @param dict
	 *            : A dictionary of words dict
	 */

	private int getMaxLength(Set<String> dict) {
		int maxLength = 0;
		for (String word : dict) {
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}

	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return true;
		int maxLength = getMaxLength(dict);
		boolean[] arr = new boolean[s.length() + 1];
		arr[0] = true;
		for (int i = 1; i < s.length() + 1; i++) {
			int j = i;
			while (j >= 1 && i - j <= maxLength) {
				if (dict.contains(s.subSequence(j - 1, i)) && arr[j - 1]) {
					arr[i] = true;
					break;
				}
				j--;
			}
		}
		return arr[s.length()];
	}

	/*
	 * Given three strings: s1, s2, s3, determine whether s3 is formed by the
	 * interleaving of s1 and s2. Example For s1 = "aabcc", s2 = "dbbca"
	 * 
	 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return
	 * false.
	 */

	/**
	 * Determine whether s3 is formed by interleaving of s1 and s2.
	 * 
	 * @param s1
	 *            , s2, s3: As description.
	 * @return: true or false.
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		boolean[][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
		interleaved[0][0] = true;

		for (int i = 1; i <= s1.length(); i++) {
			if (s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0])
				interleaved[i][0] = true;
		}

		for (int j = 1; j <= s2.length(); j++) {
			if (s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1])
				interleaved[0][j] = true;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]))
						|| ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1]))
					interleaved[i][j] = true;
			}
		}

		return interleaved[s1.length()][s2.length()];
	}

	/*
	 * Distinct Subsequences Given a string S and a string T, count the number
	 * of distinct subsequences of T in S. A subsequence of a string is a new
	 * string which is formed from the original string by deleting some (can be
	 * none) of the characters without disturbing the relative positions of the
	 * remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC"
	 * is not).
	 * 
	 * Given S = "rabbbit", T = "rabbit", return 3.
	 */
	/**
	 * @param S
	 *            , T: Two string.
	 * @return: Count the number of distinct subsequences
	 */
	public int numDistinct(String S, String T) {
		if (null == S || null == T)
			return 0;
		if (T.equals(""))
			return 1;
		int[][] buffer = new int[S.length() + 1][T.length() + 1];
		for (int i = 0; i < S.length(); i++) {
			buffer[i][0] = 1;
		}
		for (int i = 1; i < S.length() + 1; i++) {
			for (int j = 1; j < T.length() + 1; j++) {
				buffer[i][j] = buffer[i - 1][j];
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					buffer[i][j] += buffer[i - 1][j - 1];
				}
			}
		}
		return buffer[S.length()][T.length()];
	}

	/*
	 * For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1,
	 * 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.
	 */

	/**
	 * @param nums
	 *            : A list of integers
	 * @return: An integer denotes the sum of max two non-overlapping subarrays
	 */
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0)
			return 0;
		int[] lf_arr = new int[nums.size()];
		int[] rf_arr = new int[nums.size()];
		int sum = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			sum += nums.get(i);
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
			lf_arr[i] = max;
		}
		sum = 0;
		max = Integer.MIN_VALUE;
		for (int i = nums.size() - 1; i >= 0; i--) {
			sum += nums.get(i);
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
			rf_arr[i] = max;
		}
		max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size() - 1; i++) {
			max = Math.max(lf_arr[i] + rf_arr[i + 1], max);
		}
		return max;
	}

	/**
	 * @param nums
	 *            : an array of integers
	 * @return: an integer
	 */
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE, sum = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				if (sum < 0) {
					sum *= nums[i];
					max = Math.max(max, sum);
				} else {

				}
				sum *= nums[i];

			} else {
				sum *= nums[i];
				max = Math.max(max, sum);
				sum = Math.max(sum, 1);
			}
		}
		return max;
	}

	/**
	 * @param nums
	 *            : A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	public int maxSubArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0)
			return 0;
		int[][] maxsum = new int[nums.size()][3];
		maxsum[0][0] = 0;
		maxsum[0][1] = 0;
		maxsum[0][2] = nums.get(0);
		for (int i = 1; i < nums.size(); i++) {
			if (nums.get(i) <= 0) {
				maxsum[i][0] = maxsum[i - 1][0];
				maxsum[i][1] = maxsum[i - 1][1];
				maxsum[i][2] = maxsum[i - 1][2];
			} else {
				int tmp = maxsum[i - 1][2];
				for (int j = maxsum[i - 1][1] + 1; j <= i; j++) {
					tmp += nums.get(j);
				}
				if (tmp < nums.get(i) || tmp < maxsum[i - 1][2]) {
					if (maxsum[i - 1][2] < nums.get(i)) {
						maxsum[i][0] = i;
						maxsum[i][1] = i;
						maxsum[i][2] = nums.get(i);
					} else {
						maxsum[i][0] = maxsum[i - 1][0];
						maxsum[i][1] = maxsum[i - 1][1];
						maxsum[i][2] = maxsum[i - 1][2];
					}
				} else {

					maxsum[i][0] = maxsum[i - 1][0];
					maxsum[i][1] = i;
					maxsum[i][2] = tmp;
				}
			}
		}
		return maxsum[nums.size() - 1][2];
	}

	public class Solution {
		private ArrayList<ArrayList<Integer>> triangle;
		private int[][] sum;
		private int n;

		public int search(int x, int y) {
			if (x >= n)
				return 0;
			if (sum[x][y] != Integer.MAX_VALUE)
				return sum[x][y];
			sum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1))
					+ triangle.get(x).get(y);
			return sum[x][y];
		}

		public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
			this.n = triangle.size();
			this.triangle = triangle;
			sum = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum[i][j] = Integer.MAX_VALUE;
				}
			}
			return search(0, 0);
		}
	}

	/**
	 * @param triangle
	 *            : a list of lists of integers.
	 * @return: An integer, minimum path sum.
	 */
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (null == triangle || triangle.size() == 0)
			return 0;
		int n = triangle.size();
		int[][] sum = new int[n][n];
		for (int i = 0; i < n; i++) {
			sum[n - 1][i] = triangle.get(n - 1).get(i);
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				sum[i][j] = triangle.get(i).get(j)
						+ Math.min(sum[i + 1][j], sum[i + 1][j + 1]);
			}
		}
		return sum[0][0];
	}

	/**
	 * @param n
	 *            : An integer
	 * @return: An integer
	 */
	public int climbStairs(int n) {
		if (n == 2 || n == 1)
			return n;
		int s1 = 1, s2 = 2;
		int num = 2;
		do {
			int tmp = s1 + s2;
			s1 = s2;
			s2 = tmp;
			num++;
		} while (num != n);
		return s2;
	}

	/**
	 * @param obstacleGrid
	 *            : A list of lists of integers
	 * @return: An integer
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (null == obstacleGrid)
			return 0;
		int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];
		for (int i = 0; i < cache.length; i++) {
			if (obstacleGrid[i][0] == 1) {
				cache[i][0] = Integer.MAX_VALUE;
				for (int j = i; j < cache.length; j++)
					cache[i][0] = Integer.MAX_VALUE;
			} else
				cache[i][0] = 1;
		}
		for (int i = 0; i < cache[0].length; i++) {
			if (obstacleGrid[0][i] == 1) {
				cache[0][i] = Integer.MAX_VALUE;
				for (int j = i; j < cache[0].length; j++)
					cache[0][i] = Integer.MAX_VALUE;
			} else
				cache[0][i] = 1;
		}
		for (int i = 1; i < cache.length; i++) {
			for (int j = 1; j < cache[0].length; j++) {
				if (cache[i][j - 1] == Integer.MAX_VALUE
						|| cache[i - 1][j] == Integer.MAX_VALUE) {
					cache[i][j] = Math.min(cache[i][j - 1], cache[i - 1][j]);
				} else
					cache[i][j] = cache[i][j - 1] + cache[i - 1][j];
			}
		}
		return cache[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

	/**
	 * Get all distinct N-Queen solutions
	 * 
	 * @param n
	 *            : The number of queens
	 * @return: All distinct solutions For example, A string '...Q' shows a
	 *          queen on forth position
	 */
	private String[] drawChessboard(ArrayList<Integer> cols) {
		String[] chessboard = new String[cols.size()];
		for (int i = 0; i < cols.size(); i++) {
			chessboard[i] = "";
			for (int j = 0; j < cols.size(); j++) {
				if (j == cols.get(i)) {
					chessboard[i] += "Q";
				} else {
					chessboard[i] += ".";
				}
			}
		}

		return chessboard;
	}

	private boolean isValid(ArrayList<Integer> cols, int col) {
		int row = cols.size();
		for (int i = 0; i < row; i++) {
			// same column
			if (cols.get(i) == col) {
				return false;
			}
			// left-top to right-bottom
			if (i - cols.get(i) == row - col) {
				return false;
			}
			// right-top to left-bottom
			if (i + cols.get(i) == row + col) {
				return false;
			}
		}
		return true;
	}

	private void search(int n, ArrayList<Integer> cols,
			ArrayList<String[]> result) {
		if (cols.size() == n) {
			result.add(drawChessboard(cols));
			return;
		}

		for (int col = 0; col < n; col++) {
			if (!isValid(cols, col)) {
				continue;
			}
			cols.add(col);
			search(n, cols, result);
			cols.remove(cols.size() - 1);
		}
	}

	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();
		if (n <= 0) {
			return solutions;
		}
		search(n, new ArrayList<Integer>(), result);
		for (String[] tmp : result) {
			ArrayList<String> solution = new ArrayList<String>();
			for (String item : tmp) {
				solution.add(item);
			}
			solutions.add(solution);
		}
		return solutions;
	}

	/**
	 * @param start
	 *            , a string
	 * @param end
	 *            , a string
	 * @param dict
	 *            , a set of string
	 * @return a list of lists of string
	 */
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> ladders = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Map<String, Integer> distance = new HashMap<String, Integer>();

		dict.add(start);
		dict.add(end);

		bfs(map, distance, start, end, dict);

		List<String> path = new ArrayList<String>();

		dfs(ladders, path, end, start, distance, map);

		return ladders;
	}

	void dfs(List<List<String>> ladders, List<String> path, String crt,
			String start, Map<String, Integer> distance,
			Map<String, List<String>> map) {
		path.add(crt);
		if (crt.equals(start)) {
			Collections.reverse(path);
			ladders.add(new ArrayList<String>(path));
			Collections.reverse(path);
		} else {
			for (String next : map.get(crt)) {
				if (distance.containsKey(next)
						&& distance.get(crt) == distance.get(next) + 1) {
					dfs(ladders, path, next, start, distance, map);
				}
			}
		}
		path.remove(path.size() - 1);
	}

	void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
			String start, String end, Set<String> dict) {
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		distance.put(start, 0);
		for (String s : dict) {
			map.put(s, new ArrayList<String>());
		}

		while (!q.isEmpty()) {
			String crt = q.poll();

			List<String> nextList = expand(crt, dict);
			for (String next : nextList) {
				map.get(next).add(crt);
				if (!distance.containsKey(next)) {
					distance.put(next, distance.get(crt) + 1);
					q.offer(next);
				}
			}
		}
	}

	List<String> expand(String crt, Set<String> dict) {
		List<String> expansion = new ArrayList<String>();

		for (int i = 0; i < crt.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch != crt.charAt(i)) {
					String expanded = crt.substring(0, i) + ch
							+ crt.substring(i + 1);
					if (dict.contains(expanded)) {
						expansion.add(expanded);
					}
				}
			}
		}

		return expansion;
	}

	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (null == dict || dict.size() == 0)
			return 0;
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.remove(start);
		int length = 1;
		while (!queue.isEmpty()) {
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				String current = queue.poll();
				for (char s = 'a'; s < 'z'; s++) {
					for (int j = 0; j < current.length(); j++) {
						if (s == current.charAt(j))
							continue;
						String tmp = replace(current, j, s);
						if (tmp.equals(end))
							return length + 1;
						if (dict.contains(tmp)) {
							queue.offer(tmp);
							dict.remove(tmp);
						}
					}
				}
			}
			length++;
		}
		return 0;
	}

	private String replace(String s, int index, char c) {
		char[] s_arr = s.toCharArray();
		s_arr[index] = c;
		return new String(s_arr);
	}

	/**
	 * @param node
	 *            : A undirected graph node
	 * @return: A undirected graph node
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> cache = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		createNode(cache, node);
		createNodeEdge(cache, node);
		return cache.get(node.label);
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
			if (cache.containsKey(neighbor))
				break;
			createNode(cache, neighbor);
		}
	}

	private void createNodeEdge(
			HashMap<UndirectedGraphNode, UndirectedGraphNode> cache,
			UndirectedGraphNode node) {
		UndirectedGraphNode parent = cache.get(node);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			if (parent == cache.get(neighbor)) {
				if (parent.neighbors.size() == 0)
					parent.neighbors.add(cache.get(neighbor));
				break;
			}
			parent.neighbors.add(cache.get(neighbor));
			createNodeEdge(cache, neighbor);
		}
	}

	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
		if (node == null)
			return null;
		ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> cache = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		nodes.add(node);
		cache.put(node, new UndirectedGraphNode(node.label));
		int start = 0;
		// copy nodes
		while (start < nodes.size()) {
			UndirectedGraphNode item = nodes.get(start++);
			for (int j = 0; j < item.neighbors.size(); j++) {
				if (!cache.containsKey(item.neighbors.get(j))) {
					cache.put(item.neighbors.get(j), new UndirectedGraphNode(
							item.neighbors.get(j).label));
					nodes.add(item);
				}
			}
		}

		// copy edges
		for (int i = 0; i < nodes.size(); i++) {
			UndirectedGraphNode item = nodes.get(i);
			for (int j = 0; j < item.neighbors.size(); j++) {
				cache.get(item).neighbors.add(cache.get(item.neighbors.get(j)));
			}
		}
		return cache.get(nodes);
	}

	/**
	 * @param graph
	 *            : A list of Directed graph node
	 * @return: Any topological order for the given graph.
	 */
	public ArrayList<DirectedGraphNode> topSort(
			ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> rst = new ArrayList<DirectedGraphNode>();
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		for (DirectedGraphNode unselectedNode : graph) {
			if (!cache.containsKey(unselectedNode.label)) {
				visit(rst, cache, unselectedNode);
			}
		}
		return rst;
	}

	private void visit(ArrayList<DirectedGraphNode> rst,
			HashMap<Integer, Integer> cache, DirectedGraphNode unselectedNode) {
		if (!cache.containsKey(unselectedNode.label)) {
			cache.put(unselectedNode.label, 0);
			for (DirectedGraphNode neighborhood : unselectedNode.neighbors) {
				visit(rst, cache, neighborhood);
			}
			rst.add(0, unselectedNode);
		}
	}

	/**
	 * @param graph
	 *            : A list of Directed graph node
	 * @return: Any topological order for the given graph.
	 */
	public ArrayList<DirectedGraphNode> topSortII(
			ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> rst = new ArrayList<DirectedGraphNode>();
		HashMap<DirectedGraphNode, Integer> counter_edges = new HashMap<DirectedGraphNode, Integer>();
		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode neighbor : node.neighbors) {
				if (!counter_edges.containsKey(neighbor)) {
					counter_edges.put(neighbor, 1);
				} else {
					counter_edges
							.put(neighbor, counter_edges.get(neighbor) + 1);
				}
			}
		}
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for (DirectedGraphNode node : graph) {
			if (!counter_edges.containsKey(node)) {
				queue.offer(node);
				rst.add(node);
			}
		}
		while (!queue.isEmpty()) {
			DirectedGraphNode node = queue.poll();
			for (DirectedGraphNode tmp : node.neighbors) {
				counter_edges.put(tmp, counter_edges.get(tmp) - 1);
				if (counter_edges.get(tmp) == 0) {
					queue.add(tmp);
					rst.add(tmp);
				}
			}
		}
		return rst;
	}

	public int removeDuplicates(int[] nums) {
		if (nums == null)
			return 0;
		int length = 0, count = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[length]) {
				if (count < 1) {
					swap(nums, ++length, i);
				}
				count++;
			} else {
				count = 0;
				swap(nums, ++length, i);
			}
		}
		return length + 1;
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public int partitionArray(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			if (nums[right] >= k) {
				right--;
			} else {
				swap(nums, left, right);
				left++;
			}
		}
		return right + 1;

	}

	// [1,0,-1,-1,-1,-1,0,1,1,1,2]
	public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numbers.length - 3; i++) {
			for (int j = i + 1; j < numbers.length - 2; j++) {
				int left = j + 1;
				int right = numbers.length - 1;
				while (left < right) {
					int sum = numbers[i] + numbers[j] + numbers[left]
							+ numbers[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						ArrayList<Integer> item = new ArrayList<Integer>();
						item.add(numbers[i]);
						item.add(numbers[j]);
						item.add(numbers[left]);
						item.add(numbers[right]);
						rst.add(item);
						left++;
						right--;
						while (left < numbers.length
								&& numbers[left] == numbers[left + 1])
							left++;
						while (right > left
								&& numbers[right] == numbers[right - 1])
							right--;
					}
				}
				while (j < numbers.length - 2 && numbers[j] == numbers[j + 1])
					j++;
			}
			while (i < numbers.length - 3 && numbers[i] == numbers[i + 1])
				i++;
		}
		return rst;
	}

	/**
	 * @param S
	 *            : A set of numbers.
	 * @return: A list of lists. All valid subsets.
	 */
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		Collections.sort(S);
		ArrayList<Integer> path = new ArrayList<Integer>();
		helpers(S, path, 0, rst);
		return rst;
	}

	private void helpers(ArrayList<Integer> S, ArrayList<Integer> path,
			int index, ArrayList<ArrayList<Integer>> rst) {
		rst.add(new ArrayList<Integer>(path));
		if (index == S.size())
			return;
		int prev = -1;
		for (int i = index; i < S.size(); i++) {
			// skip duplicates items
			if (prev != -1 && prev == S.get(i))
				continue;
			path.add(S.get(i));
			helpers(S, path, i + 1, rst);
			path.remove(path.size() - 1);
			prev = S.get(i);
		}
	}

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
	 * Definition for Directed graph.
	 */
	class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;

		DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<DirectedGraphNode>();
		}
	};

	/**
	 * Definition for undirected graph.
	 */
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
}
