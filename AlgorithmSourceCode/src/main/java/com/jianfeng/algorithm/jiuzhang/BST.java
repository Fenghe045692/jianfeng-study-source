package com.jianfeng.algorithm.jiuzhang;

public class BST {
	private BTNode root;
	
	public BST(){
		root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void insert(int val){
		root = insert(root, val);
	}
	
	public BTNode insert(BTNode root, int val){
		if(root == null){
			return new BTNode(val);
		}
		if(root.val > val){
			root.right = insert(root.right, val);
		}else{
			root.left = insert(root.left, val);
		}
		return root;
	}
	
	public void delete(int value){
		if(isEmpty()){
			System.out.println("Empty BST!");
			return;
		}
		
		root = delete(root, value);
	}
	
	public BTNode delete(BTNode root, int value){
		if(root == null)
			return root;
		if(root.val == value){
			BTNode lt = root.left;
			BTNode rt = root.right;
			if(lt == null && rt == null){
				return null;
			}else if(lt == null){
				return rt;
			}else if(rt == null){
				return lt;
			}else{
				BTNode p2 = rt;
				BTNode p = rt;
				while(p.left != null){
					p = p.left;
				}
				p.left = lt;
				return p2;
			}
		}else if(root.val > value){
			root.left = delete(root.left, value);
			
		}else{
			root.right = delete(root.right, value);
		}
		return root;
	}
	
	public int countNodes(){
		return countNodes(root);
	}
	
	public int countNodes(BTNode root){
		if(root == null)
			return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	
	private boolean search(BTNode root, int val){
		if(root == null)
			return false;
		if(root.val == val){
			return true;
		}else if(root.val > val){
			return search(root.left, val);
		}else{
			return search(root.right, val);
		}
	}
}
