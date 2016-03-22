
package com.jianfeng.algorithm.jiuzhang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeALG {

	public static void main(String[] args) throws Exception {
		BinaryTreeALG bt = new BinaryTreeALG();
//		bt.testheapify();
//		bt.testconvertBSTToLinkedList();
		bt.testNonRecursionTraversal();
	}
	
	public void testNonRecursionTraversal(){
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(6);
		TreeNode c = new TreeNode(14);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(8);
		TreeNode f = new TreeNode(12);
		TreeNode g = new TreeNode(16);
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		a.left = b;
		a.right = c;
		nonRecursionTraversal(a);
	}
	
	public void nonRecursionTraversal(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		Stack<TreeNode> output = new Stack<TreeNode>();
		nodes.push(root);
		while(!nodes.empty()){
			TreeNode top = nodes.pop();
			output.push(top);
			if(top.left != null)
				nodes.push(top.left);
			if(top.right != null)
				nodes.push(top.right);
		}
		while(!output.empty()){
			System.out.print(output.pop().val + " ");
		}
	}
	
	private List<TreeNode> getPath2Root(TreeNode node){
		List<TreeNode> path = new ArrayList<TreeNode>();
		while(node != null){
			path.add(node);
			node = node.parent;
		}
		return path;
	}
	public TreeNode getNextBiggerII(TreeNode node1, TreeNode node2){
		List<TreeNode> path1 = getPath2Root(node1);
		List<TreeNode> path2 = getPath2Root(node2);
		int i, j;
		for(i = path1.size() - 1, j = path2.size() - 1; i >=0 && j>= 0; i--,j--){
			if(path1.get(i).val != path2.get(j).val){
				return path1.get(i).parent;
			}
		}
		return path1.get(i+1);
	}
	
	public TreeNode getNextBigger(TreeNode node){
		if(node.right != null){
	        node = node.right;
	        while(node.left != null);
	            node = node.left;
	        return node;
		}
	    while(node.parent != null){
	        if(node.parent.left == node)
	            return node.parent;
	        node = node.parent;
	    }
	    return null;
	}

	public void testconvertBSTToLinkedList() {
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(6);
		TreeNode c = new TreeNode(14);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(8);
		TreeNode f = new TreeNode(12);
		TreeNode g = new TreeNode(16);
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		a.left = b;
		a.right = c;
		a = convertBSTtoLinkedList(a);
		while(a != null){
			System.out.println(" " + a.val);
			a = a.right;
		}
	}
	
	private TreeNode pLastNodeInlist;

	public void convertBSTToLinkedList(TreeNode root) {
		if (root == null)
			return;
		if(root.left != null){
			convertBSTToLinkedList(root.left);
		}
		if(pLastNodeInlist != null)
			pLastNodeInlist.right = root;
		root.left = pLastNodeInlist;
		pLastNodeInlist = root;
		if(root.right != null){
			convertBSTToLinkedList(root.right);
		}
	}

	public TreeNode convertBSTtoLinkedList(TreeNode root) {
		if (root == null)
			return root;
		convertBSTToLinkedList(root);
		while(pLastNodeInlist != null && pLastNodeInlist.left != null)
			pLastNodeInlist = pLastNodeInlist.left;
		return pLastNodeInlist;
	}

	public void testheapify() {
		int[] A = new int[] { 3, 2, 1, 4, 5 };
		heapify(A);
		for (int tmp : A)
			System.out.print(" " + tmp);
	}

	/**
	 * @param A
	 *            : Given an integer array
	 * @return: void
	 */
	public void heapify(int[] A) {
		if (A == null || A.length == 0)
			return;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		int current_count = 1;
		while (!queue.isEmpty()) {
			int next_count = 0;
			while (current_count > 0) {
				int curr_root = queue.poll();
				swapElement(A, getMinimumIndex(curr_root, A), curr_root);
				if (curr_root * 2 + 1 < A.length) {
					queue.offer(curr_root * 2 + 1);
					next_count++;
				}
				if (curr_root * 2 + 2 < A.length) {
					queue.offer(curr_root * 2 + 2);
					next_count++;
				}
				current_count--;
			}
			current_count = next_count;
		}
	}

	public int getMinimumIndex(int root, int[] A) {
		if (root * 2 > A.length) {
			return root;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(root);
		int current_count = 1;
		int min_index = root;
		while (!queue.isEmpty()) {
			int next_count = 0;
			while (current_count > 0) {
				int curr_root = queue.poll();
				if (A[min_index] > A[curr_root]) {
					min_index = curr_root;
				}
				if (curr_root * 2 + 1 < A.length) {
					queue.offer(curr_root * 2 + 1);
					next_count++;
				}
				if (curr_root * 2 + 2 < A.length) {
					queue.offer(curr_root * 2 + 2);
					next_count++;
				}
				current_count--;
			}
			current_count = next_count;
		}
		System.out.println(" root : " + root + " min_index: " + min_index);
		return min_index;
	}

	public void swapElement(int[] A, int p1, int p2) {
		int tmp = A[p1];
		A[p1] = A[p2];
		A[p2] = tmp;
	}

	public void testserialization() {
		TreeNode root = deserialize("1,2,3,11,#,4,5,#,#,6,7,#,10,#,#,8,9,#,#,12,13,#,#,#,#,#,14");
		System.out.println(serialize(root));
	}

	public void testDeleteDigits() {
		System.out.println(DeleteDigits("178542", 4));
		System.out.println(DeleteDigits("90249", 2));
	}

	/**
	 * @param root
	 *            : The root of the binary search tree.
	 * @param value
	 *            : Remove the node with given value.
	 * @return: The root of the binary search tree after removal.
	 */
	public TreeNode removeNode(TreeNode root, int value) {
		return removeNodeSubTree(root, value);
	}

	public TreeNode removeNodeSubTree(TreeNode root, int value) {
		if (root == null)
			return null;
		if (root.val == value) {
			if (root.left == null) {
				return root.right;
			} else {
				if (root.left.right == null) {
					root.left.right = root.right;
					return root.left;
				} else {
					TreeNode max = getParentMaxValue(root.left);
					max.right.right = root.right;
					max.right.left = root.left;
					TreeNode result = max.right;
					max.right = null;
					return result;
				}
			}
		} else if (root.val > value) {
			root.left = removeNodeSubTree(root.left, value);
		} else {
			root.right = removeNodeSubTree(root.right, value);
		}
		return root;
	}

	public TreeNode getParentMaxValue(TreeNode root) {
		if (root == null)
			return root;
		if (root.right == null) {
			return root.right;
		} else {
			if (root.right.right == null)
				return root;
			else
				return getParentMaxValue(root.right);
		}
	}

	/**
	 * Design an algorithm and write code to serialize and deserialize a binary
	 * tree. Writing the tree to a file is called 'serialization' and reading
	 * back from the file to reconstruct the exact same binary tree is
	 * 'deserialization'.
	 * 
	 * There is no limit of how you deserialize or serialize a binary tree, you
	 * only need to make sure you can serialize a binary tree to a string and
	 * deserialize this string to the original structure.
	 * 
	 * This method will be invoked first, you should design your own algorithm
	 * to serialize a binary tree which denote by a root node to a string which
	 * can be easily deserialized by your own "deserialize" method later.
	 */
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		StringBuffer sr = new StringBuffer();
		nodes.add(root);
		sr.append(root.val);
		int current_level_num = 1;
		int next_level_num = 0;
		while (!nodes.isEmpty()) {
			next_level_num = 0;
			while (current_level_num != 0) {
				TreeNode rt = nodes.poll();
				current_level_num--;
				if (rt.left != null) {
					nodes.add(rt.left);
					sr.append("," + rt.left.val);
					next_level_num++;
				} else {
					sr.append(",#");
				}
				if (rt.right != null) {
					nodes.add(rt.right);
					sr.append("," + rt.right.val);
					next_level_num++;
				} else {
					sr.append(",#");
				}
			}
			current_level_num = next_level_num;
		}
		while (sr.toString().charAt(sr.length() - 1) == '#'
				|| sr.toString().charAt(sr.length() - 1) == ',') {
			sr.deleteCharAt(sr.length() - 1);
		}
		return sr.toString();
	}

	/**
	 * This method will be invoked second, the argument data is what exactly you
	 * serialized at method "serialize", that means the data is not given by
	 * system, it's given by your own serialize method. So the format of data is
	 * designed by yourself, and deserialize it here as you serialize it in
	 * "serialize" method.
	 */
	public TreeNode deserialize(String data) {
		if (data.equals(""))
			return null;
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		int current_level_num = 1;
		int next_level_num = 0;
		int i = 0;
		String[] items = data.split(",");
		TreeNode root = new TreeNode(Integer.valueOf(items[0]));
		i++;
		nodes.add(root);
		while (!nodes.isEmpty() && i < items.length) {
			next_level_num = 0;
			while (current_level_num != 0 && i < data.length()) {
				TreeNode tmp = nodes.poll();
				current_level_num--;
				if (!items[i].equals("#")) {
					TreeNode lf = new TreeNode(Integer.valueOf(items[i]));
					tmp.left = lf;
					nodes.add(lf);
					next_level_num++;
				}
				i++;
				if (i < items.length && !items[i].equals("#")) {
					TreeNode rf = new TreeNode(Integer.valueOf(items[i]));
					tmp.right = rf;
					nodes.add(rf);
					next_level_num++;
				}
				i++;
			}
			current_level_num = next_level_num;
		}
		return root;
	}

	/**
	 * @param root
	 *            : The root of the binary search tree.
	 * @param k1
	 *            and k2: range k1 to k2.
	 * @return: Return all keys that k1<=key<=k2 in ascending order.
	 */
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if (null == root || k1 > k2)
			return rst;
		addRangeValue(root, rst, k1, k2);
		return rst;
	}

	private void addRangeValue(TreeNode root, ArrayList<Integer> rst, int k1,
			int k2) {
		if (root == null)
			return;
		if (root.val > k1)
			addRangeValue(root.left, rst, k1, k2);
		if (root.val >= k1 && root.val <= k2)
			rst.add(root.val);
		if (root.val < k2)
			addRangeValue(root.right, rst, k1, k2);
	}

	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: A list of lists of integer include the zigzag level order
	 *          traversal of its nodes' values
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return rst;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int flag = 1;
		while (!queue.isEmpty()) {
			ArrayList<Integer> current_level = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (flag == 1)
					current_level.add(node.val);
				else
					current_level.add(0, node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			flag = (flag == 1 ? 0 : 1);
			rst.add(current_level);
		}
		return rst;
	}

	/**
	 * @param preorder
	 *            : A list of integers that preorder traversal of a tree
	 * @param inorder
	 *            : A list of integers that inorder traversal of a tree
	 * @return : Root of a tree
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return null;
	}

	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		Stack<Integer> buffer = new Stack<Integer>();
		return traverseNodes(root, buffer);
	}

	private boolean traverseNodes(TreeNode root, Stack<Integer> buffer) {
		if (root == null)
			return true;
		if (traverseNodes(root.left, buffer)) {
			if (buffer.size() == 0) {
				buffer.add(root.val);
			} else {
				if (root.val < buffer.peek()) {
					return false;
				} else {
					buffer.add(root.val);
				}
			}
		} else
			return false;
		return traverseNodes(root.right, buffer);
	}

	private boolean firstNode = true;
	private int lastVal = Integer.MAX_VALUE;

	public boolean isValidBSTs(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}
		if (!firstNode && lastVal >= root.val) {
			return false;
		}
		firstNode = false;
		lastVal = root.val;
		return isValidBST(root.right);
	}

	/**
	 * @param root
	 *            : The root of the binary search tree.
	 * @param node
	 *            : insert this node into the binary search tree
	 * @return: The root of the new binary search tree.
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		if (root == null)
			return node;
		TreeNode tmp = root;
		while (tmp != null) {
			if (tmp.val >= node.val) {
				if (tmp.left == null) {
					tmp.left = node;
					break;
				}
				tmp = tmp.left;
			} else {
				if (tmp.right == null) {
					tmp.right = node;
					break;
				}
				tmp = tmp.right;
			}
		}
		return root;
	}

	/**
	 * @param l1
	 *            : the first list
	 * @param l2
	 *            : the second list
	 * @return: the sum list of l1 and l2
	 */
	public ListNode addLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l1;
		if (l2 == null)
			return l2;
		ListNode dumy = new ListNode(0);
		dumy.next = l2;
		ListNode pre_l2 = dumy;
		while (l1 != null && l2 != null) {
			l2.val = (l1.val + l2.val) % 10;
			if (l1.val + l2.val > 10) {
				if (l2.next == null) {
					ListNode tmp = new ListNode(1);
					l2.next = tmp;
				} else {
					l2.next.val += 1;
				}
			}
			pre_l2 = l2;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l2 == null) {
			pre_l2.next = l1;
		}
		return dumy.next;
	}

	/**
	 * @param A
	 *            : A positive integer which has N digits, A is a string.
	 * @param k
	 *            : Remove k digits.
	 * @return: A string
	 */
	public String DeleteDigits(String A, int k) {
		if (k >= A.length())
			return null;
		char[] buffer = A.toCharArray();
		for (int i = 0; i < k; i++) {
			int j = 0;
			for (; j < A.length() - i; j++) {
				if (Integer.valueOf(buffer[j]) > Integer.valueOf(buffer[j + 1])) {
					break;
				}
			}
			deleteOneItem(buffer, j);
		}
		StringBuffer rst = new StringBuffer();
		int flag = 0;
		for (int i = 0; i < buffer.length - k; i++) {
			if (buffer[i] != '0')
				flag = 1;
			if (flag == 1)
				rst.append(buffer[i]);
		}
		if (flag == 0)
			return "0";
		else
			return String.valueOf(Integer.valueOf(rst.toString()));
	}

	private void deleteOneItem(char[] nums, int index) {
		for (int i = index; i < nums.length - 1; i++) {
			nums[i] = nums[i + 1];
		}
	}

	public class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode parent;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
