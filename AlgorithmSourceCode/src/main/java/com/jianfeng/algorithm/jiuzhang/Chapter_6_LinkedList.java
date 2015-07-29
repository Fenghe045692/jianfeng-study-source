package com.jianfeng.algorithm.jiuzhang;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Chapter_6_LinkedList {
	public static void main(String[] args) {
		Chapter_6_LinkedList ls = new Chapter_6_LinkedList();
		ls.testrecoverRotatedSortedArray();
	}
	
	/**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        int len = A.length;
        TreeNode[] stk = new TreeNode[len];
        for (int i = 0; i < len; ++i)
            stk[i] = new TreeNode(0);
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            TreeNode tmp = new TreeNode(A[i]);
            while (cnt > 0 && A[i] > stk[cnt-1].val) {
                tmp.left = stk[cnt-1];
                cnt --;
            }
            if (cnt > 0)
                stk[cnt - 1].right = tmp;
            stk[cnt++] = tmp;
        }
        return stk[0];
    }
	
	private void copyNext(RandomListNode head) {
        while(head!= null){
        	RandomListNode newnode = new RandomListNode(head.label);
        	newnode.next = head.next;
        	newnode.random = head.random;
        	head.next = newnode;
        	head = head.next.next;
        }
    }

    private void copyRandom(RandomListNode head) {
        while(head != null){
        	if(head.next.random != null)
        		head.next.random = head.random.next;
        	head = head.next.next;
        }
    }

    private RandomListNode splitList(RandomListNode head) {
    	RandomListNode newnode = head.next;
    	while(head != null){
    		RandomListNode tmp = head.next;
    		head.next = tmp.next;
    		if(tmp.next != null)
    			tmp.next = tmp.next.next;
    		head = head.next;
    	}
    	return newnode;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
	
	public void testrecoverRotatedSortedArray(){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(4);nums.add(5);nums.add(1);nums.add(2);nums.add(3);
		recoverRotatedSortedArray(nums);
		printArrayList(nums);
	}
	
	public void printArrayList(ArrayList<Integer> nums){
		if(null != nums){
			for(int item : nums){
				System.out.print(item + " ");
			}
		}
	}
	
	 /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
	public void recoverRotatedSortedArray(ArrayList<Integer> nums){
		if(null == nums || nums.size()==0)
            return;
		int i = 0;
		while(i < nums.size() -1 && nums.get(i) < nums.get(i + 1)) i++;
		if(i == nums.size()-1)
			return;
		int j = 0;
		while(j < i + 1) {
			nums.add(nums.remove(0));
			j++;
		}
	}
	
	/**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null)
    		return head;
    	HashMap<RandomListNode, RandomListNode> cache = new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode dumy = new RandomListNode(0);
    	RandomListNode pre = dumy, newNode;
    	while(head != null){
    		if(!cache.containsKey(head)){
    			newNode = new RandomListNode(head.label);
    			cache.put(head, newNode);
    		}else{
    			newNode = cache.get(head);
    		}
    		pre.next = newNode;
    		if(head.random != null){
    			if(!cache.containsKey(head.random)){
        			newNode.random = new RandomListNode(head.random.label);
        			cache.put(head.random, newNode);
        		}else{
        			newNode.random = cache.get(head.random);
        		}
    		}
    		pre = pre.next;
    		head = head.next;
    	}
    	return dumy.next;
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
      
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
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
	
	/**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
    	if(head == null || head.next == null)
    		return false;
    	ListNode slow,fast;
    	fast = head.next;
    	slow = head;
    	while(fast != slow){
    		if(fast == null || fast.next == null)
    			return false;
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return true;
    }
	
	 /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
    	return null;
    }
	
	/**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dumy = new ListNode(0);
    	ListNode index = dumy;
    	while(l1 != null && l2!=null){
    		if(l2.val >= l1.val){
    			index.next = l1;
    			l1 = l1.next;
    		}else{
    			index.next = l2;
    			l2 = l2.next;
    		}
    		index = index.next;
    	}
    	if(l1 == null){
    		index.next = l2;
    	}else{
    		index.next = l1;
    	}
    	return dumy.next;
    }
	
	/**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
    	if(m >= n || head == null || head.next == null || m < 1)
    		return head;
    	ListNode dumy = new ListNode(0);
    	dumy.next = head;
    	head = dumy;
    	int i = 0;
    	ListNode start = head;
    	while(i < m - 1) { i++; start = start.next;}
    	ListNode end = start;
    	while(i < n) { i++; end = end.next;}
    	ListNode index = start.next;
    	start.next = end;
    	start = index;
    	i = 1;
    	while(i <= n - m){
    		ListNode item = start.next;
    		start.next = end.next;
    		end.next = start;
    		start = item;
    		i++;
    	}
    	return head.next;
    }

	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
    	if(null == head || head.next == null)
    		return head;
    	ListNode dumy = new ListNode(0);
    	dumy.next = head;
    	head = dumy;
    	while(null!= head.next && head.next.next != null){
    		if(head.next.val == head.next.next.val){
    			int val = head.next.val;
    			while(head.next.next != null && head.next.val == val){
    				head.next = head.next.next;
    			}
    			
    		}else{
    			head = head.next;
    		}
    	}
    	return dumy.next;
    }
	
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	ListNode dumy = new ListNode(0);
    	while(head != null){
    		ListNode item = head;
    		head = head.next;
    		item.next = dumy.next;
    		dumy.next = item;
    	}
    	return dumy.next;
    }
	
	// Definition for ListNode
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	/**
	 * Definition for singly-linked list with a random pointer.
	 **/
	  class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  }
	  
	  /**
	   * Definition of TreeNode:
	   */
	    public class TreeNode {
	        public int val;
	        public TreeNode left, right;
	        public TreeNode(int val) {
	            this.val = val;
	            this.left = this.right = null;
	       }
	   }
	   
}
